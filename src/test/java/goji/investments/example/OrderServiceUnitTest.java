package goji.investments.example;

import goji.investments.example.order.db.OrderJpaRepository;
import goji.investments.example.order.model.Order;
import goji.investments.example.order.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static goji.investments.example.order.model.CurrencyType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceUnitTest {
    @InjectMocks
    OrderService orderService;

    @Mock
    OrderJpaRepository orderRepository;

    @Test
    @DisplayName("Should return filtered order result by given currency type")
    void shouldReturnOrderListWithFilteredCurrency() {
        //Given
        Order order1 = Order.builder()
                .currency(GBP)
                .build();
        Order order2 = Order.builder()
                .currency(PLN)
                .build();
        Order order3 = Order.builder()
                .currency(USD)
                .build();
        //When
        when(orderRepository.findAll()).thenReturn(List.of(order1, order2, order3));
        List<Order> result = orderService.filterByCurrency(GBP);

        //Then
        assertThat(result).hasSize(1);
    }
}
