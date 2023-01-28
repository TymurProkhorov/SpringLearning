package tim.springLearning.aop.afterThrowingAdviceTypeLearning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tim.springLearning.aop.MyConfig;
import tim.springLearning.aop.afterReturningAdviceTypeLearning.University;

public class TestAOP3 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        University university1 = context.getBean("university", University.class);
        try {
            university1.getStudentsWithException();
        } catch (Exception e) {
            System.out.println("exception catching");
        }
    }
}
