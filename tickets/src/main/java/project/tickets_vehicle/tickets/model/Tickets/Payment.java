package project.tickets_vehicle.tickets.model.Tickets;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
import project.tickets_vehicle.tickets.model.basic.BaseEntity;

@Entity
@Table(name = "Route")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment extends BaseEntity{
    @Column(name = "payment_date")
    LocalDateTime paymentDate;
    @Column(name = "amount")
    BigDecimal amount;
    @Column(name = "method")
    String method;
    @Column(name = "status")
    Integer status;
    @ManyToOne(cascade = { CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH }, fetch = FetchType.EAGER)
    @JoinColumn(name = "bookings_id")
    Bookings bookings_id;
}
