/*
        Created by IntelliJ IDEA.
        User: devksh930
        Date: 2019/11/12
        Info: Talent List Control Servlet
        Time: 9:02 오전
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
import java.util.Date;
import java.util.List;

public class TalentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String urlSubPath = request.getPathInfo().split("/")[1];
        String viewName = null;
        System.out.println(urlSubPath);

        TalentDAO talentDAO = TalentDAO.getInstance();
        List<TalentBean> talentlist = null;
        switch (urlSubPath) {
            case "all":
                System.out.println(urlSubPath);
                talentlist = talentDAO.getList();
                break;
            case "design":
                System.out.println(urlSubPath);
                talentlist = talentDAO.getCategoryList(String.valueOf(2));
                break;
            case "it":
                System.out.println(urlSubPath);
                talentlist = talentDAO.getCategoryList(String.valueOf(3));
                break;
            case "business":
                talentlist = talentDAO.getCategoryList(String.valueOf(4));
                break;
            case "text":
                System.out.println(urlSubPath);
                talentlist = talentDAO.getCategoryList(String.valueOf(5));
                break;
            case "trans":

                System.out.println(urlSubPath);
                talentlist = talentDAO.getCategoryList(String.valueOf(12));
                break;
            case "tutor":
                System.out.println(urlSubPath);
                talentlist = talentDAO.getCategoryList(String.valueOf(13));
                break;
            case "etc":

                System.out.println(urlSubPath);
                talentlist = talentDAO.getCategoryList(String.valueOf(14));
                break;
        }
        request.setAttribute("talentlist", talentlist);
        viewName = "/commission_list.jsp";

        if (viewName != null) {
            RequestDispatcher view = request.getRequestDispatcher(viewName);
            view.forward(request, response);
        }
    }
}
