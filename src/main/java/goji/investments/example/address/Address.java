package goji.investments.example.address;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public
class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String street;
    private String postcode;
    private String country;
    private String city;
}
