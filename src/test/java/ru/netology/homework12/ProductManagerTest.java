package ru.netology.homework12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(1, "Книга", 500, "Мастер и Маргарита", "Михаил Булгаков");
    Product product2 = new Smartphone(2, "Смартфон", 70_000, "Iphone13", "Apple");

    Product product3 = new Book(1, "Книга", 600, "Идиот}", "Федор Достоевский");

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
    }

    @Test
    public void shouldAddProducts() {

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByBook() {

        Product[] expected = {product1, product3};
        Product[] actual = manager.searchBy("Книга");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphone() {

        Product[] expected = {product2};
        Product[] actual = manager.searchBy("Смартфон");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchBy() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Майки");

        Assertions.assertArrayEquals(expected, actual);
    }

}