package com.company.birthdayCelebrations;

public abstract class Societies {

    private String id;
    private String birthday;

    public Societies(String id, String birthday) {
        this.setId(id);
        this.setBirthday(birthday);
    }

    public String getBirthday() {
        return birthday;
    }

    private void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
