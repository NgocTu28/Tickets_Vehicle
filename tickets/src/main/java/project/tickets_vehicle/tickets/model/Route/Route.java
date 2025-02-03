package project.tickets_vehicle.tickets.model.Route;

import java.time.Duration;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import project.tickets_vehicle.tickets.model.basic.BaseEntity;

@Entity
@Table(name = "Route")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Route extends BaseEntity{
    @Column(name = "start_station")
    String startStation;
    @Column(name = "end_station")
    String endStation;
    @Column(name = "distance")
    Float distance;
    @Column(name = "duration")
    Duration duration;
    @OneToMany(mappedBy = "route_id", cascade = { CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @ToString.Exclude
    Set<Trip> trips;
}
