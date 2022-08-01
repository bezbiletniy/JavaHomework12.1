package ru.netology.homework12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.PortUnreachableException;

public class ProductRepositoryTest {

    Product product1 = new Book(1, "Книга", 500, "Мастер и Маргарита", "Михаил Булгаков");
    Product product2 = new Smartphone(2, "Смартфон", 70_000, "Iphone13", "Apple");

    @Test
    public void shouldSaveProduct() {
        ProductRepository repo = new ProductRepository();
        repo.saveProducts(product1);

        Product[] expected = {product1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSaveProduct() {
        ProductRepository repo = new ProductRepository();

        Product[] expected = {};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetProducts() {
        ProductRepository repo = new ProductRepository();
        repo.saveProducts(product1);
        repo.saveProducts(product2);

        Product[] expected = {product1, product2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveProducts() {
        ProductRepository repo = new ProductRepository();
        repo.saveProducts(product1);
        repo.saveProducts(product2);
        repo.removeProducts(product1.getId());

        Product[] expected = {product2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}