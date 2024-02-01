package org.example;

import com.thed.zephyr.cloud.rest.ZFJCloudRestClient;
import com.thed.zephyr.cloud.rest.client.JwtGenerator;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Demo {
//    public static String generateJwtToken(String apiKey, String apiSecret, String baseUrl) throws JOSEException {
//        JWSSigner signer=new MACSigner(apiSecret);
//        JWTClaimsSet claimSet= new JWTClaimsSet.Builder()
//                .issuer(apiKey)
//                .expirationTime(new Date(new Date().getTime()+60 *1000))
//                .jwtID(UUID.randomUUID().toString())
//                .build();
//
//        SignedJWT signedJWT =new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimSet);
//        signedJWT.sign(signer);
//        return signedJWT.serialize();
//    }


    public static void main(String[] args) throws ParseException, URISyntaxException, JOSEException {
//        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
//        Date date = new Date();
//        strCurrentdate = format.format(date);
//        System.out.println(strCurrentdate);
        String ZephyURL="https://prod-play.zephyr4jiracloud.com/connect/";
        String accessKey="OTkxYTc3MTYtNmUzYS0zNzY4LTg3YjEtMTFmYWFjMTJkN2NkIDcxMjAyMCUzQTE5Zjk0NzBjLWEwMDctNDYyYy04ZTQ3LTQ3ZGYwMDIzOWYwMiBVU0VSX0RFRkFVTFRfTkFNRQ";
        String SecretKey="daQz-Nq0Tfn8J-5mEJJ3AS0fHYV8xh38HW1yjug9_2M";
        String accountID="712020:19f9470c-a007-462c-8e47-47df00239f02";
        ZFJCloudRestClient client= ZFJCloudRestClient.restBuilder(ZephyURL, accessKey, SecretKey,accountID).build();
        JwtGenerator jwtGenerator= client.getJwtGenerator();
//
        String createCycleUri= ZephyURL +"/connect/public/rest/api/1.0/cycle";

        URI uri=new URI(createCycleUri);
        int expirationInsec=360;
        String jwt= jwtGenerator.generateJWT("GET", uri, expirationInsec);

        System.out.println("Final Api :" + uri.toString());
        System.out.println("jwt Token :" + jwt);

        Client client2 = ClientBuilder.newClient();
        Response response = client2.target("https://prod-play.zephyr4jiracloud.com/connect/public/rest/api/1.0/cycles/search?versionId=-1&projectId=10028")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("Authorization", "JWT "+jwt)
                .header("zapiAccessKey", "ATATT3xFfGF0LtGenqTnjGDYNtQlIRziPUF74ULiN64uLN7yFtRw8Bbdh5Z94Cf6X2o-hIQW-eWfxiJ3I0Ky6_zvKbqcS1EQU3ZvvJJ9tOAY02d1CxO8aKi8ymY8yRF6YKHiK9_NVezr3bAilzhT_Dx6Y6URqWPycq-aiiUCs_09DtoK5fiQr64=579B49F6")
                .get();

        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + response.readEntity(String.class));
       /* String apiKey="OTkxYTc3MTYtNmUzYS0zNzY4LTg3YjEtMTFmYWFjMTJkN2NkIDcxMjAyMCUzQTE5Zjk0NzBjLWEwMDctNDYyYy04ZTQ3LTQ3ZGYwMDIzOWYwMiBVU0VSX0RFRkFVTFRfTkFNRQ";
        String apiSecret="daQz-Nq0Tfn8J-5mEJJ3AS0fHYV8xh38HW1yjug9_2M";
        String baseUrl="https://prod-play.zephyr4jiracloud.com/connect/";

        String jwtToken =generateJwtToken(apiKey, apiSecret, baseUrl);
        System.out.println("Generated JWT Token: "+ jwtToken);

      Client client = ClientBuilder.newClient();
        Response response = client.target("https://prod-play.zephyr4jiracloud.com/connect/public/rest/api/1.0/cycles/search?versionId=-1&projectId=10028")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("Authorization", "JWT "+jwtToken)
                .header("zapiAccessKey", "ATATT3xFfGF0UmsE_1ffmol3Tb6ENuyE9OPVVv8FdmwEe1InPFg-G_Kjy-BSuBfzTCq9dnklldhfyjC_MSN-MXFhCbA-wp6hnvUWff0dqIIEEIibrX3SlVVjri5lUzIAc17dZH_DFyL5wYC0xF1FUkgxE7jLm9rwLxL0IIQ6Gp68YYXg6XnNLuM=B9255D22")
                .get();

        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + response.readEntity(String.class));*/


    }

}
