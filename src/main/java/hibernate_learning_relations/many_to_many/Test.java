package hibernate_learning_relations.many_to_many;

import hibernate_learning_relations.many_to_many.entity.Child;
import hibernate_learning_relations.many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory()) {

            Session session = factory.getCurrentSession();

            Section section1 = new Section("football");
            Child child1 = new Child("Tim", 5);
            Child child2 = new Child("Ann", 5);
            Child child3 = new Child("Kosha", 2);
            section1.addChildrenToSection(child1);
            section1.addChildrenToSection(child2);
            section1.addChildrenToSection(child3);
            session.beginTransaction();

            session.save(section1);
/*
если наоборот, создать три секции и одного ребенка, который будет в них ходить,
то все также сработает со всеми таблицами
Section section = session.getSections(Section.class, 1).sout; тоже все работает, наоборот, для получения ребенка - тоже
session.delete(section); секция 1 удалится, но вместе с детьми, которые ее посещают. Это неверное поведение,
вызванное каскадом, поэтому в каскаде для обоих классов можно выбрать все каскады, кроме ALL и REMOVE.
Но после этого не будет работать каскадное сохранение, так как в пакете javax.persistence, откуда мы импортим всё,
 нет CascadeType.SAVE, он есть в пакете Хайбернейта. Чтобы это обойти и все же мочь добавлять детей в секции
и наоборот, можно добавлять вручную, т.е., без каскада, уже внутри транзакции сохранить секцию, ПОСЛЕ добавить в
нее детей методом addChildrenToSection()  и потом вручную их сохранять:
session.save(child1)
session.save(child2)
session.save(child3)

ИЛИ
можно просто юзать метод persist() вместо save.
 */
            session.getTransaction().commit();
            System.out.println("Done!");
            session.close();
        }
    }
}
