/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Marker;

/**
 *
 * @author Артем
 */
public abstract class Marker {
    protected int id;
    protected boolean complete;

    public Marker(int id, boolean complete) {
        this.id = id;
        this.complete = complete;
    }
    
    public int getId(){
        return id;
    }
        
}
