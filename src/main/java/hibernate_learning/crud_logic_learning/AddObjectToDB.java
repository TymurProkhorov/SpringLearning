package hibernate_learning.crud_logic_learning;

import hibernate_learning.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddObjectToDB { // добавление объекта в БД
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory(); // создана SessionFactory

        try {
            Session session = factory.getCurrentSession(); // создана сессия
//            Employee emp1 = new Employee("Tim", "Prokhorov", "IT", 5000);
            Employee emp2 = new Employee("Anna", "Prokhorova", "Recruitment", 5000);
            session.beginTransaction(); // открыли транзакцию. В SQL открывается автоматически, здесь - вручную.
            session.save(emp2); // инсертим объект в БД
            session.getTransaction().commit(); // закрыли транзакцию. В SQL тоже вручную надо закрывать.
        } finally {
            factory.close(); // можно через TWR
        }
        System.out.println("Done!");
        }
}
