package tim.springLearning.springCore.annotationConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myPerson")
@Scope("prototype")
public class Person2 {

    @Value("${person2.surname}")
    private String surname;
    @Value("${person2.age}")
    private int age;
    private Pet2 pet2;

//    @Autowired
//    public Person2(String surname, int age, Pet2 pet2) {
//        this.surname = surname;
//        this.age = age;
//        this.pet2 = pet2;
//    }

    public Person2(@Qualifier("myDog") Pet2 pet2) {
        System.out.println("Person2 bean created");
        this.pet2 = pet2;
    }

    @Autowired
    public Person2(){
        System.out.println("person22 bean created");
    }

    public Pet2 getPet2() {
        return pet2;
    }

    public void setPet2(Pet2 pet2) {
        System.out.println("setPet2 added");
        this.pet2 = pet2;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("setSurname added");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void persons2Method() {
        System.out.println("person`s2 method");
    }
}
