package dtos;

import entities.Role;
import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDTO {

    private Long id;
    private String userName;
    private String userPass;

    public UserDTO() {
    }

    public UserDTO(Long id, String userName, String userPass) {
        this.id = id;
        this.userName = userName;
        this.userPass = userPass;
    }

    public UserDTO(User u) {
        this.id = u.getId();
        this.userName = u.getUserName();
        this.userPass = u.getUserPass();
    }


    public static List<UserDTO> getUserDTOs(List<User> users) {
        List<UserDTO> userDTOList = new ArrayList<>();
        users.forEach(user -> {
            userDTOList.add(new UserDTO(user));
        });
        return userDTOList;
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



// ROLE INNER DTO

    public static class RoleInnerDTO {
        private String roleName;

        public RoleInnerDTO() {
        }

        public RoleInnerDTO(String roleName) {
            this.roleName = roleName;
        }

        public RoleInnerDTO(Role r) {
            this.roleName = r.getRoleName();
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        @Override
        public String toString() {
            return "RoleInnerDTO{" +
                    "roleName='" + roleName + '\'' +
                    '}';
        }
    }
}









