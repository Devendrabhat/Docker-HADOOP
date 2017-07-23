package pack1;
import java.io.*;

import java.util.StringTokenizer;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;
import java.util.*;

public class ResumeMapper extends MapReduceBase implements
		Mapper<LongWritable, Text, Text, IntWritable> {
	// hadoop supported data types

	// map method that performs the tokenizer job and framing the initial key
	// value pairs
	// after all lines are converted into key-value pairs, reducer is called.
	private final static IntWritable one = new IntWritable(1);
	 //public static String input="java";
	public static String uinput;
	public static Scanner sc=new Scanner(System.in);
	public static int f=0;
	public Integer myIntegerOption;
    public String myStringOption;
    public static String input;
	//public static final String input="java" ;
	@Override
    public void configure(JobConf job) {
        super.configure(job);
       // myIntegerOption = job.getInt("myIntOption", -1); 
        // nb: last arg is the default value if option is not set
        input= job.get("input");
    }

	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
		/*if(f==0)
		{
			System.out.println("enter your query");
			uinput=sc.next();
			f=1;
		}*/
//----------------------------------resume code------------------------------------------------------		
	    /*String line = value.toString();
	    String[] words = line.split(" ");
	   
	    FileSplit fsplit = (FileSplit) reporter.getInputSplit();
	    String inputFileName = fsplit.getPath().getName();
	    int flag=0;
	    	if(line.contains(input));
		    {
		    	  
		          BufferedWriter bw = new BufferedWriter(new FileWriter(new File("/home/sandesh/Desktop/interm.txt"), true));  
		     	  bw.write(line);
		          bw.newLine();
		          bw.close();
		          flag=1;
		    	  	
		    }
	    	
		
	    if(flag==1)
	    {
	    	output.collect(new Text(inputFileName), one);
	    }*/
		String s = value.toString();
		String[] words = s.split(" ");
		int flag=0;
		FileSplit fsplit = (FileSplit) reporter.getInputSplit();
	    String inputFileName = fsplit.getPath().getName();
		/*for(int i=0;i<(words.length);i++)
		{
			if(words[i].equalsIgnoreCase("1year"))
			{
				flag=1;
				break;
			}
		}*/
	    if(s.contains(input))
	    {
	    	flag=1;
	    }
		if(flag==1)
		{
			output.collect(new Text(inputFileName), one);	
		}
	    
	    
	    

//-------------------------------------------------------------------------------------------------
		/*String s = value.toString();
		String[] words = s.split(",");
		
		String temp=words[0];
		String plasma_glucose="";
		String blood_pressure="";
		String skin_thicness="";
		String serum_insulin="";
		String  Body_mass_index="";
		String Diabetes_pedigree_function="";
		String class_var="";
		String age="";
		flag=0;
		for (int i=1; i<(words.length); i++)
		{
			if(i==1)
			{
				plasma_glucose=words[i];
				plasma_glucose=plasma_glucose.trim();
				if(plasma_glucose.equalsIgnoreCase("0"))
				{
					float new_value=Plasma_Glucose_Recovery.get_Error_Recovery();
					String new_value1=String.valueOf(new_value);
					temp=temp+" ,"+new_value1;
					flag=1;
				}
				else
				{
					temp=temp+","+plasma_glucose;
				}
			}
			if(i==2)
			{
				blood_pressure=words[i];
				blood_pressure=blood_pressure.trim();
				if(blood_pressure.equalsIgnoreCase("0"))
				{
					float new_value=Blood_Pressure_Recovery.get_Error_Recovery();
					String new_value1=String.valueOf(new_value);
					temp=temp+" ,"+new_value1;
					flag=1;
				}
				else
				{
					temp=temp+" ,"+blood_pressure;
				}
			}
			if(i==3)
			{
				skin_thicness=words[i];
				skin_thicness=skin_thicness.trim();
				if(skin_thicness.equalsIgnoreCase("0"))
				{
					float new_value=Skin_Thickness_Recovery.get_Error_Recovery();
					String new_value1=String.valueOf(new_value);
					temp=temp+" ,"+new_value1;
					flag=1;
				}
				else
				{
					temp=temp+" ,"+skin_thicness;
				}
			}
			if(i==4)
			{
				serum_insulin=words[i];
				serum_insulin=serum_insulin.trim();
				if(serum_insulin.equalsIgnoreCase("0"))
				{
					float new_value=Serum_Insulin_Recovery.get_Error_Recovery();
					String new_value1=String.valueOf(new_value);
					temp=temp+" ,"+new_value1;
					flag=1;
				}
				else
				{
					temp=temp+" ,"+serum_insulin;
				}
			}
			if(i==5)
			{
				Body_mass_index=words[i];
				Body_mass_index=Body_mass_index.trim();
				if(Body_mass_index.equalsIgnoreCase("0"))
				{
					float new_value=Body_Mass_Index_Recovery.get_Error_Recovery();
					String new_value1=String.valueOf(new_value);
					temp=temp+" ,"+new_value1;
					flag=1;
				}
				else
				{
					temp=temp+" ,"+Body_mass_index;
				}
			}
			if(i==6)
			{
				Diabetes_pedigree_function=words[i];
				Diabetes_pedigree_function=Diabetes_pedigree_function.trim();
				if(Diabetes_pedigree_function.equalsIgnoreCase("0"))
				{
					
					temp=temp+" ,"+"0.672";
					flag=1;
				}
				else
				{
					temp=temp+" ,"+Diabetes_pedigree_function;
				}
			}
			if(i==7)
			{
				age=words[i];
				age=age.trim();
				if(age.equalsIgnoreCase("0"))
				{
					float new_value=Age_Recovery.get_Error_Recovery();
					String new_value1=String.valueOf(new_value);
					temp=temp+" ,"+new_value1;
					flag=1;
				}
				else
				{
					temp=temp+" ,"+age;
				}
			}
			
			
		}

		
		if(flag==1)
		{
		word.set(temp);
		output.collect(word, one);
		}
*/		/*for (int i=1; i<(words.length)-1; i++)
		{
			String check=words[i].trim();
				
			if (check.equalsIgnoreCase("0")) 
			{
				flag=1;
					a=a+" "+"b";

			}
			else
			{
				a=a+" "+words[i];
			}

		}
*/		

		

/*		for (int i=1; i<(words.length)-1; i++) {
		String check=words[i].trim();
			Float f = Float.parseFloat(check);
		if (f==0.0) {
				word.set(main_str);
				output.collect(word, one);

			}

		}
*/
	}

}
