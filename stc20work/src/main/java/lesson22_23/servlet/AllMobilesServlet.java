package lesson22_23.servlet;


import lesson22_23.dao.MobileDao;
import lesson22_23.pojo.Mobile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(urlPatterns = "/allmobiles", name = "Mobiles")
public class AllMobilesServlet extends HttpServlet {
    private MobileDao mobileDao;

    private static Logger LOGGER = LogManager.getLogger(AllMobilesServlet.class);


    @Override
    public void init() throws ServletException {
        mobileDao = (MobileDao) getServletContext().getAttribute("dao");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Mobile> mobiles = mobileDao.getAllMobile();
        req.setAttribute("mobiles", mobiles);
        req.setAttribute("PageTitle", "Mobiles");
        req.setAttribute("PageBody", "allmobiles.jsp");
        req.getRequestDispatcher("/layout.jsp")
            .forward(req, resp);
    }
}
