package core;

import java.io.File;
import java.io.IOException;
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
					duplicateFileList.add("rm -rf "+currentFileInfo.getFilename());					
			}
			if(file.isDirectory())
				searchFolder(file);
							
		}		
	}
	
	public static void main(String[] args)throws IOException,NoSuchAlgorithmException
	{
		if(args.length==0)
		{
			System.out.println("Usage :  java -jar target/SystemCleanup-0.0.1-SNAPSHOT.jar \"Path to the root\"");
		}
		String rootPath = args[0];
		File rootFolder = new File(rootPath);
		System.out.println("Analysing "+rootPath+" for duplicates ...");		
		searchFolder(rootFolder);
		System.out.println("Files scanned "+(fileList.size()+duplicateFileList.size()));
		System.out.println("Duplicates : "+duplicateFileList.size());
		System.out.println("Removal commands : (Unix)");
		for(String command : duplicateFileList)
			System.out.println(command);
		System.out.println("Comparision completed!!");
		
		
		
		//TODO Move this below test into a complete Test Case. 
		/* Unit test case for SearchEngine */
		/*
		FileInfo file1 = new FileInfo();
		FileInfo file2 = new FileInfo();
		File file = new File("C:\\Users\\1021623\\git\\SystemCleanup\\file1.pptx");
		file1.setFilename(file.getAbsolutePath());
		file1.setFileSize(FileUtils.sizeCalculator(file));				
		file1.setSha1sumValue(FileUtils.getSHA1SUM(file));
		file = new File("C:\\Users\\1021623\\git\\SystemCleanup\\file2.pptx");
		file2.setFilename(file.getAbsolutePath());
		file2.setFileSize(FileUtils.sizeCalculator(file));				
		file2.setSha1sumValue(FileUtils.getSHA1SUM(file));
		System.out.println(file1);
		System.out.println(fileList.add(file1));
		System.out.println(file2);
		System.out.println(fileList.add(file2));
		System.out.println(fileList.size());
		*/
	}
}
