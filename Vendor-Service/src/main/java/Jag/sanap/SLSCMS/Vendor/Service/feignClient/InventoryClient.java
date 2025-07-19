package Jag.sanap.SLSCMS.Vendor.Service.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "inventory-service", url = "${inventory.service.url}")
public interface InventoryClient {

    @PutMapping("/{id}/updateStock")
    void updateStock(@PathVariable("id") Long productId, @RequestParam int quantity);
}
