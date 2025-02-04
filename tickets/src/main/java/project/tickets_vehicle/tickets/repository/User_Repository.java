package project.tickets_vehicle.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.tickets_vehicle.tickets.model.user.User;
@Repository
public interface User_Repository extends JpaRepository<User, Long>{
    @Query(value = "SELECT u FROM User u WHERE u.id = :id")
    String getRoleByID(@Param("id") long id);
    @Query(value = "SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String email);
}
