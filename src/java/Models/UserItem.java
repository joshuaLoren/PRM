/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author small
 */
public class UserItem implements Serializable {

    public Item item;
    int rating;
    boolean madeIt;

    public UserItem(Item item, int rating, boolean madeIt) {
        this.item = item;
        this.rating = rating;
        this.madeIt = madeIt;
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

    public void setMadeIt(boolean madeIt) {
        this.madeIt = madeIt;
    }

}
