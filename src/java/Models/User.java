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
public class User implements Serializable {

    String UserID = "";
    String firstName = "";
    String lastName = "";
    String emailAddress = "";
    String password="";

    public User() {
        UserID = "";
        firstName = "";
        lastName = "";
        emailAddress = "";
        password="";
    }

    public User(String UserID, String password, String firstName, String lastName, String emailAddress) {
        this.UserID = UserID;
        this.firstName = firstName;
        this.password = password;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }
    
    public String getPassword() {
    	return password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmail(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
