package yesmysql;
import java.sql.*;
import java.io.*;

public class MySql {

    
    public static void main(String[] args)throws IOException {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       
       Connection con=null;
          try{
       Class.forName("com.mysql.cj.jdbc.Driver");
       System.out.println("Driver loaded");
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sarthak","root","12345");
       System.out.println("Connection Established");
     Statement st=con.createStatement();
     ResultSet rs;
     System.out.println("To create table enter yes otherwise no");
     String a=br.readLine();
     if(a.equals("yes"))
     {
    System.out.println("Enter name of table");
    String n=br.readLine();
    st.execute("create table "+n+"(name varchar(10),rollno int(5),course varchar(7))");
     System.out.println("..Table created..");
     }
     else
     {
     rs=st.executeQuery("Select * from customers");
     while(rs.next())
     {
     String str=rs.getString("name");
     System.out.println(str);
       }
          }
          }
       catch(ClassNotFoundException e){
           System.out.println("Exception:"+e.getMessage());
       }
          catch(SQLException e)
          {
              System.out.println(e.getMessage());
          }
    }
    
}
