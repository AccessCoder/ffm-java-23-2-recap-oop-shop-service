package de.neuefische.repo;

import de.neuefische.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {


    @Test
    void getProducts_ShouldReturnEmptyList_WhenCalledInitially(){
        //GIVEN
        ProductRepo repo = new ProductRepo();
        //WHEN
        List<Product> actual = repo.getProducts();
        //THEN
        assertEquals(List.of(), actual);
    }

    @Test
    void getProductById_ShouldReturnProduct1_WhenCalledWith1(){
        //GIVEN
        ProductRepo repo = new ProductRepo();
        Product expected = new Product("1", "Apfel");
        repo.addProduct(expected);
        //WHEN
        Product actual = repo.getProductById("1");
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void getProductById_ShouldReturnNull_WhenCalledWithInvalidId(){
        //GIVEN
        ProductRepo repo = new ProductRepo();
        //WHEN
        Product actual = repo.getProductById("1");
        //THEN
        assertNull(actual);
    }

    @Test
    void addProduct_ShouldReturnProduct1_WhenCalledWithProduct1(){
        //GIVEN
        ProductRepo repo = new ProductRepo();
        Product expected = new Product("1", "Apfel");
        //WHEN
        Product actual = repo.addProduct(expected);;
        //THEN
        assertEquals(expected, actual);
        assertEquals(expected, repo.getProductById("1"));
    }

    @Test
    void removeProduct_ShouldRemoveProduct1_WhenCalledWithId1(){
        //GIVEN
        ProductRepo repo = new ProductRepo();
        repo.addProduct(new Product("1", "Apfel"));
        //WHEN
        repo.removeProduct("1");
        //THEN
        assertNull(repo.getProductById("1"));
        assertEquals(List.of(), repo.getProducts());
    }
}