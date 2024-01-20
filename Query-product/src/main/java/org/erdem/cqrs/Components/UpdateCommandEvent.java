package org.erdem.cqrs.Components;

import lombok.RequiredArgsConstructor;
import org.erdem.cqrs.dto.ProductEvent;
import org.erdem.cqrs.Entity.Product;
import org.erdem.cqrs.Repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UpdateCommandEvent implements ICommandEvents{

    private final ProductRepository productRepository;
    @Override
    public void queryOperations(ProductEvent productEvent) {
        Optional<Product> oldProduct = productRepository.findById(productEvent.getProduct().getId());
        oldProduct.get().setPrice(productEvent.getProduct().getPrice());
        productRepository.save(oldProduct.get());
    }
}
