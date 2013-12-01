/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Артем
 */
public class Player {    
    private String firstName;
    private String lastName;
    private String id;
    private String number;
    
    
    public Player(String firstName,String lastName,String id,String number){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.number = number;
    }
    /**
     * @return the FirstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param FirstName the FirstName to set
     */
    public void setFirstName(String FirstName) {
        this.firstName = FirstName;
    }

    /**
     * @return the LastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param LastName the LastName to set
     */
    public void setLastName(String LastName) {
        this.lastName = LastName;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }
}
