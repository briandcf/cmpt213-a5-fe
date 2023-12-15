package com.example.JsonInteraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import com.example.superHumanLogic.SuperhumanList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Used to get the SuperhumanList from the server
 */

public class FromServer {
    @JsonProperty("superhumanList")
    private static SuperhumanList superhumanList;

    public static SuperhumanList getSuperHumanList() {
        String json = "";
        try {
            URI uri = new URI("http://localhost:8080/list");
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));   
            json = reader.readLine();
            System.out.println("Response code from server: " + connection.getResponseCode());
            connection.disconnect();
            
        }catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (ProtocolException e) {
         System.out.println("Protocol Exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        } catch (URISyntaxException e) {
            System.out.println("Error creating URI: " + e.getMessage());
        } catch (SecurityException e) {
            System.out.println("Security Exception: " + e.getMessage());
        } catch (Exception e) {
         // Catch any other generic exceptions
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
        return getListFromJson(json);
    }



    public static SuperhumanList getListFromJson(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            superhumanList = (SuperhumanList) mapper.readValue(jsonString, SuperhumanList.class);
        } catch (JsonProcessingException e) {
            System.out.println("Error processing JSON: " + e.getMessage());
        }
        return superhumanList;
    }
    

}
