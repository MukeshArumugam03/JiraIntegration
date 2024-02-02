package jsons;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.jcraft.jsch.*;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class PayloadStore {

    static String strdate;
    static String strCurrentdate;
    public static JsonNode jsonNode2;

    public static String guwid;

    public static String vnumber;

        public static void domesticTransaction2(String scheme, String amount, String currency, String Merchant_ID, String TerminalID, String SessionID,String Session_Date) throws org.json.simple.parser.ParseException, IOException {

        String strMcpayload = "{\n" +
                "    \"headers\": {},\n" +
                "    \"payload\": {\n" +
                "        \"peTransaction\": {\n" +
                "            \"guwid\": \"DB_m8ac7-d5ee-4ffa-27dec-07eeff4b7cd7"+strdate+ "\",\n" +
                "            \"acqAuthorization\": \"297664\",\n" +
                "            \"acqNumber\": 405,\n" +
                "            \"acqBin\": \"ACQ\",\n" +
                "            \"acqTraceNumber\": 862890,\n" +
                "            \"arn\": \"24245007304103100068043\",\n" +
                "            \"bcId\": 617976,\n" +
                "            \"bcSig\": \"GN0000317E52836E\",\n" +
                "            \"ccMonth\": 12,\n" +
                "            \"ccNumber\": \"411111****1111\",\n" +
                "            \"ccOwner\": \"cardholder\",\n" +
                "            \"ccType\": " + scheme + ",\n" +
                "            \"ccYear\": 2021,\n" +
                "            \"curCode\": \"" + currency + "\",\n" +
                "            \"demoMode\": \"0\",\n" +
                "            \"groupId\": \"DB_f8ac7-d5ee-4ffa-27dec-07eeff4b7cd7"+strdate+ "\",\n" +
                "            \"loginId\": 1,\n" +
                "            \"merchantFunctionId\": \"ywaDPDBlmczR8XXqpHyYH3hwNrR3Ljmg\",\n" +
                "            \"merchantJobId\": \"123456789\",\n" +
                "            \"merchantRequestTime\":  \""+strCurrentdate+"\",\n" +
                "            \"terminalType\": \"2\",\n" +
                "            \"tnumber\": \"" + TerminalID + "\",\n" +
                "            \"transAmount\": " + amount + ",\n" +
                "            \"signedAmount\": \"" + amount + "\",\n" +
                "            \"origAmount\": " + amount + ",\n" +
                "            \"transCountryCode\": \"DE\",\n" +
                "            \"transId\": \"any transaction\",\n" +
                "            \"transIpAddr\": \"127.9.9.9\",\n" +
                "            \"transMode\": 40,\n" +
                "            \"transPurchaseTime\":\""+strCurrentdate+"\",\n" +
                "            \"transReference\": \"\",\n" +
                "            \"transRefMode\": 0,\n" +
                "            \"transStatus\": 0,\n" +
                "            \"transTime\": \""+strCurrentdate+"\",\n" +
                "            \"vnumber\": \"" + Merchant_ID + "\",\n" +
                "            \"fxSettlAmount\": " + amount + ",\n" +
                "            \"fxSettlCurCode\": \"" + currency + "\",\n" +
                "            \"fxSettlRate\": 1,\n" +
                "            \"fxAcqAmount\": 1342,\n" +
                "            \"fxAcqCurCode\": \"EUR\",\n" +
                "            \"fxAcqRate\": 1,\n" +
                "            \"fxEurBaseAmount\": 1342,\n" +
                "            \"fxUsdBaseAmount\": 1610,\n" +
                "            \"fxEurBaseRate\": 1,\n" +
                "            \"fxUsdBaseRate\": 1.2,\n" +
                "            \"fxSettlValidityTs\": \""+strCurrentdate+"\",\n" +
                "            \"fxSettlProviderId\": \"4\",\n" +
                "            \"fxUpToDateInd\": \"0\",\n" +
                "            \"fxSolId\": 2,\n" +
                "            \"fxAcqValidityTs\": \""+strCurrentdate+"\",\n" +
                "            \"fxAcqProviderId\": \"4\",\n" +
                "            \"fxEurBaseValidityTs\": \""+strCurrentdate+"\",\n" +
                "            \"fxEurBaseProviderId\": \"4\",\n" +
                "            \"fxUsdBaseValidityTs\": \""+strCurrentdate+"\",\n" +
                "            \"fxUsdBaseProviderId\": \"4\",\n" +
                "            \"cardTypeInd\": \"1\",\n" +
                "            \"classification\": \"N\",\n" +
                "            \"issuerCountry\": \"DE\",\n" +
                "            \"userName\": \"System\",\n" +
                "            \"agentCode\": 34456853,\n" +
                "            \"agentName\": \"Sita Travels\",\n" +
                "            \"airlineCode\": 999,\n" +
                "            \"airlineName\": \"Lufthansa\",\n" +
                "            \"checkDigit\": 9,\n" +
                "            \"flightNumber\": \"7104\",\n" +
                "            \"originAirport\": \"MUC\",\n" +
                "            \"passengerName\": \"Lars Ulrich\",\n" +
                "            \"pnrFileKey\": \"723983\",\n" +
                "            \"ticketNumber\": 625979881,\n" +
                "            \"restricted\": \"1\",\n" +
                "            \"ticketIssueDate\":\"22-12-2023 13:13:05\",\n" +
                "            \"emdId\": 0,\n" +
                "            \"emdTicketNumber\": \"654321\",\n" +
                "            \"procParameters\": \"1=\\\"3\\\",2=\\\"5\\\",4=\\\"012\\\",5=\\\"00\\\",6=\\\"3\\\",7=\\\"1\\\",9=\\\"0\\\",10=\\\"Y6161\\\",11=\\\"M\\\",132=\\\"false\\\",472=\\\"021/17b19579001AG00\\\",506=\\\"N\\\",444=\\\"1\\\",568=\\\"true\\\",567=\\\"true\\\"\",\n" +
                "            \"gatewayType\": \"PECC\",\n" +
                "            \"chiFirstName\": \"ChiFirst\",\n" +
                "            \"chiLastName\": \"ChiLast\",\n" +
                "            \"chiEmail\": \"chi@chimail.com\",\n" +
                "            \"chiPhone\": \"+49(89)1111119\",\n" +
                "            \"chiAddress1\": \"Chi Street\",\n" +
                "            \"chiAddress2\": \"100/A\",\n" +
                "            \"chiCity\": \"Los Angeles\",\n" +
                "            \"chiState\": \"CA\",\n" +
                "            \"chiCountry\": \"US\",\n" +
                "            \"chiZipCode\": \"04431\",\n" +
                "            \"lastUpdateTS\": \""+strCurrentdate+"\",\n" +
                "            \"transactionSource\": \"Merchant Site\",\n" +
                "            \"iccData\": \"ICC\",\n" +
                "            \"issuerName\": \"WirecardBank\",\n" +
                "            \"sequenceNumber\": \"" + SessionID + "\",\n" +
                "            \"dccAmount\": 100,\n" +
                "            \"dccCurCode\": \"USD\",\n" +
                "            \"dccTransactionId\": \"DCCId\",\n" +
                "            \"dccRate\": 1.2,\n" +
                "            \"dccFxProviderId\": \"DCCFxProvider\",\n" +
                "            \"ccToken\": \"2a0b3c59076d47b98bd35f7d53142070\",\n" +
                "            \"dccProviderId\": \"dccproviderId\",\n" +
                "            \"tenor\": 12,\n" +
                "            \"cycle\": \"M\",\n" +
                "            \"promotionId\": \"10\",\n" +
                "            \"interestRate\": 1.24,\n" +
                "            \"nextAmount\": 100,\n" +
                "            \"cardProgramId\": 1,\n" +
                "            \"receipt\": \"789789123\",\n" +
                "            \"wduuid\": \"0471C9E3FA61461CBB1FE537D795213A\",\n" +
                "            \"hopId\": \"5\",\n" +
                "            \"csdSenderFirstName\": \"CSD1\",\n" +
                "            \"csdSenderLastName\": \"CSD2\",\n" +
                "            \"csdSenderAddress\": \"CSD6\",\n" +
                "            \"csdSenderCity\": \"CSD3\",\n" +
                "            \"csdSenderCountry\": \"CSD4\",\n" +
                "            \"csdSenderState\": \"CSD5\",\n" +
                "            \"csdSenderPostalCode\": \"CSD7\",\n" +
                "            \"csdSenderAccountNumber\": \"CSD9\",\n" +
                "            \"csdSenderFundsSource\": \"CSD10\",\n" +
                "            \"csdReferenceNumber\": \"CSD8\",\n" +
                "            \"csdReceiverFirstName\": \"CSD11\",\n" +
                "            \"csdReceiverLastName\": \"CSD12\",\n" +
                "            \"dcardCardProduct\": \"PRO\",\n" +
                "            \"dcardAcqBinRegion\": \"CAN\",\n" +
                "            \"dcardAcqBinCountry\": \"CAN\",\n" +
                "            \"dcardSchClrDate\": \""+ Session_Date +"\",\n" +
                "            \"dcardSchReconAmount\": 200,\n" +
                "            \"dcardSchReconAmountCurCode\": \"USD\",\n" +
                "            \"dcardSchExchangeRate\": 1.2,\n" +
                "            \"dcardCutoverDate\": \"" + Session_Date + "\",\n" +
                "            \"dcardDiscountAmount\": 100.12,\n" +
                "            \"settlementBarrier\": \""+strCurrentdate+"\"\n" +
                "        },\n" +
                "        \"airlineItinerary\": {\n" +
                "            \"segments\": [\n" +
                "                {\n" +
                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-27dec-07eeff4b7cd7"+strdate+ "\",\n" +
                "                    \"segmentId\": 4,\n" +
                "                    \"carrierCode\": \"LH\",\n" +
                "                    \"classOfService\": \"fancy\",\n" +
                "                    \"stopOverCode\": \"1\",\n" +
                "                    \"legDepartureDate\": \""+strCurrentdate+"\",\n" +
                "                    \"destination\": \"Ploske\",\n" +
                "                    \"fareBasis\": \"very fare\",\n" +
                "                    \"origin\": \"MUC-notUsed\",\n" +
                "                    \"flightNumber\": \"flightNumber-123\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        \"txnFees\": {\n" +
                "            \"fees\": [\n" +
                "                {\n" +
                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-27dec-07eeff4b7cd7"+strdate+ "\",\n" +
                "                    \"feeTypeId\": \"1\",\n" +
                "                    \"feeAmount\": -11,\n" +
                "                    \"feeCurCode\": \"GBP\",\n" +
                "                    \"settlementAmount\": -11,\n" +
                "                    \"settlementCurrencyCode\": \"EUR\",\n" +
                "                    \"settlementRate\": 1.13981,\n" +
                "                    \"transFeeAmount\": -11,\n" +
                "                    \"transFeeCurrencyCode\": \"EUR\",\n" +
                "                    \"transFeeRate\": 1.13981,\n" +
                "                    \"transFeeAmountHighPrec\": null,\n" +
                "                    \"transFeeAmountHighPrecScale\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-27dec-07eeff4b7cd7"+strdate+ "\",\n" +
                "                    \"feeTypeId\": \"2\",\n" +
                "                    \"feeAmount\": 100,\n" +
                "                    \"feeCurCode\": \"EUR\",\n" +
                "                    \"settlementAmount\": 100,\n" +
                "                    \"settlementCurrencyCode\": \"EUR\",\n" +
                "                    \"settlementRate\": 1,\n" +
                "                    \"transFeeAmount\": 100,\n" +
                "                    \"transFeeCurrencyCode\": \"EUR\",\n" +
                "                    \"transFeeRate\": 1,\n" +
                "                    \"transFeeAmountHighPrec\": null,\n" +
                "                    \"transFeeAmountHighPrecScale\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-27dec-07eeff4b7cd7"+strdate+ "\",\n" +
                "                    \"feeTypeId\": \"3\",\n" +
                "                    \"feeAmount\": 120,\n" +
                "                    \"feeCurCode\": \"USD\",\n" +
                "                    \"settlementAmount\": 84,\n" +
                "                    \"settlementCurrencyCode\": \"EUR\",\n" +
                "                    \"settlementRate\": 0.70124752,\n" +
                "                    \"transFeeAmount\": 84,\n" +
                "                    \"transFeeCurrencyCode\": \"EUR\",\n" +
                "                    \"transFeeRate\": 0.70124752,\n" +
                "                    \"transFeeAmountHighPrec\": 840,\n" +
                "                    \"transFeeAmountHighPrecScale\": 3\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    }\n" +
                "}";

        ObjectMapper objectMapper2 = new ObjectMapper();
        jsonNode2 = objectMapper2.readTree(strMcpayload);

        // String strGuwid = node.get("guwid[1]").asText();
        //  System.out.println(strGuwid);
        Map<String, Object> mapping = new ObjectMapper().readValue(strMcpayload, LinkedHashMap.class);
        Map<String, String> map2 = new HashMap<>();
        map2 = (Map<String, String>) ((Map) mapping.get("payload")).get("peTransaction");
        guwid = map2.get("guwid");
        System.out.println("Transaction Guwid = " + guwid);

    }

    public static void internationalTransaction2(String scheme, String amount, String currency, String Merchant_ID, String TerminalID, String SessionID,String Session_Date) throws org.json.simple.parser.ParseException, IOException {

        String strMcpayload = "{\n" +
                "    \"headers\": {},\n" +
                "    \"payload\": {\n" +
                "        \"peTransaction\": {\n" +
                "            \"guwid\": \"DB_m8ac7-d5ee-4ffa-07eeff4c8"+strdate+ "\",\n" +
                "            \"acqAuthorization\": \"297664\",\n" +
                "            \"acqNumber\": 405,\n" +
                "            \"acqBin\": \"ACQ\",\n" +
                "            \"acqTraceNumber\": 862890,\n" +
                "            \"arn\": \"24245007304103100068043\",\n" +
                "            \"bcId\": 617976,\n" +
                "            \"bcSig\": \"GN0000317E52836E\",\n" +
                "            \"ccMonth\": 12,\n" +
                "            \"ccNumber\": \"411111****1111\",\n" +
                "            \"ccOwner\": \"cardholder\",\n" +
                "            \"ccType\": " + scheme + ",\n" +
                "            \"ccYear\": 2021,\n" +
                "            \"curCode\": \"" + currency + "\",\n" +
                "            \"demoMode\": \"0\",\n" +
                "            \"groupId\": \"DB_f8ac7-d5ee-4ffa-07eeff4c8"+strdate+ "\",\n" +
                "            \"loginId\": 1,\n" +
                "            \"merchantFunctionId\": \"ywaDPDBlmczR8XXqpHyYH3hwNrR3Ljmg\",\n" +
                "            \"merchantJobId\": \"123456789\",\n" +
                "            \"merchantRequestTime\": \""+strCurrentdate+"\",\n" +
                "            \"terminalType\": \"2\",\n" +
                "            \"tnumber\": \"" + TerminalID + "\",\n" +
                "            \"transAmount\": 1000,\n" +
                "            \"signedAmount\": \"" + amount + "\",\n" +
                "            \"origAmount\":  1000,\n" +
                "            \"transCountryCode\": \"DE\",\n" +
                "            \"transId\": \"any transaction\",\n" +
                "            \"transIpAddr\": \"127.9.9.9\",\n" +
                "            \"transMode\": 40,\n" +
                "            \"transPurchaseTime\":\""+strCurrentdate+"\",\n" +
                "            \"transReference\": \"\",\n" +
                "            \"transRefMode\": 0,\n" +
                "            \"transStatus\": 0,\n" +
                "            \"transTime\": \""+strCurrentdate+"\",\n" +
                "            \"vnumber\": \"" + Merchant_ID + "\",\n" +
                "            \"fxSettlAmount\":  1342,\n" +
                "            \"fxSettlCurCode\": \"" + currency + "\",\n" +
                "            \"fxSettlRate\": 1,\n" +
                "            \"fxAcqAmount\": 1342,\n" +
                "            \"fxAcqCurCode\": \"EUR\",\n" +
                "            \"fxAcqRate\": 1,\n" +
                "            \"fxEurBaseAmount\": 1342,\n" +
                "            \"fxUsdBaseAmount\": 1610,\n" +
                "            \"fxEurBaseRate\": 1,\n" +
                "            \"fxUsdBaseRate\": 1.2,\n" +
                "            \"fxSettlValidityTs\":\""+strCurrentdate+"\",\n" +
                "            \"fxSettlProviderId\": \"4\",\n" +
                "            \"fxUpToDateInd\": \"0\",\n" +
                "            \"fxSolId\": 2,\n" +
                "            \"fxAcqValidityTs\":  \""+strCurrentdate+"\",\n" +
                "            \"fxAcqProviderId\": \"4\",\n" +
                "            \"fxEurBaseValidityTs\":  \""+strCurrentdate+"\",\n" +
                "            \"fxEurBaseProviderId\": \"4\",\n" +
                "            \"fxUsdBaseValidityTs\":  \""+strCurrentdate+"\",\n" +
                "            \"fxUsdBaseProviderId\": \"4\",\n" +
                "            \"cardTypeInd\": \"1\",\n" +
                "            \"classification\": \"N\",\n" +
                "            \"issuerCountry\": \"DE\",\n" +
                "            \"userName\": \"System\",\n" +
                "            \"agentCode\": 34456853,\n" +
                "            \"agentName\": \"Sita Travels\",\n" +
                "            \"airlineCode\": 999,\n" +
                "            \"airlineName\": \"Lufthansa\",\n" +
                "            \"checkDigit\": 9,\n" +
                "            \"flightNumber\": \"7104\",\n" +
                "            \"originAirport\": \"MUC\",\n" +
                "            \"passengerName\": \"Lars Ulrich\",\n" +
                "            \"pnrFileKey\": \"723983\",\n" +
                "            \"ticketNumber\": 625979881,\n" +
                "            \"restricted\": \"1\",\n" +
                "            \"ticketIssueDate\":\"22-12-2023 13:13:05\",\n" +
                "            \"emdId\": 0,\n" +
                "            \"emdTicketNumber\": \"654321\",\n" +
                "            \"procParameters\": \"1=\\\"3\\\",2=\\\"5\\\",4=\\\"012\\\",5=\\\"00\\\",6=\\\"3\\\",7=\\\"1\\\",9=\\\"0\\\",10=\\\"Y6161\\\",11=\\\"M\\\",132=\\\"false\\\",472=\\\"021/17b19579001AG00\\\",506=\\\"N\\\",444=\\\"1\\\",568=\\\"false\\\",567=\\\"true\\\"\",\n" +
                "            \"gatewayType\": \"PECC\",\n" +
                "            \"chiFirstName\": \"ChiFirst\",\n" +
                "            \"chiLastName\": \"ChiLast\",\n" +
                "            \"chiEmail\": \"chi@chimail.com\",\n" +
                "            \"chiPhone\": \"+49(89)1111119\",\n" +
                "            \"chiAddress1\": \"Chi Street\",\n" +
                "            \"chiAddress2\": \"100/A\",\n" +
                "            \"chiCity\": \"Los Angeles\",\n" +
                "            \"chiState\": \"CA\",\n" +
                "            \"chiCountry\": \"US\",\n" +
                "            \"chiZipCode\": \"04431\",\n" +
                "            \"lastUpdateTS\":  \""+strCurrentdate+"\",\n" +
                "            \"transactionSource\": \"Merchant Site\",\n" +
                "            \"iccData\": \"ICC\",\n" +
                "            \"issuerName\": \"WirecardBank\",\n" +
                "            \"sequenceNumber\": \"" + SessionID + "\",\n" +
                "            \"dccAmount\": 100,\n" +
                "            \"dccCurCode\": \"USD\",\n" +
                "            \"dccTransactionId\": \"DCCId\",\n" +
                "            \"dccRate\": 1.2,\n" +
                "            \"dccFxProviderId\": \"DCCFxProvider\",\n" +
                "            \"ccToken\": \"2a0b3c59076d47b98bd35f7d53142070\",\n" +
                "            \"dccProviderId\": \"dccproviderId\",\n" +
                "            \"tenor\": 12,\n" +
                "            \"cycle\": \"M\",\n" +
                "            \"promotionId\": \"10\",\n" +
                "            \"interestRate\": 1.24,\n" +
                "            \"nextAmount\": 100,\n" +
                "            \"cardProgramId\": 1,\n" +
                "            \"receipt\": \"789789123\",\n" +
                "            \"wduuid\": \"0471C9E3FA61461CBB1FE537D795213A\",\n" +
                "            \"hopId\": \"5\",\n" +
                "            \"csdSenderFirstName\": \"CSD1\",\n" +
                "            \"csdSenderLastName\": \"CSD2\",\n" +
                "            \"csdSenderAddress\": \"CSD6\",\n" +
                "            \"csdSenderCity\": \"CSD3\",\n" +
                "            \"csdSenderCountry\": \"CSD4\",\n" +
                "            \"csdSenderState\": \"CSD5\",\n" +
                "            \"csdSenderPostalCode\": \"CSD7\",\n" +
                "            \"csdSenderAccountNumber\": \"CSD9\",\n" +
                "            \"csdSenderFundsSource\": \"CSD10\",\n" +
                "            \"csdReferenceNumber\": \"CSD8\",\n" +
                "            \"csdReceiverFirstName\": \"CSD11\",\n" +
                "            \"csdReceiverLastName\": \"CSD12\",\n" +
                "            \"dcardCardProduct\": \"PRO\",\n" +
                "            \"dcardAcqBinRegion\": \"CAN\",\n" +
                "            \"dcardAcqBinCountry\": \"CAN\",\n" +
                "            \"dcardSchClrDate\": \"" + Session_Date + "\",\n" +
                "            \"dcardSchReconAmount\": 200,\n" +
                "            \"dcardSchReconAmountCurCode\": \"USD\",\n" +
                "            \"dcardSchExchangeRate\": 1.2,\n" +
                "            \"dcardCutoverDate\": \"" + Session_Date + "\",\n" +
                "            \"dcardDiscountAmount\": 150.12,\n" +
                "            \"settlementBarrier\": \""+strCurrentdate+"\"\n" +
                "        },\n" +
                "        \"airlineItinerary\": {\n" +
                "            \"segments\": [\n" +
                "                {\n" +
                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-07eeff4c8"+strdate+ "\",\n" +
                "                    \"segmentId\": 4,\n" +
                "                    \"carrierCode\": \"LH\",\n" +
                "                    \"classOfService\": \"fancy\",\n" +
                "                    \"stopOverCode\": \"1\",\n" +
                "                    \"legDepartureDate\": \""+strCurrentdate+"\",\n" +
                "                    \"destination\": \"Ploske\",\n" +
                "                    \"fareBasis\": \"very fare\",\n" +
                "                    \"origin\": \"MUC-notUsed\",\n" +
                "                    \"flightNumber\": \"flightNumber-123\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        \"txnFees\": {\n" +
                "            \"fees\": [\n" +
                "                {\n" +
                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-07eeff4c8"+strdate+ "\",\n" +
                "                    \"feeTypeId\": \"1\",\n" +
                "                    \"feeAmount\": -11,\n" +
                "                    \"feeCurCode\": \"GBP\",\n" +
                "                    \"settlementAmount\": -11,\n" +
                "                    \"settlementCurrencyCode\": \"EUR\",\n" +
                "                    \"settlementRate\": 1.13981,\n" +
                "                    \"transFeeAmount\": -11,\n" +
                "                    \"transFeeCurrencyCode\": \"EUR\",\n" +
                "                    \"transFeeRate\": 1.13981,\n" +
                "                    \"transFeeAmountHighPrec\": null,\n" +
                "                    \"transFeeAmountHighPrecScale\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-07eeff4c8"+strdate+ "\",\n" +
                "                    \"feeTypeId\": \"2\",\n" +
                "                    \"feeAmount\": 100,\n" +
                "                    \"feeCurCode\": \"EUR\",\n" +
                "                    \"settlementAmount\": 100,\n" +
                "                    \"settlementCurrencyCode\": \"EUR\",\n" +
                "                    \"settlementRate\": 1,\n" +
                "                    \"transFeeAmount\": 100,\n" +
                "                    \"transFeeCurrencyCode\": \"EUR\",\n" +
                "                    \"transFeeRate\": 1,\n" +
                "                    \"transFeeAmountHighPrec\": null,\n" +
                "                    \"transFeeAmountHighPrecScale\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-07eeff4c8"+strdate+ "\",\n" +
                "                    \"feeTypeId\": \"3\",\n" +
                "                    \"feeAmount\": 120,\n" +
                "                    \"feeCurCode\": \"USD\",\n" +
                "                    \"settlementAmount\": 84,\n" +
                "                    \"settlementCurrencyCode\": \"EUR\",\n" +
                "                    \"settlementRate\": 0.70124752,\n" +
                "                    \"transFeeAmount\": 84,\n" +
                "                    \"transFeeCurrencyCode\": \"EUR\",\n" +
                "                    \"transFeeRate\": 0.70124752,\n" +
                "                    \"transFeeAmountHighPrec\": 840,\n" +
                "                    \"transFeeAmountHighPrecScale\": 3\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    }\n" +
                "}";

        ObjectMapper objectMapper2 = new ObjectMapper();
        jsonNode2 = objectMapper2.readTree(strMcpayload);

        // String strGuwid = node.get("guwid[1]").asText();
        //  System.out.println(strGuwid);
        Map<String, Object> mapping = new ObjectMapper().readValue(strMcpayload, LinkedHashMap.class);
        Map<String, String> map2 = new HashMap<>();
        map2 = (Map<String, String>) ((Map) mapping.get("payload")).get("peTransaction");
        guwid = map2.get("guwid");
        System.out.println("Transaction Guwid = " + guwid);

        Map<String, Object> mapping2 = new ObjectMapper().readValue(strMcpayload, LinkedHashMap.class);
        Map<String, String> map3 = new HashMap<>();
        map3 = (Map<String, String>) ((Map) mapping2.get("payload")).get("peTransaction");
        vnumber = map2.get("vnumber");
        System.out.println("Transaction vnumber = " + vnumber);


    }

    public static void generateGuwid() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("ddMMyyyymmssss");
        Date date = new Date();
        strdate = format.format(date);
    }

    public static void generatedate() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Date date = new Date();
        strCurrentdate = format.format(date);

    }

    public static void domesticTransaction(String scheme, String amount, String currency, String Merchant_ID, String TerminalID, String SessionID,String Session_Date,String Instant_flag) throws org.json.simple.parser.ParseException, IOException {

        String strMcpayload = "{\n" +
                "    \"headers\": {},\n" +
                "    \"payload\": {\n" +
                "        \"peTransaction\": {\n" +
                "            \"guwid\": \"DB_f8ac7-d5ee-4ffa-27dec-07eeff4b7cd7"+strdate+ "\",\n" +
                "            \"acqAuthorization\": \"297664\",\n" +
                "            \"acqNumber\": 405,\n" +
                "            \"acqBin\": \"ACQ\",\n" +
                "            \"acqTraceNumber\": 862890,\n" +
                "            \"arn\": \"24245007304103100068043\",\n" +
                "            \"bcId\": 6179767,\n" +
                "            \"bcSig\": \"GN0000317E52836E\",\n" +
                "            \"ccMonth\": 12,\n" +
                "            \"ccNumber\": \"411111****1111\",\n" +
                "            \"ccOwner\": \"cardholder\",\n" +
                "            \"ccType\": " + scheme + ",\n" +
                "            \"ccYear\": 2021,\n" +
                "            \"curCode\": \"" + currency + "\",\n" +
                "            \"demoMode\": \"0\",\n" +
                "            \"groupId\": \"DB_f8ac7-d5ee-4ffa-27dec-07eeff4b7cd7"+strdate+ "\",\n" +
                "            \"loginId\": 1,\n" +
                "            \"merchantFunctionId\": \"ywaDPDBlmczR8XXqpHyYH3hwNrR3Ljmg\",\n" +
                "            \"merchantJobId\": \"123456789\",\n" +
                "            \"merchantRequestTime\":  \""+strCurrentdate+"\",\n" +
                "            \"terminalType\": \"2\",\n" +
                "            \"tnumber\": \"" + TerminalID + "\",\n" +
                "            \"transAmount\": 1000,\n" +
                "            \"signedAmount\": \"" + amount + "\",\n" +
                "            \"origAmount\":  1000,\n" +
                "            \"transCountryCode\": \"DE\",\n" +
                "            \"transId\": \"any transaction\",\n" +
                "            \"transIpAddr\": \"127.9.9.9\",\n" +
                "            \"transMode\": 40,\n" +
                "            \"transPurchaseTime\":\""+strCurrentdate+"\",\n" +
                "            \"transReference\": \"\",\n" +
                "            \"transRefMode\": 0,\n" +
                "            \"transStatus\": 0,\n" +
                "            \"transTime\": \""+strCurrentdate+"\",\n" +
                "            \"vnumber\": \"" + Merchant_ID + "\",\n" +
                "            \"fxSettlAmount\": 1342,\n" +
                "            \"fxSettlCurCode\": \"" + currency + "\",\n" +
                "            \"fxSettlRate\": 1,\n" +
                "            \"fxAcqAmount\": 1342,\n" +
                "            \"fxAcqCurCode\": \"EUR\",\n" +
                "            \"fxAcqRate\": 1,\n" +
                "            \"fxEurBaseAmount\": 1342,\n" +
                "            \"fxUsdBaseAmount\": 1610,\n" +
                "            \"fxEurBaseRate\": 1,\n" +
                "            \"fxUsdBaseRate\": 1.2,\n" +
                "            \"fxSettlValidityTs\": \""+strCurrentdate+"\",\n" +
                "            \"fxSettlProviderId\": \"4\",\n" +
                "            \"fxUpToDateInd\": \"0\",\n" +
                "            \"fxSolId\": 2,\n" +
                "            \"fxAcqValidityTs\": \""+strCurrentdate+"\",\n" +
                "            \"fxAcqProviderId\": \"4\",\n" +
                "            \"fxEurBaseValidityTs\": \""+strCurrentdate+"\",\n" +
                "            \"fxEurBaseProviderId\": \"4\",\n" +
                "            \"fxUsdBaseValidityTs\": \""+strCurrentdate+"\",\n" +
                "            \"fxUsdBaseProviderId\": \"4\",\n" +
                "            \"cardTypeInd\": \"1\",\n" +
                "            \"classification\": \"N\",\n" +
                "            \"issuerCountry\": \"DE\",\n" +
                "            \"userName\": \"System\",\n" +
                "            \"agentCode\": 34456853,\n" +
                "            \"agentName\": \"Sita Travels\",\n" +
                "            \"airlineCode\": 999,\n" +
                "            \"airlineName\": \"Lufthansa\",\n" +
                "            \"checkDigit\": 9,\n" +
                "            \"flightNumber\": \"7104\",\n" +
                "            \"originAirport\": \"MUC\",\n" +
                "            \"passengerName\": \"Lars Ulrich\",\n" +
                "            \"pnrFileKey\": \"723983\",\n" +
                "            \"ticketNumber\": 625979881,\n" +
                "            \"restricted\": \"1\",\n" +
                "            \"ticketIssueDate\":\"22-12-2023 13:13:05\",\n" +
                "            \"emdId\": 0,\n" +
                "            \"emdTicketNumber\": \"654321\",\n" +
                "            \"procParameters\": \"1=\\\"3\\\",2=\\\"5\\\",4=\\\"012\\\",5=\\\"00\\\",6=\\\"3\\\",7=\\\"1\\\",9=\\\"0\\\",10=\\\"Y6161\\\",11=\\\"M\\\",132=\\\"false\\\",472=\\\"021/17b19579001AG00\\\",506=\\\"N\\\",444=\\\"1\\\",568=\\\"true\\\",567=\\\"" + Instant_flag + "\\\"\",\n" +
                "            \"gatewayType\": \"PECC\",\n" +
                "            \"chiFirstName\": \"ChiFirst\",\n" +
                "            \"chiLastName\": \"ChiLast\",\n" +
                "            \"chiEmail\": \"chi@chimail.com\",\n" +
                "            \"chiPhone\": \"+49(89)1111119\",\n" +
                "            \"chiAddress1\": \"Chi Street\",\n" +
                "            \"chiAddress2\": \"100/A\",\n" +
                "            \"chiCity\": \"Los Angeles\",\n" +
                "            \"chiState\": \"CA\",\n" +
                "            \"chiCountry\": \"US\",\n" +
                "            \"chiZipCode\": \"04431\",\n" +
                "            \"lastUpdateTS\": \""+strCurrentdate+"\",\n" +
                "            \"transactionSource\": \"Merchant Site\",\n" +
                "            \"iccData\": \"ICC\",\n" +
                "            \"issuerName\": \"WirecardBank\",\n" +
                "            \"sequenceNumber\": \"" + SessionID + "\",\n" +
                "            \"dccAmount\": 100,\n" +
                "            \"dccCurCode\": \"USD\",\n" +
                "            \"dccTransactionId\": \"DCCId\",\n" +
                "            \"dccRate\": 1.2,\n" +
                "            \"dccFxProviderId\": \"DCCFxProvider\",\n" +
                "            \"ccToken\": \"2a0b3c59076d47b98bd35f7d53142070\",\n" +
                "            \"dccProviderId\": \"dccproviderId\",\n" +
                "            \"tenor\": 12,\n" +
                "            \"cycle\": \"M\",\n" +
                "            \"promotionId\": \"10\",\n" +
                "            \"interestRate\": 1.24,\n" +
                "            \"nextAmount\": 100,\n" +
                "            \"cardProgramId\": 1,\n" +
                "            \"receipt\": \"789789123\",\n" +
                "            \"wduuid\": \"0471C9E3FA61461CBB1FE537D795213A\",\n" +
                "            \"hopId\": \"5\",\n" +
                "            \"csdSenderFirstName\": \"CSD1\",\n" +
                "            \"csdSenderLastName\": \"CSD2\",\n" +
                "            \"csdSenderAddress\": \"CSD6\",\n" +
                "            \"csdSenderCity\": \"CSD3\",\n" +
                "            \"csdSenderCountry\": \"CSD4\",\n" +
                "            \"csdSenderState\": \"CSD5\",\n" +
                "            \"csdSenderPostalCode\": \"CSD7\",\n" +
                "            \"csdSenderAccountNumber\": \"CSD9\",\n" +
                "            \"csdSenderFundsSource\": \"CSD10\",\n" +
                "            \"csdReferenceNumber\": \"CSD8\",\n" +
                "            \"csdReceiverFirstName\": \"CSD11\",\n" +
                "            \"csdReceiverLastName\": \"CSD12\",\n" +
                "            \"dcardCardProduct\": \"PRO\",\n" +
                "            \"dcardAcqBinRegion\": \"CAN\",\n" +
                "            \"dcardAcqBinCountry\": \"CAN\",\n" +
                "            \"dcardSchClrDate\": \""+ Session_Date +"\",\n" +
                "            \"dcardSchReconAmount\": 200,\n" +
                "            \"dcardSchReconAmountCurCode\": \"USD\",\n" +
                "            \"dcardSchExchangeRate\": 1.2,\n" +
                "            \"dcardCutoverDate\": \"" + Session_Date + "\",\n" +
                "            \"dcardDiscountAmount\": 250.12,\n" +
                "            \"settlementBarrier\": \""+strCurrentdate+"\"\n" +
                "        },\n" +
                "        \"airlineItinerary\": {\n" +
                "            \"segments\": [\n" +
                "                {\n" +
                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-27dec-07eeff4b7cd7"+strdate+ "\",\n" +
                "                    \"segmentId\": 4,\n" +
                "                    \"carrierCode\": \"LH\",\n" +
                "                    \"classOfService\": \"fancy\",\n" +
                "                    \"stopOverCode\": \"1\",\n" +
                "                    \"legDepartureDate\": \""+strCurrentdate+"\",\n" +
                "                    \"destination\": \"Ploske\",\n" +
                "                    \"fareBasis\": \"very fare\",\n" +
                "                    \"origin\": \"MUC-notUsed\",\n" +
                "                    \"flightNumber\": \"flightNumber-123\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        \"txnFees\": {\n" +
                "            \"fees\": [\n" +
                "                {\n" +
                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-27dec-07eeff4b7cd7"+strdate+ "\",\n" +
                "                    \"feeTypeId\": \"1\",\n" +
                "                    \"feeAmount\": -11,\n" +
                "                    \"feeCurCode\": \"GBP\",\n" +
                "                    \"settlementAmount\": -11,\n" +
                "                    \"settlementCurrencyCode\": \"EUR\",\n" +
                "                    \"settlementRate\": 1.13981,\n" +
                "                    \"transFeeAmount\": -11,\n" +
                "                    \"transFeeCurrencyCode\": \"EUR\",\n" +
                "                    \"transFeeRate\": 1.13981,\n" +
                "                    \"transFeeAmountHighPrec\": null,\n" +
                "                    \"transFeeAmountHighPrecScale\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-27dec-07eeff4b7cd7"+strdate+ "\",\n" +
                "                    \"feeTypeId\": \"2\",\n" +
                "                    \"feeAmount\": 100,\n" +
                "                    \"feeCurCode\": \"EUR\",\n" +
                "                    \"settlementAmount\": 100,\n" +
                "                    \"settlementCurrencyCode\": \"EUR\",\n" +
                "                    \"settlementRate\": 1,\n" +
                "                    \"transFeeAmount\": 100,\n" +
                "                    \"transFeeCurrencyCode\": \"EUR\",\n" +
                "                    \"transFeeRate\": 1,\n" +
                "                    \"transFeeAmountHighPrec\": null,\n" +
                "                    \"transFeeAmountHighPrecScale\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-27dec-07eeff4b7cd7"+strdate+ "\",\n" +
                "                    \"feeTypeId\": \"3\",\n" +
                "                    \"feeAmount\": 120,\n" +
                "                    \"feeCurCode\": \"USD\",\n" +
                "                    \"settlementAmount\": 84,\n" +
                "                    \"settlementCurrencyCode\": \"EUR\",\n" +
                "                    \"settlementRate\": 0.70124752,\n" +
                "                    \"transFeeAmount\": 84,\n" +
                "                    \"transFeeCurrencyCode\": \"EUR\",\n" +
                "                    \"transFeeRate\": 0.70124752,\n" +
                "                    \"transFeeAmountHighPrec\": 840,\n" +
                "                    \"transFeeAmountHighPrecScale\": 3\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    }\n" +
                "}";

        ObjectMapper objectMapper2 = new ObjectMapper();
        jsonNode2 = objectMapper2.readTree(strMcpayload);

        // String strGuwid = node.get("guwid[1]").asText();
        //  System.out.println(strGuwid);
        Map<String, Object> mapping = new ObjectMapper().readValue(strMcpayload, LinkedHashMap.class);
        Map<String, String> map2 = new HashMap<>();
        map2 = (Map<String, String>) ((Map) mapping.get("payload")).get("peTransaction");
        guwid = map2.get("guwid");
        System.out.println("Transaction Guwid = " + guwid);

    }

    public static void internationalTransaction(String scheme, String amount, String currency, String Merchant_ID, String TerminalID, String SessionID,String Session_Date, String Instant_flag) throws org.json.simple.parser.ParseException, IOException {

        String strMcpayload = "{\n" +
                "    \"headers\": {},\n" +
                "    \"payload\": {\n" +
                "        \"peTransaction\": {\n" +
                "            \"guwid\": \"DB_f8ac7-d5ee-4ffa-07eeff4c8"+strdate+ "\",\n" +
                "            \"acqAuthorization\": \"297664\",\n" +
                "            \"acqNumber\": 405,\n" +
                "            \"acqBin\": \"ACQ\",\n" +
                "            \"acqTraceNumber\": 862890,\n" +
                "            \"arn\": \"24245007304103100068043\",\n" +
                "            \"bcId\": 539777,\n" +
                "            \"bcSig\": \"GN0000317A9D928D\",\n" +
                "            \"ccMonth\": 12,\n" +
                "            \"ccNumber\": \"411111****1111\",\n" +
                "            \"ccOwner\": \"cardholder\",\n" +
                "            \"ccType\": " + scheme + ",\n" +
                "            \"ccYear\": 2021,\n" +
                "            \"curCode\": \"" + currency + "\",\n" +
                "            \"demoMode\": \"0\",\n" +
                "            \"groupId\": \"DB_f8ac7-d5ee-4ffa-07eeff4c8"+strdate+ "\",\n" +
                "            \"loginId\": 1,\n" +
                "            \"merchantFunctionId\": \"ywaDPDBlmczR8XXqpHyYH3hwNrR3Ljmg\",\n" +
                "            \"merchantJobId\": \"123456789\",\n" +
                "            \"merchantRequestTime\": \""+strCurrentdate+"\",\n" +
                "            \"terminalType\": \"2\",\n" +
                "            \"tnumber\": \"" + TerminalID + "\",\n" +
                "            \"transAmount\": " + amount + ",\n" +
                "            \"origAmount\": " + amount + ",\n" +
                "            \"transCountryCode\": \"DE\",\n" +
                "            \"transId\": \"any transaction\",\n" +
                "            \"transIpAddr\": \"127.9.9.9\",\n" +
                "            \"transMode\": 40,\n" +
                "            \"transPurchaseTime\":\""+strCurrentdate+"\",\n" +
                "            \"transReference\": \"\",\n" +
                "            \"transRefMode\": 0,\n" +
                "            \"transStatus\": 0,\n" +
                "            \"transTime\": \""+strCurrentdate+"\",\n" +
                "            \"vnumber\": \"" + Merchant_ID + "\",\n" +
                "            \"fxSettlAmount\": " + amount + ",\n" +
                "            \"fxSettlCurCode\": \"" + currency + "\",\n" +
                "            \"fxSettlRate\": 1,\n" +
                "            \"fxAcqAmount\": 1342,\n" +
                "            \"fxAcqCurCode\": \"EUR\",\n" +
                "            \"fxAcqRate\": 1,\n" +
                "            \"fxEurBaseAmount\": 1342,\n" +
                "            \"fxUsdBaseAmount\": 1610,\n" +
                "            \"fxEurBaseRate\": 1,\n" +
                "            \"fxUsdBaseRate\": 1.2,\n" +
                "            \"fxSettlValidityTs\":\""+strCurrentdate+"\",\n" +
                "            \"fxSettlProviderId\": \"4\",\n" +
                "            \"fxUpToDateInd\": \"0\",\n" +
                "            \"fxSolId\": 2,\n" +
                "            \"fxAcqValidityTs\":  \""+strCurrentdate+"\",\n" +
                "            \"fxAcqProviderId\": \"4\",\n" +
                "            \"fxEurBaseValidityTs\":  \""+strCurrentdate+"\",\n" +
                "            \"fxEurBaseProviderId\": \"4\",\n" +
                "            \"fxUsdBaseValidityTs\":  \""+strCurrentdate+"\",\n" +
                "            \"fxUsdBaseProviderId\": \"4\",\n" +
                "            \"cardTypeInd\": \"1\",\n" +
                "            \"classification\": \"N\",\n" +
                "            \"issuerCountry\": \"DE\",\n" +
                "            \"userName\": \"System\",\n" +
                "            \"agentCode\": 34456853,\n" +
                "            \"agentName\": \"Sita Travels\",\n" +
                "            \"airlineCode\": 999,\n" +
                "            \"airlineName\": \"Lufthansa\",\n" +
                "            \"checkDigit\": 9,\n" +
                "            \"flightNumber\": \"7104\",\n" +
                "            \"originAirport\": \"MUC\",\n" +
                "            \"passengerName\": \"Lars Ulrich\",\n" +
                "            \"pnrFileKey\": \"723983\",\n" +
                "            \"ticketNumber\": 625979881,\n" +
                "            \"restricted\": \"1\",\n" +
                "            \"ticketIssueDate\":\"22-12-2023 13:13:05\",\n" +
                "            \"emdId\": 0,\n" +
                "            \"emdTicketNumber\": \"654321\",\n" +
                "            \"procParameters\": \"1=\\\"3\\\",2=\\\"5\\\",4=\\\"012\\\",5=\\\"00\\\",6=\\\"3\\\",7=\\\"1\\\",9=\\\"0\\\",10=\\\"Y6161\\\",11=\\\"M\\\",132=\\\"false\\\",472=\\\"021/17b19579001AG00\\\",506=\\\"N\\\",444=\\\"1\\\",568=\\\"false\\\",567=\\\"" + Instant_flag + "\\\"\",\n" +
                "            \"gatewayType\": \"PECC\",\n" +
                "            \"chiFirstName\": \"ChiFirst\",\n" +
                "            \"chiLastName\": \"ChiLast\",\n" +
                "            \"chiEmail\": \"chi@chimail.com\",\n" +
                "            \"chiPhone\": \"+49(89)1111119\",\n" +
                "            \"chiAddress1\": \"Chi Street\",\n" +
                "            \"chiAddress2\": \"100/A\",\n" +
                "            \"chiCity\": \"Los Angeles\",\n" +
                "            \"chiState\": \"CA\",\n" +
                "            \"chiCountry\": \"US\",\n" +
                "            \"chiZipCode\": \"04431\",\n" +
                "            \"lastUpdateTS\":  \""+strCurrentdate+"\",\n" +
                "            \"transactionSource\": \"Merchant Site\",\n" +
                "            \"iccData\": \"ICC\",\n" +
                "            \"issuerName\": \"WirecardBank\",\n" +
                "            \"sequenceNumber\": \"" + SessionID + "\",\n" +
                "            \"dccAmount\": 100,\n" +
                "            \"dccCurCode\": \"USD\",\n" +
                "            \"dccTransactionId\": \"DCCId\",\n" +
                "            \"dccRate\": 1.2,\n" +
                "            \"dccFxProviderId\": \"DCCFxProvider\",\n" +
                "            \"ccToken\": \"2a0b3c59076d47b98bd35f7d53142070\",\n" +
                "            \"dccProviderId\": \"dccproviderId\",\n" +
                "            \"tenor\": 12,\n" +
                "            \"cycle\": \"M\",\n" +
                "            \"promotionId\": \"10\",\n" +
                "            \"interestRate\": 1.24,\n" +
                "            \"nextAmount\": 100,\n" +
                "            \"cardProgramId\": 1,\n" +
                "            \"receipt\": \"789789123\",\n" +
                "            \"wduuid\": \"0471C9E3FA61461CBB1FE537D795213A\",\n" +
                "            \"hopId\": \"5\",\n" +
                "            \"csdSenderFirstName\": \"CSD1\",\n" +
                "            \"csdSenderLastName\": \"CSD2\",\n" +
                "            \"csdSenderAddress\": \"CSD6\",\n" +
                "            \"csdSenderCity\": \"CSD3\",\n" +
                "            \"csdSenderCountry\": \"CSD4\",\n" +
                "            \"csdSenderState\": \"CSD5\",\n" +
                "            \"csdSenderPostalCode\": \"CSD7\",\n" +
                "            \"csdSenderAccountNumber\": \"CSD9\",\n" +
                "            \"csdSenderFundsSource\": \"CSD10\",\n" +
                "            \"csdReferenceNumber\": \"CSD8\",\n" +
                "            \"csdReceiverFirstName\": \"CSD11\",\n" +
                "            \"csdReceiverLastName\": \"CSD12\",\n" +
                "            \"dcardCardProduct\": \"PRO\",\n" +
                "            \"dcardAcqBinRegion\": \"CAN\",\n" +
                "            \"dcardAcqBinCountry\": \"CAN\",\n" +
                "            \"dcardSchClrDate\": \"" + Session_Date + "\",\n" +
                "            \"dcardSchReconAmount\": 200,\n" +
                "            \"dcardSchReconAmountCurCode\": \"USD\",\n" +
                "            \"dcardSchExchangeRate\": 1.2,\n" +
                "            \"dcardCutoverDate\": \"" + Session_Date + "\",\n" +
                "            \"dcardDiscountAmount\": 250.12,\n" +
                "            \"settlementBarrier\": \""+strCurrentdate+"\"\n" +
                "        },\n" +
                "        \"airlineItinerary\": {\n" +
                "            \"segments\": [\n" +
                "                {\n" +
                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-07eeff4c8"+strdate+ "\",\n" +
                "                    \"segmentId\": 4,\n" +
                "                    \"carrierCode\": \"LH\",\n" +
                "                    \"classOfService\": \"fancy\",\n" +
                "                    \"stopOverCode\": \"1\",\n" +
                "                    \"legDepartureDate\": \""+strCurrentdate+"\",\n" +
                "                    \"destination\": \"Ploske\",\n" +
                "                    \"fareBasis\": \"very fare\",\n" +
                "                    \"origin\": \"MUC-notUsed\",\n" +
                "                    \"flightNumber\": \"flightNumber-123\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        \"txnFees\": {\n" +
                "            \"fees\": [\n" +
                "                {\n" +
                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-07eeff4c8"+strdate+ "\",\n" +
                "                    \"feeTypeId\": \"1\",\n" +
                "                    \"feeAmount\": -11,\n" +
                "                    \"feeCurCode\": \"GBP\",\n" +
                "                    \"settlementAmount\": -11,\n" +
                "                    \"settlementCurrencyCode\": \"EUR\",\n" +
                "                    \"settlementRate\": 1.13981,\n" +
                "                    \"transFeeAmount\": -11,\n" +
                "                    \"transFeeCurrencyCode\": \"EUR\",\n" +
                "                    \"transFeeRate\": 1.13981,\n" +
                "                    \"transFeeAmountHighPrec\": null,\n" +
                "                    \"transFeeAmountHighPrecScale\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-07eeff4c8"+strdate+ "\",\n" +
                "                    \"feeTypeId\": \"2\",\n" +
                "                    \"feeAmount\": 100,\n" +
                "                    \"feeCurCode\": \"EUR\",\n" +
                "                    \"settlementAmount\": 100,\n" +
                "                    \"settlementCurrencyCode\": \"EUR\",\n" +
                "                    \"settlementRate\": 1,\n" +
                "                    \"transFeeAmount\": 100,\n" +
                "                    \"transFeeCurrencyCode\": \"EUR\",\n" +
                "                    \"transFeeRate\": 1,\n" +
                "                    \"transFeeAmountHighPrec\": null,\n" +
                "                    \"transFeeAmountHighPrecScale\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-07eeff4c8"+strdate+ "\",\n" +
                "                    \"feeTypeId\": \"3\",\n" +
                "                    \"feeAmount\": 120,\n" +
                "                    \"feeCurCode\": \"USD\",\n" +
                "                    \"settlementAmount\": 84,\n" +
                "                    \"settlementCurrencyCode\": \"EUR\",\n" +
                "                    \"settlementRate\": 0.70124752,\n" +
                "                    \"transFeeAmount\": 84,\n" +
                "                    \"transFeeCurrencyCode\": \"EUR\",\n" +
                "                    \"transFeeRate\": 0.70124752,\n" +
                "                    \"transFeeAmountHighPrec\": 840,\n" +
                "                    \"transFeeAmountHighPrecScale\": 3\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    }\n" +
                "}";

        ObjectMapper objectMapper2 = new ObjectMapper();
        jsonNode2 = objectMapper2.readTree(strMcpayload);

        // String strGuwid = node.get("guwid[1]").asText();
        //  System.out.println(strGuwid);
        Map<String, Object> mapping = new ObjectMapper().readValue(strMcpayload, LinkedHashMap.class);
        Map<String, String> map2 = new HashMap<>();
        map2 = (Map<String, String>) ((Map) mapping.get("payload")).get("peTransaction");
        guwid = map2.get("guwid");
        System.out.println("Transaction Guwid = " + guwid);

    }




