package project.tickets_vehicle.tickets.model.basic;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
@MappedSuperclass
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "id", updatable = false)
    Long id;

    @Column(name = "create_date", updatable = false)
    Long createDate;

    @Column(name = "update_date")
    Long updateDate;

    @Column(name = "user_create")
    String userCreate;

    @Column(name = "user_update")
    String userUpdate;

    @Column(name = "user_status")
    Integer userStatus;
}
