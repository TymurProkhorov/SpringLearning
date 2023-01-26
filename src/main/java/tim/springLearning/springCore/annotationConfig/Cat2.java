package tim.springLearning.springCore.annotationConfig;

public class Cat2 implements Pet2 {

    public Cat2(){
        System.out.println("Cat2 bean created");
    }
    @Override
    public void say() {
        System.out.println("mau-mau");
    }
}
