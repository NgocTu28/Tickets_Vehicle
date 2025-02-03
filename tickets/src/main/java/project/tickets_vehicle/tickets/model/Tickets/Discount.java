package project.tickets_vehicle.tickets.model.Tickets;

import java.math.BigDecimal;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import project.tickets_vehicle.tickets.model.basic.BaseEntity;
import project.tickets_vehicle.tickets.model.user.User;

@Entity
@Table(name = "Discount")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Discount extends BaseEntity {
    @Column(name = "code")
    String code;
    @Column(name = "description")
    String description;
    @Column(name = "discount_type")
    Integer discountType;
    @Column(name = "discount_value")
    BigDecimal discountValue;
    @Column(name = "status")
    Integer status;
    @ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_ids")
    User user_ids;
}
