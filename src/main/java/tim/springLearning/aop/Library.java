package tim.springLearning.aop;

import org.springframework.stereotype.Component;

@Component("libraryBean")
public class Library {

    public void getBook() {
        System.out.println(("getting a book"));
    }

    public void returnBook() {
        System.out.println("returning a book");
    }

    public void getBook(String bookName) {
        System.out.println("getting specific book - " + bookName);
    }

    public void getBook(Book book) {
        System.out.println("getting custom book:" + book.getName());
    }

    public void addBook() {
        System.out.println("adding a book");
    }

}
