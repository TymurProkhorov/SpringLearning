package tim.springLearning.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // здесь компонент нужен, чтоб SC создал его бин и мог вызывать advice-ы.
@Aspect
public class LoggingAspect {

    @Pointcut("execution(void get*()))")
    private void allGetMethods(){}

    @Before("allGetMethods()") // поинткат!
    public void beforeGetBookAdvice() {
        /*
         advice - метод внутри аспект-класса.
         Before указывает, перед каким методом этот эдвайс должен идти.
         */
        System.out.println("beforeGetBookAdvice: trying to get a book");
    }
    //Этот код можно прочитать так: "Перед выполнением метода public void getBook() выполни метод beforeGetBookAdvice()

    @Before("execution(public * returnBook())")
    public void beforeReturnBookAdvice() {
        System.out.println("beforeReturnBookAdvice: Returning book.");
    }

    @Before("execution(void getBook(String))")
    public void beforeGetSpecificBookAdvice() {
        System.out.println("beforeGetSpecificBook: getting specific book");
    }

    @Before("execution(void getBook(tim.springLearning.aop.Book))") // Для кастомных объектов нужно указывать полное имя класса
    public void beforeGetCustomBookAdvice() {
        System.out.println("beforeGetCustomBookAdvice: getting specific book");
    }
}

/*
 Поинткаты можно комбинировать с помощью нового поинтката, в который прописываются ссылки на другие поинткаты
 через логические операторы.
 */