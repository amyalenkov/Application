/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tactics;

/**
 *
 * @author Артем
 */
public class FourFourTwoDiamond extends Tactics{
    public FourFourTwoDiamond(){
        setTactic(POSITION.D, LINE.L);
        setTactic(POSITION.D, LINE.CL);
        setTactic(POSITION.D, LINE.CR);
        setTactic(POSITION.D, LINE.R);
        
        setTactic(POSITION.DM, LINE.C);
        setTactic(POSITION.AM, LINE.C);
        setTactic(POSITION.CM, LINE.L);
        setTactic(POSITION.CM, LINE.R);
        
        setTactic(POSITION.F, LINE.CL);
        setTactic(POSITION.F, LINE.CR);
    }
    
}
