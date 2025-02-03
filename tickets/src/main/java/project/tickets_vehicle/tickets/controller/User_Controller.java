package project.tickets_vehicle.tickets.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import project.tickets_vehicle.tickets.service.User_Service;

@RestController
@RequestMapping("/v1/user")
@AllArgsConstructor
public class User_Controller {
    User_Service userService;

    @GetMapping("")
    public ResponseEntity<?> getListUser(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        return (ResponseEntity<?>) userService.getAllUser(pageNo, pageSize);
    }

}
