package service.impl;

import model.User;
import repository.IUserRepository;
import repository.impl.UserRepository;
import service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    IUserRepository iUserRepository = new UserRepository();

    @Override
    public void insertUser(User user) {
        iUserRepository.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return iUserRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return iUserRepository.selectAllUsers();
    }

    @Override
    public void deleteUser(int id) {
        iUserRepository.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        iUserRepository.updateUser(user);
    }

    @Override
    public List<User> searchByName(String name) {
        return iUserRepository.searchByName(name);
    }

    @Override
    public List<User> searchById(Integer id) {
        return iUserRepository.searchById(id);
    }

    @Override
    public User getUserById(Integer id) {
        return iUserRepository.getUserById(id);
    }

    @Override
    public void insertUserStore(User user) {

        iUserRepository.insertUserStore(user);
    }

    public void addUserTransaction(User user, int[] permision) {
        iUserRepository.addUserTransaction(user, permision);
    }

    @Override
    public void insertUpdateWithoutTransaction() {

        iUserRepository.insertUpdateWithoutTransaction();
    }

    @Override
    public void insertUpdateUseTransaction() {

        iUserRepository.insertUpdateUseTransaction();
    }

    @Override
    public void selectUser() {

        iUserRepository.selectUser();
    }

    public void updateUserStore(User user) {

        iUserRepository.updateUser(user);
    }

    @Override
    public List<User> searchByCountry(String country) {

        return iUserRepository.searchByCountry(country);
    }

    @Override
    public void deleteUserStore(Integer id) {
        iUserRepository.deleteUserStore(id);
    }
}
