package tim.springLearning.aop;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {

    @Pointcut("execution(* add*(..))")
    public void allAddMethods(){} // public!  Чтоб другие видели.
}
