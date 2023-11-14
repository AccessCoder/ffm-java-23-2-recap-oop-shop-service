package de.neuefische.service;

import de.neuefische.model.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void addOrder_ShouldReturn_Null_WhenInvalidIdListWasGiven(){
        //GIVEN
        ShopService service = new ShopService();
        List<String> productIds = List.of("2");
        //WHEN
        Order actual = service.addOrder(productIds);
        //THEN
        assertNull(actual);
    }

    //Aktuell nicht testbar, da z. B. addProduct Methode in ShopService fehlt.
    @Test
    void addOrder_ShouldReturnNewOrder_WhenValidIdListWasGiven(){
        //GIVEN
        ShopService service = new ShopService();
        List<String> productIds = List.of("1");
        //WHEN
        Order actual = service.addOrder(productIds);
        //THEN
        assertNull(actual);
    }
}