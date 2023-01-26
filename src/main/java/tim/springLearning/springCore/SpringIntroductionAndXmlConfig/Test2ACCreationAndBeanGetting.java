package tim.springLearning.springCore.SpringIntroductionAndXmlConfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2ACCreationAndBeanGetting {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Pet pet = context.getBean("myPet", Pet.class);
        pet.say();
        context.close();
    }
}
