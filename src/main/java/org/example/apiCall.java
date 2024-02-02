package org.example;

import com.fasterxml.jackson.databind.JsonNode;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.restassured.RestAssured;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.HttpClients;


import java.io.*;
import java.net.http.HttpRequest;
import java.util.Base64;
import java.util.HashMap;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

public class apiCall {

    static String url="https://sanpagonxt-getneteurope.atlassian.net/";
    static String projectId="10028";
    static String VersionID="-1";
    static String issueKey="ISM-41";
    static String  cycleid="006741bb-cd18-4f6a-bc32-31dd0f25c620";

    static String ExecutionId="4089f4c7-1d5b-4355-b8be-a8f96d880c26";

//    private static HttpRequest.BodyPublisher buildMultipartBody(String filePath){
//        File file=new File(filePath);
//        String boundary="Boundary-" + System.currentTimeMillis();
//        return HttpRequest.BodyPublishers.ofByteArrays(
//                MultipartEntityBuilder.create()
//                        .with
//        )
//
//
//    }


    public static void main(String[] args) throws UnirestException {

        try {
            String jiraBaseUrl = "https://sanpagonxt-getneteurope.atlassian.net";

            String issueKey = "ISM-563";
            String jiraUsername = "n330601@pagonxt.com";
            String jiraPassword = "ATATT3xFfGF0UmsE_1ffmol3Tb6ENuyE9OPVVv8FdmwEe1InPFg-G_Kjy-BSuBfzTCq9dnklldhfyjC_MSN-MXFhCbA-wp6hnvUWff0dqIIEEIibrX3SlVVjri5lUzIAc17dZH_DFyL5wYC0xF1FUkgxE7jLm9rwLxL0IIQ6Gp68YYXg6XnNLuM=B9255D22";

            HttpClient httpClient = HttpClients.createDefault();
            String apiUrl = jiraBaseUrl + "/rest/api/2/issue/" + issueKey;
            System.out.println(apiUrl);

            HttpPut httpPut = new HttpPut(apiUrl);
            httpPut.setHeader("Content-Type", "application/json");
            httpPut.setHeader("Authorization", "Basic " + Base64.getEncoder().encodeToString((jiraUsername + ":" + jiraPassword).getBytes()));

            String updateData = "{\"fields\"" +
                                ":{\"description\":\"ISM-Regression  \"}}";

            StringEntity entity = new StringEntity(updateData);
            httpPut.setEntity(entity);
//          HttpResponse response =httpClient.execute(httpPut);
            HttpResponse response=httpClient.execute(httpPut);
            if(response.getStatusLine().getStatusCode()==204){
                System.out.println("Issue updated successfully!");
            }else{
                System.out.println("Failed to update issue. Status code: "+ response.getStatusLine().getStatusCode());
                BufferedReader reader =new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String line;
                while((line = reader.readLine())!=null){
                    System.out.println(line);
                }
            }

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }





     /*   String jiraBaseUrl = "https://sanpagonxt-getneteurope.atlassian.net";

        String issueKey = "ISM-563";
        String jiraUsername = "n330601@pagonxt.com";
        String jiraPassword = "ATATT3xFfGF0UmsE_1ffmol3Tb6ENuyE9OPVVv8FdmwEe1InPFg-G_Kjy-BSuBfzTCq9dnklldhfyjC_MSN-MXFhCbA-wp6hnvUWff0dqIIEEIibrX3SlVVjri5lUzIAc17dZH_DFyL5wYC0xF1FUkgxE7jLm9rwLxL0IIQ6Gp68YYXg6XnNLuM=B9255D22";


        String filePath ="C:\\Users\\mukesh.a\\IdeaProjects\\Totalization_Auto\\src\\main\\resources\\Report.png";
        try{
            HttpPost request= new HttpPost(jiraBaseUrl + "/rest/api/2/issue/" + issueKey +"/attachments");
           System.out.println(request);
            UsernamePasswordCredentials credentials=new UsernamePasswordCredentials(jiraUsername,jiraPassword);
            request.addHeader(new BasicScheme().authenticate(credentials,request,null));

            MultipartEntityBuilder multipartEntityBuilder= MultipartEntityBuilder.create();
            multipartEntityBuilder.addBinaryBody("file", new File(filePath), ContentType.DEFAULT_BINARY,"Report.png");
            request.setEntity(multipartEntityBuilder.build());

            HttpClient client = HttpClients.createDefault();
            HttpResponse response=client.execute(request);

            System.out.println("HTTP Status Code: "+ response.getStatusLine().getStatusCode());
        } catch (AuthenticationException | IOException e) {
            throw new RuntimeException(e);
        }*/


        //Sucess





  /*      RequestSpecification issueIdReq= RestAssured.given();
        issueIdReq.header("Content-Type", "application/json");
        issueIdReq.header("Authorization","Basic bjMzMDYwMUBwYWdvbnh0LmNvbTpBVEFUVDN4RmZHRjA4SG9TZkp0b1pMRXJnTFp6QVRBWUZCenZsV1VmVTBHcVc3Z3JSSmdBR3hWRy13emJnenpOWFFYWlNSUmIxWEp5cmJocXIzWEl2SEVONEpWV0dvWmFsbGVzWlA3RUN2MFZMb2M4OGx4QUhFWGk0WmpvWTdhVlhxZktSVmhTNklmLTd3cWdMTXhUS0dSQnhMU0hSVmpmRW1fb3NqZ3BsUGZVZ1RWa01lZjBTVjg9ODZCNzU2RDM=");
        String issueEndpoint= "https://sanpagonxt-getneteurope.atlassian.net//rest/api/latest/issue/"+issueKey;
        String issueId=issueIdReq.get(issueEndpoint).getBody().jsonPath().get("id").toString();
        System.out.println(issueId);

//        https://sanpagonxt-getneteurope.atlassian.net/rest/api/2/issue/ISM-41
//Create ExecutionID
      RequestSpecification ExecutionIdReq= RestAssured.given();
        ExecutionIdReq.header("Content-Type", "application/json");
        ExecutionIdReq.header("Authorization","Basic bjMzMDYwMUBwYWdvbnh0LmNvbTpiak16TURZd01VQndZV2R2Ym5oMExtTnZiVHBCVkVGVVZETjRSbVpIUmpCVmJYTkZYekZtWm0xdmJETlVZalpGVG5WNVJUbFBVRlpXZGpoR1pHMTNSV1V4U1c1UVJtY3RSMTlMYW5rdFFsTjFRbVo2VkVOeE9XUnVhMnhzWkdobWVXcERYMDFUVGkxTldFWm9RMkpCTFhkd05taHVkbFZYWm1Zd1pIRkpTVVZGU1dsaWNsZ3pVMnhXVm1weWFUVnNWWHBKUVdNeE4yUmFTRjlFUm5sTU5YZFpRekI0UmpGR1ZXdG5lRVUzYWt4dE9YSjNUSGhNTUVsSlVUWkhjRFk0V1ZsWVp6WlliazVNZFUwOVFqa3lOVFZFTWpJPQ==");
        String ExecutionEndpoint= "https://sanpagonxt-getneteurope.atlassian.net/plugins/servlet/ac/com.thed.zephyr.je/rest/zapi/latest/execution/";
        HashMap<String,String> requestBody=new HashMap<String, String>();
        requestBody.put("issue.id", issueId);
        requestBody.put("cycle.id",cycleid);
        requestBody.put("version.id", VersionID);
        requestBody.put("project.id", projectId);
        ExecutionIdReq.body(requestBody);

        int statusCode=ExecutionIdReq.post(ExecutionEndpoint).getStatusCode();
        System.out.println(statusCode);

        String ExecutionId= ExecutionIdReq.post(ExecutionEndpoint).getBody().asString().split(":")[0].replace("\"","").replace("{","");
        System.out.println(ExecutionId);*/

//        RequestSpecification updateReq= RestAssured.given();
//        updateReq.header("Content-Type", "application/json");
//        updateReq.header("Authorization","Basic bjMzMDYwMUBwYWdvbnh0LmNvbTpBVEFUVDN4RmZHRjA4SG9TZkp0b1pMRXJnTFp6QVRBWUZCenZsV1VmVTBHcVc3Z3JSSmdBR3hWRy13emJnenpOWFFYWlNSUmIxWEp5cmJocXIzWEl2SEVONEpWV0dvWmFsbGVzWlA3RUN2MFZMb2M4OGx4QUhFWGk0WmpvWTdhVlhxZktSVmhTNklmLTd3cWdMTXhUS0dSQnhMU0hSVmpmRW1fb3NqZ3BsUGZVZ1RWa01lZjBTVjg9ODZCNzU2RDM=");
//        String updateEndpoint= "https://sanpagonxt-getneteurope.atlassian.net//rest/api/latest/execution/"+ExecutionId+"/execute";
//        HashMap<String,String> updateReqBody=new HashMap<String, String>();
//        updateReqBody.put("status","1");
//        updateReq.body(updateReqBody);
//        int status=updateReq.put(updateEndpoint).getStatusCode();
//        System.out.println(status);





//
//        HttpResponse<JsonNode> response = (HttpResponse<JsonNode>) Unirest.get("https://sanpagonxt-getneteurope.atlassian.net/rest/api/2/issue/{ISM-41}/attachments")
//                .basicAuth("n330601@pagonxt.com", "bjMzMDYwMUBwYWdvbnh0LmNvbTpBVEFUVDN4RmZHRjBVbXNFXzFmZm1vbDNUYjZFTnV5RTlPUFZWdjhGZG13RWUxSW5QRmctR19LanktQlN1QmZ6VENxOWRua2xsZGhmeWpDX01TTi1NWEZoQ2JBLXdwNmhudlVXZmYwZHFJSUVFSWliclgzU2xWVmpyaTVsVXpJQWMxN2RaSF9ERnlMNXdZQzB4RjFGVWtneEU3akxtOXJ3THhMMElJUTZHcDY4WVlYZzZYbk5MdU09QjkyNTVEMjI=")
//                .header("Accept", "application/json")
//                .asJson();
//
//        System.out.println(response.body());















//        HttpResponse<JsonNode> response2 = (HttpResponse<JsonNode>) Unirest.get("https://sanpagonxt-getneteurope.atlassian.net/rest/api/2/issue/ISM-41")
//                .basicAuth("n330601@pagonxt.com", "ATATT3xFfGF08HoSfJtoZLErgLZzATAYFBzvlWUfU0GqW7grRJgAGxVG-wzbgzzNXQXZSRRb1XJyrbhqr3XIvHEN4JVWGoZallesZP7ECv0VLoc88lxAHEXi4ZjoY7aVXqfKRVhS6If-7wqgLMxTKGRBxLSHRVjfEm_osjgplPfUgTVkMef0SV8=86B756D3")
//                .header("Accept", "application/json")
//                .asJson();
//
//        System.out.println(((com.mashape.unirest.http.HttpResponse<?>) response2).getBody());

   /*     Client client = ClientBuilder.newClient();
        Response response = client.target("https://prod-api.zephyr4jiracloud.com/connect/public/rest/api/1.0/attachment/search/execution?projectId=&issueId=&entityId=")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("Authorization", "JWT eyJhbGciOiJIUzI1NiI...")
                .header("zapiAccessKey", "daQz-Nq0Tfn8J-5mEJJ3AS0fHYV8xh38HW1yjug9_2M")
                .get();

        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + response.readEntity(String.class));*/
    }
}
