import Dao.UserDao;
import entity.User;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user =new User();
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        UserDao userDao =new UserDao(entityManager);

        String usrname = req.getParameter("userName");
        user.setfirstName( req.getParameter("firstName"));
         user.setLastname(req.getParameter("lastName"));
        user.setEmail(req.getParameter("email"));
        user.setUserName(req.getParameter("userName"));
        user.setPassword(req.getParameter("password"));
        userDao.save(user);
        req.getRequestDispatcher("index.jsp").forward(req,resp);




        entityManager.getTransaction().commit();

    }
}


