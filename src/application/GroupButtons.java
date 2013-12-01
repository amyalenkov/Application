/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author Артем
 */
public class GroupButtons {
    private List<JButton> basicButtons = new ArrayList<JButton>();
    private List<JButton> additionalButtons = new ArrayList<JButton>();
    private List<JButton> partBodyButtons = new ArrayList<JButton>();
    private List<JButton> onePlayerButtons = new ArrayList<JButton>();
    private List<JButton> twoPlayerButtons = new ArrayList<JButton>();
    private List<JButton> jButtonsTactic1 = new ArrayList<JButton>();
    private List<JButton> jButtonsTactic2 = new ArrayList<JButton>();

    public List<JButton> getjButtonsTactic1() {
        return jButtonsTactic1;
    }

    public void setjButtonsTactic1(JButton... jButtonsTactic1) {
        for(JButton button : jButtonsTactic1){
            this.jButtonsTactic1.add(button);
        }
    }

    public List<JButton> getjButtonsTactic2() {
        return jButtonsTactic2;
    }

    public void setjButtonsTactic2(JButton... jButtonsTactic2) {
        for(JButton button : jButtonsTactic2){
            this.jButtonsTactic2.add(button);
        }
    }
    public List<JButton> getBasicButtons() {
        return basicButtons;
    }

    public List<JButton> getOnePlayerButtons() {
        return onePlayerButtons;
    }

    public void setOnePlayerButtons(JButton... onePlayerButtons) {        
        for(JButton button : onePlayerButtons){
            this.onePlayerButtons.add(button);
        }
    }

    public List<JButton> getTwoPlayerButtons() {
        return twoPlayerButtons;
    }

    public void setTwoPlayerButtons(JButton... twoPlayerButtons) {
        for(JButton button : twoPlayerButtons){
            this.twoPlayerButtons.add(button);
        }
    }

    public List<JButton> getAdditionalButtons() {
        return additionalButtons;
    }

    public void setAdditionalButtons(JButton... additionalButtons) {        
        for(JButton button : additionalButtons){
            this.additionalButtons.add(button);
        }
    }

    public List<JButton> getPartBodyButtons() {
        return partBodyButtons;
    }

    public void setPartBodyButtons(JButton... partBodyButtons) {        
        for(JButton button : partBodyButtons){
            this.partBodyButtons.add(button);
        }
    }

    public void setBasicButtons(JButton... basicButtons) {
        for(JButton button : basicButtons){
            this.basicButtons.add(button);
        }        
    }
    
    
    
    
}
