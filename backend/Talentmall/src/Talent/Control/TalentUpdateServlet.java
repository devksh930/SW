/*
        Created by IntelliJ IDEA.
        User: devksh930
        Date: 2019/12/02
        Info: Talent Update parameter Control Servlet
        Time: 20:12 오전
        To change this template use File | Settings | File Templates.
        */
package Talent.Control;

import Category.Model.CategoryBean;
import Category.Model.CategoryDAO;
import Talent.Model.TalentBean;
import Talent.Model.TalentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TalentUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String idx = request.getParameter("idx");
        String category = request.getParameter("category");
        String title = request.getParameter("title");
        String id = request.getParameter("id");
        String content = request.getParameter("content");
       //PARAM CHECK
        /*
        System.out.println(idx);
        System.out.println("카, 타, 아,콘");
        System.out.println(category);
        System.out.println(title);
        System.out.println(id);
        System.out.println(content);

         */
        TalentDAO talentDAO = TalentDAO.getInstance();
        int result = talentDAO.updatetalent(title,content,idx);
        if (result == 1) {
            request.setAttribute("message", "재능 등록에 성공했습니다.");
        } else {
            request.setAttribute("message", "재능 추가에 실패했습니다.");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        System.out.println(dispatcher);
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String idx = request.getParameter("idx");

        CategoryDAO categoryDAO = CategoryDAO.getInstance();
        List<CategoryBean> categoryList = categoryDAO.getsection();

        TalentDAO talentDAO = TalentDAO.getInstance();
        TalentBean detailview = null;
        detailview = talentDAO.detailview(idx);

       // System.out.println("Bean??" + detailview.getTitle() + detailview.getContents()); //BEAN PARAM CHECK

        request.setAttribute("categoryList",categoryList);
        request.setAttribute("detailview", detailview);

        RequestDispatcher rd =request.getRequestDispatcher("update_commission.jsp");
        rd.forward(request,response);


    }
}
