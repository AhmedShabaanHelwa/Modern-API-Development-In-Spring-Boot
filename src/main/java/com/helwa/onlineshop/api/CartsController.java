package com.helwa.onlineshop.api;

import com.helwa.onlineshop.api.model.Cart;
import com.helwa.onlineshop.api.model.Item;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class CartsController implements CartApi {
    final private static Logger logger = LoggerFactory.getLogger(CartsController.class);

    @Override
    public ResponseEntity<List<Item>> addCartItemsByCustomerId(String customerId, @Valid Item item)
    {
        logger.info("Request for customer ID: {}\nItem: {}", customerId, item);
        return ResponseEntity.ok(Collections.EMPTY_LIST);
    }

    @Override
    public ResponseEntity<List<Cart>> getCartByCustomerId(String customerId)
    {
        throw new RuntimeException("Manual exception thrown.");
    }

}
