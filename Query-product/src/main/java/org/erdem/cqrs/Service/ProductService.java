package org.erdem.cqrs.Service;

import lombok.RequiredArgsConstructor;
import org.erdem.cqrs.Components.CommandEventsFactory;
import org.erdem.cqrs.Components.ICommandEvents;
import org.erdem.cqrs.dto.ProductEvent;
import org.erdem.cqrs.Entity.Product;
import org.erdem.cqrs.Enums.EventTypes;
import org.erdem.cqrs.Repository.ProductRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final CommandEventsFactory commandEventsFactory;

    private final ProductRepository productRepository;
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @KafkaListener(topics = "product-event-topic",groupId = "product-event-group")
    public void processCommandEvents(ProductEvent productEvent){
        ICommandEvents commandEvent = EventTypes.getCommandEvent(productEvent.getEventType(),commandEventsFactory);
        commandEvent.queryOperations(productEvent);
    }


}
