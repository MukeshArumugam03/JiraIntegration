package org.example;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public class integration {
//    private static void sendHttpRequest(String url,String method,String data,String authHeader) throws IOException, InterruptedException {
//
//        HttpClient httpClient=HttpClient.newHttpClient();
//        HttpRequest request=HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .header("Content-Type","application/json")
//                .header("Authorization",authHeader)
//                .method(method, HttpRequest.BodyPublishers.ofString(data))
//                .build();
//
//        HttpResponse<String> response= httpClient.send(request,HttpResponse.BodyHandlers.ofString());
//        System.out.println("Http Status Code: "+ response.statusCode());
//        System.out.println("Response Body: "+ response.body());
//    }

    private static String sendHttpRequest(String url,String method,String authHeader) throws IOException, InterruptedException {

        HttpClient httpClient=HttpClient.newHttpClient();
        HttpRequest request=HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type","application/json")
                .header("Authorization",authHeader)
                .method(method, HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response= httpClient.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println("Http Status Code: "+ response.statusCode());
        System.out.println("Response Body: "+ response.body());
        return response.body();
    }


    public static void main(String[] args) throws IOException, InterruptedException {

        String username="n330601@pagonxt.com";
        String password="Thinkpad@2024";
        String ZephyrUrl ="https://sanpagonxt-getneteurope.atlassian.net/rest/api/2/";
        String projectId="10028";

        //Authentication
        String auth=username+":"+ password;
        String authHeader="Basic "+ Base64.getEncoder().encodeToString(auth.getBytes());
        System.out.println(authHeader);

        String getCyclesUrl=ZephyrUrl+"cycle?projectId=" + projectId;
        String cyclesResponse=sendHttpRequest(getCyclesUrl,"GET", authHeader);

        JSONArray cyclesArray= new JSONArray(cyclesResponse);
        for(int i=0;i< cyclesArray.length();i++){
            JSONObject cycleObject=cyclesArray.getJSONObject(i);
            String cycleId=cycleObject.getString("id");
            String cycleName=cycleObject.getString("name");

            System.out.println("Cycle Id: "+ cycleId);
            System.out.println("Cycle Name: "+ cycleName);
        }



        //Update test cycle status
     /*   String cycleId="006741bb-cd18-4f6a-bc32-31dd0f25c620";
        String statusUpdate=ZephyrUrl+"execution/"+cycleId+"/status";
        String statusData="{\"status\": \"1\"}";
        sendHttpRequest(statusUpdate, "PUT",statusData,authHeader);*/



    }
}
