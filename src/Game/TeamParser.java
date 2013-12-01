/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Артем
 */
public class TeamParser {
    public static List<String> listTeams(String text){       
        String regex = "\\[(\\D+)\\((\\d+)\\)";
        return getRegex(regex, text, 1);
    }
    
    public static List<String> listTeamsId(String text){       
        String regex = "\\[(\\D+)\\((\\d+)\\)";
        return getRegex(regex, text, 2);
    }
    
    public static List<String> listLastName(String team,String id,String text){
        String regex = "\\["+team+"\\("+id+"\\):(((\\D+)\\|(\\D+)\\|(\\d+)\\|(\\d+))+;)]";
        String players = getRegex(regex, text, 1).get(0);
        return getRegex("(\\D+)\\|(\\D+)\\|(\\d+)\\|(\\d+);",players,1);
    }
    
    public static List<String> listFirstName(String team,String id,String text){
         String regex = "\\["+team+"\\("+id+"\\):(((\\D+)\\|(\\D+)\\|(\\d+)\\|(\\d+))+;)]";
        String players = getRegex(regex, text, 1).get(0);
        return getRegex("(\\D+)\\|(\\D+)\\|(\\d+)\\|(\\d+);",players,2);
    }
    
    public static List<String> listNumber(String team,String id,String text){
         String regex = "\\["+team+"\\("+id+"\\):(((\\D+)\\|(\\D+)\\|(\\d+)\\|(\\d+))+;)]";
        String players = getRegex(regex, text, 1).get(0);
        return getRegex("(\\D+)\\|(\\D+)\\|(\\d+)\\|(\\d+);",players,3);
    }
    
    public static List<String> listId(String team,String id,String text){
         String regex = "\\["+team+"\\("+id+"\\):(((\\D+)\\|(\\D+)\\|(\\d+)\\|(\\d+))+;)]";
        String players = getRegex(regex, text, 1).get(0);
        return getRegex("(\\D+)\\|(\\D+)\\|(\\d+)\\|(\\d+);",players,4);
    }
    
    public static List<String> getRegex(String regex, String text, int groupCount) {
        List<String> retText = new ArrayList<String>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            retText.add(matcher.group(groupCount));            
        }
        return retText;
    }
}
