package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory(); // создана SessionFactory

        try {
            Session session = factory.getCurrentSession(); // создана сессия
            Employee emp1 = new Employee("Tim", "Prokhorov", "IT", 5000);
            session.beginTransaction(); // открыли транзакцию. В SQL открывается автоматически, здесь - вручную.
            session.save(emp1); // инсертим объект в БД
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
        }
}
