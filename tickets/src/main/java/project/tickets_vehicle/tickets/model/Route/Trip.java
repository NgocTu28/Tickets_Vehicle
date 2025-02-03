package project.tickets_vehicle.tickets.model.Route;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import project.tickets_vehicle.tickets.model.Tickets.Bookings;
import project.tickets_vehicle.tickets.model.Tickets.CartItem;
import project.tickets_vehicle.tickets.model.Tickets.Ticket;
import project.tickets_vehicle.tickets.model.basic.BaseEntity;
import project.tickets_vehicle.tickets.model.user.Review;
import project.tickets_vehicle.tickets.model.vehicle.Vehicle;

@Entity
@Table(name = "Trip")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Trip extends BaseEntity{
    @Column(name = "departure_time")
    LocalDateTime departureTime;
    @Column(name = "arrival_time")
    LocalDateTime arrivalTime;
    @Column(name = "price_ticket")
    BigDecimal priceTicket;
    @ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id")
    Vehicle vehicle_id;

    @ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinColumn(name = "route_id")
    Route route_id;

    @OneToMany(mappedBy = "trip_ids", cascade = { CascadeType.ALL}, fetch = FetchType.LAZY)
    @ToString.Exclude
    Set<CartItem> cartItems;

    @OneToMany(mappedBy = "trip_idss", cascade = { CascadeType.ALL}, fetch = FetchType.LAZY)
    @ToString.Exclude
    Set<Ticket> tickets;
    @OneToMany(mappedBy = "trip_id", cascade = { CascadeType.ALL}, fetch = FetchType.LAZY)
    @ToString.Exclude
    Set<Review> reviews;
}
