package tim.springLearning.springCore.javaCodeConfig.option2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaCodeConfigTestOption2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

//        Pet3 cat = context.getBean("catBean", Pet3.class);
//        cat.say();

        Person4 person4 = context.getBean("person4Bean", Person4.class);
        Person4 person5 = context.getBean("person4Bean", Person4.class);
        // создастся лишь один бин, так как скоуп - синглтон.
        System.out.println(person4.getAge());
        System.out.println(person4.getSurname());

    }
}
