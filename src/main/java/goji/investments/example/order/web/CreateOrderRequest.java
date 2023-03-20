package goji.investments.example.order.web;

import goji.investments.example.address.Address;
import goji.investments.example.order.model.CurrencyType;
import goji.investments.example.order.model.Order;

public record CreateOrderRequest(String productId, String invoiceId, CurrencyType currency, String comment,
                                 RequestAddress shipping) {
    public Order toOrder() {
        return Order.builder()
                .productId(productId)
                .invoiceId(invoiceId)
                .currency(currency)
                .comment(comment)
                .shipping(Address.builder()
                        .street(shipping.street())
                        .postcode(shipping.street())
                        .city(shipping.city())
                        .country(shipping.country())
                        .build())
                .build();
    }

    record RequestAddress(String street, String postCode, String city, String country) {
    }
}
