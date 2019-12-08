/*
        Created by IntelliJ IDEA.
        User: devksh930
        Date: 2019/11/28
        Info: Category PARAMETER CONTROL SERVLET
        Time: 11:42 오전
        version: 1.0.0
        To change this template use File | Settings | File Templates.
        */
package Category.Control;

import Category.Model.CategoryBean;
import Category.Model.CategoryDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = CategoryDAO.getInstance();
        List<CategoryBean> sectionlist=categoryDAO.getsection();

//        List<CategoryBean> sectionlist=categoryDAO.getDevision(2);

        request.setAttribute("sectionlist",sectionlist);

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request,response);
    }
}
