/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Models.User;
import Models.UserProfile;
import java.util.ArrayList;

/**
 *
 * @author small
 */
public class UserDB {

    public static ArrayList<User> getItems() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("1", "Joshua", "Small", "jsmall17@uncc.edu"));
        users.add(new User("2", "Christina", "Small", "csmall@uncc.edu"));
        return users;
    }

    public static User getFirstItem() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("1", "Joshua", "Small", "jsmall17@uncc.edu"));
        users.add(new User("2", "Christina", "Small", "csmall@uncc.edu"));
        return users.get(0);
    }

}
