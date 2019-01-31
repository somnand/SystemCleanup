package model;

public class FileInfo
{
	private String filename; //contains the absolute file path too FILEPATH+FILENAME+EXTENSION. 
	private String sha1sumValue;//contains the SHA1SUM value for the file. Unique for each file.
	private long fileSize;//contains the fileSize. THis will act as the first point of doubt as to the file in question is already listed or not.
	
	/* Setters and getters for all properties*/
	
	public String getFilename()
	{
		return filename;
	}
	public void setFilename(String filename)
	{
		this.filename = filename;
	}
	public String getSha1sumValue()
	{
		return sha1sumValue;
	}
	public void setSha1sumValue(String sha1sumValue)
	{
		this.sha1sumValue = sha1sumValue;
	}
	public long getFileSize()
	{
		return fileSize;
	}
	public void setFileSize(long fileSize)
	{
		this.fileSize = fileSize;
	}
	
	@Override
	public int hashCode()
	{
		return 0;//returning this to focus on the equals() only.
	}
		
	@Override
	public boolean equals(Object anotherFile)
	{
		boolean isEqual=false;
		
		if(anotherFile instanceof FileInfo)
		{
			if(this.fileSize==((FileInfo)anotherFile).getFileSize())
			{
				isEqual=true;
			}
			if(this.sha1sumValue==((FileInfo)anotherFile).getSha1sumValue())
			{
				isEqual=true;
			}
		}
		return isEqual;
	}
	@Override
	public String toString()
	{
		return filename+" : "+sha1sumValue+" : "+fileSize;
	}		
}
