/*
        Created by IntelliJ IDEA.
        User: devksh930
        Date: 2019/11/12
        Info: USE AdminBean DATA access object
        Time: 9:02 오전
        Class:AdminDAO
        To change this template use File | Settings | File Templates.
        */
package Member.Model;

import DBconf.DBManager;
import org.apache.axis.utils.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO extends DBManager {

    private AdminDAO() {

    }

    private static AdminDAO instance = new AdminDAO();

    public static AdminDAO getInstance() {
        return instance;
    }

    public int memberCheck(String id, String pw) { //DB CHECK ID SQL
        int result = -1;
        String sql = "SELECT pw FROM admins WHERE id=?";
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.connect();
            System.out.println(id);
            System.out.println(pw);
            System.out.println(conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getString("pw") != null && rs.getString("pw").equals(pw)) {
                    result = 1; //회원
                } else {
                    result = 0; //비밀번호틀림
                }
            } else {
                result = -1; // 회원아님
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public AdminBean getMember(String id) { //ADMIN CHECK
        AdminBean adminBean = null;
        String sql = "select * from admin where id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBManager.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                adminBean = new AdminBean();
                adminBean.setId(rs.getString("id"));
                adminBean.setPw(rs.getString("pw"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return adminBean;
    } // getMember end
}
