import Dao.DirectionDao;
import Dao.UserDao;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class App {
//    public static java.util.Date stringtodate(String date) throws ParseException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        return  dateFormat.parse(date);
//    }
    public static void main(String[] args) throws ParseException {
        EntityManager entityManager= JPAUtil.getEntityManagerFactory().createEntityManager();

        entityManager.getTransaction().begin();
//        UserDao userDao = new UserDao(entityManager);
//        DirectionDao directionDao = new DirectionDao(entityManager);
//        System.out.println(userDao.loadMaxSalary("hosein1996","1234"));

//        System.out.println(directionDao.loadDirection("tehran","esfahan",stringtodate("1399-11-08")));
        entityManager.getTransaction().commit();
        entityManager.close();
        JPAUtil.shutdown();
    }
}
