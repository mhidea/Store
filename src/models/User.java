package models;

import abstracts.PersistanceModel;

public class User extends PersistanceModel {

    public User() {
        super();
        setValue("score", "0");
    }

    public User(String id) throws Exception {
        super(id);
    }

    public String[] getAttributes() {
        return new String[] { "id", "name", "score" };
    }

    public String getName() {
        return this.getValue("name");
    }

    public void setName(String name) {
        this.setValue("name", name);
    }

}
