package com.example.JsonInteraction;

import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import com.example.superHumanLogic.Superhuman;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Used to contact the server side to add, remove, or update a superhuman
 */


public class ToServer {

    public static void removeSuperhuman(String name) {
        
        try {
            URI uri = new URI("http://localhost:8080/remove/" + name);
            URL url = uri.toURL(); 
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            System.out.println("DELETE");
            
            System.out.println("Response code from server: " + connection.getResponseCode());   
            connection.disconnect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addSuperHuman(Superhuman superH){
        try{
            URI uri = new URI("http://localhost:8080/add");
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type","application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.connect();
            String json = writeJsonFromSuperhuman(superH);
            connection.getOutputStream().write(json.getBytes());
            System.out.println("Response code from server: " + connection.getResponseCode());
            connection.disconnect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String writeJsonFromSuperhuman(Superhuman superH) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            StringWriter writer = new StringWriter();
            mapper.writeValue(writer, superH);
            return writer.toString();
        } catch (JsonProcessingException e) {
            System.out.println("Error processing JSON: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error writing JSON: " + e.getMessage());
        }
        return null;
    }
    
    public static void updateSuperHuman(Superhuman superH){
        try {
            URI uri = new URI("http://localhost:8080/edit"); // Replace with your actual update endpoint
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.connect();
            String json = writeJsonFromSuperhuman(superH);
            connection.getOutputStream().write(json.getBytes());
            System.out.println("Response code from server: " + connection.getResponseCode());
            connection.disconnect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
