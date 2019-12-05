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

@WebServlet(name = "CartegoryServlet")
public class CartegoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = CategoryDAO.getInstance();
        //List<CategoryBean> list=categoryDAO.getsection();

        List<CategoryBean> list=categoryDAO.getDevision(2);

        request.setAttribute("list",list);

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request,response);
    }
}
