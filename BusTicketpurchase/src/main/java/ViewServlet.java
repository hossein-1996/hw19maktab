import Dao.DirectionDao;
import Dao.UserDao;
import entity.Direction;
import entity.User;
import lombok.SneakyThrows;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ViewServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        DirectionDao directionDao = new DirectionDao(entityManager);
        resp.setContentType("text/html");

        Date date = stringtodate(req.getParameter("tarikh"));
        String beginning = req.getParameter("beginning");
        String destination = req.getParameter("Destination");
        System.out.println(date +"+"+beginning+"+"+destination);
//        Date startDate=new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("startDate"));
        List<Direction> directions = directionDao.loadDirection(beginning,destination,date);

        System.out.println(directions);

        req.setAttribute("directions", directions);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/history.jsp");
        dispatcher.forward(req, resp);
        req.setAttribute("directions", directions);
        RequestDispatcher dispatcher2 = req.getRequestDispatcher("/servlet4");
        dispatcher2.forward(req, resp);
        entityManager.getTransaction().commit();


    }
        public static java.util.Date stringtodate(String date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return  dateFormat.parse(date);
    }
}