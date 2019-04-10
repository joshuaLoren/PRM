/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author small
 */
public class Item {

    public String itemCode = "";
    public String itemName = "";
    public String itemCategory = "";
    public String itemDescription = "";
    public int itemRating = 0;
    public String imageUrl = "";

    /*
        No-arg constructor
     */
    public Item() {
        itemCode = "";
        itemName = "";
        itemCategory = "";
        itemDescription = "";
        itemRating = 0;
        imageUrl = "";
    }

    /*
        All-arg constructor
     */
    public Item(String itemCode, String itemName, String itemCategory, String itemDescription, int itemRating,
            String imageUrl) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemDescription = itemDescription;
        this.itemRating = itemRating;
        this.imageUrl = imageUrl;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getItemRating() {
        return itemRating;
    }

    public void setItemRating(int itemRating) {
        this.itemRating = itemRating;
    }

    public String getUrl() {
        return imageUrl;
    }

    public void setUrl(String url) {
        this.imageUrl = url;
    }



}
