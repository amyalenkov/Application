/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Marker;

import Marker.Content.AdditionalAction;
import Marker.Content.BasicAction;
import Marker.Content.PartBody;

/**
 *
 * @author Артем
 */
public class BasicMarker extends Marker{
    private BasicAction basicAction;
    private AdditionalAction additionalAction;

    public BasicAction getBasicAction() {
        return basicAction;
    }

    public void setBasicAction(BasicAction basicAction) {
        this.basicAction = basicAction;
    }

    public PartBody getPartBody() {
        return partBody;
    }

    public void setPartBody(PartBody partBody) {
        this.partBody = partBody;
    }

    public String getPlayerNumber1() {
        return playerNumber1;
    }

    public void setPlayerNumber1(String playerNumber1) {
        this.playerNumber1 = playerNumber1;
    }

    public String getPlayerNumber2() {
        return playerNumber2;
    }

    public void setPlayerNumber2(String playerNumber2) {
        this.playerNumber2 = playerNumber2;
    }

    public String getTeamId1() {
        return teamId1;
    }

    public void setTeamId1(String teamId1) {
        this.teamId1 = teamId1;
    }

    public String getTeamId2() {
        return teamId2;
    }

    public void setTeamId2(String teamId2) {
        this.teamId2 = teamId2;
    }

    public int getxPoint() {
        return xPoint;
    }

    public void setxPoint(int xPoint) {
        this.xPoint = xPoint;
    }

    public int getyPoint() {
        return yPoint;
    }

    public void setyPoint(int yPoint) {
        this.yPoint = yPoint;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    private PartBody partBody;
    
    private String playerNumber1;
    private String playerNumber2;
    
    private String teamId1;
    private String teamId2;
    
    private int xPoint;
    private int yPoint;
    
    //???
    private int time;
    
    public BasicMarker(int id, BasicAction basicAction){
        super(id, false);
        this.basicAction = basicAction;
    }
    
    public AdditionalAction getAdditionalAction() {
        return additionalAction;
    }

    public void setAdditionalAction(AdditionalAction additionalAction) {
        this.additionalAction = additionalAction;
    }
}
