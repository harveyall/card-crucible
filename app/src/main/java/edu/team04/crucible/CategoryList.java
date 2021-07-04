package edu.team04.crucible;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a list of the Card Categories which in turn have lists of the cards that belong to
 * said categories.
 */
public class CategoryList {
    //This class will contain all data that gets saved to localStorage
    // as well as methods to manipulate its data
    List<Category> categories;

    public CategoryList(){
        this.categories = new ArrayList();
    }
    public CategoryList(List<Category> categories){
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
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

    public Category getCategory(int index){
        return this.categories.get(index);
    }

    public void deleteCategory(String categoryName){
        for(Category category : this.categories){
            if(category.getName().equals(categoryName)){
                this.categories.remove(category);
            }
        }
    }

    public void deleteCategory(int index){
        this.categories.remove(index);
    }

    public void addCategory(Category category){
        if(this.canAddCategory()) {
            this.categories.add(category);
        }
    }

    public void clearData(){
        for(int i = 0; i < this.categories.size(); i++){
            this.deleteCategory(i);
        }
    }
    /** This method returns true if there are less than 5 categories in the categories list and false if not */
    public boolean canAddCategory(){
        return this.categories.size() < 5;
    }

    @Override
    public String toString() {
        return "CategoryList{" +
                "categories=" + categories +
                '}';
    }
}