package resume;
import java.io.*;
import java.net.URI;

import org.apache.hadoop.fs.*;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
 
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;



public class FileWriteToHDFS {
	public static float sum11=0;
	public static float sum12=0;
	public static float sum13=0;
	public static float sum14=0;
	public static float sum15=0;
	public static float sum16=0;
	public static float sum17=0;
	public static float sum01=0;
	public static float sum02=0;
	public static float sum03=0;
	public static float sum04=0;
	public static float sum05=0;
	public static float sum06=0;
	public static float sum07=0;
	public static int count0=0;
	public static int count1=0;
	public static void copyFromLocal (String source, String dest) throws IOException {
		 
		Configuration conf = new Configuration();
		/*conf.addResource(new Path("/home/hadoop/hadoop/conf/core-site.xml"));
		conf.addResource(new Path("/home/hadoop/hadoop/conf/hdfs-site.xml"));
		conf.addResource(new Path(zz"/home/hadoop/hadoop/conf/mapred-site.xml"));*/
		
		conf.addResource(new Path("/usr/local/hadoop/etc/hadoop/core-site.xml"));
		conf.addResource(new Path("/usr/local/hadoop/etc/hadoop/hdfs-site.xml"));
		conf.addResource(new Path("/usr/local/hadoop/etc/hadoop/mapred-site.xml"));
		 
		FileSystem fileSystem = FileSystem.get(conf);
		Path srcPath = new Path(source);
		 
		Path dstPath = new Path(dest);
		// Check if the file already exists
		if (!(fileSystem.exists(dstPath))) {
		System.out.println("No such destination " + dstPath);
		return;
		}
		 
		// Get the filename out of the file path
		String filename = source.substring(source.lastIndexOf('/') + 1, source.length());
		 
		try{
		fileSystem.copyFromLocalFile(srcPath, dstPath);
		//System.out.println("File " + filename + "copied to " + dest);
		}catch(Exception e){
		System.err.println("Exception caught! :" + e);
		System.exit(1);
		}finally{
		fileSystem.close();
		}
		}
	//------------------------------------------------------------------------------------------------------------------------
	public static void  copyFromHdfs (String source, String dest) throws IOException {
		 
		Configuration conf = new Configuration();
		conf.addResource(new Path("/home/hadoop/hadoop/conf/core-site.xml"));
		conf.addResource(new Path("/home/hadoop/hadoop/conf/hdfs-site.xml"));
		conf.addResource(new Path("/home/hadoop/hadoop/conf/mapred-site.xml"));
		 
		FileSystem fileSystem = FileSystem.get(conf);
		Path srcPath = new Path(source);
		 
		Path dstPath = new Path(dest);
		// Check if the file already exists
		if (!(fileSystem.exists(dstPath))) {
		System.out.println("No such destination " + dstPath);
		return;
		}
		 
		// Get the filename out of the file path
		String filename = source.substring(source.lastIndexOf('/') + 1, source.length());
		 
		try{
		fileSystem.copyToLocalFile(srcPath, dstPath);
		System.out.println("File " + filename + "copied to " + dest);
		}catch(Exception e){
		System.err.println("Exception caught! :" + e);
		System.exit(1);
		}finally{
		fileSystem.close();
		}
		}
	//------------------------------------------------------------------------------------------------------------------------
	public static void readFile(String file) throws IOException {
		Configuration conf = new Configuration();
		conf.addResource(new Path("/home/hadoop/hadoop/conf/core-site.xml"));
		conf.addResource(new Path("/home/hadoop/hadoop/conf/hdfs-site.xml"));
		conf.addResource(new Path("/home/hadoop/hadoop/conf/mapred-site.xml"));
		 
		FileSystem fileSystem = FileSystem.get(conf);
		 
		Path path = new Path(file);
		if (!fileSystem.exists(path)) {
		System.out.println("File " + file + " does not exists");
		return;
		}
		 
		FSDataInputStream in = fileSystem.open(path);
		 
		String filename = file.substring(file.lastIndexOf('/') + 1,
		file.length());
		 
		OutputStream out = new BufferedOutputStream(new FileOutputStream(
		new File(filename)));
		 
		byte[] b = new byte[1024];
		int numBytes = 0;
		while ((numBytes = in.read(b)) > 0) {
		out.write(b, 0, numBytes);
		}
		 
		in.close();
		out.close();
		fileSystem.close();
		}
		 
	//-------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws Exception {
		
		//FileWriteToHDFS.copyFromLocal("/home/sandesh/Documents/resumes_dataset/resume_text/b.txt","/usr/local/hadoop/test");
		//FileWriteToHDFS.copyFromHdfs("/usr/local/hadoop/test/b.txt","/home/sandesh/Desktop");
		FileWriteToHDFS.readFile("/usr/local/hadoop/resume/akash.txt");   
   	 
