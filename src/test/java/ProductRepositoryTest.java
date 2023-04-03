import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Product item1 = new Book(11, "книга1", 100, "Иван Аванов");
    Product item2 = new Book(22, "книга2", 200, "Петр Петров");
    Product item3 = new Smartphone(33, "смартфон3", 300, "Китай");

    @Test
    public void addItems() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        Product[] expected = {item1, item2, item3};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void addItemsThrow() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(item2);
        });
    }


    @Test
    public void removeById() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.removeById(item2.getId());

        Product[] expected = {item1, item3};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void removeByIdThrow() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);


        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(4);
        });
    }


}
