package Member;


import DBconf.DBManager;


import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class MemberDAO {
    private MemberDAO() {

    }

    private static MemberDAO instance = new MemberDAO();

    public static MemberDAO getInstance() {
        return instance;
    }

    public int memberCheck(String id, String pw) {
        int result = -1;
        String sql = "SELECT pw FROM members WHERE id=?";
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

    public MemberBean getMember(String userid) {	MemberBean memberBean = null;
        String sql = "select * from member where userid=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBManager.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userid);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                memberBean = new MemberBean();
                memberBean.setId(rs.getString("id"));
                memberBean.setPhone(rs.getString("pw"));
                memberBean.setName(rs.getString("name"));
                memberBean.setPhone(rs.getString("phone"));
                memberBean.setKind(rs.getString("kind"));
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
        return memberBean;
    } // getMember end
    }

