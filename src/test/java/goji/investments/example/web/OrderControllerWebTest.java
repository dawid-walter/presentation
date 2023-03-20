package goji.investments.example.web;

import goji.investments.example.order.OrderCRUDService;
import goji.investments.example.order.model.Order;
import goji.investments.example.order.web.OrderController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static goji.investments.example.order.model.CurrencyType.*;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest({OrderController.class})
class OrderControllerWebTest {
    @MockBean
    OrderCRUDService orderCRUDService;

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("api/orders | GET")
    void shouldGetAllOrders() throws Exception {
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
        Mockito.when(orderCRUDService.findAll()).thenReturn(List.of(order1, order2, order3));

        //Then
        mockMvc.perform(get("/api/orders"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].currency", is("GBP")))
                .andExpect(jsonPath("$[1].currency", is("PLN")))
                .andExpect(jsonPath("$[2].currency", is("USD")));
    }
}
