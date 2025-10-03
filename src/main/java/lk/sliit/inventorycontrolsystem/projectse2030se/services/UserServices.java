package lk.sliit.inventorycontrolsystem.projectse2030se.services;

import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.UserDAO;
import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.jdbc.UserDAOJdbc;
import lk.sliit.inventorycontrolsystem.projectse2030se.DTO.user.*;
import lk.sliit.inventorycontrolsystem.projectse2030se.data.UserLoginStatus;
import lk.sliit.inventorycontrolsystem.projectse2030se.data.UserRoles;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.User;
import lk.sliit.inventorycontrolsystem.projectse2030se.config.crypto.Argon2Config;

public class UserServices {

    private static final UserDAO userDAO = new UserDAOJdbc();

    public UserLoginStatus loginUser(UserRequestLoginDTO userRequestLoginDTO) {
        try {
            if (userRequestLoginDTO.isUserFound()) {
                if (userRequestLoginDTO.isUserActive()) {

                    User user = userRequestLoginDTO.toUser();

                    System.out.println(Argon2Config.verifyPassword(user.getPasswordHash(), userRequestLoginDTO.password()) ? UserLoginStatus.LOGIN_SUCCESS : UserLoginStatus.INVALID_CREDENTIALS);
                    return ((Argon2Config.verifyPassword(user.getPasswordHash(), userRequestLoginDTO.password()))
                            ? UserLoginStatus.LOGIN_SUCCESS
                            : UserLoginStatus.INVALID_CREDENTIALS
                    );
                }
                else {
                    System.out.println("A Deactivated Account");
                }
            }
            else {
                System.out.println("User not found, or " + UserLoginStatus.NOT_REGISTERED + "!");
            }
        } catch (Exception e) {
            System.out.println("Error while trying to Login!");
        }
        return UserLoginStatus.NOT_REGISTERED;
    }

    public boolean registerUser(UserRequestRegisterDTO userRequestRegisterDTO) {
        try {
            if ((userDAO.getByUsername(userRequestRegisterDTO.userName()) == null) && (userDAO.getByEmail(userRequestRegisterDTO.email()) == null)) {
                User user = userRequestRegisterDTO.toUser();
                userDAO.create(user);
                System.out.println("Successfully Registered User!");
                return true;
            }
            else {
                System.out.println("User already exists!");
            }
        }
        catch (Exception e) {
            System.out.println("Error while trying to Register User!");
        }
        return false;
    }

    public boolean changePassword(UserRequestPasswordChangeDTO userRequestPasswordChangeDTO) {
        try {
            if (userRequestPasswordChangeDTO.isUserActive()) {
                User user = userRequestPasswordChangeDTO.toUser();

                userDAO.update(user);
                System.out.println("Successfully Changed Password!");

                return true;
            }
            else {
                System.out.println("A Deactivated Account!");
            }
        } catch (Exception e) {
            System.out.println("Error while changing password!");
        }
        return false;
    }

    public boolean changeUserData(UserRequestUpdateDTO userRequestUpdateDTO) {
        try {
            if (userRequestUpdateDTO.isUserActive()) {
                User user = userRequestUpdateDTO.toUser();

                userDAO.update(user);
                System.out.println("Successfully Changed User Data!");
                return true;
            }
            else {
                System.out.println("A Deactivated Account!");
            }
        } catch (Exception e) {
            System.out.println("Error while changing User Data!");
        }
        return false;
    }

    public boolean changeUserActiveStatus(UserRequestActiveStatusChangeDTO userRequestActiveStatusChangeDTO) {
        try {
            if (userRequestActiveStatusChangeDTO.isUserActive()) {
                User user = userRequestActiveStatusChangeDTO.toUser();

                userDAO.update(user);
                System.out.println("Successfully Changed User Active Status!");
                return true;
            }
            else {
                System.out.println("A Deactivated Account!");
            }
        }
        catch (Exception e) {
            System.out.println("Error while changing User's Status!");
        }
        return false;
    }

    public boolean deleteUser(UserRequestActiveStatusChangeDTO userRequestActiveStatusChangeDTO) {
        try {
            if (userRequestActiveStatusChangeDTO.isUserActive()) {
                User user = userRequestActiveStatusChangeDTO.toUser();

                userDAO.delete(user);
                System.out.println("Successfully Deleted User!");
                return true;
            }
            else {
                System.out.println("A Deactivated Account!");
            }
        }
        catch (Exception e) {
            System.out.println("Error while deleting User!");
        }
        return false;
    }

}
