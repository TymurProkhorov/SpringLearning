package tim.springLearning.springCore.SpringIntroductionAndXmlConfig;

public class Cat implements Pet {
    public Cat() {
        System.out.println("Cat bean was created");
    }

    @Override
    public void say() {
        System.out.println("Meoow");
    }
}
