/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.schema;

import Game.player.Disposition;
import Game.Player;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Артем
 */
public class Schema {
    String name;
    Disposition amplua;
    private Map<Integer,Disposition> disposition = new HashMap<Integer, Disposition>();
}
