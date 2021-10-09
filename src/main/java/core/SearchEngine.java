package core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;

import model.FileInfo;
import util.FileUtils;

/**
 * This class will iterate through all folders recursively limited to the root directory mentioned.
 * It will obtain all the files and store them into a [data-structure]currently HashSet.
 * Objects of <code>model.FileInfo</code> are created which are later on stored into the HashSet mentioned.
 * Any collision will show same files. 
 * @author Somsurya Nanda
 *
 */
public class SearchEngine 
{
	private static HashSet<FileInfo> fileList=new HashSet<FileInfo>();
	private static HashSet<String> duplicateFileList = new HashSet<String>();
	private static final String VERSION="2.0.1";
	
	
	/**
	 * Method to iterate over the current folder and add the <code>FileInfo</code> into the HashSet.
	 * @param folder
	 */
	private static void searchFolder(File folder)throws IOException,NoSuchAlgorithmException
	{
		FileInfo currentFileInfo=null;
		File[] filesInFolder = folder.listFiles();
		if(folder.getName().startsWith("."))
			return;
		if(folder.isHidden())
			return;
		if(filesInFolder==null)
			return;
		
		for(File file : filesInFolder)
		{
			if(file.isFile())
			{
				//Building the FileInfo object to add to the HashSet
				currentFileInfo=new FileInfo();
				currentFileInfo.setFilename(file.getAbsolutePath());
				currentFileInfo.setFileSize(FileUtils.sizeCalculator(file));				
				currentFileInfo.setSha1sumValue(FileUtils.getSHA1SUM(file));
						
				boolean isAdded = fileList.add(currentFileInfo);
				if(!isAdded)
					duplicateFileList.add(currentFileInfo.getFilename());					
			}
			if(file.isDirectory())
				searchFolder(file);							
		}		
	}
	
	
	
	public static void main(String[] args)throws IOException,NoSuchAlgorithmException
	{
		if(args.length==0)
		{
			System.out.println("Usage :  java -jar SystemCleanup.jar \"Path to the root within double quotes\"");
			return;
		}
		System.out.println("Engine Version : "+VERSION);		
		String rootPath = args[0];
		File rootFolder=null;
		Path path = Paths.get(rootPath);		
		rootFolder = new File(path.toAbsolutePath().toString());
		System.out.println("Analysing "+rootFolder.getAbsolutePath()+" for duplicates ...");		
		searchFolder(rootFolder);
		System.out.println("Files scanned "+(fileList.size()+duplicateFileList.size()));
		System.out.println("Duplicates : "+duplicateFileList.size());
		if(duplicateFileList.size()!=0)
		{
			//Determining the Operating System
			String os = System.getProperty("os.name").toLowerCase();
			System.out.println("Removal commands : "+os);		
			String command = null;
			if(os.contains("win"))
				command="del /q ";
			if(os.contains("nix"))
				command="rm -f ";
			if(os.contains("mac"))
				command="rm -f ";
			
			for(String fileName : duplicateFileList)
				System.out.println(command+"\""+fileName+"\"");		
		}
		else
			System.out.println("No Duplicates found !!");
		System.out.println("Comparision completed!!");		
	}
}
