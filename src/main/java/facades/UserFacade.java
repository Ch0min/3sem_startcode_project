package facades;

import dtos.UserDTO;
import entities.Role;
import entities.User;

import javax.persistence.*;

import org.mindrot.jbcrypt.BCrypt;
import security.errorhandling.AuthenticationException;
import utils.EMF_Creator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserFacade {

    private static EntityManagerFactory emf;
    private static UserFacade instance;

    private UserFacade() {
    }

    public static UserFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new UserFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public User getVerifiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.userName = :username", User.class);
            query.setParameter("username", username);
            user = query.getSingleResult();

            if (/* user == null ||*/ !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid username or password");
            }
        } catch (NoResultException e) {
            throw new AuthenticationException("Invalid username or password");
        } finally {
            em.close();
        }
        return user;
    }

    public List<UserDTO> getAllUsers() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
            List<User> users = query.getResultList();

            List<UserDTO> userDTOList = new ArrayList<>();
            for (User user : users) {
                userDTOList.add(new UserDTO(user));
            }
            return userDTOList;
        } finally {
            em.close();
        }
    }

    public UserDTO getUserByID(Long userId) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.id = :id", User.class);
            query.setParameter("id", userId);

            User user = query.getSingleResult();
            return new UserDTO(user);

        } finally {
            em.close();
        }
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = new User(userDTO);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return new UserDTO(user);
        } finally {
            em.close();
        }
    }


    public UserDTO updateUser(UserDTO userDTO) {
        User user = new User(userDTO);
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
            return new UserDTO(user);
        } finally {
            em.close();
        }
    }


    public UserDTO deleteUser(long id) {
        EntityManager em = getEntityManager();
        User user = em.find(User.class, id);
        try {
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
            return new UserDTO(user);
        } finally {
            em.close();
        }
    }

}
