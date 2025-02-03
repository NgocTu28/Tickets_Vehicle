package project.tickets_vehicle.tickets.model.user;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import project.tickets_vehicle.tickets.model.Tickets.Bookings;
import project.tickets_vehicle.tickets.model.Tickets.Cart;
import project.tickets_vehicle.tickets.model.Tickets.Discount;
import project.tickets_vehicle.tickets.model.basic.BaseEntity;

@Entity
@Table(name = "User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity {
    @Column(name = "user_id")
    String userId;
    @Column(name = "password")
    String password;
    @Column(name = "email")
    String email;
    @Column(name = "phone_number")
    String phoneNumber;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    Role role;
    @Column(name = "google_id")
    String googleId;
    @OneToMany(mappedBy = "user_id", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @ToString.Exclude
    Set<Bookings> booking;
    @OneToMany(mappedBy = "user_ids", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @ToString.Exclude
    Set<Discount> Discount;
    @OneToMany(mappedBy = "user_id", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @ToString.Exclude
    Set<Review> reviews;
    @OneToMany(mappedBy = "user_id", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @ToString.Exclude
    Set<Nontification> nontifications;
    @OneToOne(mappedBy = "user_id", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @ToString.Exclude
    Cart cart;
}
