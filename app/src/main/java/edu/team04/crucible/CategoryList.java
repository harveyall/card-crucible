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
    /** Constructs a CategoryList with an empty array list*/
    public CategoryList(){
        this.categories = new ArrayList();
    }

    /** Constructs a CategoryList with a specified List of categories
     * @param categories
     * */
    public CategoryList(List<Category> categories){
        this.categories = categories;
    }



    /** Return the list of categories in this CategoryList*/
    public List<Category> getCategories() {
        return categories;
    }

    /** Set the list of categories to the specified category list*/
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /** Return a specific category in this CategoryList based on its name
     * @param categoryName
     * */
    public Category getCategory(String categoryName){
        Category retrievedCategory = null;
        for(Category category : this.categories){
            if(category.getName().equals(categoryName)){
                retrievedCategory = category;
            }
        }
        return retrievedCategory;
    }

    /** Return a specific category from the category list based on its index
     * @param index
     * */
    public Category getCategory(int index){
        return this.categories.get(index);
    }


    /** Return index of a specified category if it exists, else return -1
     * @param category
     * */
    public int getCategoryIndex(Category category){
        for(int i = 0; i < this.categories.size(); i++){
            if(categories.get(i).getName().equals(category.getName())){
                return i;
            }
        }
        return -1;
    }

    /** Remove a specified category from the category list
     * @param categoryName
     * */
    public void deleteCategory(String categoryName){
        for(Category category : this.categories){
            if(category.getName().equals(categoryName)){
                this.categories.remove(category);
            }
        }
    }

    /** Remove a specified category from the category list
     * @param index
     * */
    public void deleteCategory(int index){
        this.categories.remove(index);
    }

    /** Add a specified category to the category list
     * @param category
     * */
    public void addCategory(Category category){
        if(this.canAddCategory()) {
            this.categories.add(category);
        }
    }

    /** Remove all categories in the category list */
    public void clearData(){
        for(int i = 0; i < this.categories.size(); i++){
            this.deleteCategory(i);
        }
    }
    /** This method returns true if there are less than 5 categories in the categories list and false if not */
    public boolean canAddCategory(){
        return this.categories.size() < 5;
    }

    /** Return a string representation of this CategoryList*/
    @Override
    public String toString() {
        return "CategoryList{" +
                "categories=" + categories +
                '}';
    }
}