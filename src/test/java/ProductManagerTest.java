import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {


    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);


    Product item1 = new Book(11, "книга1", 100, "Иван Аванов");
    Product item2 = new Book(22, "книга2", 200, "Петр Петров");
    Product item3 = new Smartphone(33, "смартфон3", 300, "Китай");

    @Test
    public void managerAdd() {

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);


        Product[] expected = {item1, item2, item3};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void searchByNameBook() {

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);


        Product[] expected = {item1};
        Product[] actual = manager.searchBy("книга1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNameSmartPhone() {

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);


        Product[] expected = {item3};
        Product[] actual = manager.searchBy("смартфон");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void matchesTrue() {


        boolean expected = true;
        boolean actual = manager.matches(item1, "книга");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesFalse() {


        boolean expected = false;
        boolean actual = manager.matches(item3, "книга");

        Assertions.assertEquals(expected, actual);
    }


}
