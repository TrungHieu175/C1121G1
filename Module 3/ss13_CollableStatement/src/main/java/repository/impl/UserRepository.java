package repository.impl;

import model.User;
import repository.IUserRepository;
import service.IUserService;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";

    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";

    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"

            + "("

            + " ID serial,"

            + " NAME varchar(100) NOT NULL,"

            + " SALARY numeric(15, 2) NOT NULL,"

            + " CREATED_DATE timestamp,"

            + " PRIMARY KEY (ID)"

            + ")";

    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";
    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, country) VALUES (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String SEARCH_BY_ID = "select * from users where id = ?;";
    private static final String SEARCH_BY_NAME = "select * from users where users.name like ? ;";
    private static final String ORDERBY_USERS_SQL = "SELECT * FROM users ORDER BY name asc ;";
    public BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<User> searchByCountry(String country) {
        List<User> userList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        String query = "{CALL search_country(?)}";
        CallableStatement callableStatement = null;
        try {
            callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, country);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country1 = resultSet.getString("country");
                User user = new User(id, name1, email, country1);
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void insertUser(User user) {
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public User selectUser(int id) {
        Connection connection = baseRepository.getConnection();
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> userList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(ORDERBY_USERS_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user;
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                userList.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    @Override
    public void deleteUser(int id) {
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteUserStore(Integer id) {
        Connection connection = baseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{CALL delete_user(?)}");
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateUser(User user) {
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<User> searchByName(String name) {
        List<User> userList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name1, email, country);
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<User> searchById(Integer id) {
        List<User> userList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id1, name, email, country);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User getUserById(Integer id) {
        Connection connection = baseRepository.getConnection();
        User user = null;

        String query = "{CALL get_user_by_id(?)}";

        try {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1, id);

            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {

                String name = resultSet.getString("name");

                String email = resultSet.getString("email");

                String country = resultSet.getString("country");

                user = new User(id, name, email, country);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public void selectUser() {
        Connection connection = baseRepository.getConnection();
        User user = null;
        String query = "{CALL select_user()}";
        CallableStatement callableStatement = null;
        try {
            callableStatement = connection.prepareCall(query);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {

                Integer id = resultSet.getInt("id");

                String name = resultSet.getString("name");

                String email = resultSet.getString("email");

                String country = resultSet.getString("country");

                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserStore(User user) {
        String query = "{CALL update_user(?,?,?,?)}";

        Connection connection = baseRepository.getConnection();

        CallableStatement callableStatement = null;
        try {
            callableStatement = connection.prepareCall(query);

            callableStatement.setInt(1, user.getId());

            callableStatement.setString(2, user.getName());

            callableStatement.setString(3, user.getEmail());

            callableStatement.setString(4, user.getCountry());

            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void insertUserStore(User user) {
        String query = "{CALL insert_user(?,?,?)}";

        Connection connection = baseRepository.getConnection();

        CallableStatement callableStatement = null;
        try {
            callableStatement = connection.prepareCall(query);

            callableStatement.setString(1, user.getName());

            callableStatement.setString(2, user.getEmail());

            callableStatement.setString(3, user.getCountry());

            System.out.println(callableStatement);

            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addUserTransaction(User user, int[] permisions) {

        Connection conn = null;

        PreparedStatement pstmt = null;


        PreparedStatement pstmtAssignment = null;

        ResultSet rs = null;

        try {

            conn = baseRepository.getConnection();

            conn.setAutoCommit(false);

            pstmt = conn.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, user.getName());

            pstmt.setString(2, user.getEmail());

            pstmt.setString(3, user.getCountry());

            int rowAffected = pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();

            int userId = 0;

            if (rs.next())

                userId = rs.getInt(1);

            if (rowAffected == 1) {

                String sqlPivot = "INSERT INTO user_permision(user_id,permision_id) "

                        + "VALUES(?,?)";

                pstmtAssignment = conn.prepareStatement(sqlPivot);

                for (int permisionId : permisions) {

                    pstmtAssignment.setInt(1, userId);

                    pstmtAssignment.setInt(2, permisionId);

                    pstmtAssignment.executeUpdate();

                }

                conn.commit();

            } else {

                conn.rollback();

            }

        } catch (SQLException ex) {

            // roll back the transaction

            try {

                if (conn != null)

                    conn.rollback();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

            System.out.println(ex.getMessage());

        } finally {

            try {

                if (rs != null) rs.close();

                if (pstmt != null) pstmt.close();

                if (pstmtAssignment != null) pstmtAssignment.close();

                if (conn != null) conn.close();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

        }

    }

    @Override
    public void insertUpdateWithoutTransaction() {

        try (Connection conn = baseRepository.getConnection();

             Statement statement = conn.createStatement();

             PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);

             PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {


            statement.execute(SQL_TABLE_DROP);

            statement.execute(SQL_TABLE_CREATE);

            psInsert.setString(1, "Quynh");

            psInsert.setBigDecimal(2, new BigDecimal(10));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();


            psInsert.setString(1, "Ngan");

            psInsert.setBigDecimal(2, new BigDecimal(20));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();

            psUpdate.setBigDecimal(2, new BigDecimal(999.99));

            psUpdate.setString(2, "Quynh");

            psUpdate.execute();


        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public void insertUpdateUseTransaction() {

        try (Connection conn = baseRepository.getConnection();

             Statement statement = conn.createStatement();

             PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);

             PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {

            statement.execute(SQL_TABLE_DROP);

            statement.execute(SQL_TABLE_CREATE);

            conn.setAutoCommit(false);

            psInsert.setString(1, "Quynh");

            psInsert.setBigDecimal(2, new BigDecimal(10));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();


            psInsert.setString(1, "Ngan");

            psInsert.setBigDecimal(2, new BigDecimal(20));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();

            psUpdate.setBigDecimal(1, new BigDecimal(999.99));

            psUpdate.setString(2, "Quynh");

            psUpdate.execute();

            conn.commit();

            conn.setAutoCommit(true);


        } catch (Exception e) {

            System.out.println(e.getMessage());

            e.printStackTrace();

        }

    }
}
