public class ProductManager {

    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product item) {

        repo.save(item);
    }


    public Product[] getItems() {
        Product[] all = repo.getItems();
        Product[] reversed = new Product[all.length];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = all[all.length - 1 - i];
        }
        return reversed;
    }

    public Product[] findAll() {
        return repo.getItems();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        int i = 0;
        for (Product item: repo.getItems()) {
            if (matches(item, text)) {
               result[i] =  item;
            }
        }
        return result;
    }


    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }

    }


}
