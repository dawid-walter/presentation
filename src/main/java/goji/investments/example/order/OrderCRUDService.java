package goji.investments.example.order;

import goji.investments.example.order.model.CurrencyType;
import goji.investments.example.order.model.Order;
import goji.investments.example.order.web.CreateOrderRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderCRUDService {
    List<Order> findAll();

    Optional<Order> findById(UUID id);

    Order add(CreateOrderRequest request);

    List<Order> filterByCurrency(CurrencyType currency);

    List<Order> findAllPaged(Integer page, Integer size);

    List<Order> findAllSorted(String sortBy, final Sort.Direction sort);
}
