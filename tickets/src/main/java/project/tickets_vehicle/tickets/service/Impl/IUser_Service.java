package project.tickets_vehicle.tickets.service.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import project.tickets_vehicle.tickets.model.user.User;
import project.tickets_vehicle.tickets.repository.User_Repository;
import project.tickets_vehicle.tickets.service.User_Service;

@Service
@AllArgsConstructor
public class IUser_Service implements User_Service {
    User_Repository user_Repository;

    @Override
    public Page<User> getAllUser(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<User> pageUser = user_Repository.findAll(pageable);
        return pageUser;
    }

}
