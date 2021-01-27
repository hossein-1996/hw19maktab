package servlet;

import dao.EmployeeDao;
import entity.Employee;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter() ;

        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String email = req.getParameter("email");

        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);

        EntityManagerFactory entityManagerfactory =  JPAUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerfactory.createEntityManager();
        entityManager.getTransaction().begin();

        EmployeeDao employeeDao = new EmployeeDao(entityManager);
        employeeDao.save(employee);

        entityManager.getTransaction().commit();
        entityManager.close();
        JPAUtil.shutdown();

        writer.println("Successful saved");
        req.getRequestDispatcher("/index.jsp").include(req,resp);

    }
}
