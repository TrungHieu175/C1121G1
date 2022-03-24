package repository.impl;

import model.Category;
import repository.BaseRepository;
import repository.ICategoryRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepoImpl implements ICategoryRepo {
    @Override
    public List<Category> getAllCategory() {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        List<Category> categoryList = new ArrayList<>();
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement("select * from category;");
                resultSet = preparedStatement.executeQuery();
                Category category;
                while (resultSet.next()) {
                    category = new Category();
                    category.setCategoryId(resultSet.getInt("category_id"));
                    category.setCategoryName(resultSet.getString("category_name"));
                    categoryList.add(category);
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
        }
        return categoryList;
    }
}
