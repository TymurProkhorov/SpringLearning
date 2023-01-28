package tim.springLearning.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspectForAroundAdvice {

    @Around("execution(public String returnBook1())") // around с получением/изменением таргет-метода:
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: book is trying to be returned to the library");
        // логика перед таргет-методом
        Object targetMethodResult = proceedingJoinPoint.proceed(); // вызов метода
        // логика после вызова таргет-метода
        System.out.println("aroundReturnBookLoggingAdvice: book was returned to the library successfully.");
        return targetMethodResult;
    }

    @Around("execution(public String returnBook1WithException())")
    public Object aroundReturnBookWithExceptionLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookWithExceptionLoggingAdvice: book is trying to be returned to the library");
        // логика перед таргет-методом

        Object targetMethodResult = null;
        try {
            targetMethodResult = proceedingJoinPoint.proceed(); // вызов метода
        } catch (Exception e) {
            System.out.println("aroundReturnBookWithExceptionLoggingAdvice: exception " + e + " catched");
            /* таргет-метод не успел получить значение из-за исключения, поэтому он сейчас null, поэтому
            в блоке catch нужно самостоятельно задать какое-то значение. Но так как хардкодить - не лучшее
             решение, как и обработка исключения прямо тут(ведь в мейне никто никогда не увидит, что тут вообще было
             исключение), то здесь можно указать какое-то дефолтное значение: targetMethodResult = "unknown book";
              лучший вариант - проброс исключения дальше. Делается так: */
            throw e; // таким образом, исключение пойдет дальше, в данном случае - в метод main.
        }

        // логика после вызова таргет-метода
        System.out.println("aroundReturnBookWithExceptionLoggingAdvice: book was returned to the library successfully.");
        return targetMethodResult;
    }

}
