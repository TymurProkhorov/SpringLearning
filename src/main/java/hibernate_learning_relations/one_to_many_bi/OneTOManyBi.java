package hibernate_learning_relations.one_to_many_bi;

import hibernate_learning_relations.one_to_many_bi.entity.Department;
import hibernate_learning_relations.one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneTOManyBi {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
//        try {
//            session = sessionFactory.getCurrentSession();
//
//            Department dept = new Department("IT", 1200, 300);
//            Employee emp1 = new Employee("Tim", "Prokhorov", 1000);
//            Employee emp2 = new Employee("Anna", "Prokhorova", 900);
//            dept.addEmployeeToDepartment(emp1);
//            dept.addEmployeeToDepartment(emp2);
//            session.beginTransaction();
//
//            session.save(dept); // сохранится  идеп-т и оба работника.
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//        } finally {
//            sessionFactory.close();
//        }

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Department dept = session.get(Department.class, 1); // получим департамент
            System.out.println(dept);
            System.out.println(dept.getEmps()); // и по каскаду всех работников этого деп-та

            Employee employee = session.get(Employee.class, 1); // также можно получить работника
            System.out.println(employee);
            System.out.println(employee.getDepartment()); // и его департамент

            /* session.delete(employee); в этом случае удалятся все работники и деп-т, так как стоит каскад ALL -
             он потянул за собой удаление деп-та, а удаление деп-та потянуло за собой удаление остальных работников.
             session.delete(dept) - то же самое, удалится деп-т и его работники
             Чтоб это исправить, например, удалить одного работника, нужно изменить каскад с ALL на PERSIST, DETACH,
             REFRESH и MERGE в обоих классах. */

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            sessionFactory.close();
        }
    }
}
