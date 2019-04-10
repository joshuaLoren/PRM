/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.ConnectionPool;
import Sql.Utility;

/**
 *
 * @author small
 */
public class UserItem implements Serializable {

    public Item item;
    int rating;
    boolean madeIt;
    String madeItString;

    public UserItem(Item item, int rating, boolean madeIt) {
        this.item = item;
        this.rating = rating;
        this.madeIt = madeIt;
    }

    public UserItem() {
		super();
	}

	public Item getItem() {
        return item;
    }
	
    public void setItem(Item item) {
        this.item = item;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isMadeIt() {
        return madeIt;
    }

    public void setMadeIt(String madeItString) {
    	if(madeItString.equals("1")) {
    		madeIt = true;
    	} else {
    		madeIt = false;
    	}
        
    }

    public String getItemName() {
        return item.itemName;
    }

    public String getItemCategory() {
        return item.itemCategory;
    }

}
