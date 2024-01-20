package tests.restAPI;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetToken {

    public static String getToken() throws Exception {

        String clientId = "83454c332c424556a1d34ad4521b48e4";
        String clientSecret = "9abb5173dee947918b652ae2ccac11f0";

        String authString = clientId + ":" + clientSecret;
        String authBase64 = Base64.getEncoder().encodeToString(authString.getBytes(StandardCharsets.UTF_8));

        String tokenEndpoint = "https://accounts.spotify.com/api/token";

        HttpPost httpPost = new HttpPost(tokenEndpoint);
        httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + authBase64);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");

        StringEntity requestBody = new StringEntity("grant_type=client_credentials");
        httpPost.setEntity(requestBody);

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String response = EntityUtils.toString(httpClient.execute(httpPost).getEntity());
            return response.split("\"access_token\":\"")[1].split("\"")[0];
        }
    }

}