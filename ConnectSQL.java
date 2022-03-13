/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Theory_JavaAdv;

import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

/**
 *
 * @author xtir0
 */
public class ConnectSQL {
//    private String serverName;
//    private int port;
//    private String userName;
//    private String password;
//    private String dbName;
    private Connection conn = null;
    
    public ConnectSQL() {
        
    }
    public void Connect(String serverName, int port, String userName, String password, String dbName) {
        try {
            SQLServerDataSource ds = new SQLServerDataSource();
            ds.setServerName(serverName);
            ds.setPortNumber(port);
            ds.setUser(userName);
            ds.setPassword(password);
            ds.setDatabaseName(dbName);
            conn = ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Lấy dữ liệu
    public ResultSet getData(String query) {
        ResultSet rs = null;
        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    // Cập nhật dữ liệu
    public void excute(String query) {
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
}
