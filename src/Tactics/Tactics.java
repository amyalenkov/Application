/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tactics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Артем
 */
public class Tactics {
        
    private List<Disposition> tactic; 
    
    public Tactics(){        
        tactic = new ArrayList<Disposition>();        
        tactic.add(new Disposition(POSITION.G, LINE.C));
    }
    
    public void setTactic(POSITION position, LINE line){        
        tactic.add(new Disposition(position,line));
    }
    
    public List<Disposition> getTactic(){
        return tactic;
    }
}
