/*
        Created by IntelliJ IDEA.
        User: devksh930
        Date: 2019/12/4
        Info: USE TalentBean DATA access object
        Time: 9:02 오전
        To change this template use File | Settings | File Templates.
        */
package Talent.Model;

import Category.Model.CategoryBean;
import DBconf.DBManager;
import Member.Model.MemberBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TalentDAO {
    private TalentDAO() {
    }

    private static TalentDAO instance = new TalentDAO();

    public static TalentDAO getInstance() {
        return instance;
    }

    public int deltalent(String idx) { //DELTE TALENT SQL
        int result = -1;
        String sql = "DELETE FROM talents where idx = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBManager.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, idx);
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


    public int updatetalent(String title, String content, String idx) { //UPDATE TALENT SQL
        int result = -1;
        String sql = "UPDATE talents SET title=?, contents=? where idx = ? ";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setString(3, idx);
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

    public TalentBean detailview(String talentidx) { //TALENT DETAIL VIEW
        TalentBean talentBean = null;
        String sql = "select * from talents where idx=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBManager.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, talentidx);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                talentBean = new TalentBean();
                talentBean.setIdx(rs.getInt("idx"));
                talentBean.setTitle(rs.getString("title"));
                talentBean.setContents(rs.getString("contents"));
                talentBean.setStart_date(rs.getString("start_date"));
                talentBean.setEnd_date(rs.getString("end_date"));
                talentBean.setMember_id(rs.getString("member_id"));
                talentBean.setCategory_id(rs.getString("category_idx"));
                // System.out.println("query??" + talentBean.getContents());
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
        return talentBean;
    } // getMember end

    public ArrayList<TalentBean> getList() { //TALENT GET ALL LIST
        String sql = "select * from talents";
        ArrayList<TalentBean> list = new ArrayList<TalentBean>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBManager.connect();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                TalentBean talentBean = new TalentBean();
                talentBean.setIdx(rs.getInt("idx"));
                talentBean.setTitle(rs.getString("title"));
                talentBean.setContents(rs.getString("contents"));
                talentBean.setStart_date(rs.getString("start_date"));
                talentBean.setEnd_date(rs.getString("end_date"));
                talentBean.setMember_id(rs.getString("member_id"));
                talentBean.setCategory_id(rs.getString("category_idx"));
                list.add(talentBean);


            }
        } catch (SQLException e) {
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

        return list;
    }

    public int talentInsert(String category, String title, String id, String content) { //TALENT INSERT SQL
        int result = -1;
        String sql = "INSERT INTO talents (title, contents,end_date, member_id,category_idx) VALUES (?, ?, CURRENT_TIMESTAMP + INTERVAL '7' DAY, ?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBManager.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setString(3, id);
            pstmt.setString(4, category);

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


    public ArrayList<TalentBean> getCategoryList(String idx) { //TALENT INSERTING GET CATEGORY
        String sql = "select * from talents where category_idx = ?";
        ArrayList<TalentBean> list = new ArrayList<TalentBean>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBManager.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, idx);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                TalentBean talentBean = new TalentBean();
                talentBean.setIdx(rs.getInt("idx"));
                talentBean.setTitle(rs.getString("title"));
                talentBean.setContents(rs.getString("contents"));
                talentBean.setStart_date(rs.getString("start_date"));
                talentBean.setEnd_date(rs.getString("end_date"));
                talentBean.setMember_id(rs.getString("member_id"));
                talentBean.setCategory_id(rs.getString("category_idx"));
                list.add(talentBean);
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i).getTitle());
                } //카테고리 테스트


            }
        } catch (SQLException e) {
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

        return list;
    }
}