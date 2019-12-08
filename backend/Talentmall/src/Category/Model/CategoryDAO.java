/*
        Created by IntelliJ IDEA.
        User: devksh930
        Date: 2019/11/29
        Info: commission list
        Time: 9:02 오전
        Class:CategoryDAO
        To change this template use File | Settings | File Templates.
        */
package Category.Model;

import DBconf.DBManager;
import Member.Model.AdminBean;
import Member.Model.MemberDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAO extends DBManager {
    private CategoryDAO() {
    }

    private static CategoryDAO instance = new CategoryDAO();

    public static CategoryDAO getInstance() {
        return instance;
    }

    public ArrayList<CategoryBean> getsection() { //GET CATEGORY LIST ALL
        String sql = "select * from category";
        ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBManager.connect();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                CategoryBean categoryBean = new CategoryBean();
                categoryBean.setIdx(rs.getInt("idx"));
                categoryBean.setName(rs.getString("name"));
                categoryBean.setCategory_idx(rs.getInt("category_idx"));
                list.add(categoryBean);
//                for(int i=0; i<list.size(); i++){
//                    System.out.println(list.get(i).getName());
//                } //카테고리 테스트

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
        return list;
    } // getMember end

    public ArrayList<CategoryBean> getDevision(int idx) { //GET CATEGORY LIST in param
        String sql = "select * from category where category_idx = ?";
        ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.connect();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(idx));
            rs = pstmt.executeQuery();

            while (rs.next()) {
                CategoryBean categoryBean = new CategoryBean();
                categoryBean.setIdx(rs.getInt("idx"));
                categoryBean.setName(rs.getString("name"));
                list.add(categoryBean);
//                for(int i=0; i<list.size(); i++){
//                    System.out.println(list.get(i).getName());
//                } //카테고리 테스트

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
