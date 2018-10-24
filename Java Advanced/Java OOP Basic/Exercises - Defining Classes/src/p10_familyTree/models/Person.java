package p10_familyTree.models;

import java.util.LinkedList;
import java.util.List;

public class Person {

    private String name;
    private String birthday;
    private List<Parent> parents;
    private List<Children> childrens;

    public Person() {
        this.parents = new LinkedList<>();
        this.childrens = new LinkedList<>();
    }

    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
        this.parents = new LinkedList<>();
        this.childrens = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void addParent(Parent parent) {
        this.parents.add(parent);
    }

    public List<Children> getChildrens() {
        return childrens;
    }

    public void addChildren(Children children) {
        this.childrens.add(children);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s", this.getName(), this.getBirthday()))
                .append(System.lineSeparator())
                .append("Parents:").append(System.lineSeparator());
        if (this.getParents().size() > 0) {
            for (Parent parent : this.getParents()) {
                sb.append(parent).append(System.lineSeparator());
            }
        }
        sb.append("Children:").append(System.lineSeparator());
        if (this.getChildrens().size() > 0) {
            for (Children children : this.getChildrens()) {
                sb.append(children).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
