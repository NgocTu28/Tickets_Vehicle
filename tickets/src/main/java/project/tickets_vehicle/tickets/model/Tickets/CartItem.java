package project.tickets_vehicle.tickets.model.Tickets;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import project.tickets_vehicle.tickets.model.Route.Trip;
import project.tickets_vehicle.tickets.model.basic.BaseEntity;
import project.tickets_vehicle.tickets.model.vehicle.Seat;

@Entity
@Table(name = "Cart_Item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItem extends BaseEntity {
    @Column(name = "quanlity")
    Integer quanlity;
    @Column(name = "price")
    Integer price;
    @Column(name = "added_at")
    LocalDateTime addedAt;
    @ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    Cart cart_id;
    @ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinColumn(name = "seat_id")
    Seat seat_id;
    @ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinColumn(name = "trip_ids")
    Trip trip_ids;
}
