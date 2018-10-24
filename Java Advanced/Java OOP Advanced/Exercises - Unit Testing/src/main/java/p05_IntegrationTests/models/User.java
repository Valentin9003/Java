package p05_IntegrationTests.models;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class User {

    private String name;
    private Set<Category> categories;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Set<Category> getCategories() {
        return Collections.unmodifiableSet(this.categories);
    }

    public void addCategory(Category category) {
        if (category == null) {
            return;
        }
        this.categories.add(category);
    }

    public void removeCategory(Category category) {
        this.categories =
                this.categories.stream()
                .filter(c -> !c.getName().equals(category.getName()))
                .collect(Collectors.toSet());

        if (category.getParent() != null)
        {
            this.categories.add(category.getParent());
        }
    }
}
