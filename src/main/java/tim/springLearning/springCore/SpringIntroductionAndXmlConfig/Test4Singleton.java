package tim.springLearning.springCore.SpringIntroductionAndXmlConfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4Singleton {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml"); // АС-ы можно через зпт добавлять много
        Dog myDog = context.getBean("myPet", Dog.class);
        Dog yourDog = context.getBean("myPet", Dog.class);
        // Два раза запросили у SC бин Dog. Но Singleton создает ОДИН объект. Проверим это:
        System.out.println(myDog == yourDog);
        // и глянем на ссылки этих переменных:
        System.out.println(myDog);
        System.out.println(yourDog);

        myDog.setName("Belka");
        yourDog.setName("Strelka");
        System.out.println(myDog.getName());
        System.out.println(yourDog.getName());

        context.close();
    }
}
