import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Employee.class);
        SessionFactory factory =configuration.buildSessionFactory();
        Session session=factory.getCurrentSession();

        Employee employee = new Employee();
       // employee.setIdEmployee(6);
        employee.setFirstname("Marcin");
        employee.setLastname("Baclawski");
        employee.setSalary(3000);

        //zapisywanie
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
       // factory.close();

        session=factory.getCurrentSession();

        session.beginTransaction();
        String hql = "FROM Employee";
        Query query = session.createQuery(hql);
        List q = query.list();
        session.getTransaction().commit();
        factory.close();
    }
}
