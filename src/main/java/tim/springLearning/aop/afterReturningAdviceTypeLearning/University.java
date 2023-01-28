package tim.springLearning.aop.afterReturningAdviceTypeLearning;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    List<Student> listOfStudents = new ArrayList<>();

    public void addStudents() { // заполним список студентов этим методом:
        Student st1 = new Student("Tim Prokhorov", 5, 10.0);
        Student st2 = new Student("Albus Dambldor", 4, 7.2);
        Student st3 = new Student("Agent Smith", 352, 6.6);
        listOfStudents.add(st1);
        listOfStudents.add(st2);
        listOfStudents.add(st3);
    }

    public List<Student> getStudents() { // получим студентов:
        System.out.println("Information from method getStudents:");
        System.out.println(listOfStudents);
        return listOfStudents;
    }

    public List<Student> getStudentsWithException() { // получим студентов:
        System.out.println("Information from method getStudents:");
        System.out.println(listOfStudents.get(3)); // IndexOutOfBoundsException!!!  до return-а дело не дойдет.
        System.out.println(listOfStudents);
        return listOfStudents;
    }
}
