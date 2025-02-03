package project.tickets_vehicle.tickets.model.vehicle;

import java.math.BigDecimal;
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
import project.tickets_vehicle.tickets.model.Tickets.Ticket;
import project.tickets_vehicle.tickets.model.basic.BaseEntity;

@Entity
@Table(name = "Seat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Seat extends BaseEntity{
    @Column(name = "seat_number")
    String seat_number;
    @Column(name = "status")
    Integer status;
    @Column(name = "type")
    String type;
    @Column(name = "price_seat")
    BigDecimal priceSeat;
    @ManyToOne(cascade = { CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH }, fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id")
    Vehicle vehicle_id;
    @OneToMany(mappedBy = "seat_idss", cascade = { CascadeType.ALL}, fetch = FetchType.LAZY)
    @ToString.Exclude
    Set<Ticket> ticket;
}
