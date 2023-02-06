package hibernate_learning_relations.one_to_many_uni;

import hibernate_learning_relations.one_to_many_uni.entity.Department;
import hibernate_learning_relations.one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneTOManyUni {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            Department department = new Department("Sales", 2000, 200);
            Employee emp1 = new Employee("Kosha", "Ryzhova", 1200);
            Employee emp2 = new Employee("Okorochok", "Chernov", 1400);
            department.addEmployeeToDepartment(emp1);
            department.addEmployeeToDepartment(emp2);
            session.beginTransaction();

            session.save(department); // благодаря односторонней связи и каскаду, при сохранении департамента, сохранятся и работники.

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            sessionFactory.close();
        }
    }
}

