package pack1;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class ResumeReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>
{
      //reduce method accepts the Key Value pairs from mappers, do the aggregation based on keys and produce the final out put
      public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException
      {
    	  
    	  /*while (values.hasNext()) {
  			Text t =  values.next();
  			String s=t.toString();
  			output.collect( new Text(s),key);

  			
  		}*/
    	  String fname=key.toString();
    	  BufferedWriter bw = new BufferedWriter(new FileWriter(new File("/home/dev/Documents/interm.txt"), true));  
     	  bw.write(fname);
          bw.newLine();
          bw.close();
    	  
    	  
    	  output.collect( key,new IntWritable(1));
    	  System.out.println("Hello red done");
    	  
    	  
    	  /*
            int sum = 0;
            iterates through all the values available with a key and add them together and give the
            final result as the key and sum of its values
          while (values.hasNext())
          {
               sum += values.next().get();
          }
          output.collect(key, new IntWritable(sum));*/
      }
}