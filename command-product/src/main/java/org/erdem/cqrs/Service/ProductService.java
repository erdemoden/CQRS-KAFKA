package org.erdem.cqrs.Service;

import lombok.RequiredArgsConstructor;
import org.erdem.cqrs.dto.ProductEvent;
import org.erdem.cqrs.Entity.Product;
import org.erdem.cqrs.Repository.ProductRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final KafkaTemplate<String,Object> template;
    public void SaveProduct(Product product){
        Product createdProduct = productRepository.save(product);
        ProductEvent productEvent = new ProductEvent("Create",createdProduct);
        template.send("product-event-topic",productEvent);
    }
    public void updatePriceById(UUID id, String price){
        Product product = productRepository.findById(id).get();
        product.setPrice(price);
        Product updatedProduct = productRepository.save(product);
        ProductEvent productEvent = new ProductEvent("Update",updatedProduct);
        template.send("product-event-topic",productEvent);
    }
}
