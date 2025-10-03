package lk.sliit.inventorycontrolsystem.projectse2030se.DTO.user;

import lk.sliit.inventorycontrolsystem.projectse2030se.data.UserRoles;

import java.time.LocalDateTime;

public record UserResponseDTO(String userID, LocalDateTime created_at, LocalDateTime updated_at, String userName, String firstName, String lastName, String displayName, String address, String email, String phoneNumber, UserRoles role, boolean activeStatus) {
//    public static UserResponseDTO toUserResponseDTO() {
//        UserDAO userDAO = new UserDAOJdbc();
//    }
}
