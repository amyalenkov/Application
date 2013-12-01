/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpClient;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Артем
 */
public class HttpClient {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpGet httpget;
    
    public String getResponse(String url, String servlet, 
            Map<String,String> paramValue) throws IOException{        
        String params = "?";
        for(String nameParam : paramValue.keySet()){
            params = params + nameParam+ "=" + paramValue.get(nameParam) + "&";
        }
        String urlToReq = url+servlet+params;
        System.out.println(urlToReq);
        httpget = new HttpGet(urlToReq);
        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
        return httpclient.execute(httpget, responseHandler);               
    } 
    public String getResponse(String url, String servlet) throws IOException{                
        String urlToReq = url+servlet;
        httpget = new HttpGet(urlToReq);
        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
        return httpclient.execute(httpget, responseHandler);               
    } 
    
}
