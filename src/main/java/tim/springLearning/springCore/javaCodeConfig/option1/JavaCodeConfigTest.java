package tim.springLearning.springCore.javaCodeConfig.option1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaCodeConfigTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Person3 person3 = context.getBean("person3", Person3.class);

        System.out.println(person3.getAge());
        person3.persons3Method();

        context.close();
    }
}
