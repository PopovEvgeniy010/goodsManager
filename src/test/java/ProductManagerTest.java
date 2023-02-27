import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    @Test
    public void searchForMultipleProducts() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Поттер1", 5500, "Ролинг");
        Book book2 = new Book(2, "Поттер2", 6500, "Лув");
        Book book3 = new Book(3, "Поттер3", 7500, "Толстой");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Поттер");
        Product[] expected = {book1, book2, book3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchForOneProducts() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Поттер 1", 5500, "Ролинг");
        Book book2 = new Book(2, "Поттер", 6500, "Лув");
        Book book3 = new Book(3, "Поттер 2", 7500, "Толстой");
        Smartphone smartphone1 = new Smartphone(4, "Nokia", 10000, "China");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        Product[] actual = manager.searchBy("Nokia");
        Product[] expected = {smartphone1};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchForNoneProducts() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Поттер 1", 5500, "Ролинг");
        Book book2 = new Book(2, "Поттер", 6500, "Лув");
        Book book3 = new Book(3, "Поттер 2", 7500, "Толстой");
        Smartphone smartphone1 = new Smartphone(4, "Nokia", 10000, "Китай");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        Product[] actual = manager.searchBy("Воронов лучший эксперт");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);

    }
}