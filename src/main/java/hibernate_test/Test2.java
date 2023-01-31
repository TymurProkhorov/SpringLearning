package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 { // получение объекта по id из БД с помощью get()
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory(); // создана SessionFactory

        try {
            Session session = factory.getCurrentSession(); // создана сессия
            Employee emp1 = new Employee("Kosha", "Ryzhova", "CEO", 500000);
            session.beginTransaction(); // открыли транзакцию. В SQL открывается автоматически, здесь - вручную.
            session.save(emp1); // инсертим объект в БД
            session.getTransaction().commit(); // закрыли транзакцию. В SQL тоже вручную надо закрывать.

            int myId = emp1.getId();
            session = factory.getCurrentSession(); // создаем новую сессию, так как предыдущая транзакция закрыта
            session.beginTransaction();
            Employee employee = session.get(Employee.class, myId); // получаем объект из БД. Несуществующее айди выдаст null
            session.getTransaction().commit(); // закрываем транзакцию
            System.out.println(employee); // что-то делаем с объектом.
        } finally {
            factory.close(); // можно через TWR
        }
        System.out.println("Done!");
        }
}
