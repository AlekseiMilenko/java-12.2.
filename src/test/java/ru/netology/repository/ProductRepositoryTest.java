package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repo = new ProductRepository();
    private Book first = new Book(111, "East", 1000, "Jack");
    private Book second = new Book(222, "South", 2000, "Bill");
    private Smartphone third = new Smartphone(333, "North", 3000, "Nokia");
    private Smartphone fourth = new Smartphone(444, "West", 4000, "Samsung");

    @Test
    void save() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
        int actual = repo.getItems().length;
        int expected = 4;
        assertEquals(expected, actual);
    }


}