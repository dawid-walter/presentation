package goji.investments.example.order;

import goji.investments.example.order.model.CurrencyType;
import goji.investments.example.order.model.Order;
import goji.investments.example.order.web.CreateOrderRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderCRUDService {
    List<Order> findAll();

    Optional<Order> findById(UUID id);

    Order add(CreateOrderRequest request);

    List<Order> filterByCurrency(CurrencyType currency);
}
