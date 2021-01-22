
package dao;

import connection.MyConnection;
import model.Product;
import java.sql.*;
import java.util.*;
public class ProductDAO 
{
         public static  boolean  checkLogin(String uname,String upass)throws Exception
          {
              
               Connection con=null;
              PreparedStatement ps=null;
              ResultSet rs=null;
              con=MyConnection.getConnection();
              String sql;
              sql="select * from productlogin where username=? and password=?";
              ps=con.prepareStatement(sql);
              ps.setString(1, uname);
              ps.setString(2, upass);
              rs=ps.executeQuery();
              if(rs.next())
                  return true;
              
              return false;
          }
    
    
           public boolean insertProduct(Product P) throws Exception
           {
              Connection con=null;
              PreparedStatement ps=null;
              con=MyConnection.getConnection();
              String sql;
              sql="insert into product values(?,?,?,?)";
              ps=con.prepareStatement(sql);
              ps.setInt(1, P.getId());
              ps.setString(2, P.getName());
              ps.setInt(3, P.getPrice());
              ps.setString(4, P.getType());
              if(ps.executeUpdate()>0)
                  return true;
              
             return false;
              
           }
           public boolean deleteById(int id) throws Exception
           {
           
                  Connection con=null;
                  PreparedStatement ps=null;
                 ResultSet rs=null;
                  con=MyConnection.getConnection();
                 String sql;
                 sql="delete from product where pid=?";
                 ps=con.prepareStatement(sql);
                 ps.setInt(1, id);
                 if(ps.executeUpdate()>0)
                     return true;
               
               return  false;
           }
           
           
           
           
           
           public List<Product> searchAll() throws Exception
           {
                  Connection con=null;
                  PreparedStatement ps=null;
                  ResultSet rs=null;
                  con=MyConnection.getConnection();
                  String sql;
                  sql="select * from product";
                  ps=con.prepareStatement(sql);
                  rs=ps.executeQuery();
                  List<Product>mylist=new ArrayList<Product>();
                  
                  while(rs.next())
                  {
                     Product P=new Product();
                     P.setId(rs.getInt(1));
                     P.setName(rs.getString(2));
                     P.setPrice(rs.getInt(3));
                     P.setType(rs.getString(4));
                     mylist.add(P);
                     P=null;   
                  }
               
               return mylist;
           }
           
           
           public Product searchById(int id) throws Exception
           {
                  Connection con=null;
                  PreparedStatement ps=null;
                 ResultSet rs=null;
                  con=MyConnection.getConnection();
                 String sql;
                 sql="select * from product where pid=?";
                 ps=con.prepareStatement(sql);
                 ps.setInt(1, id);
                 rs=ps.executeQuery();
                 Product P=new Product();
                 if(rs.next())
                 {
                     P.setId(rs.getInt(1));
                     P.setName(rs.getString(2));
                     P.setPrice(rs.getInt(3));
                     P.setType(rs.getString(4));
                 }
                 else
                     P=null;
                 
               return P;  
           }
   
       public boolean updateProduct(Product P) throws Exception
           {
              Connection con=null;
              PreparedStatement ps=null;
              con=MyConnection.getConnection();
              String sql;
              sql="update Product set pname=?,price=?,ptype=? where pid=?";
              ps=con.prepareStatement(sql);
              ps.setString(1, P.getName());
              ps.setInt(2, P.getPrice());
              ps.setString(3, P.getType());
              ps.setInt(4, P.getId());
              if(ps.executeUpdate()>0)
                  return true;
              
             return false;
              
           }     
           
           
           
}
