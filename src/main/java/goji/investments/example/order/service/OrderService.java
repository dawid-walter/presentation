package goji.investments.example.order.service;

import goji.investments.example.order.OrderCRUDService;
import goji.investments.example.order.db.OrderJpaRepository;
import goji.investments.example.order.model.CurrencyType;
import goji.investments.example.order.model.Order;
import goji.investments.example.order.web.CreateOrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.data.domain.PageRequest.of;
import static org.springframework.data.domain.Sort.by;

@Service
@RequiredArgsConstructor
public
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

    @Override
    public List<Order> filterByCurrency(CurrencyType currency) {
        return repository.findAll().stream()
                .filter(order -> order.getCurrency() == currency)
                .toList();
    }

    @Override
    public List<Order> findAllPaged(Integer page, Integer size) {
        var pageNumber = page != null && page >= 0 && page < Integer.MAX_VALUE ? page : 0;
        var sizeValue = size != null && size >= 1 && size < Integer.MAX_VALUE ? size : 1;
        return repository.findAllPaged(of(pageNumber, sizeValue));
    }

    @Override
    public List<Order> findAllSorted(String sortBy, Sort.Direction sort) {
        var sortByParameter = sortBy != null ? sortBy : "id";
        var sortDirection = sort != null ? sort : Sort.Direction.ASC;

        return repository.findAllSorted(by(sortDirection, sortByParameter));
    }
}
