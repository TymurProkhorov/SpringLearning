package tim.springLearning.springCore.javaCodeConfig.option2;

public class Dog implements Pet3 {
    @Override
    public void say() {
        System.out.println("gav-gav-gav-gav");
    }

    public Dog(){
        System.out.println("Dog`s bean created");
    }

}
