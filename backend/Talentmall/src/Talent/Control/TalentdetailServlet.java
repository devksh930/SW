/*
        Created by IntelliJ IDEA.
        User: devksh930
        Date: 2019/11/12
        Info: Talente Detailview Parameter Control Servlet
        Time: 9:02 오전
        To change this template use File | Settings | File Templates.
        */
package Talent.Control;

import Member.Model.MemberDAO;
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

@WebServlet(name = "TalentdetailServlet")
public class TalentdetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String idx= request.getParameter("idx");
        System.out.println("idx는" +idx);
        TalentDAO talentDAO = TalentDAO.getInstance();
        TalentBean detailview = null;
        detailview = talentDAO.detailview(idx);

       //System.out.println("Bena??"+detailview.getTitle()+detailview.getContents());
        request.setAttribute("detailview",detailview);


        RequestDispatcher rd =request.getRequestDispatcher("detailSection.jsp");
        rd.forward(request,response);

    }
}
