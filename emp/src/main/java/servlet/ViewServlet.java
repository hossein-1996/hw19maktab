package servlet;

import dao.EmployeeDao;
import entity.Employee;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
//        resp.setContentType("text/html");
//        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
//        EmployeeDao employeeDao = new EmployeeDao(entityManager);
//        List<Employee> employees = employeeDao.loadAll(entityManager);
//        PrintWriter printWriter = resp.getWriter();
//        for (int i=0; i<employees.size() ; i++){
//            printWriter.println(employees.get(i));
//        }
        //        resp.setContentType("text/html");
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EmployeeDao employeeDao = new EmployeeDao(entityManager);
        List<Employee> employees = employeeDao.loadAll(entityManager);
        PrintWriter printWriter = resp.getWriter();

        printWriter.println("[");
        for (int i=0; i<employees.size() ; i++){
            printWriter.println(employees.get(i));
            if (i != employees.size()-1)
                printWriter.println(",");
        }
        printWriter.println("]");

    }
}
