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
import java.util.Date;
import java.util.List;

public class TalentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TalentDAO talentDAO = TalentDAO.getInstance();
        List<TalentBean> talentlist=talentDAO.getList();

//        List<CategoryBean> sectionlist=categoryDAO.getDevision(2);

        request.setAttribute("talentlist",talentlist);

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request,response);
    }
}
