package org.erdem.cqrs.Components;

import org.erdem.cqrs.dto.ProductEvent;


public interface ICommandEvents {
    void queryOperations(ProductEvent productEvent);
}
