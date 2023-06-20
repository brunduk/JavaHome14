import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(2, "Пиво", 40);
    Product product2 = new Product(5, "Вода", 30);
    Product product3 = new Product(7, "Сок", 70);


    @Test
    public void Test2() {
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();


        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findIdNull() {
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Product[] expected = {null};
        Product[] actual = new Product[]{repo.findById(1)};


        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findIdOne() {
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Product[] expected = {product1};
        Product[] actual = new Product[]{repo.findById(2)};


        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void idNotFound() {
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(11);
        });

    }

    @Test
    public void removeId() {
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.removeById(5);


        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();


        Assertions.assertArrayEquals(expected, actual);

    }
}
