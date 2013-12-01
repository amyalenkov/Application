/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Артем
 */
public class Team {
    private String name;
    private String id;
    static final int[] serialNumbers = new int[]{1,2,3,4,5,6,7,8,9,10,11};

    private List<Player> players = new ArrayList<Player>();
    //serialNumber - Player
    Map<Integer,Player> teamPlayer = new HashMap<Integer,Player>();
    //Player - Disposition
    
    
    public Team() {
        
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    
    
}
