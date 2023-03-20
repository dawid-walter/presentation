package goji.investments.example.order.web;

import goji.investments.example.order.OrderCRUDService;
import goji.investments.example.order.model.CurrencyType;
import goji.investments.example.order.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/filtered")
    public List<Order> getFiltered(@RequestParam CurrencyType currencyType) {
        return orderService.filterByCurrency(currencyType);
    }

    @GetMapping("/paginated")
    public List<Order> getPaginated(@RequestParam(required = false) Integer page,
                                    @RequestParam(required = false) Integer size) {
        return orderService.findAllPaged(page, size);
    }

    @GetMapping("/sorted")
    public List<Order> getSorted(@RequestParam(required = false) String sortBy,
                                 @RequestParam(required = false) Sort.Direction sort) {
        return orderService.findAllSorted(sortBy, sort);
    }
}
