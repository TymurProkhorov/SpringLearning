package tim.springLearning.springCore.annotationConfig;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationConfigTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext4.xml");
//
//        Person2 person2 = context.getBean("myPerson", Person2.class);
//        person2.persons2Method();

        Person2 person22 = context.getBean("person22", Person2.class);
        person22.persons2Method();
        System.out.println(person22.getAge());
        System.out.println(person22.getSurname());

        context.close();
    }
}