		/*String fileName = "/home/sandesh/Desktop/dibeties.txt";

  		 BufferedReader br = new BufferedReader(new FileReader(fileName)); 

  			String line=null;
  			while ((line = br.readLine()) != null) {
  				
  				
  				String[] words = line.split(",");
  				if(words.length<9)
  				{
  					break;
  				}
  				System.out.println("length of array"+words.length);
  				for(int i=0;i<words.length;i++)
  				{
  					System.out.println(i+"="+words[i]);
  				}
  				
  				if(words[8].equalsIgnoreCase("0"))
  				{
  					count0++;
  				for(int i=0;i<words.length;i++)
  				{
  					if(i==1)
  					{
  				String first=words[1];
  				float first_1=Float.parseFloat(first);
  				sum01=sum01+first_1;
  					}
  		  	    
  		  	    if(i==2)
  		  	    {
  		  	    String second=words[2];
  		  	  float first_1=Float.parseFloat(second);
  		  	sum02=sum02+first_1;
  		  	    }
  			    if(i==3)
  			    {
  			    String third=words[3];
  			  float first_1=Float.parseFloat(third);
  			  sum03=sum03+first_1;
  			    }
  		  	    if(i==4)
  		  	    {
  		  	    String fourth=words[4];
  		  	float first_1=Float.parseFloat(fourth);
  		  	sum04=sum04+first_1;
  		  	    }
  		  	if(i==5)
		  	    {
		  	    String fourth=words[5];
		  	float first_1=Float.parseFloat(fourth);
		  	sum05=sum05+first_1;
		  	    }
  		  if(i==6)
	  	    {
	  	    String fifth=words[6];
	  	float first_1=Float.parseFloat(fifth);
	  	sum06=sum06+first_1;
	  	    }
  		if(i==7)
	  	    {
	  	    String six=words[7];
	  	float first_1=Float.parseFloat(six);
	  	sum07=sum07+first_1;
	  	    }
  		  	    
  				}
  				}
  				//-----------------------------------------------------------------------
  				if(words[8].equalsIgnoreCase("1"))
  				{
  					count1++;
  				for(int i=0;i<words.length;i++)
  				{
  					if(i==1)
  					{
  				String first=words[1];
  				float first_1=Float.parseFloat(first);
  				sum11=sum11+first_1;
  					}
  		  	    
  		  	    if(i==2)
  		  	    {
  		  	    String second=words[2];
  		  	  float first_1=Float.parseFloat(second);
  		  	sum12=sum12+first_1;
  		  	    }
  			    if(i==3)
  			    {
  			    String third=words[3];
  			  float first_1=Float.parseFloat(third);
  			  sum13=sum13+first_1;
  			    }
  		  	    if(i==4)
  		  	    {
  		  	    String fourth=words[4];
  		  	float first_1=Float.parseFloat(fourth);
  		  	sum14=sum14+first_1;
  		  	    }
  		  	if(i==5)
		  	    {
		  	    String fourth=words[5];
		  	float first_1=Float.parseFloat(fourth);
		  	sum15=sum15+first_1;
		  	    }
  		  if(i==6)
	  	    {
	  	    String fourth=words[6];
	  	float first_1=Float.parseFloat(fourth);
	  	sum16=sum16+first_1;
	  	    }
  		if(i==7)
	  	    {
	  	    String fourth=words[7];
	  	float first_1=Float.parseFloat(fourth);
	  	sum17=sum17+first_1;
	  	    }
  		  	    
  				}
  				}

  				
  			}
            br.close();
          //  System.out.println(sum01);
           // System.out.println(sum02);
            //System.out.println(sum03);
            //System.out.println(sum04);
            //System.out.println(sum11);
            //System.out.println(sum12);
            //System.out.println(sum13);
           // System.out.println(sum14);
           // System.out.println("count0="+count0);
            //System.out.println("count1="+count1);
            float avg01=sum01/count0;
            float avg02=sum02/count0;
            float avg03=sum03/count0;
            float avg04=sum04/count0;
            float avg05=sum05/count0;
            float avg06=sum06/count0;
            float avg07=sum07/count0;
            float avg11=sum11/count1;
            float avg12=sum12/count1;
            float avg13=sum13/count1;
            float avg14=sum14/count1;
            float avg15=sum15/count1;
            float avg16=sum16/count1;
            float avg17=sum17/count1;
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("/home/sandesh/Desktop/abc.txt"), true));  
       	 
    	      bw.write(avg01+","+avg02+","+avg03+","+avg04+","+avg05+","+","+avg06+","+avg07+","+"from 0");
            bw.newLine();
            bw.write(avg11+","+avg12+","+avg13+","+avg14+","+avg15+", "+","+avg16+","+avg17+","+"from 1");
            
            bw.close();
		
		 //-------------------------------------------------------------------------------------
		//Source file in the local file system
		String localSrc ="/home/sandesh/Desktop/bank69.txt";
		//hadoop dfs -copyFromLocal /home/sandesh/Desktop/bank68.txt /usr/local/hadoop/test

		//Destination file in HDFS
		String dst = "/usr/local/hadoop/test";
		 
		//Input stream for the file in local file system to be written to HDFS
		InputStream in = new BufferedInputStream(new FileInputStream(localSrc));
		 
		//Get configuration of Hadoop system
		Configuration conf = new Configuration();
		System.out.println("Connecting to -- "+conf.get("fs.defaultFS"));
		 
		//Destination file in HDFS
		FileSystem fs = FileSystem.get(URI.create(dst), conf);
		OutputStream out = fs.create(new Path(dst));
		 
		//Copy file from local to HDFS
		IOUtils.copyBytes(in, out, 4096, true);
		 
		System.out.println(dst + " copied to HDFS");
		 
*/		

	}
}
