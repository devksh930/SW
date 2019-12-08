/*
        Created by IntelliJ IDEA.
        User: devksh930
        Date: 2019/11/28
        Info: Member LOGIN parameter control SERVLET
        Time: 9:02 오전
        To change this template use File | Settings | File Templates.
        */
package Member.Control;


import Member.Model.AdminBean;
import Member.Model.AdminDAO;
import Member.Model.MemberBean;
import Member.Model.MemberDAO;
import org.apache.axis.utils.Admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int result;
        String url = "login.jsp";
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        if (id.equals("admin")) { //CHECK ADMIN
            request.setAttribute("permission", "관리자 로그인");
            url = "admin.jsp";
            AdminDAO adminDAO = AdminDAO.getInstance();

            result = adminDAO.memberCheck(id, pw);

            if (result == 1) { //CHECK RETURN PARAM
                AdminBean login_user_info = adminDAO.getMember(id);  //유저의 정보를 받아와서 vo에 저장
                HttpSession session = request.getSession();  //세션 객체 생성
                session.setAttribute("loginUser", login_user_info);  // vo에 저장한 유저정보를 세션  값으로 입력
                request.setAttribute("message", "로그인에 성공했습니다.");
                url = "index.jsp";
            } else if (result == 0) {
                request.setAttribute("message", "비밀번호가 틀렸습니다.");
            } else if (result == -1) {
                request.setAttribute("message", "존재하지 않는 회원입니다.");
            }
        } else {
            MemberDAO memberDAO = MemberDAO.getInstance();
            //System.out.println(id);
            //System.out.println(pw);
            result = memberDAO.memberCheck(id, pw);
            //System.out.println("로그인체크" + result);
            MemberBean login_user_info = null;

            if (result == 1) {
                login_user_info = memberDAO.getMember(id);  //유저의 정보를 받아와서 vo에 저장
                HttpSession session = request.getSession();  //세션 객체 생성
                session.setAttribute("loginUser", login_user_info);  // vo에 저장한 유저정보를 세션  값으로 입력
                request.setAttribute("message", "로그인에 성공했습니다.");
                url = "index.jsp";
            } else if (result == 0) {
                request.setAttribute("message", "비밀번호가 틀렸습니다.");
            } else if (result == -1) {
                request.setAttribute("message", "존재하지 않는 회원입니다.");
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "login.jsp";
        HttpSession session = request.getSession();
        System.out.println("path는?");

        if (session.getAttribute("loginUser") != null) {
            url = "index.jsp";
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);


    }
}
