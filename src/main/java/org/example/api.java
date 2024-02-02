package org.example;

import com.fasterxml.jackson.databind.JsonNode;
//import com.mashape.unirest.http.Unirest;
//import com.mashape.unirest.http.exceptions.UnirestException;
//import io.restassured.RestAssured;
//import jakarta.ws.rs.client.Client;
//import jakarta.ws.rs.client.ClientBuilder;
//import jakarta.ws.rs.core.MediaType;
//import jakarta.ws.rs.core.Response;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.text.ParseException;

//public class api {

  /*  public static void main(String[] args) throws IOException, ParseException, UnirestException {

      /*  Client client = ClientBuilder.newClient();
        Response response = client.target("https://sanpagonxt-getneteurope.atlassian.net/connect/public/rest/api/1.0/attachment/search/teststep?projectId=&issueId=&entityId=")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("Authorization", "JWT eyJhbGciOiJIUzI1NiI...")
                .header("zapiAccessKey", "amlyYTo3YjU3OTBhN...")
                .get();

        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + response.readEntity(String.class));*/

        // This code sample uses the  'Unirest' library:
        // http://unirest.io/java.html
     /*   HttpResponse response = (HttpResponse) Unirest.post("https://sanpagonxt-getneteurope.atlassian.net/rest/api/2/issue/{ISM-41}/attachments")
                .basicAuth("n330601@pagonxt.com", "Thinkpad@2024")
                .header("Accept", "application/json")
                .header("X-Atlassian-Token", "no-check")
                .field("file", new File("myfile.txt"))
                .asJson();

        System.out.println(response.body());*/

        // This code sample uses the  'Unirest' library:
// http://unirest.io/java.html
//        HttpResponse<JsonNode> response = (HttpResponse<JsonNode>) Unirest.get("https://sanpagonxt-getneteurope.atlassian.net/rest/api/2/issue/{ISM-41}/attachments")
//                .basicAuth("n330601@pagonxt.com", "Thinkpad@2024")
//                .header("Accept", "application/json")
//                .asJson();
//
//        System.out.println(response.body());

         // http://unirest.io/java.html
//          HttpResponse<JsonNode> response = Unirest.post("https://your-domain.atlassian.net/rest/api/2/issue/{issueIdOrKey}/attachments")
//         .basicAuth("email@example.com", "<api_token>")
//         .header("Accept", "application/json")
//         .asJson();
//         System.out.println(response.getBody());
//
//        RestAssured.baseURI="https://sanpagonxt-getneteurope.atlassian.net/browse/ISM-57";
//         given.header

//    }

//}
