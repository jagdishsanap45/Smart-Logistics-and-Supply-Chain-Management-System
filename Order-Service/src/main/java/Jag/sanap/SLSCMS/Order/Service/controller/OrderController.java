package Jag.sanap.SLSCMS.Order.Service.controller;


import Jag.sanap.SLSCMS.Order.Service.entity.Order;
import Jag.sanap.SLSCMS.Order.Service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    private  OrderService service;

    @PostMapping
    public ResponseEntity<Order> place(@RequestParam Long productId, @RequestParam int quantity) {
        return ResponseEntity.ok(service.placeOrder(productId, quantity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getOrder(id));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(service.getAllOrders());
    }
}

