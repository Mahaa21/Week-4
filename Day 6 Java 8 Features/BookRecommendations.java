import java.util.*;
import java.util.stream.*;

class Book {
    String title;
    String author;
    String genre;
    double rating;

    public Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }
}

class BookRecommendation {
    String title;
    double rating;

    public BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "BookRecommendation{title='" + title + "', rating=" + rating + "}";
    }
}

public class BookRecommendations {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Dune", "Frank Herbert", "Science Fiction", 4.5),
                new Book("Neuromancer", "William Gibson", "Science Fiction", 4.2),
                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.6),
                new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.3),
                new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 4.1),
                new Book("The Martian", "Andy Weir", "Science Fiction", 4.7),
                new Book("The Left Hand of Darkness", "Ursula K. Le Guin", "Science Fiction", 4.4),
                new Book("Ender's Game", "Orson Scott Card", "Science Fiction", 4.5),
                new Book("Brave New World", "Aldous Huxley", "Science Fiction", 4.2),
                new Book("Childhood's End", "Arthur C. Clarke", "Science Fiction", 4.3),
                new Book("The Road", "Cormac McCarthy", "Post-Apocalyptic", 4.1)
        );
        List<Book> filteredBooks = books.stream()
                .filter(b -> "Science Fiction".equals(b.getGenre()) && b.getRating() > 4.0)
                .collect(Collectors.toList());

        List<BookRecommendation> recommendations = filteredBooks.stream()
                .map(b -> new BookRecommendation(b.getTitle(), b.getRating()))
                .collect(Collectors.toList());

        List<BookRecommendation> sortedRecommendations = recommendations.stream()
                .sorted((b1, b2) -> Double.compare(b2.rating, b1.rating))
                .collect(Collectors.toList());

        List<BookRecommendation> top10 = sortedRecommendations.stream()
                .limit(10)
                .collect(Collectors.toList());

        System.out.println("Page 1:");
        top10.stream().limit(5).forEach(System.out::println);

        System.out.println("\nPage 2:");
        top10.stream().skip(5).limit(5).forEach(System.out::println);
    }
}
