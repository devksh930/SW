package Member.Control;


import Member.Model.MemberBean;
import Member.Model.MemberDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");


        String url = "index.jsp";
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        MemberDAO memberDAO = MemberDAO.getInstance();
        //System.out.println(id);
        //System.out.println(pw);
        int result = memberDAO.memberCheck(id, pw);
        //System.out.println("로그인체크" + result);
        if (result == 1) {
            MemberBean memberBean = memberDAO.getMember(id);  //유저의 정보를 받아와서 vo에 저장
            HttpSession session = request.getSession();  //세션 객체 생성
            session.setAttribute("loginUser", memberBean);  // vo에 저장한 유저정보를 세션  값으로 입력
            request.setAttribute("message", "로그인에 성공했습니다.");
            url = "index.jsp";
        } else if (result == 0) {
            request.setAttribute("message", "비밀번호가 틀렸습니다.");
        } else if (result == -1) {
            request.setAttribute("message", "존재하지 않는 회원입니다.");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "index.jsp";
        HttpSession session = request.getSession();
        String pathinfo = request.getPathInfo();
        System.out.println("path는?");

        if (session.getAttribute("loginuser") != null) {
            url = "index.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
