package Jag.sanap.SLSCMS.Inventory.Service.service;

import Jag.sanap.SLSCMS.Inventory.Service.entity.Product;
import Jag.sanap.SLSCMS.Inventory.Service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Optional<Product> getProductBtId(Long id){
        return productRepository.findById(id);
    }

    public boolean inStock(Long productId){
        return productRepository.findById(productId)
                .map(product -> product.getQuantity() >0)
                .orElse(false);

    }

    public void updateStock(Long productId, int quantity){
        Product product = productRepository.findById(productId).orElseThrow();
        product.setQuantity(quantity);
        productRepository.save(product);
    }

    public List<Product> getAllProduct(){
       return productRepository.findAll();
    }
}
