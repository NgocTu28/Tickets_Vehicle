package project.tickets_vehicle.tickets.model.Tickets;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import project.tickets_vehicle.tickets.model.basic.BaseEntity;
import project.tickets_vehicle.tickets.model.user.User;
import project.tickets_vehicle.tickets.model.vehicle.Vehicle;

@Entity
@Table(name = "Cart")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cart extends BaseEntity {
    @Column(name = "status")
    Integer status;
    @OneToMany(mappedBy = "cart_id", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @ToString.Exclude
    Set<CartItem> cartItems;
    @OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User user_id;
}
