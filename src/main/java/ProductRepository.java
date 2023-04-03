public class ProductRepository {

    private Product[] items = new Product[0];

    public Product[] getItems() {

        return items;
    }


    public void save(Product item) {

        if (findById(item.id) == item) {
            throw new AlreadyExistsException(
                    "Товар: " + item + " уже добавлен"
            );
        }
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }


    public Product findById(int id) {
        Product[] tmp = new Product[items.length];
        int copyToIndex = 0;
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }


    public void removeById(int id) {


        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        }
        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;

    }

    public Product[] findAll() {
        return getItems();
    }
}




