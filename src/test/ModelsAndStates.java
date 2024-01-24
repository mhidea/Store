package test;

import models.User;

public class ModelsAndStates {
    public static void main(String[] args) {

        User me = null;
        try {
            me = new User("1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (me == null) {
            me = new User();
            me.setName("name");
            me.save();
        }
        me.setName("newName");
        me.save();
        me.save();
        me.setName("WrongName");
        me.rollback();

    }
}
