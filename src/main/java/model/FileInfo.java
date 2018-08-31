package model;

import lombok.Data;

@Data
public class FileInfo
{
	private String filename; //contains the absolute file path too FILEPATH+FILENAME+EXTENSION. 
	private String sha1sumValue;
}
