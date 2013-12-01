/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tactics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Test;

/**
 *
 * @author Артем
 */
public class Disposition {
    private POSITION position;
    private LINE line;
    
    public Disposition(POSITION position,LINE line){
        this.position = position;
        this.line = line;
    }
    
    /**
     * @return the position
     */
    public POSITION getPosition() {
        return position;
    }
    
    public LINE getLine() {
        return line;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(POSITION position) {
        this.position = position;
    }

    /**
     * @param line the line to set
     */
    public void setLine(LINE line) {
        this.line = line;
    }
    
    public static int getPositionX(POSITION position){
        if(position.equals(POSITION.G)){
            return 30;
        }else if(position.equals(POSITION.D)){
            return 100;
        }else if(position.equals(POSITION.DM)){
            return 170;
        }else if(position.equals(POSITION.CM)){
            return 240;
        }else if(position.equals(POSITION.AM)){
            return 310;
        }else if(position.equals(POSITION.F)){
            return 380;
        }
        else{
            return 0;
        }
    }
    
    public static int getPositionXupend(POSITION position){
        if(position.equals(POSITION.G)){
            return 450;
        }else if(position.equals(POSITION.D)){
            return 415;
        }else if(position.equals(POSITION.DM)){
            return 380;
        }else if(position.equals(POSITION.CM)){
            return 345;
        }else if(position.equals(POSITION.AM)){
            return 310;
        }else if(position.equals(POSITION.F)){
            return 275;
        }
        else{
            return 0;
        }
        
    }
    
    public static int getLineY(LINE line){
        if(line.equals(LINE.C)){
            return 130;            
        }else if(line.equals(LINE.L)){
            return 20;
        }else if(line.equals(LINE.CL)){
            return 75;
        }else if(line.equals(LINE.CR)){
            return 185;
        }else if(line.equals(LINE.R)){
            return 240;
        }    
        else{
            return 0;
        }
    }
    
     public static int getLineYupend(LINE line){
        if(line.equals(LINE.C)){
            return 130;
        }else if(line.equals(LINE.CL)){
            return 185;
        }else if(line.equals(LINE.CR)){
            return 75;
        }else if(line.equals(LINE.R)){
            return 20;
        }else if(line.equals(LINE.L)){
            return 240;
        }    
        else{
            return 0;
        }
    }
    
    
    
    public int getPositionX(){
        if(position.equals(POSITION.G)){
            return 30;
        }else if(position.equals(POSITION.D)){
            return 100;
        }else if(position.equals(POSITION.DM)){
            return 170;
        }else if(position.equals(POSITION.CM)){
            return 240;
        }else if(position.equals(POSITION.AM)){
            return 310;
        }else if(position.equals(POSITION.F)){
            return 380;
        }
        else{
            return 0;
        }
    }
    
    public int getLineY(){
        if(line.equals(LINE.C)){
            return 130;
        }else if(line.equals(LINE.CL)){
            return 75;
        }else if(line.equals(LINE.CR)){
            return 185;
        }else if(line.equals(LINE.R)){
            return 240;
        }else if(line.equals(LINE.L)){
            return 20;
        }    
        else{
            return 0;
        }
    }
    
    public int getPositionXupend(){
        if(position.equals(POSITION.G)){
            return 450;
        }else if(position.equals(POSITION.D)){
            return 380;
        }else if(position.equals(POSITION.DM)){
            return 310;
        }else if(position.equals(POSITION.CM)){
            return 240;
        }else if(position.equals(POSITION.AM)){
            return 170;
        }else if(position.equals(POSITION.F)){
            return 100;
        }
        else{
            return 0;
        }
    }
    
    public int getLineYupend(){
        if(line.equals(LINE.C)){
            return 130;
        }else if(line.equals(LINE.CL)){
            return 185;
        }else if(line.equals(LINE.CR)){
            return 75;
        }else if(line.equals(LINE.R)){
            return 20;
        }else if(line.equals(LINE.L)){
            return 240;
        }    
        else{
            return 0;
        }
    }
    
    public static Disposition getDisp(int x, int y){
        HashMap<Integer, POSITION> xPos = new HashMap<Integer, POSITION>();
        List<Integer> valX = new ArrayList<Integer>();
        HashMap<Integer, LINE> yPos = new HashMap<Integer, LINE>();
        List<Integer> valY = new ArrayList<Integer>();        
        
        for(POSITION position : POSITION.values()){
            xPos.put(Math.abs(x - getPositionX(position)),position);
            valX.add(Math.abs(x - getPositionX(position)));
        }        
        Collections.sort(valX);       
        
        for(LINE line : LINE.values()){
            yPos.put(Math.abs(y - getLineY(line)),line);
            valY.add(Math.abs(y - getLineY(line)));
        }
        
        Collections.sort(valY);        
        return new Disposition(xPos.get(valX.get(0)),yPos.get(valY.get(0)));
    }
    
    public static Disposition getDispUpend(int x, int y){
        HashMap<Integer, POSITION> xPos = new HashMap<Integer, POSITION>();
        List<Integer> valX = new ArrayList<Integer>();
        HashMap<Integer, LINE> yPos = new HashMap<Integer, LINE>();
        List<Integer> valY = new ArrayList<Integer>();        
        
        for(POSITION position : POSITION.values()){
            xPos.put(Math.abs(x - getPositionXupend(position)),position);
            valX.add(Math.abs(x - getPositionXupend(position)));
        }        
        Collections.sort(valX);       
        
        for(LINE line : LINE.values()){
            yPos.put(Math.abs(y - getLineYupend(line)),line);
            valY.add(Math.abs(y - getLineYupend(line)));
        }
        
        Collections.sort(valY);        
        return new Disposition(xPos.get(valX.get(0)),yPos.get(valY.get(0)));
    }
    
    
    public static void main(String[] art){
        getDisp(64, 330);
    }
    
    
    
}
