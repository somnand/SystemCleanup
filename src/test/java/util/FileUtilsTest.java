package util;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FileUtilsTest extends TestCase
{
	
	public FileUtilsTest(String testName)
	{
		super(testName);
	}
	
	public static Test suite()
	{
		return new TestSuite(FileUtilsTest.class);
	}
	
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
	
	
	/*public static void main(String[] args)throws NoSuchAlgorithmException,IOException
	{
		String filename="OVERVIEW_SLIDE_modified.pptx";
		File file=new File(filename);
		
		String sha1sumValue= FileUtils.getSHA1SUM(file);
		System.out.println(sha1sumValue);
	}*/
}
