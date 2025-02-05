package project.tickets_vehicle.tickets.Config.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String jwt;
    private String role;
    private Long id;
    private String ten;
    private String email;
    private String sdt;
    private String avatar;
    private Integer trangThai;
}
