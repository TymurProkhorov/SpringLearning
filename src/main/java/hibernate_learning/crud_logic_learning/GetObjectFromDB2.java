package hibernate_learning.crud_logic_learning;

import hibernate_learning.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetObjectFromDB2 { // получение объекта из БД с помощью HQL
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory(); // создана SessionFactory

        try {
            Session session = factory.getCurrentSession(); // создана сессия
            session.beginTransaction(); // открыли транзакцию. В SQL открывается автоматически, здесь - вручную.

            // получим всех работников и выведем их на экран
            List<Employee> employees = session.createQuery("from Employee") // создается очередь объектов из класса Employee
                    .getResultList(); //  и пакуется в List
            for (Employee employee : employees) {
                System.out.println(employee); // выводим
            }
            session.getTransaction().commit();

            // получим всех работников по имени Tim
            Session session1 = factory.getCurrentSession();
            session1.beginTransaction();
            List<Employee> employees1 = session1.createQuery("from Employee where name = 'Tim'").getResultList();
            for (Employee employee: employees1) {
                System.out.println(employee);
            }

            session1.getTransaction().commit(); // закрыли транзакцию. В SQL тоже вручную надо закрывать.
            System.out.println("Done!");
        } finally {
            factory.close(); // можно через TWR
        }
    }
}
