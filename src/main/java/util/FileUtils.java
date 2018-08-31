package util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class FileUtils
{
	/**
	 * Method to calculate the size of File/Directories
	 * 
	 * @param filename
	 * @return
	 */
	public static long sizeCalculator(String filename)throws IOException
	{
		File file = new File(filename);
		if(file.exists() && file.isFile())
			return file.length();
		else
			throw new IOException("Can't determine file size");
	}
	/**
	 * Overloaded version for the above method
	 * 
	 * @param file
	 * @return
	 */
	public static long sizeCalculator(File file)throws IOException
	{
		if(file.exists() && file.isFile())
			return file.length();
		else
			throw new IOException("Can't determine file size");
	}
	/**
	 * Method to calculate the SHA1SUM value for the file.
	 * 
	 * @param filename
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public static String getSHA1SUM(final String filename) throws NoSuchAlgorithmException, IOException
	{
		
		File file=new File(filename);
		final MessageDigest messageDigest = MessageDigest.getInstance("SHA1");

		InputStream in = new BufferedInputStream(new FileInputStream(filename));

		byte[] buffer = new byte[1024];

		int read = 0;		

		while ((read = in.read(buffer)) != -1)
		{
			messageDigest.update(buffer, 0, read);			
		}

		Formatter formatter = new Formatter();
		for (byte b : messageDigest.digest())
		{
			formatter.format("%02x", b);
		}

		return formatter.toString();
	}

	/**
	 * Overloaded version for the above method
	 * 
	 * @param file
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public static String getSHA1SUM(final File file) throws NoSuchAlgorithmException, IOException
	{
		final MessageDigest messageDigest = MessageDigest.getInstance("SHA1");

		InputStream in = new BufferedInputStream(new FileInputStream(file));

		byte[] buffer = new byte[1024];

		int read = 0;		

		while ((read = in.read(buffer)) != -1)
		{
			messageDigest.update(buffer, 0, read);			
		}

		Formatter formatter = new Formatter();
		for (byte b : messageDigest.digest())
		{
			formatter.format("%02x", b);
		}

		return formatter.toString();
	}
}
