import org.example.Book;
import org.example.Product;
import org.example.ProductManager;
import org.example.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    @Test
    public void search(){
       ProductRepository repo = new ProductRepository ();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1,"Поттер 1",5500,"Ролинг");
        Book book2 = new Book(2,"Поттер",6500,"Лув");
        Book book3 = new Book(3,"Поттер 2",7500,"Толстой");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Поттер");
        Product[] expected = { book1,book2, book3};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void search2() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Поттер 1", 5500, "Ролинг");
        Book book2 = new Book(2, "Поттер", 6500, "Лув");
        Book book3 = new Book(3, "Поттер 2", 7500, "Толстой");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Поттер 1");
        Product[] expected = {book1};
        Assertions.assertArrayEquals(expected, actual);

    }}