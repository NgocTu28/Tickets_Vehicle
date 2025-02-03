package project.tickets_vehicle.tickets.model.Tickets;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import project.tickets_vehicle.tickets.model.Route.Trip;
import project.tickets_vehicle.tickets.model.basic.BaseEntity;
import project.tickets_vehicle.tickets.model.user.User;

@Entity
@Table(name = "Booking")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bookings extends BaseEntity{
    @Column(name = "booking_date")
    LocalDateTime bookingDate;
    @Column(name = "status")
    Integer status;
    @Column(name = "total_price")
    BigDecimal totalPrice;
    @ManyToOne(cascade = { CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH }, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User user_id;
    @ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinColumn(name = "trip_id")
    Trip trip_id;
    @OneToMany(mappedBy = "bookings_id", cascade = { CascadeType.ALL}, fetch = FetchType.LAZY)
    @ToString.Exclude
    Set<Payment> payment;
    @OneToMany(mappedBy = "booking_idss", cascade = { CascadeType.ALL}, fetch = FetchType.LAZY)
    @ToString.Exclude
    Set<Ticket> ticket;
}
