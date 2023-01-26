package tim.springLearning.springCore.javaCodeConfig.option1;

import org.springframework.stereotype.Component;
import tim.springLearning.springCore.SpringIntroductionAndXmlConfig.Pet;

@Component("person3")
public class Person3 {
    private String name;
    private int age;
    private Pet pet;

    public Person3() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void persons3Method() {
        System.out.println("persons3Method");
    }
}
