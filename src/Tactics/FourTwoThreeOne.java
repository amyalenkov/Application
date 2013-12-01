/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tactics;

/**
 *
 * @author Артем
 */
public class FourTwoThreeOne extends Tactics{
    public FourTwoThreeOne(){
        setTactic(POSITION.D, LINE.L);
        setTactic(POSITION.D, LINE.CL);
        setTactic(POSITION.D, LINE.CR);
        setTactic(POSITION.D, LINE.R);
        
        setTactic(POSITION.DM, LINE.CL);
        setTactic(POSITION.DM, LINE.CR);
        
        setTactic(POSITION.AM, LINE.L);
        setTactic(POSITION.AM, LINE.R);        
        setTactic(POSITION.AM, LINE.C);
        
        setTactic(POSITION.F, LINE.C);
    }
    
}
