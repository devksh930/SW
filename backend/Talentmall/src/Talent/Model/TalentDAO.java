package Talent.Model;

import Category.Model.CategoryBean;
import DBconf.DBManager;

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

    public ArrayList<TalentBean> getList() {
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
                for(int i=0; i<list.size(); i++){
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


    public ArrayList<TalentBean> getCategoryList(String idx) {
        String sql = "select * from talents where category_idx = ?";
        ArrayList<TalentBean> list = new ArrayList<TalentBean>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBManager.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,idx);
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
                for(int i=0; i<list.size(); i++){
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