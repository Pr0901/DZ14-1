public class ProductManager {

    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product item) {

        repo.save(item);
    }


    public Product[] findAll() {
        return repo.getItems();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product item : repo.findAll()) {
            if (matches(item, text)) {
                Product[] tmp = new Product[result.length + 1];
                tmp[result.length] = item;
                result = tmp;
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
