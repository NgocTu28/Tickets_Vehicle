package project.tickets_vehicle.tickets.model.vehicle;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import project.tickets_vehicle.tickets.model.Route.Trip;
import project.tickets_vehicle.tickets.model.basic.BaseEntity;

@Entity
@Table(name = "Vehicle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Vehicle extends BaseEntity{
    @Column(name = "vehicle_name")
    String vehicleName;
    @Column(name = "vehicle_type")
    @Enumerated(EnumType.STRING)
    Vehicle_Type vehicleType;
    @Column(name = "tool_seat")
    Integer tooleSeat;
    @Column(name = "Status")
    Integer status;
    @OneToMany(mappedBy = "vehicle_id", cascade = { CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @ToString.Exclude
    Set<Trip> trips;
}