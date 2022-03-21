package service;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    public void insertUser(User user);

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public void deleteUser(int id);

    public void updateUser(User user);

    public List<User> searchByName(String name);

    public List<User> searchById(Integer id);

    User getUserById(Integer id);

    void insertUserStore(User user);

    void addUserTransaction(User user, int[] permision);

    public void insertUpdateWithoutTransaction();

    public void insertUpdateUseTransaction();

    public void selectUser();

    public void updateUserStore(User user);

    public List<User> searchByCountry(String country);

    public void deleteUserStore(Integer id);
}
