package goji.investments.example.order.web;

import goji.investments.example.order.OrderCRUDService;
import goji.investments.example.order.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderCRUDService orderService;

    @GetMapping
    public List<Order> get() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id) {
        return orderService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public String create(@RequestBody CreateOrderRequest request) {
        Order add = orderService.add(request);
        return add.getId().toString();
    }
}
