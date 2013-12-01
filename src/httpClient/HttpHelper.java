/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpClient;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Артем
 */
public class HttpHelper {
    HttpClient httpClient = new HttpClient();
    private  String getAllToutnamentsMatchesByHttp() throws IOException{
        return URLDecoder.decode(httpClient.getResponse(HttpClientParams.URL, 
                HttpClientParams.SERVLET_TOURMAMENTS),"UTF-8");
    }
    
    public String getMatchTitlesById(String matchId) throws IOException{
        Map<String,String> paramIdMatch = new HashMap<String, String>();
        paramIdMatch.put("idMatch", matchId);
        return URLDecoder.decode(httpClient.getResponse(HttpClientParams.URL, 
                HttpClientParams.SERVLET_MATCH_TITLES_BY_ID,paramIdMatch),"UTF-8");
    }
    
    public String getMatchById(String matchId) throws IOException{
        Map<String,String> paramIdMatch = new HashMap<String, String>();
        paramIdMatch.put("idMatch", matchId);
        return URLDecoder.decode(httpClient.getResponse(HttpClientParams.URL, 
                HttpClientParams.SERVLET_MATCH_BY_ID,paramIdMatch),"UTF-8");
    }
    
    public List<String> getToutnaments() throws IOException{
        String regexTours = "\\?(\\D+):";
        return getRegex(regexTours, getAllToutnamentsMatchesByHttp());        
    }
    
    public  List<String> getMatches(String tournament) throws IOException{
        String regexMatches = ":(((\\d{2}\\.\\d{2}\\.\\d{4};\\D+;\\D+;\\d{6}):)+)";
        List<String> matches =  getRegex("\\?" + tournament + regexMatches, 
                getAllToutnamentsMatchesByHttp());        
        String regexMatch = "(\\d{2}\\.\\d{2}\\.\\d{4};\\D+;\\D+;\\d{6})";
        return getRegex(regexMatch, matches.get(0));
    }
    
   
    
    public static List<String> getRegex(String regex, String text) {
        List<String> retText = new ArrayList<String>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            retText.add(matcher.group(1));
        }
        return retText;
    }
}
