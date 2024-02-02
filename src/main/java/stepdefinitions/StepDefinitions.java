package stepdefinitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jsons.PayloadStore;
import org.junit.Assert;
import utils.DBConnection;
import utils.ReportVerification;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class StepDefinitions {

    @When("I trigger domestic transaction2 for scheme \"(.*)\" amount \"(.*)\" with currency as \"(.*)\" and Merchant_ID as \"(.*)\" and TerminalID as \"(.*)\" with SessionID \"(.*)\" and Session_Date as \"(.*)\"$")
    public void i_trigger_domestic_transaction2(String scheme, String amount, String currency, String Merchant_ID, String TerminalID, String SessionID, String Session_Date) throws InterruptedException, org.json.simple.parser.ParseException, IOException, ParseException {
        // Write code here that turns the phrase above into concrete actions
        if(scheme.equalsIgnoreCase("mastercard")){

            scheme = "4";

        } else if (scheme.equalsIgnoreCase("amex")) {

            scheme = "3";

        }
        else if (scheme.equalsIgnoreCase("diners")) {

            scheme = "2";

        }
        else if (scheme.equalsIgnoreCase("visa")) {

            scheme = "1";

        }

        if(Merchant_ID.equalsIgnoreCase("Same_MerchantID")){

            Merchant_ID = "049050113";
        }
        if(Merchant_ID.equalsIgnoreCase("Different_MerchantID")){

            Merchant_ID = "105";
        }

        if(TerminalID.equalsIgnoreCase("Same_TerminalID")){

            TerminalID = "WD004365";
        }
        if(TerminalID.equalsIgnoreCase("Different_TerminalID")){

            TerminalID = "WD005222";
        }

        if(SessionID.equalsIgnoreCase("Same_SessionID")){

            SessionID = "105";
        }
        if(SessionID.equalsIgnoreCase("Different_SessionID")){

            SessionID = "110";
        }
        if(Session_Date.equalsIgnoreCase("Same_Date")){

            Session_Date = "01-01-2024 13:13:05";
        }
        if(Session_Date.equalsIgnoreCase("Different_Date")){

            Session_Date = "01-01-2024 13:30:05";
        }
//        if(instant_flag.equalsIgnoreCase("Yes")){
//
//            instant_flag = "true";
//        }
//        if(instant_flag.equalsIgnoreCase("no")){
//
//            instant_flag = "false";
//        }

        int ExpectedCode = 200;
        PayloadStore.generateGuwid();

        PayloadStore.generatedate();

        PayloadStore.domesticTransaction2(scheme,amount, currency, Merchant_ID, TerminalID, SessionID, Session_Date);

        RestAssured.baseURI = "http://q-nr-gwi-dashboard01.wirecard.diq:9000/v1/gwi-dashboard/gateway/send/pe";


        Response res = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(PayloadStore.jsonNode2)
                .post();

        int ActualCode = res.getStatusCode();
        System.out.println("Actuaaaaallll is "+ ActualCode);

        Assert.assertEquals(ExpectedCode,ActualCode);
        System.out.println("Transaction created for the amount "+amount+ " and currency as "+currency);
        Thread.sleep(4000);

    }

    @When("I trigger international transaction2 for scheme \"(.*)\" amount \"(.*)\" with currency as \"(.*)\" and Merchant_ID as \"(.*)\" and TerminalID as \"(.*)\" with SessionID \"(.*)\" and Session_Date as \"(.*)\"$")
    public void i_trigger_international_transaction2(String scheme, String amount, String currency, String Merchant_ID, String TerminalID, String SessionID, String Session_Date) throws InterruptedException, org.json.simple.parser.ParseException, IOException, ParseException {
        // Write code here that turns the phrase above into concrete actions
        if(scheme.equalsIgnoreCase("mastercard")){

            scheme = "4";

        } else if (scheme.equalsIgnoreCase("amex")) {

            scheme = "3";

        }
        else if (scheme.equalsIgnoreCase("diners")) {

            scheme = "2";

        }
        else if (scheme.equalsIgnoreCase("visa")) {

            scheme = "1";

        }
        if(Merchant_ID.equalsIgnoreCase("Same_MerchantID")){

            Merchant_ID = "104";
        }
        if(Merchant_ID.equalsIgnoreCase("Different_MerchantID")){

            Merchant_ID = "105";
        }

        if(TerminalID.equalsIgnoreCase("Same_TerminalID")){

            TerminalID = "WD004365";
        }
        if(TerminalID.equalsIgnoreCase("Different_TerminalID")){

            TerminalID = "WD005222";
        }

        if(SessionID.equalsIgnoreCase("Same_SessionID")){

            SessionID = "105";
        }
        if(SessionID.equalsIgnoreCase("Different_SessionID")){

            SessionID = "110";
        }
        if(Session_Date.equalsIgnoreCase("Same_Date")){

            Session_Date = "01-01-2024 13:13:05";
        }
        if(Session_Date.equalsIgnoreCase("Different_Date")){

            Session_Date = "01-01-2024 13:30:05";
        }

        int ExpectedCode = 200;
        PayloadStore.generateGuwid();

        PayloadStore.generatedate();

        PayloadStore.internationalTransaction2(scheme,amount, currency, Merchant_ID, TerminalID, SessionID, Session_Date);

        RestAssured.baseURI = "http://q-nr-gwi-dashboard01.wirecard.diq:9000/v1/gwi-dashboard/gateway/send/pe";

        Response res = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(PayloadStore.jsonNode2)
                .post();

        int ActualCode = res.getStatusCode();
        System.out.println("Actuaaaaallll is "+ ActualCode);

        Assert.assertEquals(ExpectedCode,ActualCode);
        System.out.println("Transaction created for the amount "+amount+ " and currency as "+currency);
        //   System.out.println(res.getBody().asString());
        Thread.sleep(4000);

    }


    @When("I trigger domestic transaction for scheme \"(.*)\" amount \"(.*)\" with currency as \"(.*)\" and Merchant_ID as \"(.*)\" and TerminalID as \"(.*)\" with SessionID \"(.*)\" and Session_Date as \"(.*)\" and Instant_flag is \"(.*)\"$")
    public void i_trigger_domestic_transaction(String scheme, String amount, String currency, String Merchant_ID, String TerminalID, String SessionID, String Session_Date, String Instant_flag) throws InterruptedException, org.json.simple.parser.ParseException, IOException, ParseException {
        // Write code here that turns the phrase above into concrete actions
        if(scheme.equalsIgnoreCase("mastercard")){

            scheme = "4";

        } else if (scheme.equalsIgnoreCase("amex")) {

            scheme = "3";

        }
        else if (scheme.equalsIgnoreCase("diners")) {

            scheme = "2";

        }
        else if (scheme.equalsIgnoreCase("visa")) {

            scheme = "1";

        }

        if(Merchant_ID.equalsIgnoreCase("Same_MerchantID")){

            Merchant_ID = "104";
        }
        if(Merchant_ID.equalsIgnoreCase("Different_MerchantID")){

            Merchant_ID = "105";
        }

        if(TerminalID.equalsIgnoreCase("Same_TerminalID")){

            TerminalID = "WD004365";
        }
        if(TerminalID.equalsIgnoreCase("Different_TerminalID")){

            TerminalID = "WD005222";
        }

        if(SessionID.equalsIgnoreCase("Same_SessionID")){

            SessionID = "105";
        }
        if(SessionID.equalsIgnoreCase("Different_SessionID")){

            SessionID = "110";
        }
        if(Session_Date.equalsIgnoreCase("Same_Date")){

            Session_Date = "01-01-2024 13:13:05";
        }
        if(Session_Date.equalsIgnoreCase("Different_Date")){

            Session_Date = "01-01-2024 13:30:05";
        }
        if(Instant_flag.equalsIgnoreCase("Yes")){

            Instant_flag = "true";
        }
        if(Instant_flag.equalsIgnoreCase("no")){

            Instant_flag = "false";
        }

        int ExpectedCode = 200;
        PayloadStore.generateGuwid();

        PayloadStore.generatedate();

        PayloadStore.domesticTransaction(scheme,amount, currency, Merchant_ID, TerminalID, SessionID, Session_Date, Instant_flag);

        RestAssured.baseURI = "http://q-nr-gwi-dashboard01.wirecard.diq:9000/v1/gwi-dashboard/gateway/send/pe";


        Response res = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(PayloadStore.jsonNode2)
                .post();

        int ActualCode = res.getStatusCode();
        System.out.println("Actuaaaaallll is "+ ActualCode);

        Assert.assertEquals(ExpectedCode,ActualCode);
        System.out.println("Transaction created for the amount "+amount+ " and currency as "+currency);
        Thread.sleep(4000);

    }

    @When("I trigger international transaction for scheme \"(.*)\" amount \"(.*)\" with currency as \"(.*)\" and Merchant_ID as \"(.*)\" and TerminalID as \"(.*)\" with SessionID \"(.*)\" and Session_Date as \"(.*)\" and Instant_flag is \"(.*)\"$")
    public void i_trigger_international_transaction(String scheme, String amount, String currency, String Merchant_ID, String TerminalID, String SessionID, String Session_Date, String Instant_flag) throws InterruptedException, org.json.simple.parser.ParseException, IOException, ParseException {
        // Write code here that turns the phrase above into concrete actions
        if(scheme.equalsIgnoreCase("mastercard")){

            scheme = "4";

        } else if (scheme.equalsIgnoreCase("amex")) {

            scheme = "3";

        }
        else if (scheme.equalsIgnoreCase("diners")) {

            scheme = "2";

        }
        else if (scheme.equalsIgnoreCase("visa")) {

            scheme = "1";

        }
        if(Merchant_ID.equalsIgnoreCase("Same_MerchantID")){

            Merchant_ID = "104";
        }
        if(Merchant_ID.equalsIgnoreCase("Different_MerchantID")){

            Merchant_ID = "105";
        }

        if(TerminalID.equalsIgnoreCase("Same_TerminalID")){

            TerminalID = "WD004365";
        }
        if(TerminalID.equalsIgnoreCase("Different_TerminalID")){

            TerminalID = "WD005222";
        }

        if(SessionID.equalsIgnoreCase("Same_SessionID")){

            SessionID = "105";
        }
        if(SessionID.equalsIgnoreCase("Different_SessionID")){

            SessionID = "110";
        }
        if(Session_Date.equalsIgnoreCase("Same_Date")){

            Session_Date = "01-01-2024 13:13:05";
        }
        if(Session_Date.equalsIgnoreCase("Different_Date")){

            Session_Date = "01-01-2024 13:30:05";
        }

        if(Instant_flag.equalsIgnoreCase("Yes")){

            Instant_flag = "true";
        }
        if(Instant_flag.equalsIgnoreCase("no")){

            Instant_flag = "false";
        }
        int ExpectedCode = 200;
        PayloadStore.generateGuwid();

        PayloadStore.generatedate();

        PayloadStore.internationalTransaction(scheme,amount, currency, Merchant_ID, TerminalID, SessionID, Session_Date, Instant_flag);

        RestAssured.baseURI = "http://q-nr-gwi-dashboard01.wirecard.diq:9000/v1/gwi-dashboard/gateway/send/pe";

        Response res = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(PayloadStore.jsonNode2)
                .post();

        int ActualCode = res.getStatusCode();
        System.out.println("Actuaaaaallll is "+ ActualCode);

        Assert.assertEquals(ExpectedCode,ActualCode);
        System.out.println("Transaction created for the amount "+amount+ " and currency as "+currency);
        //   System.out.println(res.getBody().asString());
        Thread.sleep(4000);

    }

    @Then("I  wait for payment processing")
    public void i_wait_for_payment_processing() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(180000);
    }

    @Then("I check \"(.*)\" table for STATUS as \"(.*)\"$")
    public void dbCheckForstatus(String tableName, String status) throws IOException, org.json.simple.parser.ParseException, java.text.ParseException, InterruptedException{
        DBConnection.dbCheck(tableName);
        if(status.equalsIgnoreCase("PROCESSED")){

            status = "PROCESSED";
        }else if(status.equalsIgnoreCase("PENDING")){

            status="PENDING";
        }else if(status.equalsIgnoreCase("PROCESSING")){

            status="PROCESSING";
        }

        Assert.assertEquals(status,DBConnection.status);
        System.out.println("Expected processing status is : "+status + " and Actual is : "+ DBConnection.status);

    }
    @Then("I check Totalization Transaction table for amount as \"(.*)\"$")
    public void iCheckTotalizationTransactionTableForAmountAs(int amount) throws SQLException, ClassNotFoundException, InterruptedException {
        int totalizationAmount = DBConnection.dbCheck_totalAmount();
        Assert.assertEquals(amount,totalizationAmount);
        System.out.println("Expected total amount is : "+amount + " and Actual amount is : "+ totalizationAmount);

    }
    @Then("I check TOTALIZATION_TRANSACTION table for netamount as \"(.*)\"$")
    public void dbCheckForNetamount(int amount)throws IOException, org.json.simple.parser.ParseException, java.text.ParseException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        int NetAmount = DBConnection.dbChecknetamount();

        Assert.assertEquals(amount, NetAmount);
        System.out.println("Expected total amount is : "+amount + " and Actual amount is : "+ NetAmount);
    }

    @Then("I check TOTALIZATION_TRANSACTION table for TotalPayOutAmount as \"(.*)\"$")
    public void dbCheckFordiscountamount(int amount)throws IOException, org.json.simple.parser.ParseException, java.text.ParseException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        int NetAmount = DBConnection.dbCheckdiscountamount();
        Assert.assertEquals(amount, NetAmount);
        System.out.println("Expected total amount is : "+amount + " and Actual amount is : "+ NetAmount);
    }

