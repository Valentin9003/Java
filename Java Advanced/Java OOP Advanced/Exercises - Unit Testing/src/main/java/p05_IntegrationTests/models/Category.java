package p05_IntegrationTests.models;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Category {

    private String name;
    private Set<User> users;
    private Set<Category> childCategories;
    private Category parent;

    public Category(String name) {
        this.name = name;
        this.users = new HashSet<>();
        this.childCategories = new HashSet<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Cannot create parent without name");
        }
        this.name = name;
    }

    public Set<User> getUsers() {
        return Collections.unmodifiableSet(this.users);
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Category> getChildCategories() {
        return Collections.unmodifiableSet(this.childCategories);
    }

    public void setChildCategories(Set<Category> childCategories) {
        this.childCategories = childCategories;
    }

    public Category getParent() {
        return this.parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public void moveUsersToParent() {
        if (this.parent == null) {
            return;
        }

        for (User user : this.users) {
            this.parent.addUser(user);
        }
    }

    public void addChild(Category child) {
        this.childCategories.add(child);
        child.setParent(this);
    }

    public void addUser(User user) {
        this.users.add(user);
        user.addCategory(this);
    }

    public void removeChild(String name) {
        Category categoryToRemove =
                this.childCategories.stream()
                        .filter(c -> c.getName().equals(name))
                        .findFirst()
                        .get();

        this.childCategories.remove(categoryToRemove);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(getName(), category.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName());
    }
}
