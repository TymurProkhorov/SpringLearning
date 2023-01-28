package tim.springLearning.aop.aspects;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import tim.springLearning.aop.afterReturningAdviceTypeLearning.Student;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

    @AfterReturning(pointcut = "execution(java.util.List getStudents())", returning = "students")
    public void afterReturningGetStudentsLoggingAdvice(List<Student> students) {
        Student firstStudent = students.get(0);
        String newNameSurname = "Mr. " + firstStudent.getNameSurname();
        firstStudent.setNameSurname(newNameSurname);
        System.out.println("afterReturningGetStudentsLoggingAdvice: logging getting list of students" +
                " after method getStudents");
    }

    @AfterThrowing(pointcut = "execution(* getStudentsWithException())",
    throwing = "exception")
    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception) {
        System.out.println("afterThrowingGetStudentsLoggingAdvice: getting exception" + exception);
    }
}
