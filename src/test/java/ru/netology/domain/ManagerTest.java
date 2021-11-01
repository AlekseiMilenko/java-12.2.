package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private ProductRepository repository = new ProductRepository();
    private Manager manager = new Manager(repository);


    private Book first = new Book(111, "East", 1000, "Jack");
    private Book second = new Book(222, "South", 2000, "Bill");
    private Smartphone third = new Smartphone(333, "North", 3000, "Nokia");
    private Smartphone fourth = new Smartphone(444, "West", 4000, "Samsung");

    @Test
    public void shouldAddProducts() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);
        int actual = repository.getItems().length;
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchNoResult() {

        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneResultBySmartphoneBrand() {

        Manager manager = new Manager(repository);

        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);

        Product[] actual = manager.searchBy("Nokia");
        Product[] expected = new Product[]{third};
        assertArrayEquals(expected, actual);
    }




}


