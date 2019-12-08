/*
        Created by IntelliJ IDEA.
        User: devksh930
        Date: 2019/12/01
        Info: Talent Insert Parameter Control Servlet
        Time: 19:02 오후
        Class TalentInsertServlet
        To change this template use File | Settings | File Templates.
        */
package Talent.Control;

import Category.Model.CategoryBean;
import Category.Model.CategoryDAO;
import Talent.Model.TalentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class TalentInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String category = request.getParameter("category");
        String title = request.getParameter("title");
        String id = request.getParameter("id");
        String content = request.getParameter("content");
       /*
        //CHCK PARAM
        System.out.println("카, 타, 아,콘");
        System.out.println(category);
        System.out.println(title);
        System.out.println(id);
        System.out.println(content);
        */
        TalentDAO talentDAO = TalentDAO.getInstance();
        int result = talentDAO.talentInsert(category, title, id, content);

        if (result == 1) {
            request.setAttribute("message", "재능 등록에 성공했습니다.");
        } else {
            request.setAttribute("message", "재능 추가에 실패했습니다.");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("./talent/all");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        CategoryDAO categoryDAO = CategoryDAO.getInstance();
        List<CategoryBean> categoryList = categoryDAO.getsection();

        request.setAttribute("categoryList", categoryList);

        RequestDispatcher rd = request.getRequestDispatcher("write_commission.jsp");

        rd.forward(request, response);
    }
}
