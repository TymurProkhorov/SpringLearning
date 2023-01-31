package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test5 { // удаление объекта из БД
    public static void main(String[] args) {


        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee emp = session.get(Employee.class, 1);
            session.delete(emp);
            /* если нет готового объекта для удаления или нужно удалить несколько объектов, то потребуется HQL-query:
            session.createQuery("delete Employee where name = 'Tim'").executeUpdate; */
            session.getTransaction().commit(); // после коммита удаление вступит в силу
            System.out.println("Done!");
        }
    }
}
