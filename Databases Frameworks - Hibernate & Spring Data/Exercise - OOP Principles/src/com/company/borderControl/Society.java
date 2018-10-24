package com.company.borderControl;

public abstract class Society {

    private String id;

    public Society(String id) {
        this.setId(id);
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
