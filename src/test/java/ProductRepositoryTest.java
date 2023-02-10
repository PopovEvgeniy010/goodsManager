import org.example.Book;
import org.example.Product;
import org.example.ProductManager;
import org.example.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    @Test
    public void removeId() {
        ProductRepository repo = new ProductRepository();
        Book book1 = new Book(1, "Поттер 1", 5500, "Ролинг");
        Book book2 = new Book(2, "Поттер", 6500, "Лув");
        Book book3 = new Book(3, "Поттер 2", 7500, "Толстой");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.removeById(2);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, book3};
        Assertions.assertArrayEquals(expected, actual);
    }
}
