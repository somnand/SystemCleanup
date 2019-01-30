package core;

import java.util.HashSet;

import model.FileInfo;

/**
 * This class will iterate through all folders recursively limited to the root directory mentioned.
 * It will obtain all the files and storre them into a [datastructure]currently HashSet.
 * Objects of <code>model.FileInfo</code> are created which are later on stored into the HashSet mentioned.
 * Any collision will show same files. 
 * @author Somsurya Nanda
 *
 */
public class SearchEngine 
{
	HashSet<FileInfo> fileList=new HashSet<FileInfo>();
	
	public static void main(String[] args) 
	{
		// TODO  Recursively call the folders and add files to HashSet.

	}
}
