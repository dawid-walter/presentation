package goji.investments.example.order.service;

import goji.investments.example.order.OrderCRUDService;
import goji.investments.example.order.db.OrderJpaRepository;
import goji.investments.example.order.model.Order;
import goji.investments.example.order.web.CreateOrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class OrderService implements OrderCRUDService {
    private final OrderJpaRepository repository;

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Order> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Order add(CreateOrderRequest request) {
        return repository.save(request.toOrder());
    }
}
