package tim.springLearning.springCore.annotationConfig;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myDog")
@Scope("prototype")
public class Dog2 implements Pet2 {

    public Dog2(){
        System.out.println("Dog2 bean created");
    }

    @Override
    public void say() {
        System.out.println("gavvvvvv");
    }
}
