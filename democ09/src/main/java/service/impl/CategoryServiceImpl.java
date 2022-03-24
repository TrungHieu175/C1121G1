package service.impl;

import model.Category;
import repository.ICategoryRepo;
import repository.impl.CategoryRepoImpl;
import service.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    private static ICategoryRepo iCategoryRepo = new CategoryRepoImpl();
    @Override
    public List<Category> getAllCategory() {
        return iCategoryRepo.getAllCategory();
    }
}
