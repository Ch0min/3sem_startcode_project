package dtos;

import entities.Role;
import entities.User;
import org.mindrot.jbcrypt.BCrypt;

import java.util.*;

public class UserDTO {

    private Long id;
    private String userName;
    private String userPass;
    private List<String> roles;

    public UserDTO() {
    }

    public UserDTO(Long id, String userName, String userPass, List<String> roles) {
        this.id = id;
        this.userName = userName;
        this.userPass = userPass;
        this.roles = roles;
    }

    public UserDTO(String userName, String userPass, List<String> roles) {
        this.userName = userName;
        this.userPass = BCrypt.hashpw(userPass, BCrypt.gensalt());
        this.roles = roles;
    }

    public UserDTO(User u) {
        this.id = u.getId();
        this.userName = u.getUserName();
        this.userPass = BCrypt.hashpw(u.getUserPass(), BCrypt.gensalt());
        this.roles = u.getRolesAsStrings();
    }


    public static List<UserDTO> getUserDTOs(List<User> users) {
        List<UserDTO> userDTOList = new ArrayList<>();
        users.forEach(user -> {
            userDTOList.add(new UserDTO(user));
        });
        return userDTOList;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO)) return false;
        UserDTO userDTO = (UserDTO) o;
        return getId().equals(userDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                '}';
    }


}









