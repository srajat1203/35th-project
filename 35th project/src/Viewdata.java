

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
/**
 * Servlet implementation class helloworld
 */



@WebServlet("/Viewdata")
public class Viewdata extends HttpServlet {
	private String message;
	
	
	 ArrayList<String> a;
	 ArrayList<Integer> g;
	 ArrayList<Integer> s;
	String a2 = "";
	String g2 = "";
	String s2 = "";
	double favg = 0;
	int h = 0;
	int l = 101;

	  public void init() throws ServletException
	  {
	      // Do required initialization
		 
	  }

	  public void doGet(HttpServletRequest request,
	                    HttpServletResponse response)
	            throws ServletException, IOException
	  {
		  
		  String temp_id = request.getParameter("id");
		  int id = 0;
		  if(temp_id != null)
		  {
			 id = Integer.parseInt(temp_id);
		  }
		  String temp_type = request.getParameter("type");
		  int type = 0;
		  if(temp_type != null)
		  {
			 type = Integer.parseInt(temp_type);
		  }
		  String temp_avgid = request.getParameter("avgid");
		  int avgid = 0;
		  if(temp_avgid != null)
		  {
			 avgid = Integer.parseInt(temp_avgid);
		  }
		  String temp_avgtype = request.getParameter("avgtype");
		  int avgtype = 0;
		  if(temp_avgtype != null)
		  {
			 avgtype = Integer.parseInt(temp_avgtype);
		  }
		  String temp_hltype = request.getParameter("hltype");
		  int hltype = 0;
		  if(temp_hltype != null)
		  {
			 hltype = Integer.parseInt(temp_hltype);
		  }
		  String course = request.getParameter("course");
		  /*
		  String temp_weight1 = request.getParameter("weight1");
		  double weight1 = 25;
		  if(temp_weight1 != null)
		  {	  
			  if(!(temp_weight1.isEmpty()))
			  {
				  weight1 = Double.parseDouble(temp_weight1);
			  }
		  }
		  String temp_weight2 = request.getParameter("weight2");
		  double weight2 = 25;
		  if(temp_weight2 != null)
		  {	  
			  if(!(temp_weight2.isEmpty()))
			  {
				  weight2 = Double.parseDouble(temp_weight2);
			  }
		  }  
		  String temp_weight3 = request.getParameter("weight3");
		  double weight3 = 25;
		  if(temp_weight3 != null)
		  {  
			  if(!(temp_weight3.isEmpty()))
			  {
				  weight3 = Double.parseDouble(temp_weight3);
			  }
		  }	  
		  String temp_weight4 = request.getParameter("weight4");
		  double weight4 = 25;
		  if(temp_weight4 != null)
		  {
				  if(!(temp_weight4.isEmpty()))
			  {
				  weight4 = Double.parseDouble(temp_weight4);
			  }
		  }	  
		  */
		  
		 // System.out.print(id + " ");
		 // System.out.print(type + " ");
		 // System.out.print(avgid + " ");
		 // System.out.print(avgtype + " ");
		 // System.out.println(hltype + " ");
		  //System.out.println(course);
		  //System.out.println(weight1 + " " + weight2 + " " + weight3 + " " + weight4);
		  
		  String url = "";
		  Connection conn = null;
		  
		  
		  try
			{
		    	Class.forName("oracle.jdbc.driver.OracleDriver");
				
		    	url = "jdbc:oracle:thin:testuser/password@localhost"; 

		    	
				//properties for creating connection to Oracle database
				Properties props = new Properties();
				props.setProperty("user", "testdb");
				props.setProperty("password", "password");
			   
		    	
		    	conn = DriverManager.getConnection(url,props);
			}	
		  
		  catch (Exception e)
			{
				e.printStackTrace();
			}
		  
		  
		  
		 //first query 
		 if( type==0 && avgid == 0 && avgtype == 0 && hltype == 0 )
		 {
			
			try{
				
			 String sql = "select DISTINCT assignment from " + "STUDENTS " + "where id = ?";
			 
		   	PreparedStatement preStatement = conn.prepareStatement(sql);
		   	preStatement.setInt(1,id);
		   	
			ResultSet result = preStatement.executeQuery();
				
			a2 = "";
			g2 = "";
			s2 = "";
			while(result.next())
			{
				String cura = result.getString("ASSIGNMENT");
				a2 += cura + "<br>";
				
			}
			
			 
			}
		  
		    catch (Exception e)
			{
				e.printStackTrace();
			}
			
			
			try{
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		 
		
		 //Second query 
		 else if( id == 0 && avgid == 0 && avgtype == 0 && hltype == 0 )
		 {
			
			try{
				
			 String sql = "select assignment from " + "STUDENTS " + "where atype = ?";
			 
		   	PreparedStatement preStatement = conn.prepareStatement(sql);
		   	preStatement.setInt(1,type);
		   	
			ResultSet result = preStatement.executeQuery();
				
			a2 = "";
			g2 = "";
			s2 = "";	
			while(result.next())
			{
				String cura = result.getString("ASSIGNMENT");
				a2 += cura + "<br>";
				
			}
			
			 
			}
		  
		    catch (Exception e)
			{
				e.printStackTrace();
			}
			
			try{
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		 
		
		 
		 //Third query 
		 else if( avgid == 0 && avgtype == 0 && hltype == 0 )
		 {
			
			try{
				
			 String sql = "select assignment from " + "STUDENTS " + "where atype = ? and id = ?";
			 
		   	PreparedStatement preStatement = conn.prepareStatement(sql);
		   	preStatement.setInt(1,type);
		   	preStatement.setInt(2,id);
		   	
			ResultSet result = preStatement.executeQuery();
			
				
			a2 = "";
			g2 = "";
			s2 = "";	
			while(result.next())
			{
				String cura = result.getString("ASSIGNMENT");
				a2 += cura + "<br>";
				
			}
			
			 
			}
		  
		    catch (Exception e)
			{
				e.printStackTrace();
			}
			
			try{
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		} 
		  
		 
		 
		 //fourth query 
		 else if( id ==0 && type==0 && avgtype == 0 && hltype == 0 )
		 {
			
			try{
				
				
				//updating weights
				//String sql2 = "update w" + "set weight1 = ?, weight2 = ?, weight3 = ?, weight3 = ?";
				//PreparedStatement Statement = conn.prepareStatement(sql2);
				
				String sql2 = "select weight1, weight2, weight3, weight4 from " +  "w";
				//String sql2 = "select assignment from " +  "students";
				
				PreparedStatement statement = conn.prepareStatement(sql2);
				ResultSet result2 = statement.executeQuery(sql2);
				
				//System.out.println(statement.getMetaData());
				
				int weight1 = 0;
				int weight2 = 0;
				int weight3 = 0;
				int weight4 = 0;
				
				while(result2.next())
				{
					
					weight1 = result2.getInt("WEIGHT1");
					weight2 = result2.getInt("WEIGHT2");
					weight3 = result2.getInt("WEIGHT3");
					weight4 = result2.getInt("WEIGHT4");
					
				}
				int ow1 = weight1;
				int ow2 = weight2;
				int ow3 = weight3;
				int ow4 = weight4;
				
				String temp_weight1 = request.getParameter("weight1");
				if(temp_weight1 != null)
				{	  
					 if(!(temp_weight1.isEmpty()))
					 {
						  weight1 = Integer.parseInt(temp_weight1);
					 }
				}
				 String temp_weight2 = request.getParameter("weight2");
				  if(temp_weight2 != null)
				  {	  
					  if(!(temp_weight2.isEmpty()))
					  {
						  weight2 = Integer.parseInt(temp_weight2);
					  }
				  }  
				  String temp_weight3 = request.getParameter("weight3");
				  if(temp_weight3 != null)
				  {  
					  if(!(temp_weight3.isEmpty()))
					  {
						  weight3 = Integer.parseInt(temp_weight3);
					  }
				  }	  
				  String temp_weight4 = request.getParameter("weight4");
				  if(temp_weight4 != null)
				  {
						  if(!(temp_weight4.isEmpty()))
					  {
						  weight4 = Integer.parseInt(temp_weight4);
					  }
				  }
				
		//updating weights in db
				  
				
				String sql3 ="delete from w";
				PreparedStatement statement2 = conn.prepareStatement(sql3);
				statement2.executeQuery();
				
				
				String sql4 = "INSERT INTO W (WEIGHT1, WEIGHT2, WEIGHT3, WEIGHT4) " + "VALUES (?, ?, ?, ?)";
				 PreparedStatement statement3 = conn.prepareStatement(sql4);
					  
				  statement3.setInt(1,weight1);
				  statement3.setInt(2,weight2);
				  statement3.setInt(3,weight3);
				  statement3.setInt(4,weight4);
				  
				  statement3.executeQuery();
				
		   
		//finding average
				  
			 String sql = "select grade, atype  from " + "STUDENTS " + "where id = ? and assignment = ?";
			 
		   	PreparedStatement preStatement = conn.prepareStatement(sql);
		  
		   	preStatement.setInt(1,avgid);
		   	preStatement.setString(2, course);
		   	
			ResultSet result = preStatement.executeQuery();
				
			a2 = "";
			g2 = "";
			s2 = "";
			int count1 = 0;
			int sum1 = 0;
			int count2 = 0;
			int sum2 = 0;
			int count3 = 0;
			int sum3 = 0;
			int count4 = 0;
			int sum4 = 0;
			while(result.next())
			{
				
				int curgrade = result.getInt("GRADE");
				int curtype = result.getInt("ATYPE");
				
				if(curtype == 1)
				{
					sum1 = sum1 + curgrade;
					count1++;
				}
				else if(curtype == 2)
				{
					sum2 = sum2 + curgrade;
					count2++;
				}
				else if(curtype == 3)
				{
					sum3 = sum3 + curgrade;
					count3++;
				}
				else if(curtype == 4)
				{
					sum4 = sum4 + curgrade;
					count4++;
				}
			}
				
			 int avg1 = 0;
			 int avg2 = 0;
			 int avg3 = 0;
			 int avg4 = 0;
			 
			 if(count1 != 0)
			 {
				 avg1 = sum1/count1;
			 }
			 if(count2 != 0)
			 {
				 avg2 = sum2/count2;
			 }
			 if(count3 != 0)
			 {
				 avg3 = sum3/count3;
			 }
			 if(count4 != 0)
			 {
				 avg4 = sum4/count4;
			 }
			 
			 double w1 = (double)weight1/100;
			 double w2 = (double)weight2/100;
			 double w3 = (double)weight3/100;
			 double w4 = (double)weight4/100;
			 double a1 = (double)avg1;
			 double a2 = (double)avg2;
			 double a3 = (double)avg3;
			 double a4 = (double)avg4;
			 
			 favg = w1*a1 + w2*a2 + w3*a3 + w4*a4;
			 //System.out.println(favg);
			 
			
			}
			
			
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			try{
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
			
		} 
		
		 
		 //fifth query 
		 else if( id ==0 && type==0 && hltype == 0 )
		 {
			
			try{
				
			 String sql = "select grade from " + "STUDENTS " + "where id = ? and atype = ? and assignment = ?";
			 
		   	PreparedStatement preStatement = conn.prepareStatement(sql);
		  
		   	preStatement.setInt(1,avgid);
		   	preStatement.setInt(2,avgtype);
		   	preStatement.setString(3,course);
		   	
			ResultSet result = preStatement.executeQuery();
				
			a2 = "";
			g2 = "";
			s2 = "";
			int count = 0;
			int sum = 0;
			while(result.next())
			{
				
				int curg = result.getInt("GRADE");
				sum = sum + curg;
				count++;
				
			}
			
			if(count != 0)
			{
				favg = sum/count;
			}
				
			 
			}
				
			
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			try{
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		} 
		 

		 //Sixth query 
		 else if( id ==0 && type==0 && avgid == 0 && avgtype == 0 )
		 {
			
			try{
				
			String sql = "select grade from " + "STUDENTS " + "where atype = ? and assignment = ?";
			 
		   	PreparedStatement preStatement = conn.prepareStatement(sql);
		  
		   	System.out.println(hltype);
		   	System.out.println(course);
		   	
		   
		   	preStatement.setInt(1,hltype);
		 	preStatement.setString(2,course);
		   	
			ResultSet result = preStatement.executeQuery();
				
			a2 = "";
			g2 = "";
			s2 = "";
			g = new ArrayList<Integer>();
			while(result.next())
			{
				
				int curg = result.getInt("GRADE");
				g.add(curg);
				
			}
			
			
			
			for(int i=0; i<g.size(); i++)
			{
				if(g.get(i) < l)
				{
					l = g.get(i);
				}
			}
			
			for(int i=0; i<g.size(); i++)
			{
				if(g.get(i) > h)
				{
					h = g.get(i);
				}
			}
			 
			}
				
			
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			try{
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}  
		 
		  	
		  	
		 
		 
		 
		  
	      // Set response content type
	      response.setContentType("text/html");
 	      
	      request.setAttribute("assignments",a2);
	      request.setAttribute("average", favg);
	      request.setAttribute("high", h);
	      request.setAttribute("low", l);
	      
	      getServletContext()
	      	.getRequestDispatcher("/output2.jsp")
	      	.forward(request, response);
	 
	   }
	  
	  public void doPost(HttpServletRequest request,
              HttpServletResponse response)
      throws ServletException, IOException
      {
		  doGet(request, response);
      }

	   public void destroy() 
	   { 
	     // do nothing. 
	   } 

}
