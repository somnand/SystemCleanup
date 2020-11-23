# System Cleanup

This program automatically identifies the duplicated files and eventually removes them.

The program will iterate through all folders recursively limited to the root directory mentioned.
It will obtain all the files and store them into a [data-structure]currently HashSet.
Objects of <code>model.FileInfo</code> are created which are later on stored into the HashSet mentioned.
Any collision will show same files. 

## Using the Software
From the releases section download the binary and run it using the following command.

java -jar SystemCleanup.jar "Path to Root" 

## Getting Started(Development)
Clone the project. 

*git clone https://github.com/somnand/SystemCleanup.git*

Once the clone is complete then run the project using following command.

*mvn clean install -DskipTests*

Testing the build.
<code> 
$ java -jar target/SystemCleanup.jar "/d/Java Programs/git/SystemCleanup/testcases"
Engine Version : 1.0.2-BUILD
Analysing D:/Java Programs/git/SystemCleanup/testcases for duplicates ...
Files scanned 3
Duplicates : 1
Removal commands : (Unix)
rm -rf D:\Java Programs\git\SystemCleanup\testcases\subfolder\same-file-other-name.pptx
Comparision completed!!
</code> 

### Prerequisites
```
1. jdk1.8
2. git
3. maven
```
## Running the tests

Currently the Unit test cases are not fully developed. So skipping them for now.

### Break down into end to end tests

<code>FileUtilsTest.getSHA1SUMTest()</code>
<code>FileUtilsTest.fileEqualityTest()</code>

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management and Project Structuring

## Authors

* **Somsurya Nanda** - *Initial work*
