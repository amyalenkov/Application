/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tactics;

/**
 * 4-4-2
 * @author Артем
 */
public class FourFourTwoClassic extends Tactics{
    public FourFourTwoClassic(){
        setTactic(POSITION.D, LINE.L);
        setTactic(POSITION.D, LINE.CL);
        setTactic(POSITION.D, LINE.CR);
        setTactic(POSITION.D, LINE.R);
        
        setTactic(POSITION.DM, LINE.CL);
        setTactic(POSITION.DM, LINE.CR);
        setTactic(POSITION.CM, LINE.L);
        setTactic(POSITION.CM, LINE.R);
        
        setTactic(POSITION.F, LINE.CL);
        setTactic(POSITION.F, LINE.CR);
    }
}
