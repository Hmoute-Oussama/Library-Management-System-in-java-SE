package src.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private final List<Book> books;
    private int nextId;

    public Library() {
        books = new ArrayList<>();
        nextId = 1;
    }

    public Book addBook(String title, String author) {
        Book book = new Book(nextId, title, author);
        books.add(book);
        nextId++;
        return book;
    }

    public boolean deleteBook(int id) {
        Book book = findBook(id);
        return book != null && books.remove(book);
    }

    public List<Book> searchBooks(String title) {
        List<Book> result = new ArrayList<>();
        if (title == null || title.trim().isEmpty()) {
            return result;
        }

        String query = title.trim().toLowerCase();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query)
                    || book.getAuthor().toLowerCase().contains(query)) {
                result.add(book);
            }
        }
        return Collections.unmodifiableList(result);
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(new ArrayList<>(books));
    }

    public boolean reserveBook(int id) {
        Book book = findBook(id);
        if (book == null || book.getStatus() != BookStatus.AVAILABLE) {
            return false;
        }
        book.setStatus(BookStatus.RESERVED);
        return true;
    }

    public boolean returnBook(int id) {
        Book book = findBook(id);
        if (book == null || book.getStatus() != BookStatus.RESERVED) {
            return false;
        }
        book.setStatus(BookStatus.AVAILABLE);
        return true;
    }

    private Book findBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
