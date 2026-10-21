package src.library;

import java.util.List;
import java.util.Scanner;

public class Main {
    private final Library library = new Library();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = readInteger("Votre choix : ");

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayBooks(library.getBooks());
                    break;
                case 3:
                    searchBooks();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    updateReservation(true);
                    break;
                case 6:
                    updateReservation(false);
                    break;
                case 0:
                    running = false;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Sélectionnez une option du menu.");
            }
            System.out.println();
        }
    }

    private void showMenu() {
        System.out.println("=== Gestion de bibliothèque ===");
        System.out.println("1. Ajouter un livre");
        System.out.println("2. Afficher tous les livres");
        System.out.println("3. Rechercher un livre");
        System.out.println("4. Supprimer un livre");
        System.out.println("5. Réserver un livre");
        System.out.println("6. Rendre un livre");
        System.out.println("0. Quitter");
    }

    private void addBook() {
        String title = readText("Titre : ");
        String author = readText("Auteur : ");
        Book book = library.addBook(title, author);
        System.out.println("Livre ajouté : " + book);
    }

    private void searchBooks() {
        String query = readText("Titre ou auteur à rechercher : ");
        displayBooks(library.searchBooks(query));
    }

    private void deleteBook() {
        int id = readInteger("Numéro du livre à supprimer : ");
        if (library.deleteBook(id)) {
            System.out.println("Livre supprimé.");
        } else {
            System.out.println("Aucun livre ne porte ce numéro.");
        }
    }

    private void updateReservation(boolean reserve) {
        int id = readInteger("Numéro du livre : ");
        boolean updated = reserve ? library.reserveBook(id) : library.returnBook(id);
        if (updated) {
            System.out.println(reserve ? "Livre réservé." : "Livre rendu et disponible.");
        } else {
            System.out.println("Opération impossible : vérifiez le numéro et le statut du livre.");
        }
    }

    private void displayBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("Aucun livre à afficher.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Cette valeur ne peut pas être vide.");
        }
    }

    private int readInteger(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException exception) {
                System.out.println("Veuillez saisir un nombre entier.");
            }
        }
    }
}
