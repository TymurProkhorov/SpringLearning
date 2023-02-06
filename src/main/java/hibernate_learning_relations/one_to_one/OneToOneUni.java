package hibernate_learning_relations.one_to_one;

import hibernate_learning_relations.one_to_one.entity.Detail;
import hibernate_learning_relations.one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneUni {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class) // !!!
                .buildSessionFactory()) {
            Employee employee = new Employee("Tymur", "Prokhorov", "IT", 1000);
            Detail empDetail = new Detail("Yzhka", 123456789, "timfromkepler@gmail.com");
            employee.setEmpDetail(empDetail); // добавляем инфу о работнике

            Employee employee2 = new Employee("Anna", "Prokhorova", "Recruitment", 1000);
            Detail empDetail2 = new Detail("Yzhka", 987654321, "anna@gmail.com");
            employee2.setEmpDetail(empDetail2);
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            /*
            Нужно добавить в SessionFactory .getAnnotatedClass(Detail.class), чтоб хайбернейт-конфиг-файл читал и его,
            в классе Employee добавить геттер и сеттер для поля Detail и здесь перед транзакцией засетить работника
            деталями(см. выше). После этого достаточно просто сохранить работника в базу и детали о нем автоматически
            добавятся благодаря каскаду.
             */
//            session.save(employee);
            Employee emp = session.get(Employee.class, 10);
            System.out.println("employee information: " + emp + ";  details about employee: " + emp.getEmpDetail());
            session.getTransaction().commit();
            System.out.println("Done!");

            //session.delete(emp) также удалит и детали о работнике благодаря все тому же каскаду.
            /*
            Если указать id - 10 в методе get, то выбросится NPE, ведь тогда сразу объект emp становится null-ом,
            но также и выскочит ошибка об утечке соединения, потому что исключение остановит работу программы на
            методе get и до закрытия сессии мы не дойдем. Поэтому можно закрывать сессию в finally, либо работать с TWR,
            как тут.
             */
        }
    }
}
