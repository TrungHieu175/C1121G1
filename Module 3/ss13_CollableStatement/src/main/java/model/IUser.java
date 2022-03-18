package model;

import java.sql.SQLException;
import java.util.List;

public interface IUser {
        void insertUser(IUser IUser) throws SQLException;

        IUser selectUser(int id);

        List<IUser> selectAllUsers();

        boolean deleteUser(int id) throws SQLException;

        boolean updateUser(IUser IUser) throws SQLException;

        IUser getUserById(int id);

        void insertUserStore(IUser IUser) throws SQLException;
}
