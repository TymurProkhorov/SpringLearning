package tim.springLearning.springCore.javaCodeConfig.option2;

import org.springframework.beans.factory.annotation.Value;

public class Person4 {
    @Value("${person4.surname}")
    private String surname;
    @Value("${person4.age}")
    private int age;
    private Pet3 pet3;

    public Person4() {
    }

    public Person4(Pet3 pet3) {
        System.out.println("person4 bean created");
        this.pet3 = pet3;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Pet3 getPet3() {
        return pet3;
    }

    public void setPet3(Pet3 pet3) {
        this.pet3 = pet3;
    }
}
