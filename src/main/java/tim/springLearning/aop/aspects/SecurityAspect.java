package tim.springLearning.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import tim.springLearning.aop.Book;

@Component
@Aspect
public class SecurityAspect { // JoinPoint learning

    @Before("tim.springLearning.aop.MyPointcuts.allAddMethods()")
    public void beforeAddSecurityAdvice(JoinPoint joinPoint) {
        /*
        JoinPoint показывает информацию о бизнес-методе - сигнатуру, параметры, тип возвращаемого значения итд.
        Будет вызвана инфа о всех бизнес-методах, которые попадут под поинткат.
         */
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // getSignature() возвр. Signature, поэтому надо кастовать до MethodSignature.
        System.out.println("methodSignature: " + methodSignature.getMethod());
        System.out.println("methodSignature.getName: " + methodSignature.getName());
        System.out.println("methodSignature.getReturnType: " + methodSignature.getReturnType());

        // теперь параметры:
        if(methodSignature.getName().equals("addBook")) { // ограничим, чтоб работать только с методами по имени addBook,
            // на случай, если есть еще методы с add...
            Object[] args = joinPoint.getArgs(); // вызываем параметры
            for (int i = 0; i < args.length; i++) { //проходимся по параметрам
                if (args[i] instanceof Book) {  // поработаем только с параметром Book book, выводя о нем инфу
                    Book myBook = (Book) args[i];
                    System.out.println("Info about my book: name - " + myBook.getName()
                    + ", year of publication - " + myBook.getYearOfPublication()
                    + "author - " + myBook.getAuthor());
                } else if(args[i] instanceof String) { // если же мой параметр - строка, то...
                    System.out.println(args[i] + " adds a book");
                }
            }
        }
    }
}
