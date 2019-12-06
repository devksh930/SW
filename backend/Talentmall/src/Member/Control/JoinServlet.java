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

public class JoinServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");


        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String role = request.getParameter("role");
        MemberBean memberBean = new MemberBean();
        memberBean.setId(id);
        memberBean.setPw(pw);
        memberBean.setName(name);
        memberBean.setPw(pw);
        memberBean.setPhone(phone);
        memberBean.setKind(role);
        MemberDAO memberDAO = MemberDAO.getInstance();
        int result = memberDAO.memberJoin(memberBean);
        HttpSession session = request.getSession();
        if (result == 1) {
            session.setAttribute("id", memberBean.getId());
            request.setAttribute("message", "회원 가입에 성공했습니다.");
        } else {
            request.setAttribute("message", "회원 가입에 실패했습니다.");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
