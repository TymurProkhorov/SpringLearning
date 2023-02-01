package hibernate_learning.crud_logic_learning;

import hibernate_learning.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UpdateObjectInDB { // изменение объекта БД
    public static void main(String[] args) {


        try (SessionFactory factory = new Configuration() // создадим SessionFactory с пом. TWR.
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            // получим объект из таблицы с id = 3 и изменим ему ЗП
            Employee emp = session.get(Employee.class, 3); // получили
            emp.setSalary(1000);

            session.getTransaction().commit(); // после коммита это изменение отобразится в базе

            //изменим теперь ЗП всех работников по имени Tim
            Session session1 = factory.getCurrentSession();
            session1.beginTransaction();
            List<Employee> employeeList = session1.createQuery("from Employee where name = 'Tim'").getResultList();
            for (Employee employee: employeeList) {
                employee.setSalary(100);
            }
            /*
             а еще можно так, вариант Заура:
             session.createQuery("update Employee set salary = 100 where name = 'Tim'").executeUpdate();
             */
            session1.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
