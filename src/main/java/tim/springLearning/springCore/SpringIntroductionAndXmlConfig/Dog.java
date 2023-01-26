package tim.springLearning.springCore.SpringIntroductionAndXmlConfig;

public class Dog implements Pet {
    private String name;
    public Dog() {
        System.out.println("Dog bean was created");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void say() {
        System.out.println("gav-gav");
    }
}
