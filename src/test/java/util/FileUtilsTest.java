package util;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;


public class FileUtilsTest
{
	/**
	 * This test targets at fetching a SHA1SUM for a file. The content of the file is kept static.
	 * When the SHA1SUM is algorithm is run it should return a standard sum value.
	 * 
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	@Test
	public void getSHA1SUMTest()throws NoSuchAlgorithmException,IOException
	{
		String filename="testcases/sample_file_for_SHA_test.txt";
		File file=new File(filename);
		
		String sha1sumValue= FileUtils.getSHA1SUM(file);		
		
		assertEquals(sha1sumValue,"832d15d23af9bca49f227de69ec403c69947410e");		
	}
	/**
	 * As per the SAH1SUM this test attempts to verify if the same files 
	 * with different names are having same SHA1SUM or not. They should return same sum if the contents are same.
	 * 
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	@Test
	public void fileEqualityTest()throws NoSuchAlgorithmException,IOException
	{
		String fileName1="testcases/same-file.pptx";
		File file1=new File(fileName1);
		String fileName2="testcases/subfolder/same-file-other-name.pptx";
		File file2=new File(fileName2);
		
		String sha1sumValue1= FileUtils.getSHA1SUM(file1);
		assertEquals(sha1sumValue1.toString(),"64799f960f37fb82dd2ec83d30f78bf77ee81136");
		
		String sha1sumValue2= FileUtils.getSHA1SUM(file2);
		assertEquals(sha1sumValue2.toString(),"64799f960f37fb82dd2ec83d30f78bf77ee81136");		
		
		long fileSize = FileUtils.sizeCalculator(fileName1);
		assertEquals(fileSize, 6445510L);

		fileSize = FileUtils.sizeCalculator(fileName2);
		assertEquals(fileSize, 6445510L);	
		
	}
}
