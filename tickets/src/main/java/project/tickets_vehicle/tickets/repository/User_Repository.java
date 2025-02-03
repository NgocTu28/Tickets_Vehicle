package project.tickets_vehicle.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.tickets_vehicle.tickets.model.user.User;

public interface User_Repository extends JpaRepository<User, Long>{

}
