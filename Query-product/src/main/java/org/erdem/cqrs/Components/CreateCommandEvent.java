package org.erdem.cqrs.Components;

import lombok.RequiredArgsConstructor;
import org.erdem.cqrs.Entity.Product;
import org.erdem.cqrs.dto.ProductEvent;
import org.erdem.cqrs.Repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateCommandEvent implements ICommandEvents{

    private final ProductRepository productRepository;
    @Override
    public void queryOperations(ProductEvent productEvent) {
        Product product = new Product();
        product.setPrice(productEvent.getProduct().getPrice());
        product.setProductName(productEvent.getProduct().getProductName());
        product.setId(productEvent.getProduct().getId());
        productRepository.save(product);
    }


}
