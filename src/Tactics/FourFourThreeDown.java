/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tactics;

/**
 *
 * @author Артем
 */
public class FourFourThreeDown extends Tactics{
    public FourFourThreeDown(){
        setTactic(POSITION.D, LINE.L);
        setTactic(POSITION.D, LINE.CL);
        setTactic(POSITION.D, LINE.CR);
        setTactic(POSITION.D, LINE.R);
        
        setTactic(POSITION.DM, LINE.C);
        setTactic(POSITION.CM, LINE.CR);
        setTactic(POSITION.CM, LINE.CL);
        
        setTactic(POSITION.AM, LINE.R);        
        setTactic(POSITION.AM, LINE.L);
        setTactic(POSITION.F, LINE.C);
    }
    
}
