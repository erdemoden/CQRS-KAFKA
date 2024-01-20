package org.erdem.cqrs.Controller;

import lombok.RequiredArgsConstructor;
import org.erdem.cqrs.Entity.Product;
import org.erdem.cqrs.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

private final ProductService productService;

@PostMapping("/save")
public ResponseEntity<String> saveProduct(@RequestBody Product product){
    productService.SaveProduct(product);
    return ResponseEntity.ok("Product Saved");
}
@PutMapping("/update")
public ResponseEntity<String> updateWithId(@RequestParam UUID id, @RequestParam String amount){
    productService.updatePriceById(id,amount);
    return ResponseEntity.ok("Product Updated");
}
}
