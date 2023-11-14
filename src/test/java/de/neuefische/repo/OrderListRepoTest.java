package de.neuefische.repo;

import de.neuefische.model.Order;
import de.neuefische.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderListRepoTest {

    @Test
    void getOrders_shouldReturnEmptyList_WhenNoItemIsSaved(){
        //GIVEN
        OrderListRepo repo = new OrderListRepo();
        List<Order> expected = List.of();
        //WHEN
        List<Order> actual = repo.getOrders();
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void getOrders_shouldReturnOrderList_WhenItemIsSaved(){
        //GIVEN
        OrderListRepo repo = new OrderListRepo();
        Product product = new Product("1", "Apfel");
        Order order = new Order("1", List.of(product));
        List<Order> expected = List.of(order);
        repo.addOrder(order);
        //WHEN
        List<Order> actual = repo.getOrders();
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void getOrderById_shouldReturnOrder1_WhenCalledWith1(){
        //GIVEN
        OrderListRepo repo = new OrderListRepo();
        Product product = new Product("1", "Apfel");
        Order order = new Order("1", List.of(product));

        Order expected = order;
        repo.addOrder(order);
        //WHEN
        Order actual = repo.getOrderById("1");
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void getOrderById_shouldReturnNull_WhenCalledWithInvalidId(){
        //GIVEN
        OrderListRepo repo = new OrderListRepo();
        //WHEN
        Order actual = repo.getOrderById("1");
        //THEN
        assertNull(actual);
    }

    @Test
    void addOrder_ShouldReturnOrder1_WhenCalledWithOrder1(){
        //GIVEN
        OrderListRepo repo = new OrderListRepo();
        Product product = new Product("1", "Apfel");
        Order expected = new Order("1", List.of(product));
        //WHEN
        Order actual = repo.addOrder(expected);
        //THEN
        assertEquals(expected, actual);
        assertEquals(expected, repo.getOrderById("1"));
    }

    @Test
    void removeOrder_ShouldRemoveOrder1_WhenCalledWithId1(){
        //GIVEN
        OrderListRepo repo = new OrderListRepo();
        Product product = new Product("1", "Apfel");
        Order expected = new Order("1", List.of(product));
        repo.addOrder(expected);
        //WHEN
        repo.removeOrder("1");
        //THEN
        assertNull(repo.getOrderById("1"));
        assertEquals(null, repo.getOrderById("1"));
        assertEquals(List.of(), repo.getOrders());
    }

}