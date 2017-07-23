package resume;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.text.*;
import java.sql.*;
import java.util.ArrayList;

import dbconnection.DbConnection;


public class DownloadImp {
	public static void performAlgorithm() throws IOException, SQLException, ParseException
	{
		Connection cn=DbConnection.getConnection();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		ArrayList<String> al=new ArrayList<String>();
		ArrayList<String> op0=new ArrayList<String>();
		ArrayList<String> op1=new ArrayList<String>();
		List<Date> myList = new ArrayList<Date>();
		String fileName = "/home/dev/Documents/interm.txt";

  		 BufferedReader br = new BufferedReader(new FileReader(fileName)); 

  			String line=null;
  			while ((line = br.readLine()) != null) 
  			{
  				line=line.trim();
  				al.add(line);
  				System.out.println("vimppppp="+line);
  				
  			}
  			
  			
  			
  			for(int i=0;i<al.size();i++)
  			{
  				Statement st=cn.createStatement();
  				ResultSet rs=st.executeQuery("select * from reg where resume='"+al.get(i)+"'");
  				String date=null;
  				//String resume=null;
  				if(rs.next())
  				{
  					date=rs.getString("date_upload");
  					
  				}
  				/*PreparedStatement ps=cn.prepareStatement("SELECT * FROM ='"+(String)al.get(i)+"'");
  				
  				rs=ps.executeQuery();
  				//formatter.parse(rs.getString(11));
  				//System.out.println(al.get(i));*/
  				if(date!=null)
  				{
  				myList.add(formatter.parse(date));
  				}
  				System.out.println(al.get(i)+" "+date);
  			}
  			
  	        
  	         
  	        Collections.sort(myList, new Comparator<Date>(){
  	 
  	            @Override
  	            public int compare(Date o1, Date o2) 
  	            {
  	                return -o1.compareTo(o2);
  	            }
  	        });
  	         
  	        for(int i = 0; i < myList.size(); i++){
  	            System.out.println(myList.get(i).toString());
  	        }
  	        System.out.println("-----------------------------------");
  	      for(int i = 0; i < myList.size(); i++){
  	    	String date_upload=formatter.format(myList.get(i));
  	    	//System.out.println(date_upload);
  	    	//------------------------------------------not repeated-----------------------------
  	    	Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select * from reg where date_upload='"+date_upload+"' and flag='0'");
			while(rs.next())
			{
				for(int j = 0; j < al.size(); j++)
				{
					//System.out.println(rs.getString("resume"));
					if(al.get(j).equalsIgnoreCase(rs.getString("resume")))
					{
						op0.add(al.get(j));
					}
					
				}
				
			}
			//----------------------------------repeated logic------------------------------------------------------------
			Statement st1=cn.createStatement();
			ResultSet rs1=st.executeQuery("select * from reg where date_upload='"+date_upload+"' and flag!=0");
			while(rs1.next())
			{
				for(int j = 0; j < al.size(); j++)
				{
					//System.out.println(rs.getString("resume"));
					if(al.get(j).equalsIgnoreCase(rs1.getString("resume")))
					{
						op1.add(al.get(j));
					}
					
				}
				
			}	
	            
	        }
  	    BufferedWriter bw = new BufferedWriter(new FileWriter(new File("/home/dev/Documents/interm1.txt"), true));  
   	  
        
        
  	    for(int i = 0; i < op0.size(); i++){
	            System.out.println((String)op0.get(i));
	            String temp=(String)op0.get(i);
	            bw.write(temp);
	            bw.newLine();
	        }
  	  for(int i = 0; i < op1.size(); i++){
          System.out.println((String)op1.get(i));
          String temp=(String)op1.get(i);
          bw.write(temp);
          bw.newLine();
      }
  	bw.close();

		
	}
	public static void main(String[] args) throws IOException, ParseException, SQLException {
		Connection cn=DbConnection.getConnection();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		ArrayList<String> al=new ArrayList<String>();
		ArrayList<String> op0=new ArrayList<String>();
		ArrayList<String> op1=new ArrayList<String>();
		List<Date> myList = new ArrayList<Date>();
		String fileName = "/home/sandesh/Desktop/interm.txt";

  		 BufferedReader br = new BufferedReader(new FileReader(fileName)); 

  			String line=null;
  			while ((line = br.readLine()) != null) 
  			{
  				line=line.trim();
  				al.add(line);
  				
  			}
  			
  			
  			
  			for(int i=0;i<al.size();i++)
  			{
  				Statement st=cn.createStatement();
  				ResultSet rs=st.executeQuery("select * from reg where resume='"+al.get(i)+"'");
  				String date=null;
  				//String resume=null;
  				if(rs.next())
  				{
  					date=rs.getString("date_upload");
  					
  				}
  				/*PreparedStatement ps=cn.prepareStatement("SELECT * FROM ='"+(String)al.get(i)+"'");
  				
  				rs=ps.executeQuery();
  				//formatter.parse(rs.getString(11));
  				//System.out.println(al.get(i));*/
  				if(date!=null)
  				{
  				myList.add(formatter.parse(date));
  				}
  				System.out.println(al.get(i)+" "+date);
  			}
  			
  	        
  	         
  	        Collections.sort(myList, new Comparator<Date>(){
  	 
  	            @Override
  	            public int compare(Date o1, Date o2) 
  	            {
  	                return -o1.compareTo(o2);
  	            }
  	        });
  	         
  	        for(int i = 0; i < myList.size(); i++){
  	            System.out.println(myList.get(i).toString());
  	        }
  	        System.out.println("-----------------------------------");
  	      for(int i = 0; i < myList.size(); i++){
  	    	String date_upload=formatter.format(myList.get(i));
  	    	//System.out.println(date_upload);
  	    	//------------------------------------------not repeated-----------------------------
  	    	Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery("select * from reg where date_upload='"+date_upload+"' and flag='0'");
			while(rs.next())
			{
				for(int j = 0; j < al.size(); j++)
				{
					//System.out.println(rs.getString("resume"));
					if(al.get(j).equalsIgnoreCase(rs.getString("resume")))
					{
						op0.add(al.get(j));
					}
					
				}
				
			}
			//----------------------------------repeated logic------------------------------------------------------------
			Statement st1=cn.createStatement();
			ResultSet rs1=st.executeQuery("select * from reg where date_upload='"+date_upload+"' and flag!=0");
			while(rs1.next())
			{
				for(int j = 0; j < al.size(); j++)
				{
					//System.out.println(rs.getString("resume"));
					if(al.get(j).equalsIgnoreCase(rs1.getString("resume")))
					{
						op1.add(al.get(j));
					}
					
				}
				
			}	
	            
	        }
  	    BufferedWriter bw = new BufferedWriter(new FileWriter(new File("/home/dev/Documents/interm1.txt"), true));  
   	  
        
        
  	    for(int i = 0; i < op0.size(); i++){
	            System.out.println((String)op0.get(i));
	            String temp=(String)op0.get(i);
	            bw.write(temp);
	            bw.newLine();
	        }
  	  for(int i = 0; i < op1.size(); i++){
          System.out.println((String)op1.get(i));
          String temp=(String)op1.get(i);
          bw.write(temp);
          bw.newLine();
      }
  	bw.close();
  	      
	}

}