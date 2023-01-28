package tim.springLearning.aop;

import org.springframework.stereotype.Component;

@Component("libraryBean")
public class Library {

    public void getBook() {
        System.out.println(("getting a book"));
        System.out.println("----------------------------------");
    }

    public void returnBook() {
        System.out.println("returning a book");
        System.out.println("----------------------------------");
    }

    public void getBook(String bookName) {
        System.out.println("getting specific book - " + bookName);
        System.out.println("----------------------------------");
    }

    public void getBook(Book book) {
        System.out.println("getting custom book:" + book.getName());
        System.out.println("----------------------------------");
    }

    public void addBook(String personName, Book book) {
        System.out.println("adding a book with parameters");
        System.out.println("----------------------------------");
    }

    public void addBook() {
        System.out.println("adding a book");
        System.out.println("----------------------------------");
    }

    public String returnBook1() {
        System.out.println("returning book to the library");
        return "War and piece";
    }

    public String returnBook1WithException() {
        int a = 10/0;
        System.out.println("returning book to the library");
        return "War and piece";
    }

}
