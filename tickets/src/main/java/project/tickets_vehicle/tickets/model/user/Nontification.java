package project.tickets_vehicle.tickets.model.user;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import project.tickets_vehicle.tickets.model.basic.BaseEntity;

@Entity
@Table(name = "Nontification")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Nontification extends BaseEntity{
    @ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User user_id;
    @Column(name = "title")
    String title;
    @Column(name = "message")
    String message;
    @Column(name = "is_read")
    Boolean isRead;
}
