package project.tickets_vehicle.tickets.model.Tickets;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import project.tickets_vehicle.tickets.model.Route.Trip;
import project.tickets_vehicle.tickets.model.basic.BaseEntity;
import project.tickets_vehicle.tickets.model.vehicle.Seat;

@Entity
@Table(name = "Ticket")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket extends BaseEntity{
    @Column(name = "price")
    BigDecimal price;
    @Column(name = "issued_at")
    LocalDate issuedAt;
    @ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinColumn(name = "booking_idss")
    Bookings booking_idss;
    @ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinColumn(name = "seat_idss")
    Seat seat_idss;
    @ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinColumn(name = "trip_idss")
    Trip trip_idss;
}
