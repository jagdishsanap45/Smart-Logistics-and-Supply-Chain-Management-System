package Jag.sanap.SLSCMS.Vendor.Service.controller;

import Jag.sanap.SLSCMS.Vendor.Service.entity.Vendor;
import Jag.sanap.SLSCMS.Vendor.Service.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping
    public ResponseEntity<Vendor> register(@RequestBody Vendor vendor) {
        return ResponseEntity.ok(vendorService.register(vendor));
    }

    @GetMapping
    public ResponseEntity<List<Vendor>> getAll() {
        return ResponseEntity.ok(vendorService.getAllVendors());
    }

    @PutMapping("/restock")
    public ResponseEntity<String> restock(@RequestParam Long productId, @RequestParam int quantity) {
        vendorService.restockProduct(productId, quantity);
        return ResponseEntity.ok("Product stock updated successfully");
    }
}
