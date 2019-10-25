package library;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book book = new Book ("Aesho", 1999, "A","Gosho");
        Book book1 = new Book ("Aesho", 2000,"A");
        Book book2 = new Book ("Aesho", 2001, "A","Ivo","Misho");

       Library library = new Library(book,book1,book2);

        List<Book> books = Arrays.asList(book,book1,book2);
        books.sort(book.DEFAULT_COMPARATOR);

      //  books.stream().sorted(book.DEFAULT_COMPARATOR).forEach(b -> System.out.println(b.getTitle() + " " + b.getYear()));

//       books.stream().sorted((b1,b2) -> b1.compareTo(b2)).forEach(b -> System.out.println(b.getTitle() + " " + b.getYear()));
       books.stream().sorted((b1,b2) -> b1.compare(b2,b1))
               .forEach(b -> System.out.println(b.getTitle() + " " + b.getYear() + " " + b.getPublisher()));
    }
}
