
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class DatabaseConnectivity{

    /**
     *
     * @param name
     * @param email
     * @param phoneNumber
     * @param message
     */
    

    public void getConnection(String name,String email,String phoneNumber,String message,PrintWriter out){
//        out.println("statement created");
         Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234567890");
        }catch(ClassNotFoundException | SQLException e){
            out.println(e);
        }
        try{
            String query="insert into db values(?,?,?,?)";
            PreparedStatement st= con.prepareStatement(query);
            st.setString(1, name);
            st.setString(2, email);
            st.setString(3, phoneNumber);
            st.setString(4, message);
            st.executeUpdate();
            }
        catch(Exception e){
            out.println("<div style=\"width:\"100%\",display:\"flex\">");
            out.println("<h1 style=\"Justify-Content:Center\" , Align-Items:\"center\" >Details are incorrect</h1>");
             out.println("</div>");
        }
        
    }   
}
