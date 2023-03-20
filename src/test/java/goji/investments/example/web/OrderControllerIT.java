package goji.investments.example.web;

import goji.investments.example.order.db.OrderJpaRepository;
import goji.investments.example.order.model.CurrencyType;
import goji.investments.example.order.model.Order;
import goji.investments.example.order.web.OrderController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static goji.investments.example.order.model.CurrencyType.GBP;
import static goji.investments.example.order.model.CurrencyType.USD;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OrderControllerIT {
    @Autowired
    OrderJpaRepository orderJpaRepository;

    @Autowired
    OrderController orderController;

    @Test
    @DisplayName("Integration test, should return list of orders")
    void shouldGetAllOrders() {
        //Given
        saveOrderToDb(GBP);
        saveOrderToDb(USD);

        //When
        List<Order> all = orderController.get();

        //Then
        assertThat(all).hasSize(2);
    }

    private void saveOrderToDb(CurrencyType currency) {
        Order order = Order.builder()
                .currency(currency)
                .build();
        orderJpaRepository.save(order);
    }
}
