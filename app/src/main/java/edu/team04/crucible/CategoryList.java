package edu.team04.crucible;

import java.util.ArrayList;
import java.util.List;

public class CategoryList {
    //This class will contain all data that gets saved to localStorage
    // as well as methods to manipulate it's data
    List<Category> categories;

    public CategoryList(){
        this.categories = new ArrayList();
    }
    public CategoryList(ArrayList categories){
        this.categories = categories;
    }

    public List getCategories() {
        return categories;
    }

    public void setCategories(List categories) {
        this.categories = categories;
    }


    public Category getCategory(String categoryName){
        Category retrievedCategory = null;
        for(Category category : this.categories){
            if(category.getName().equals(categoryName)){
                retrievedCategory = category;
            }
        }
        return retrievedCategory;
    }

    public void deleteCategory(String categoryName){
        for(Category category : this.categories){
            if(category.getName().equals(categoryName)){
                this.categories.remove(category);
            }
        }

    }

    public void addCategory(Category category){
        this.categories.add(category);

    }
}
