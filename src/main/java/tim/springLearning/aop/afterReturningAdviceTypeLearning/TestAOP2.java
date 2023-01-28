package tim.springLearning.aop.afterReturningAdviceTypeLearning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tim.springLearning.aop.MyConfig;

import java.util.List;

public class TestAOP2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        University university = context.getBean("university", University.class);
        university.addStudents(); /* при вызове этого метода также вызовется beforeAddSecurityAdvice из класса SecurityAspect,
        потому что MyConfig сканит всё из пакета aop, находит класс SecurityAspect, а в нем есть поинткат, подходящий
        под шаблон. */
        List<Student> list = university.getStudents(); //AfterReturning advice сработает ПОСЛЕ метода getStudents()
        System.out.println(list); // лист изменился после логики returning в @AfterReturning


        context.close();
    }
}
