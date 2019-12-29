package lesson22_23.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "lesson22_23.servlet.MainServlet", urlPatterns = {"hello"}, loadOnStartup = 1)
public class MainServlet extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().print("Hello, World!");
    }
//@Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String name = request.getParameter("name");
//        if (name == null) name = "World";
//        request.setAttribute("user", name);
//        request.getRequestDispatcher("response.jsp").forward(request, response);
//    }

}
