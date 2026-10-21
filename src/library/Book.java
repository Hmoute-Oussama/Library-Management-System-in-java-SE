package src.library;

public class Book {
    private int id;
    private String title;
    private String author;
    private BookStatus status;

    public Book(int id, String title, String author) {
        if (id <= 0) {
            throw new IllegalArgumentException("L'identifiant doit être positif.");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Le titre ne peut pas être vide.");
        }
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("L'auteur ne peut pas être vide.");
        }
        this.id = id;
        this.title = title.trim();
        this.author = author.trim();
        this.status = BookStatus.AVAILABLE;
    }

    public int getId() {
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public BookStatus getStatus(){
        return status;
    }

    void setStatus(BookStatus status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "N°" + id + " — " + title + " de " + author
                + " [" + (status == BookStatus.AVAILABLE ? "disponible" : "réservé") + "]";
    }
}
