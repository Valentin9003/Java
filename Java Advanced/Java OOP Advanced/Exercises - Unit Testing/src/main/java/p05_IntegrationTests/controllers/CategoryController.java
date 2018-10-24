package p05_IntegrationTests.controllers;

import p05_IntegrationTests.models.Category;
import p05_IntegrationTests.models.User;

import java.util.HashSet;
import java.util.Set;

public class CategoryController {

    private Set<Category> categories;

    public CategoryController() {
        this.categories = new HashSet<>();
    }

    public CategoryController(String... names) {
        for (String name : names) {
            this.addCategory(name);
        }
    }

    private void addCategory(String name) {
        if (this.categories.stream().anyMatch(c -> c.getName().equals(name)
                || c.getChildCategories().stream().anyMatch(cc -> cc.getName().equals(name)))) {
            return;
        }
        this.categories.add(new Category(name));
    }

    public void addCategory(String... names) {
        for (String name : names) {
            this.addCategory(name);
        }
    }

    public void removeCategory(String name) {
        Category categoryToRemove = null;
        for (Category category : this.categories) {
            if (category.getName().equals(name)) {
                categoryToRemove = category;
            }
        }

        if (categoryToRemove != null) {
            for (Category category : this.categories) {
                if (category.getChildCategories().contains(categoryToRemove)) {
                    break;
                }
            }
        }

        if (categoryToRemove == null) {
            return;
        }

        categoryToRemove.moveUsersToParent();
        this.removeCategoryFromUsersLists(categoryToRemove);
        this.moveChildrentCategoriesToParent(categoryToRemove);

        if (categoryToRemove.getParent() == null) {
            this.categories.remove(categoryToRemove);
        } else {
            categoryToRemove.getParent().removeChild(categoryToRemove.getName());
        }
    }


    public void removeCategory(String... names) {
        for (String categoryName : names) {
            this.removeCategory(categoryName);
        }
    }

    public void addChild(Category parent, String childName) {
        parent.addChild(new Category(childName));
    }

    public void addUser(Category category, User user) {
        category.addUser(user);
    }

    private void moveChildrentCategoriesToParent(Category categoryToRemove) {
        if (categoryToRemove.getParent() == null) {
            this.categories.addAll(categoryToRemove.getChildCategories());
            return;
        }

        for (Category child : categoryToRemove.getChildCategories()) {
            categoryToRemove.getParent().addChild(child);
        }
    }

    private void removeCategoryFromUsersLists(Category categoryToRemove) {
        for (User user : categoryToRemove.getUsers()) {
            user.removeCategory(categoryToRemove);
        }
    }
}
