package tim.springLearning.springCore.javaCodeConfig.option2;

public class Cat implements Pet3 {
    @Override
    public void say() {
        System.out.println("meooooooooow");
    }

    public Cat() {
        System.out.println("Cat`s bean created");
    }

}
