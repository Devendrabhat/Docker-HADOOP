package pack1;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.mapred.jobcontrol.Job;
import org.apache.hadoop.util.*;
import java.util.*;

public class Resume extends Configured implements Tool{
	public static String input;
	  
      public int run(String[] args) throws Exception
      {
            //creating a JobConf object and assigning a job name for identification purposes
    	  //Configuration conf = new Configuration();
    	  

    	    JobConf conf = new JobConf(getConf(), Resume.class);  
    	    conf.set("input",args[0]);
    	    
    	  
            //JobConf conf = new JobConf(getConf(), DbMissing.class);
            conf.setJobName("Resume");
            //conf.set("test", "123");

            //Setting configuration object with the Data Type of output Key and Value
            conf.setOutputKeyClass(Text.class);
            conf.setOutputValueClass(IntWritable.class);

            //Providing the mapper and reducer class names
            conf.setMapperClass(ResumeMapper.class);
            conf.setReducerClass(ResumeReducer.class);
            //We wil give 2 arguments at the run time, one in input path and other is output path
            /*Path inp = new Path(args[0]);
            Path out = new Path(args[1]);*/
            
            
            //fjkldsfkdslvjdfkjvkd;ljvpl;jmvl;
            
            //get
            Process p;
            try{
            
            //p= Runtime.getRuntime().exec("jps");
            
            p= Runtime.getRuntime().exec("rm -rf /home/dev/Documents/Workstation/resume_hadoop/src/output");
            p= Runtime.getRuntime().exec("/usr/local/hadoop/bin/hadoop fs -copyToLocal /input/* /home/dev/Documents/resume/re"); 
            p= Runtime.getRuntime().exec("/bin/chmod 777 /home/dev/Documents/resume/re/*");
            Path inp = new Path("/home/dev/Documents/resume/re");
            Path out = new Path("/home/dev/Documents/Workstation/resume_hadoop/src/output");
            
            //the hdfs input and output directory to be fetched from the command line
            // d;kgoljfdk,kvldoklfvdjikv
            //put
            
            
            FileInputFormat.addInputPath(conf, inp);
            FileOutputFormat.setOutputPath(conf, out);
            p= Runtime.getRuntime().exec("sudo su");
            p= Runtime.getRuntime().exec("/usr/local/hadoop/sbin/start-dfs.sh");
            p= Runtime.getRuntime().exec("/usr/local/hadoop/sbin/start-yarn.sh");
            
            }
            catch(Exception e)
            {
            	System.out.println(""+e);
            }
            JobClient.runJob(conf);
       
            p= Runtime.getRuntime().exec("hadoop fs -put /home/dev/Documents/Workstation/resume_hadoop/src/output/* /output/");
            
            return 0;
      }
      public static void runMapper(String[] args)
      {
    	  int res;
		try {
			res = ToolRunner.run(new Configuration(), new Resume(),args);
			 //System.exit(res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
    	  
      }
     
      public static void main(String[] args) throws Exception
      {
    	  Scanner sc=new Scanner(System.in);
    	  System.out.println("enter your query");
    	  input=sc.next();
    	  
        int res = ToolRunner.run(new Configuration(), new Resume(),args);
        System.exit(res);
      }
}