package tim.springLearning.aop.AroundAdviceTypeLearning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tim.springLearning.aop.Library;
import tim.springLearning.aop.MyConfig;

public class Test4AOP {
    public static void main(String[] args) {
        System.out.println("method main starts");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Library library = context.getBean("libraryBean", Library.class);
        String bookName = library.returnBook1();
        System.out.println("this book was returned to library: " + bookName);
        System.out.println("---------------------------------------");

        try {
            String tryingToReturnBookWithException = library.returnBook1WithException();
            System.out.println("trying to return book with exception: " + tryingToReturnBookWithException);
        } catch (Exception e) {
            System.out.println("exception catched in main-method");
        }


        context.close();
        System.out.println("method main ends");
    }
}
