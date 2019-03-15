/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Data.ItemDB;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author small
 */
public class UserProfile implements Serializable {

    User user = new User();
    public ArrayList<UserItem> userItems = new ArrayList<>();

    public void addItem(Item item, int rating, boolean madeIt) {
        UserItem userItem = new UserItem(item, rating, madeIt);
        int index;
        if (userItems.contains(userItem)) {
            index = userItems.indexOf(userItem);
            userItems.set(index, userItem);
        }
        userItems.add(userItem);

    }

    public void addItem(UserItem userItem) {
        int index;
        if (userItems.contains(userItem)) {
            index = userItems.indexOf(userItem);
            userItems.set(index, userItem);
        }
        userItems.add(userItem);
    }

    public void removeItem(UserItem userItem) {
        userItems.remove(userItem);
    }

    public void updateItem(UserItem userItem) {
        int index;
        if (userItems.contains(userItem)) {
            index = userItems.indexOf(userItem);
            userItems.set(index, userItem);
        } else {
            System.out.println("Can not update item. Item not found.");
        }
    }

    public ArrayList getItems() {
        UserItem item1 = new UserItem(ItemDB.getItem("1"), 0, true);
        UserItem item2 = new UserItem(ItemDB.getItem("2"), 0, false);
        UserItem item3 = new UserItem(ItemDB.getItem("3"), 0, false);

        userItems.add(item1);
        userItems.add(item2);
        userItems.add(item3);

        return userItems;
    }

    public void emptyProfile() {
        user = new User();
        userItems.clear();
    }

    public void setUser(String id, String fn, String ln, String email) {
        user.UserID = id;
        user.emailAddress = email;
        user.firstName = fn;
        user.lastName = ln;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
