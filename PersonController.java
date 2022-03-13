/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Theory_JavaAdv;
/**
 *
 * @author xtir0
 */
import java.sql.*;

public class PersonController {
    
    public ConnectSQL conn = new ConnectSQL();
    
    public PersonController() {
        conn.Connect("HL-PC\\SQLEXPRESS", 1466, "sa", "1", "Java");
    }
    
    public ResultSet getAll() {
        String query = "select * from Users order by id asc";
        return conn.getData(query);
    }
    public ResultSet getById(int id) {
        String query = "select * from Users where id = '"+id+"'";
        return conn.getData(query);
    }

    public ResultSet getByUP(String username, String password) {
        String query = "select * from Users where username = '"+username+"' and password = '"+password+"'";
        return conn.getData(query);
    }
    
    public ResultSet getByUser(String username) {
        String query = "select * from Users where username = '"+username+"'";
        return conn.getData(query);
    }
    
    public void insert(String username, String password, String firstname, String lastname, String gender, String phonenumber, String email) {
        String query = "insert into Users values('"+username+"', '"+password+"', N'"+firstname+"', N'"+lastname+"', '"+gender+"', '"+phonenumber+"', '"+email+"')";
        conn.excute(query);
    }
    
    public void delete(int username) {
        String query = "delete from Users where username ='"+username+"'";
        conn.excute(query);
    }
    
    public void update(int id, String username, String password, String firstname, String lastname, String gender, String phonenumber, String email) {
        String query = "update Users set username=N'"+username+"', password= '"+password+"', firstname= '"+firstname+"', lastname= '"+lastname+"', gender= '"+gender+"', phonenumber= '"+phonenumber+"', email= '"+email+"' where id='"+id+"'";
        conn.excute(query);
    }
    
    public int countRowAll() {
        int count = 0;
        try {
            ResultSet rs = getAll();
            while(rs.next()) {
                count++;
        }
        } catch (Exception e) {
        }
        return count;
    }
    
    public int countRowbyUP(String username, String password) {
        int count = 0;
        try {
            ResultSet rs = getByUP(username, password);
            while(rs.next()) {
                count++;
        }
        } catch (Exception e) {
        }
        return count;
    }
    
    public int countRowbyUser(String username) {
        int count = 0;
        try {
            ResultSet rs = getByUser(username);
            while(rs.next()) {
                count++;
        }
        } catch (Exception e) {
        }
        return count;
    }

}
