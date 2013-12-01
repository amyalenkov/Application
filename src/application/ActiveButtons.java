/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Артем
 */
public class ActiveButtons {

//    private List<String> buttonsName = new ArrayList<String>();
//    private List<String> actionName = new ArrayList<String>();
    private Map<String,String> buttonAction = new HashMap<String, String>();
    
    public void addActionButton(String button, String action){
        buttonAction.put(button, action);
    }
    
    public Set<String> getListButtons(){
        return buttonAction.keySet();
    }

    public String getAction(String keyChar) {
        return buttonAction.get(keyChar);
    }
    
}
