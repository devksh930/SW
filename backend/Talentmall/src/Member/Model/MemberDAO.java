package Member.Model;


import DBconf.DBManager;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MemberDAO extends DBManager {
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

    public MemberBean getMember(String userid) {
        MemberBean memberBean = null;
        String sql = "select * from members where id=?";
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
                memberBean.setPw(rs.getString("pw"));
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

    public int memberJoin(MemberBean memberBean) {
        int result = -1;
        String sql = "insert into members values(?,?,?,?,?)";
        String kind = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBManager.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberBean.getId());
            pstmt.setString(2, memberBean.getPw());
            pstmt.setString(3, memberBean.getName());
            pstmt.setString(4, memberBean.getPhone());
            if (memberBean.getKind().equals("소비자")) {
                kind = "1";
            } else if (memberBean.getKind().equals("생산자")) {
                kind = "2";
            }

            pstmt.setString(5, kind);
            result = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}

