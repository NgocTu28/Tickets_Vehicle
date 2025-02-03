package project.tickets_vehicle.tickets.model.user;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import project.tickets_vehicle.tickets.model.Route.Trip;
import project.tickets_vehicle.tickets.model.basic.BaseEntity;

@Entity
@Table(name = "Review")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Review extends BaseEntity{
    @Column(name = "comment")
    String comment;
    @Column(name = "rating")
    Integer rating;
    @ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User user_id;
    @ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinColumn(name = "trip_id")
    Trip trip_id;
}
