/*
        Created by IntelliJ IDEA.
        User: devksh930
        Date: 2019/12/01
        Info: TalentDel parameter Control Servlet
        Time: 12:21 오전
        To change this template use File | Settings | File Templates.
        */
package Talent.Control;

import Talent.Model.TalentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TalentDelServlet")
public class TalentDelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //input parma talent idx
        String idx = request.getParameter("idx");
        TalentDAO talentDAO = TalentDAO.getInstance();

        int result = talentDAO.deltalent(idx);

        if (result == 1) {
            request.setAttribute("message", "재능 삭제 성공했습니다.");
        } else {
            request.setAttribute("message", "재능 삭제에 실패했습니다.");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("./talent/all");
        dispatcher.forward(request, response);
    }
}
