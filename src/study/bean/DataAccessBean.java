package study.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.naming.NamingException;
import java.sql.PreparedStatement;

@SuppressWarnings("serial")
public class DataAccessBean implements Serializable {
    public boolean authentication(String userName, String password)
            throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
        	String sql = "SELECT userid , password FROM idfile WHERE userid=?";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:oci8:@oracle.techscore","scott","tiger");
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            if (rs.next()) {
                String selectedPassword = rs.getString("password");
                if (!password.equals(selectedPassword)) {
                    return false;
                }
            } else {
                return false;
            }
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
    public Collection<ImportInfo> findAllUserInfo() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT code , country , symbol FROM countries ORDER BY symbol";
            Collection<ImportInfo> importList = new ArrayList<ImportInfo>();
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:oci8:@oracle.techscore","scott","tiger");
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
            	ImportInfo importInfo = new ImportInfo();
                importInfo.setCode(rs.getString("code"));
                importInfo.setCountries(rs.getString("country"));
                importInfo.setSymbol(rs.getString("symbol"));
                importList.add(importInfo);
            }
            return importList;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
    public void registImportInfo(ImportInfo importInfo) throws SQLException{
        Connection conn = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO countries(code, country, symbol) VALUES (?,?,?)";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:oci8:@oracle.techscore","scott","tiger");
            ps2 = conn.prepareStatement(sql);
            ps2.setString(1, importInfo.getCode());
            ps2.setString(2, importInfo.getCountries());
            ps2.setString(3, importInfo.getSymbol());
            ps2.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps2 != null) {
                ps2.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
    public void deleteUserInfo(String code) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM country WHERE code=?";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:oci8:@oracle.techscore","scott","tiger");
            ps = conn.prepareStatement(sql);
            ps.setString(1, code);
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException(e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
