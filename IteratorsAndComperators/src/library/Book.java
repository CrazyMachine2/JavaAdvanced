package library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Book implements Comparable<Book>, Comparator<Book> {
    public final Comparator<Book> DEFAULT_COMPARATOR = new BookComparator();
    private String title;
    private int year;
    private List<String> authors;
    private String publisher;

    public Book(String title, int year,String publisher, String... authors) {
        this.title = title;
        this.year = year;
        this.publisher = publisher;
        this.authors = new ArrayList<>();

        //            throw new IllegalArgumentException();
        if(authors.length != 0) {
            this.authors.addAll(Arrays.asList(authors));
        }
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public int compareTo(Book o) {
        int titleCompare = this.getTitle().compareTo(o.getTitle());
        return titleCompare != 0 ? titleCompare : o.getYear() - this.getYear();
    }

    @Override
    public int compare(Book o1, Book o2) {
        int titleCompare = o1.getTitle().compareTo(o2.getTitle());
        int yearCompare = o1.getYear().compareTo(o2.getYear());

        if (titleCompare == 0){
            if (yearCompare == 0){
                return o1.getPublisher().compareTo(o2.publisher);
            } else {
                return o1.getYear().compareTo(o2.getYear());
            }
        } else {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }
}






































