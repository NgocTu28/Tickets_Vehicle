package project.tickets_vehicle.tickets.Config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import project.tickets_vehicle.tickets.model.user.User;
import project.tickets_vehicle.tickets.repository.User_Repository;
@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService{
    User_Repository user_Repository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userFind = user_Repository.findByEmail(username);
        String role = user_Repository.getRoleByID(userFind.getId());
        if(role.equals("USER")){
            return org.springframework.security.core.userdetails.User
            .builder()
            .username(userFind.getEmail())
            .password(userFind.getPassword())
            .roles("USER")
            .build();
        }else if(role.equals("MANAGER")){
            return org.springframework.security.core.userdetails.User
            .builder()
            .username(userFind.getEmail())
            .password(userFind.getPassword())
            .roles("MANAGER")
            .build();
        }else{
            return org.springframework.security.core.userdetails.User
            .builder()
            .username(userFind.getEmail())
            .password(userFind.getPassword())
            .roles("ADMIN")
            .build();
        }
    }


}