//    public static void winscp() throws JSchException, SftpException {
//
//            JSch jsch=new JSch();
//
//            jsch.addIdentity("C:\\Users\\mukesh.a\\IdeaProjects\\Totalization_Auto\\src\\main\\resources\\totalization_report 2.ppk");
//            Session session=jsch.getSession("sftp-qa.getnet.diq","ISM_totalisation_report",22);
//            Properties config=new Properties();
//            config.put("StrictHostKeyChecking","no");
//            session.setConfig(config);
//            session.connect();
//
//            ChannelSftp sftpChannel= (ChannelSftp) session.openChannel("sftp");
//            sftpChannel.connect();
//
////            InputStream inputStream= sftpChannel.get("/fromISM_totalisation_report/new");
////            byte[]
//
//
//
//    }



//    public static void domesticTransaction(String scheme, String amount, String currency, String Merchant_ID, String TerminalID, String SessionID,String Session_Date) throws org.json.simple.parser.ParseException, IOException {
//
//        String strMcpayload = "{\n" +
//                "    \"headers\": {},\n" +
//                "    \"payload\": {\n" +
//                "        \"peTransaction\": {\n" +
//                "            \"guwid\": \"DB_f8ac7-d5ee-4ffa-8feb-07eeff4b7cd7" + strdate + "\",\n" +
//                "            \"acqAuthorization\": \"297664\",\n" +
//                "            \"acqNumber\": 405,\n" +
//                "            \"acqBin\": \"ACQ\",\n" +
//                "            \"acqTraceNumber\": 862890,\n" +
//                "            \"arn\": \"24245007304103100068043\",\n" +
//                "            \"bcId\": 567336,\n" +
//                "            \"bcSig\": \"GN0000317A9D928D\",\n" +
//                "            \"ccMonth\": 12,\n" +
//                "            \"ccNumber\": \"411111****1111\",\n" +
//                "            \"ccOwner\": \"cardholder\",\n" +
//                "            \"ccType\": " + scheme + ",\n" +
//                "            \"ccYear\": 2021,\n" +
//                "            \"curCode\": \"" + currency + "\",\n" +
//                "            \"demoMode\": \"0\",\n" +
//                "            \"groupId\": \"DB_f8ac7-d5ee-4ffa-8feb-07eeff4b7cd7" + strdate + "\",\n" +
//                "            \"loginId\": 1,\n" +
//                "            \"merchantFunctionId\": \"ywaDPDBlmczR8XXqpHyYH3hwNrR3Ljmg\",\n" +
//                "            \"merchantJobId\": \"123456789\",\n" +
//                "            \"merchantRequestTime\": \"01-01-2024 13:13:05\",\n" +
//                "            \"terminalType\": \"2\",\n" +
//                "            \"tnumber\": \"" + TerminalID + "\",\n" +
//                "            \"transAmount\": " + amount + ",\n" +
//                "            \"origAmount\": " + amount + ",\n" +
//                "            \"transCountryCode\": \"DE\",\n" +
//                "            \"transId\": \"any transaction\",\n" +
//                "            \"transIpAddr\": \"127.9.9.9\",\n" +
//                "            \"transMode\": 40,\n" +
//                "            \"transPurchaseTime\":\"01-01-2024 13:13:05\",\n" +
//                "            \"transReference\": \"\",\n" +
//                "            \"transRefMode\": 0,\n" +
//                "            \"transStatus\": 0,\n" +
//                "            \"transTime\": \"01-01-2024 13:13:05\",\n" +
//                "            \"vnumber\": \"" + Merchant_ID + "\",\n" +
//                "            \"fxSettlAmount\": " + amount + ",\n" +
//                "            \"fxSettlCurCode\": \"" + currency + "\",\n" +
//                "            \"fxSettlRate\": 1,\n" +
//                "            \"fxAcqAmount\": 1342,\n" +
//                "            \"fxAcqCurCode\": \"EUR\",\n" +
//                "            \"fxAcqRate\": 1,\n" +
//                "            \"fxEurBaseAmount\": 1342,\n" +
//                "            \"fxUsdBaseAmount\": 1610,\n" +
//                "            \"fxEurBaseRate\": 1,\n" +
//                "            \"fxUsdBaseRate\": 1.2,\n" +
//                "            \"fxSettlValidityTs\": \"01-01-2024 13:13:05\",\n" +
//                "            \"fxSettlProviderId\": \"4\",\n" +
//                "            \"fxUpToDateInd\": \"0\",\n" +
//                "            \"fxSolId\": 2,\n" +
//                "            \"fxAcqValidityTs\": \"01-01-2024 13:13:05\",\n" +
//                "            \"fxAcqProviderId\": \"4\",\n" +
//                "            \"fxEurBaseValidityTs\": \"01-01-2024 13:13:05\",\n" +
//                "            \"fxEurBaseProviderId\": \"4\",\n" +
//                "            \"fxUsdBaseValidityTs\": \"01-01-2024 13:13:05\",\n" +
//                "            \"fxUsdBaseProviderId\": \"4\",\n" +
//                "            \"cardTypeInd\": \"1\",\n" +
//                "            \"classification\": \"N\",\n" +
//                "            \"issuerCountry\": \"DE\",\n" +
//                "            \"userName\": \"System\",\n" +
//                "            \"agentCode\": 34456853,\n" +
//                "            \"agentName\": \"Sita Travels\",\n" +
//                "            \"airlineCode\": 999,\n" +
//                "            \"airlineName\": \"Lufthansa\",\n" +
//                "            \"checkDigit\": 9,\n" +
//                "            \"flightNumber\": \"7104\",\n" +
//                "            \"originAirport\": \"MUC\",\n" +
//                "            \"passengerName\": \"Lars Ulrich\",\n" +
//                "            \"pnrFileKey\": \"723983\",\n" +
//                "            \"ticketNumber\": 625979881,\n" +
//                "            \"restricted\": \"1\",\n" +
//                "            \"ticketIssueDate\":\"21-12-2023 13:13:05\",\n" +
//                "            \"emdId\": 0,\n" +
//                "            \"emdTicketNumber\": \"654321\",\n" +
//                "            \"procParameters\": \"1=\\\"3\\\",2=\\\"5\\\",4=\\\"012\\\",5=\\\"00\\\",6=\\\"3\\\",7=\\\"1\\\",9=\\\"0\\\",10=\\\"Y6161\\\",11=\\\"M\\\",132=\\\"false\\\",472=\\\"021/17b19579001AG00\\\",506=\\\"N\\\",444=\\\"1\\\",568=\\\"true\\\",567=\\\"true\\\"\",\n" +
//                "            \"gatewayType\": \"PECC\",\n" +
//                "            \"chiFirstName\": \"ChiFirst\",\n" +
//                "            \"chiLastName\": \"ChiLast\",\n" +
//                "            \"chiEmail\": \"chi@chimail.com\",\n" +
//                "            \"chiPhone\": \"+49(89)1111119\",\n" +
//                "            \"chiAddress1\": \"Chi Street\",\n" +
//                "            \"chiAddress2\": \"100/A\",\n" +
//                "            \"chiCity\": \"Los Angeles\",\n" +
//                "            \"chiState\": \"CA\",\n" +
//                "            \"chiCountry\": \"US\",\n" +
//                "            \"chiZipCode\": \"04431\",\n" +
//                "            \"lastUpdateTS\": \"01-01-2024 13:13:05\",\n" +
//                "            \"transactionSource\": \"Merchant Site\",\n" +
//                "            \"iccData\": \"ICC\",\n" +
//                "            \"issuerName\": \"WirecardBank\",\n" +
//                "            \"sequenceNumber\": \"" + SessionID + "\",\n" +
//                "            \"dccAmount\": 100,\n" +
//                "            \"dccCurCode\": \"USD\",\n" +
//                "            \"dccTransactionId\": \"DCCId\",\n" +
//                "            \"dccRate\": 1.2,\n" +
//                "            \"dccFxProviderId\": \"DCCFxProvider\",\n" +
//                "            \"ccToken\": \"2a0b3c59076d47b98bd35f7d53142070\",\n" +
//                "            \"dccProviderId\": \"dccproviderId\",\n" +
//                "            \"tenor\": 12,\n" +
//                "            \"cycle\": \"M\",\n" +
//                "            \"promotionId\": \"10\",\n" +
//                "            \"interestRate\": 1.24,\n" +
//                "            \"nextAmount\": 100,\n" +
//                "            \"cardProgramId\": 1,\n" +
//                "            \"receipt\": \"789789123\",\n" +
//                "            \"wduuid\": \"0471C9E3FA61461CBB1FE537D795213A\",\n" +
//                "            \"hopId\": \"5\",\n" +
//                "            \"csdSenderFirstName\": \"CSD1\",\n" +
//                "            \"csdSenderLastName\": \"CSD2\",\n" +
//                "            \"csdSenderAddress\": \"CSD6\",\n" +
//                "            \"csdSenderCity\": \"CSD3\",\n" +
//                "            \"csdSenderCountry\": \"CSD4\",\n" +
//                "            \"csdSenderState\": \"CSD5\",\n" +
//                "            \"csdSenderPostalCode\": \"CSD7\",\n" +
//                "            \"csdSenderAccountNumber\": \"CSD9\",\n" +
//                "            \"csdSenderFundsSource\": \"CSD10\",\n" +
//                "            \"csdReferenceNumber\": \"CSD8\",\n" +
//                "            \"csdReceiverFirstName\": \"CSD11\",\n" +
//                "            \"csdReceiverLastName\": \"CSD12\",\n" +
//                "            \"dcardCardProduct\": \"PRO\",\n" +
//                "            \"dcardAcqBinRegion\": \"CAN\",\n" +
//                "            \"dcardAcqBinCountry\": \"CAN\",\n" +
//                "            \"dcardSchClrDate\": \"" + Session_Date + "\",\n" +
//                "            \"dcardSchReconAmount\": 200,\n" +
//                "            \"dcardSchReconAmountCurCode\": \"USD\",\n" +
//                "            \"dcardSchExchangeRate\": 1.2,\n" +
//                "            \"dcardCutoverDate\": \"" + Session_Date + "\",\n" +
//                "            \"dcardDiscountAmount\": 250.12,\n" +
//                "            \"settlementBarrier\": \"01-01-2024 13:13:05\"\n" +
//                "        },\n" +
//                "        \"airlineItinerary\": {\n" +
//                "            \"segments\": [\n" +
//                "                {\n" +
//                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-8feb-07eeff4b7cd7" + strdate + "\",\n" +
//                "                    \"segmentId\": 4,\n" +
//                "                    \"carrierCode\": \"LH\",\n" +
//                "                    \"classOfService\": \"fancy\",\n" +
//                "                    \"stopOverCode\": \"1\",\n" +
//                "                    \"legDepartureDate\": \"01-01-2024 13:13:05\",\n" +
//                "                    \"destination\": \"Ploske\",\n" +
//                "                    \"fareBasis\": \"very fare\",\n" +
//                "                    \"origin\": \"MUC-notUsed\",\n" +
//                "                    \"flightNumber\": \"flightNumber-123\"\n" +
//                "                }\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        \"txnFees\": {\n" +
//                "            \"fees\": [\n" +
//                "                {\n" +
//                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-8feb-07eeff4b7cd7" + strdate + "\",\n" +
//                "                    \"feeTypeId\": \"1\",\n" +
//                "                    \"feeAmount\": -11,\n" +
//                "                    \"feeCurCode\": \"GBP\",\n" +
//                "                    \"settlementAmount\": -11,\n" +
//                "                    \"settlementCurrencyCode\": \"EUR\",\n" +
//                "                    \"settlementRate\": 1.13981,\n" +
//                "                    \"transFeeAmount\": -11,\n" +
//                "                    \"transFeeCurrencyCode\": \"EUR\",\n" +
//                "                    \"transFeeRate\": 1.13981,\n" +
//                "                    \"transFeeAmountHighPrec\": null,\n" +
//                "                    \"transFeeAmountHighPrecScale\": null\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-8feb-07eeff4b7cd7" + strdate + "\",\n" +
//                "                    \"feeTypeId\": \"2\",\n" +
//                "                    \"feeAmount\": 100,\n" +
//                "                    \"feeCurCode\": \"EUR\",\n" +
//                "                    \"settlementAmount\": 100,\n" +
//                "                    \"settlementCurrencyCode\": \"EUR\",\n" +
//                "                    \"settlementRate\": 1,\n" +
//                "                    \"transFeeAmount\": 100,\n" +
//                "                    \"transFeeCurrencyCode\": \"EUR\",\n" +
//                "                    \"transFeeRate\": 1,\n" +
//                "                    \"transFeeAmountHighPrec\": null,\n" +
//                "                    \"transFeeAmountHighPrecScale\": null\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-8feb-07eeff4b7cd7" + strdate + "\",\n" +
//                "                    \"feeTypeId\": \"3\",\n" +
//                "                    \"feeAmount\": 120,\n" +
//                "                    \"feeCurCode\": \"USD\",\n" +
//                "                    \"settlementAmount\": 84,\n" +
//                "                    \"settlementCurrencyCode\": \"EUR\",\n" +
//                "                    \"settlementRate\": 0.70124752,\n" +
//                "                    \"transFeeAmount\": 84,\n" +
//                "                    \"transFeeCurrencyCode\": \"EUR\",\n" +
//                "                    \"transFeeRate\": 0.70124752,\n" +
//                "                    \"transFeeAmountHighPrec\": 840,\n" +
//                "                    \"transFeeAmountHighPrecScale\": 3\n" +
//                "                }\n" +
//                "            ]\n" +
//                "        }\n" +
//                "    }\n" +
//                "}";
//
//        ObjectMapper objectMapper2 = new ObjectMapper();
//        jsonNode2 = objectMapper2.readTree(strMcpayload);
//
//        // String strGuwid = node.get("guwid[1]").asText();
//        //  System.out.println(strGuwid);
//        Map<String, Object> mapping = new ObjectMapper().readValue(strMcpayload, LinkedHashMap.class);
//        Map<String, String> map2 = new HashMap<>();
//        map2 = (Map<String, String>) ((Map) mapping.get("payload")).get("peTransaction");
//        guwid = map2.get("guwid");
//        System.out.println("Transaction Guwid = " + guwid);
//
//    }
//
//    public static void internationalTransaction(String scheme, String amount, String currency, String Merchant_ID, String TerminalID, String SessionID,String Session_Date) throws org.json.simple.parser.ParseException, IOException {
//
//        String strMcpayload = "{\n" +
//                "    \"headers\": {},\n" +
//                "    \"payload\": {\n" +
//                "        \"peTransaction\": {\n" +
//                "            \"guwid\": \"DB_f8ac7-d5ee-4ffa-8feb-07eeff4b7cd7" + strdate + "\",\n" +
//                "            \"acqAuthorization\": \"297664\",\n" +
//                "            \"acqNumber\": 405,\n" +
//                "            \"acqBin\": \"ACQ\",\n" +
//                "            \"acqTraceNumber\": 862890,\n" +
//                "            \"arn\": \"24245007304103100068043\",\n" +
//                "            \"bcId\": 539777,\n" +
//                "            \"bcSig\": \"GN0000317A9D928D\",\n" +
//                "            \"ccMonth\": 12,\n" +
//                "            \"ccNumber\": \"411111****1111\",\n" +
//                "            \"ccOwner\": \"cardholder\",\n" +
//                "            \"ccType\": " + scheme + ",\n" +
//                "            \"ccYear\": 2021,\n" +
//                "            \"curCode\": \"" + currency + "\",\n" +
//                "            \"demoMode\": \"0\",\n" +
//                "            \"groupId\": \"DB_f8ac7-d5ee-4ffa-8feb-07eeff4b7cd7" + strdate + "\",\n" +
//                "            \"loginId\": 1,\n" +
//                "            \"merchantFunctionId\": \"ywaDPDBlmczR8XXqpHyYH3hwNrR3Ljmg\",\n" +
//                "            \"merchantJobId\": \"123456789\",\n" +
//                "            \"merchantRequestTime\": \"01-01-2024 13:13:05\",\n" +
//                "            \"terminalType\": \"2\",\n" +
//                "            \"tnumber\": \"" + TerminalID + "\",\n" +
//                "            \"transAmount\": " + amount + ",\n" +
//                "            \"origAmount\": " + amount + ",\n" +
//                "            \"transCountryCode\": \"DE\",\n" +
//                "            \"transId\": \"any transaction\",\n" +
//                "            \"transIpAddr\": \"127.9.9.9\",\n" +
//                "            \"transMode\": 40,\n" +
//                "            \"transPurchaseTime\":\"01-01-2024 13:13:05\",\n" +
//                "            \"transReference\": \"\",\n" +
//                "            \"transRefMode\": 0,\n" +
//                "            \"transStatus\": 0,\n" +
//                "            \"transTime\": \"01-01-2024 13:13:05\",\n" +
//                "            \"vnumber\": \"" + Merchant_ID + "\",\n" +
//                "            \"fxSettlAmount\": " + amount + ",\n" +
//                "            \"fxSettlCurCode\": \"" + currency + "\",\n" +
//                "            \"fxSettlRate\": 1,\n" +
//                "            \"fxAcqAmount\": 1342,\n" +
//                "            \"fxAcqCurCode\": \"EUR\",\n" +
//                "            \"fxAcqRate\": 1,\n" +
//                "            \"fxEurBaseAmount\": 1342,\n" +
//                "            \"fxUsdBaseAmount\": 1610,\n" +
//                "            \"fxEurBaseRate\": 1,\n" +
//                "            \"fxUsdBaseRate\": 1.2,\n" +
//                "            \"fxSettlValidityTs\":\"01-01-2024 13:13:05\",\n" +
//                "            \"fxSettlProviderId\": \"4\",\n" +
//                "            \"fxUpToDateInd\": \"0\",\n" +
//                "            \"fxSolId\": 2,\n" +
//                "            \"fxAcqValidityTs\":  \"01-01-2024 13:13:05\",\n" +
//                "            \"fxAcqProviderId\": \"4\",\n" +
//                "            \"fxEurBaseValidityTs\":  \"01-01-2024 13:13:05\",\n" +
//                "            \"fxEurBaseProviderId\": \"4\",\n" +
//                "            \"fxUsdBaseValidityTs\":  \"01-01-2024 13:13:05\",\n" +
//                "            \"fxUsdBaseProviderId\": \"4\",\n" +
//                "            \"cardTypeInd\": \"1\",\n" +
//                "            \"classification\": \"N\",\n" +
//                "            \"issuerCountry\": \"DE\",\n" +
//                "            \"userName\": \"System\",\n" +
//                "            \"agentCode\": 34456853,\n" +
//                "            \"agentName\": \"Sita Travels\",\n" +
//                "            \"airlineCode\": 999,\n" +
//                "            \"airlineName\": \"Lufthansa\",\n" +
//                "            \"checkDigit\": 9,\n" +
//                "            \"flightNumber\": \"7104\",\n" +
//                "            \"originAirport\": \"MUC\",\n" +
//                "            \"passengerName\": \"Lars Ulrich\",\n" +
//                "            \"pnrFileKey\": \"723983\",\n" +
//                "            \"ticketNumber\": 625979881,\n" +
//                "            \"restricted\": \"1\",\n" +
//                "            \"ticketIssueDate\":\"21-12-2023 13:13:05\",\n" +
//                "            \"emdId\": 0,\n" +
//                "            \"emdTicketNumber\": \"654321\",\n" +
//                "            \"procParameters\": \"1=\\\"3\\\",2=\\\"5\\\",4=\\\"012\\\",5=\\\"00\\\",6=\\\"3\\\",7=\\\"1\\\",9=\\\"0\\\",10=\\\"Y6161\\\",11=\\\"M\\\",132=\\\"false\\\",472=\\\"021/17b19579001AG00\\\",506=\\\"N\\\",444=\\\"1\\\",568=\\\"false\\\",567=\\\"true\\\"\",\n" +
//                "            \"gatewayType\": \"PECC\",\n" +
//                "            \"chiFirstName\": \"ChiFirst\",\n" +
//                "            \"chiLastName\": \"ChiLast\",\n" +
//                "            \"chiEmail\": \"chi@chimail.com\",\n" +
//                "            \"chiPhone\": \"+49(89)1111119\",\n" +
//                "            \"chiAddress1\": \"Chi Street\",\n" +
//                "            \"chiAddress2\": \"100/A\",\n" +
//                "            \"chiCity\": \"Los Angeles\",\n" +
//                "            \"chiState\": \"CA\",\n" +
//                "            \"chiCountry\": \"US\",\n" +
//                "            \"chiZipCode\": \"04431\",\n" +
//                "            \"lastUpdateTS\":  \"01-01-2024 13:13:05\",\n" +
//                "            \"transactionSource\": \"Merchant Site\",\n" +
//                "            \"iccData\": \"ICC\",\n" +
//                "            \"issuerName\": \"WirecardBank\",\n" +
//                "            \"sequenceNumber\": \"" + SessionID + "\",\n" +
//                "            \"dccAmount\": 100,\n" +
//                "            \"dccCurCode\": \"USD\",\n" +
//                "            \"dccTransactionId\": \"DCCId\",\n" +
//                "            \"dccRate\": 1.2,\n" +
//                "            \"dccFxProviderId\": \"DCCFxProvider\",\n" +
//                "            \"ccToken\": \"2a0b3c59076d47b98bd35f7d53142070\",\n" +
//                "            \"dccProviderId\": \"dccproviderId\",\n" +
//                "            \"tenor\": 12,\n" +
//                "            \"cycle\": \"M\",\n" +
//                "            \"promotionId\": \"10\",\n" +
//                "            \"interestRate\": 1.24,\n" +
//                "            \"nextAmount\": 100,\n" +
//                "            \"cardProgramId\": 1,\n" +
//                "            \"receipt\": \"789789123\",\n" +
//                "            \"wduuid\": \"0471C9E3FA61461CBB1FE537D795213A\",\n" +
//                "            \"hopId\": \"5\",\n" +
//                "            \"csdSenderFirstName\": \"CSD1\",\n" +
//                "            \"csdSenderLastName\": \"CSD2\",\n" +
//                "            \"csdSenderAddress\": \"CSD6\",\n" +
//                "            \"csdSenderCity\": \"CSD3\",\n" +
//                "            \"csdSenderCountry\": \"CSD4\",\n" +
//                "            \"csdSenderState\": \"CSD5\",\n" +
//                "            \"csdSenderPostalCode\": \"CSD7\",\n" +
//                "            \"csdSenderAccountNumber\": \"CSD9\",\n" +
//                "            \"csdSenderFundsSource\": \"CSD10\",\n" +
//                "            \"csdReferenceNumber\": \"CSD8\",\n" +
//                "            \"csdReceiverFirstName\": \"CSD11\",\n" +
//                "            \"csdReceiverLastName\": \"CSD12\",\n" +
//                "            \"dcardCardProduct\": \"PRO\",\n" +
//                "            \"dcardAcqBinRegion\": \"CAN\",\n" +
//                "            \"dcardAcqBinCountry\": \"CAN\",\n" +
//                "            \"dcardSchClrDate\": \"" + Session_Date + "\",\n" +
//                "            \"dcardSchReconAmount\": 200,\n" +
//                "            \"dcardSchReconAmountCurCode\": \"USD\",\n" +
//                "            \"dcardSchExchangeRate\": 1.2,\n" +
//                "            \"dcardCutoverDate\": \"" + Session_Date + "\",\n" +
//                "            \"dcardDiscountAmount\": 250.12,\n" +
//                "            \"settlementBarrier\": \"01-01-2024 13:13:05\"\n" +
//                "        },\n" +
//                "        \"airlineItinerary\": {\n" +
//                "            \"segments\": [\n" +
//                "                {\n" +
//                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-8feb-07eeff4b7cd7" + strdate + "\",\n" +
//                "                    \"segmentId\": 4,\n" +
//                "                    \"carrierCode\": \"LH\",\n" +
//                "                    \"classOfService\": \"fancy\",\n" +
//                "                    \"stopOverCode\": \"1\",\n" +
//                "                    \"legDepartureDate\":  \"01-01-2024 13:13:05\",\n" +
//                "                    \"destination\": \"Ploske\",\n" +
//                "                    \"fareBasis\": \"very fare\",\n" +
//                "                    \"origin\": \"MUC-notUsed\",\n" +
//                "                    \"flightNumber\": \"flightNumber-123\"\n" +
//                "                }\n" +
//                "            ]\n" +
//                "        },\n" +
//                "        \"txnFees\": {\n" +
//                "            \"fees\": [\n" +
//                "                {\n" +
//                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-8feb-07eeff4b7cd7" + strdate + "\",\n" +
//                "                    \"feeTypeId\": \"1\",\n" +
//                "                    \"feeAmount\": -11,\n" +
//                "                    \"feeCurCode\": \"GBP\",\n" +
//                "                    \"settlementAmount\": -11,\n" +
//                "                    \"settlementCurrencyCode\": \"EUR\",\n" +
//                "                    \"settlementRate\": 1.13981,\n" +
//                "                    \"transFeeAmount\": -11,\n" +
//                "                    \"transFeeCurrencyCode\": \"EUR\",\n" +
//                "                    \"transFeeRate\": 1.13981,\n" +
//                "                    \"transFeeAmountHighPrec\": null,\n" +
//                "                    \"transFeeAmountHighPrecScale\": null\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-8feb-07eeff4b7cd7" + strdate + "\",\n" +
//                "                    \"feeTypeId\": \"2\",\n" +
//                "                    \"feeAmount\": 100,\n" +
//                "                    \"feeCurCode\": \"EUR\",\n" +
//                "                    \"settlementAmount\": 100,\n" +
//                "                    \"settlementCurrencyCode\": \"EUR\",\n" +
//                "                    \"settlementRate\": 1,\n" +
//                "                    \"transFeeAmount\": 100,\n" +
//                "                    \"transFeeCurrencyCode\": \"EUR\",\n" +
//                "                    \"transFeeRate\": 1,\n" +
//                "                    \"transFeeAmountHighPrec\": null,\n" +
//                "                    \"transFeeAmountHighPrecScale\": null\n" +
//                "                },\n" +
//                "                {\n" +
//                "                    \"guwid\": \"DB_f8ac7-d5ee-4ffa-8feb-07eeff4b7cd7" + strdate + "\",\n" +
//                "                    \"feeTypeId\": \"3\",\n" +
//                "                    \"feeAmount\": 120,\n" +
//                "                    \"feeCurCode\": \"USD\",\n" +
//                "                    \"settlementAmount\": 84,\n" +
//                "                    \"settlementCurrencyCode\": \"EUR\",\n" +
//                "                    \"settlementRate\": 0.70124752,\n" +
//                "                    \"transFeeAmount\": 84,\n" +
//                "                    \"transFeeCurrencyCode\": \"EUR\",\n" +
//                "                    \"transFeeRate\": 0.70124752,\n" +
//                "                    \"transFeeAmountHighPrec\": 840,\n" +
//                "                    \"transFeeAmountHighPrecScale\": 3\n" +
//                "                }\n" +
//                "            ]\n" +
//                "        }\n" +
//                "    }\n" +
//                "}";
//
//        ObjectMapper objectMapper2 = new ObjectMapper();
//        jsonNode2 = objectMapper2.readTree(strMcpayload);
//
//        // String strGuwid = node.get("guwid[1]").asText();
//        //  System.out.println(strGuwid);
//        Map<String, Object> mapping = new ObjectMapper().readValue(strMcpayload, LinkedHashMap.class);
//        Map<String, String> map2 = new HashMap<>();
//        map2 = (Map<String, String>) ((Map) mapping.get("payload")).get("peTransaction");
//        guwid = map2.get("guwid");
//        System.out.println("Transaction Guwid = " + guwid);
//
//    }


}