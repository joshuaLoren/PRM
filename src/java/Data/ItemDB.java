/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Models.Item;
import java.util.ArrayList;

/**
 *
 * @author small
 */
public class ItemDB {

    public String description = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n"
            + "\n"
            + "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.";
    public String imageURL1 = "";
    public String imageURL2 = "";
    public String imageURL3 = "";
    public String imageURL4 = "";
    public String imageURL5 = "";
    public String imageURL6 = "";
    public String imageURL7 = "";
    public String imageURL8 = "";
    public String imageURL9 = "";

    public static Item narrativeEssay1;
    public static Item narrativeEssay2;
    public static Item narrativeEssay3;

    public static Item persuasiveEssay1;
    public static Item persuasiveEssay2;
    public static Item persuasiveEssay3;

    public static Item expositoryEssay1;
    public static Item expositoryEssay2;
    public static Item expositoryEssay3;

    public ArrayList<Item> narrativeList = new ArrayList<>();
    public ArrayList<Item> expositoryList = new ArrayList<>();
    public ArrayList<Item> persuasiveList = new ArrayList<>();
    public ArrayList<Item> allItemsList = new ArrayList<>();

    /*
        no-arg constructor
     */
    public ItemDB() {

        this.description = description;

        imageURL1 = "image1.jpeg";
        imageURL2 = "image2.jpeg";
        imageURL3 = "image3.jpeg";
        imageURL4 = "image4.jpeg";
        imageURL5 = "image5.jpeg";
        imageURL6 = "image6.jpeg";
        imageURL7 = "image7.jpeg";
        imageURL8 = "image8.jpeg";
        imageURL9 = "image9.jpeg";

        narrativeEssay1 = new Item("1", "Narrative Essay 1", "narrative", description, 5, imageURL1);
        narrativeEssay2 = new Item("2", "Narrative Essay 2", "narrative", description, 5, imageURL2);
        narrativeEssay3 = new Item("3", "Narrative Essay 3", "narrative", description, 5, imageURL3);

        persuasiveEssay1 = new Item("4", "Persuasive Essay 1", "persuasive", description, 5, imageURL4);
        persuasiveEssay2 = new Item("5", "Persuasive Essay 2", "persuasive", description, 5, imageURL5);
        persuasiveEssay3 = new Item("6", "Persuasive Essay 3", "persuasive", description, 5, imageURL6);

        expositoryEssay1 = new Item("7", "Expository Essay 1", "expository", description, 5, imageURL7);
        expositoryEssay2 = new Item("8", "Expository Essay 2", "expository", description, 5, imageURL8);
        expositoryEssay3 = new Item("9", "Expository Essay 3", "expository", description, 5, imageURL9);

        allItemsList.add(narrativeEssay1);
        allItemsList.add(narrativeEssay2);
        allItemsList.add(narrativeEssay3);
        allItemsList.add(persuasiveEssay1);
        allItemsList.add(persuasiveEssay2);
        allItemsList.add(persuasiveEssay3);
        allItemsList.add(expositoryEssay1);
        allItemsList.add(expositoryEssay2);
        allItemsList.add(expositoryEssay3);

        narrativeList.add(narrativeEssay1);
        narrativeList.add(narrativeEssay2);
        narrativeList.add(narrativeEssay3);

        persuasiveList.add(persuasiveEssay1);
        persuasiveList.add(persuasiveEssay2);
        persuasiveList.add(persuasiveEssay3);

        expositoryList.add(expositoryEssay1);
        expositoryList.add(expositoryEssay2);
        expositoryList.add(expositoryEssay3);
    }

    public ArrayList getItems() {
        return allItemsList;
    }

    public ArrayList getNarrativeList() {
        return narrativeList;
    }

    public ArrayList getPersuasiveList() {

        return persuasiveList;
    }

    public ArrayList getExpositoryList() {

        return expositoryList;
    }

    public static Item getItem(String itemCode) {

        if (itemCode.equals("1")) {
            return narrativeEssay1;
        } else if (itemCode.equals("2")) {
            return narrativeEssay2;
        } else if (itemCode.equals("3")) {
            return narrativeEssay3;
        } else if (itemCode.equals("4")) {
            return persuasiveEssay1;
        } else if (itemCode.equals("5")) {
            return persuasiveEssay2;
        } else if (itemCode.equals("6")) {
            return persuasiveEssay3;
        } else if (itemCode.equals("7")) {
            return expositoryEssay1;
        } else if (itemCode.equals("8")) {
            return expositoryEssay2;
        } else {
            return expositoryEssay3;
        }
    }

}
