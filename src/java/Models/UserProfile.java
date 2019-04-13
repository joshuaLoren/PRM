/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Data.ConnectionPool;
import Data.ItemDB;
import Sql.Utility;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author small
 */
public class UserProfile implements Serializable {

    public String description = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n"
            + "\n"
            + "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.";
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

    public void removeItem(String itemCode) {

        int index;
        System.out.println(itemCode);
        for (int i = 0; i < userItems.size(); i++) {
            if (userItems.get(i).item.itemCode.equals(itemCode)) {
                index = i;

                System.out.println("Item to destroy Index: " + index);
                System.out.println("userItems.get(i).item.itemCode: " + userItems.get(i).item.itemCode);
                System.out.println("itemCode: " + itemCode);

                userItems.remove(index);
            }
        }
    }

    public void updateItem(UserItem userItem, int rating, String itemCode, Boolean madeItB) {

        UserItem updatedItem = new UserItem(ItemDB.getItem(itemCode), rating, madeItB);

        int index;

        for (int i = 0; i < userItems.size(); i++) {
        	
        	
        	
            if (userItems.get(i).item.itemCode.equals(itemCode)) {
                index = i;
                userItems.set(index, updatedItem);
            }
        }

    }

    public ArrayList getItems() {
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
    
    public void addInitialItems(String id) {

    	ConnectionPool pool = ConnectionPool.getInstance();
    	Connection connection = pool.getConnection();
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	
        
        String query = "SELECT * FROM UserItems where userId=?";
  
           
        try {
        	ps = connection.prepareStatement(query);
                ps.setString(1, id);
                rs = ps.executeQuery();
        	UserItem userItem = null;
        	
        	while (rs.next()) {
        	userItem = new UserItem();
        	Item item = new Item();
        		
        	userItem.setMadeIt(rs.getString("madeIt"));
        	userItem.setRating(rs.getInt("rating"));
        		
                item.setItemCode(rs.getString("itemCode"));
                item.setItemName(rs.getString("itemName"));
                item.setItemCategory(rs.getString("itemCategory"));
                item.setItemDescription(rs.getString("itemDescription"));
                item.setItemRating(rs.getInt("itemRating"));
                item.setUrl(rs.getString("imageUrl"));
            	userItem.setItem(item);
                
                userItems.add(userItem);
        		
      
        	}
    
        } catch (SQLException e) {
        	System.out.println(e);
      
        } finally {
        	Utility.closePreparedStatement(ps);
        	pool.freeConnection(connection);
        }
    
    	}

}
