package tim.springLearning.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAOP {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Library library = context.getBean("libraryBean", Library.class);
//        library.getBook();

        // При повторных вызовах getBook, каждый раз также будет вызываться его advice.
//        library.getBook();
//        library.getBook();

        // Тренировка поинтката, вызываем returnBook, advice с соотв. поинткатом тоже вызовется.
//        library.returnBook();
//        library.getBook("Преступление и наказание");

        Book book = context.getBean("book", Book.class);

//        library.getBook(book);
        library.addBook("Tim", book);







        context.close();
    }
}
