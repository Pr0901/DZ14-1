import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Book item1 = new Book(11,"книга1", 100, "Иван Аванов");
    Book item2 = new Book(22,"книга2", 200, "Петр Петров");
    Book item3 = new Book(33,"книга3", 300, "Виталий Витальевич");

    @Test
    public void testAdd() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        Book[] expected = {item1, item2, item3};
        Book[] actual = (Book[]) repo.getItems();

        Assertions.assertArrayEquals(expected,actual);


    }
}
