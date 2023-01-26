package tim.springLearning.springCore.SpringIntroductionAndXmlConfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5Prototype {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");
        Dog myDog2 = context.getBean("myPet", Dog.class);
        Dog yourDog2 = context.getBean("myPet", Dog.class);
        // Два раза запросили у SC бин Dog. И prototype создает Разные объекты. Проверим это:
        System.out.println(myDog2 == yourDog2);
        // и глянем на ссылки этих переменных:
        System.out.println(myDog2);
        System.out.println(yourDog2);

        myDog2.setName("Belka");
        yourDog2.setName("Strelka");
        System.out.println(myDog2.getName());
        System.out.println(yourDog2.getName());

        context.close();
    }
}
