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

    String description = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n"
            + "\n"
            + "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.";

    String imageURL1 = "";
    String imageURL2 = "";
    String imageURL3 = "";
    String imageURL4 = "";
    String imageURL5 = "";
    String imageURL6 = "";
    String imageURL7 = "";
    String imageURL8 = "";
    String imageURL9 = "";

    Item narrativeEssay1 = new Item("1", "Narrative Essay 1", "narrative", description, 5, imageURL1);
    Item narrativeEssay2 = new Item("2", "Narrative Essay 2", "narrative", description, 5, imageURL2);
    Item narrativeEssay3 = new Item("3", "Narrative Essay 3", "narrative", description, 5, imageURL3);

    Item persuasiveEssay1 = new Item("4", "Persuasive Essay 1", "persuasive", description, 5, imageURL4);
    Item persuasiveEssay2 = new Item("5", "Persuasive Essay 2", "persuasive", description, 5, imageURL5);
    Item persuasiveEssay3 = new Item("6", "Persuasive Essay 3", "persuasive", description, 5, imageURL6);

    Item expositoryEssay1 = new Item("7", "Expository Essay 1", "expository", description, 5, imageURL7);
    Item expositoryEssay2 = new Item("8", "Expository Essay 2", "expository", description, 5, imageURL8);
    Item expositoryEssay3 = new Item("9", "Expository Essay 3", "expository", description, 5, imageURL9);

    ArrayList<Item> narrativeList = new ArrayList<>();
    ArrayList<Item> expositoryList = new ArrayList<>();
    ArrayList<Item> persuasiveList = new ArrayList<>();
    ArrayList<Item> allItems = new ArrayList<>();

}
