import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);


    Product item1 = new Book(11, "Озеро", 100, "Иван Аванов");
    Product item2 = new Book(22, "Озеро печали", 200, "Петр Петров");
    Product item3 = new Smartphone(33, "смартфон3", 300, "Китай");

    @BeforeEach
    public void setup() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
    }


    @Test
    public void managerAdd() {


        Product[] expected = {item1, item2, item3};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void searchByOneBook() {

        Product[] expected = {item2};
        Product[] actual = manager.searchBy("Озеро печали");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void searchByTwoBook() {


        Product[] expected = {item1, item2};
        Product[] actual = manager.searchBy("Озеро");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByOneSmartPhone() {


        Product[] expected = {item3};
        Product[] actual = manager.searchBy("смартфон");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchNothing() {


        Product[] expected = {};
        Product[] actual = manager.searchBy("Озера");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void matchesTrue() {


        boolean expected = true;
        boolean actual = manager.matches(item1, "Озеро");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesFalse() {


        boolean expected = false;
        boolean actual = manager.matches(item3, "книга");

        Assertions.assertEquals(expected, actual);
    }

}
