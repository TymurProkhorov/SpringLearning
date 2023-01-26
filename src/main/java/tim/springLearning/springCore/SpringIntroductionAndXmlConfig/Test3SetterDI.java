package tim.springLearning.springCore.SpringIntroductionAndXmlConfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3SetterDI {
    public static void main(String[] args) {
//        Pet pet = new Dog();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean("myPerson", Person.class);
        person.callPet();
        System.out.println(person.getAge());
        System.out.println(person.getSurname());
        context.close();
        /*
        Здесь создается Spring container, который создает бин кошки, потом пёрсон, получает бин типа Person,
        и внедряет зависимость кошки от пёрсона. И IoC и DI в действии.
        IoC - передали спрингу ответственность за создание объектов, сами не создаем, а только получаем уже
         созданные бины.
         DI с помощью конструктора - внедрили зависимость кошки пёрсону с помощью <constructor-arg ref="myPet"/>
         */
    }
}
