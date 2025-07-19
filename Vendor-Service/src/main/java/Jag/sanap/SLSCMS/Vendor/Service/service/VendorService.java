package Jag.sanap.SLSCMS.Vendor.Service.service;


import Jag.sanap.SLSCMS.Vendor.Service.entity.Vendor;
import Jag.sanap.SLSCMS.Vendor.Service.feignClient.InventoryClient;
import Jag.sanap.SLSCMS.Vendor.Service.repositery.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {

    @Autowired
    private VendorRepo vendorRepo;


    @Autowired
    private InventoryClient inventoryClient;


    public Vendor register(Vendor vendor) {
        return vendorRepo.save(vendor);
    }

    public List<Vendor> getAllVendors() {
        return vendorRepo.findAll();
    }

    public void restockProduct(Long productId, int quantity) {
        inventoryClient.updateStock(productId, quantity);
    }


}
