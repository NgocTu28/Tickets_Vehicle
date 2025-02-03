package project.tickets_vehicle.tickets.service;

import org.springframework.data.domain.Page;

import project.tickets_vehicle.tickets.model.user.User;

public interface User_Service {
    Page<User> getAllUser(Integer pageNo, Integer pageSize);
}
