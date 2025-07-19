package Jag.sanap.SLSCMS.Inventory.Service.controller;

import Jag.sanap.SLSCMS.Inventory.Service.entity.Product;
import Jag.sanap.SLSCMS.Inventory.Service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return ResponseEntity.of(productService.getProductBtId(id));
    }

    @GetMapping("/stock/{id}")
    public ResponseEntity<Boolean>  checkStock(@PathVariable Long id){
        return ResponseEntity.ok(productService.inStock(id));
    }

    @PutMapping("/{id}/updateStock")
    public ResponseEntity<Void> updateStock(@PathVariable Long id, @RequestParam int quantity){
        productService.updateStock(id, quantity);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        return  ResponseEntity.ok(productService.getAllProduct());
    }


}
