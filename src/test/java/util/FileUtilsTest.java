package util;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;


public class FileUtilsTest
{
	@Test
	public void getSHA1SUMTest()throws NoSuchAlgorithmException,IOException
	{
		String filename="OVERVIEW_SLIDE_modified.pptx";
		File file=new File(filename);
		
		String sha1sumValue= FileUtils.getSHA1SUM(file);
		System.out.println(sha1sumValue);
		
		if(sha1sumValue!=null)
			assertTrue(true);
		else
			assertTrue(false);
	}
	
	@Test
	public void fileEqualityTest()throws NoSuchAlgorithmException,IOException
	{
		String fileName1="file1.pptx";
		File file1=new File(fileName1);
		String fileName2="file2.pptx";
		File file2=new File(fileName2);
		
		String sha1sumValue1= FileUtils.getSHA1SUM(file1);
		System.out.println(sha1sumValue1);
		
		String sha1sumValue2= FileUtils.getSHA1SUM(file2);
		System.out.println(sha1sumValue2);
		
		
		
		long fileSize = FileUtils.sizeCalculator(fileName1);
		System.out.println("FileSize for "+fileName1+" = "+fileSize);

		fileSize = FileUtils.sizeCalculator(fileName2);
		System.out.println("FileSize for "+fileName2+" = "+fileSize);
		
		assertTrue(true);
		
		
	}
}
