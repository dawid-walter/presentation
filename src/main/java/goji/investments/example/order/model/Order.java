package goji.investments.example.order.model;

import goji.investments.example.address.Address;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String productId;
    private String invoiceId;
    @Enumerated(EnumType.STRING)
    private CurrencyType currency;
    private String comment;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address shipping;
}
