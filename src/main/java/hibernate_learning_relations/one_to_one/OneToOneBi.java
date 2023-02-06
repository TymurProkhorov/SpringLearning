package hibernate_learning_relations.one_to_one;

import hibernate_learning_relations.one_to_one.entity.Detail;
import hibernate_learning_relations.one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneBi {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class) // !!!
                .buildSessionFactory()) {
            Employee employee = new Employee("Vasya", "Obychnorabotnikov", "IT", 10);
            Detail empDetail = new Detail("Yzhka", 35798639, "VasyaRabotyaga@gmail.com");
             // !!!
            empDetail.setEmployee(employee);
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            // session.save(empDetail); добавил Кошу, но в таблице employees ее details_id будет null! исправим это при
            // добавлении нового работника - Vasya.
            // это будет достигаться с помощью сета их обоих, то есть и empDetail.setEmployee(employee);
            // и employee.setEmpDetail(empDetail);
            employee.setEmpDetail(empDetail); // эту строку лучше писать рядом с empDetail.setEmployee(employee);
//            session.save(employee);
            Detail detail = session.get(Detail.class, 4);
            System.out.println(detail.getEmployee());
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