//    @Then("I check ISM_PAYLOAD_STORE to check CODA_OUTBOUND_PAYLOAD Blob message")
//    public void dbCheck_OutboundMessage()throws IOException, org.json.simple.parser.ParseException, java.text.ParseException, InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        int NetAmount = DBConnection.dbCheck_OutboundMessage();
////        Assert.assertEquals(amount, NetAmount);
////        System.out.println("Expected total amount is : "+amount + " and Actual amount is : "+ NetAmount);
//    }


    @Then("I check ISM_PAYLOAD_STORE to check CODA_OUTBOUND_PAYLOAD Blob message")
    public void dbCheck_OutboundMessage(String column) {
        // Write code here that turns the phrase above into concrete actions
        boolean OutboundMessage = DBConnection.dbCheck_OutboundMessage();
//        Assert.assertEquals(amount, NetAmount);
        Assert.assertEquals(true,OutboundMessage);
        System.out.println("Expected Value is : "+true+ "Actual is : "+OutboundMessage );

    }

    @Then("I check ISM_PAYLOAD_STORE to check CODA_INBOUND_PAYLOAD Blob message")
    public void dbCheck_InboundMessage() {
        // Write code here that turns the phrase above into concrete actions
        boolean INboundMessage = DBConnection.dbCheck_InboundMessage();
//        Assert.assertEquals(amount, NetAmount);
        Assert.assertEquals(true,INboundMessage);
        System.out.println("Expected Value is : "+true+ "Actual is : "+INboundMessage );

    }

    @When("I check the report is as per the requirement")
    public void i_check_the_report_is_as_per_the_requirement() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        boolean validCSV = ReportVerification.isCSVFormat();
//        Assert.assertEquals(amount, NetAmount);
        Assert.assertEquals(true,validCSV);
        System.out.println("Expected Value is : "+true+ "Actual is : "+validCSV );
        if(validCSV){
            System.out.println("The File is in CSV format and uses ';' as the delimeter");
        }
        else{
            System.out.println("The File is not in CSV format and not uses ';' as the delimeter");
        }

    }

    @When("I check the report is as per the ExtractedTime")
    public void i_check_the_report_is_as_per_the_extracted_time() {
        // Write code here that turns the phrase above into concrete actions
        boolean ExtractionTime = ReportVerification.ExtractionTime();
//        Assert.assertEquals(amount, NetAmount);
        Assert.assertEquals(true,ExtractionTime);
        System.out.println("Expected Value is : "+true+ "Actual is : "+ExtractionTime );
        if(ExtractionTime){
            System.out.println("The report Contains the correct format");
        }
        else{
            System.out.println("The report doesn't matches the correct format");
        }

    }



}
