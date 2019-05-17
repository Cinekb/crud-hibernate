package db;

import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class DBConnection {


    public void addtoDB(String imie, String nazwisko, Integer pensja) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Employee.class);
        SessionFactory factory = configuration.buildSessionFactory();;
        Session session = factory.getCurrentSession();

        Employee employee = new Employee();
        employee.setFirstname(imie);
        employee.setLastname(nazwisko);
        employee.setSalary(pensja);

        //zapisywanie
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        factory.close();
    }

    public List<Employee> findall(){
      Configuration configuration = new Configuration();
      configuration.configure("hibernate.cfg.xml");
      configuration.addAnnotatedClass(Employee.class);
      SessionFactory factory = configuration.buildSessionFactory();;
      Session session = factory.getCurrentSession();
      session.beginTransaction();
      String hql = "FROM Employee";
      Query query = session.createQuery(hql);
      List q = query.list();
      session.getTransaction().commit();
      factory.close();
      return q;
  }

    public void removefromDb(Integer id) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Employee.class);
        SessionFactory factory = configuration.buildSessionFactory();;
        Session session = factory.getCurrentSession();

        Employee employee = new Employee();
        employee.setIdEmployee(id);
//        employee.setFirstname(imie);
//        employee.setLastname(nazwisko);
//        employee.setSalary(pensja);

        //zapisywanie
        session.beginTransaction();
        session.remove(employee);
        session.getTransaction().commit();
        factory.close();
    }

    public void editfromDb(Integer id,String imie,String nazwisko, Integer pensja){

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Employee.class);
        SessionFactory factory = configuration.buildSessionFactory();;
        Session session = factory.getCurrentSession();

        Employee employee = new Employee();
        employee.setIdEmployee(id);
        employee.setFirstname(imie);
        employee.setLastname(nazwisko);
        employee.setSalary(pensja);


        session.beginTransaction();
        session.update(employee);
        session.getTransaction().commit();
        factory.close();
    }

}

