package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jsons.PayloadStore;
import org.json.JSONObject;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;

public class DBConnection {

    public static Blob status2;
    public static String status;

    public static String value="";
    public static String message;

    public static void dbCheck(String table  ) {

        try {
            // Load the Oracle JDBC driver

            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Create a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//qn-tx-or-scan.wirecard.diq:1521/txdbs_qa.wirecard", "ISM_APP", "InstantSettlementModule@123");

            // Create a statement object
            Statement stmt = conn.createStatement();

            // Execute a SQL command and get a result set
            ResultSet rs = stmt.executeQuery("Select * from "+table+" where GUWID_ID ='"+PayloadStore.guwid+"'");

            // Get the index of the "name" column by name
            int nameColumnIndex = rs.findColumn("STATUS");

            // Loop through the result set and retrieve data by column name
            while (rs.next()) {
                status = rs.getString(nameColumnIndex);

            }
            //  System.out.println("DB status="+status);
            // Close the result set, statement, and connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }

    }

    public static int dbCheck_totalAmount(){

        int intValue=0;
        int amount=0;
        try {
            // Load the Oracle JDBC driver

            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Create a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//qn-tx-or-scan.wirecard.diq:1521/txdbs_qa.wirecard", "ISM_APP", "InstantSettlementModule@123");

            // Create a statement object
            Statement stmt = conn.createStatement();

            // Execute a SQL command and get a result set
            ResultSet rs = stmt.executeQuery("Select * from "+"TOTALIZATION_STORE"+" where GUWID_ID ='"+PayloadStore.guwid+"'");

//            String columnName="";
            // Get the index of the "name" column by name
            int nameColumnIndex = rs.findColumn("TOTALIZATION_ID");

            // Loop through the result set and retrieve data by column name
            while (rs.next()) {
                 value = rs.getString(nameColumnIndex);

            }
            System.out.println(value);
            rs.close();
            stmt.close();

            Statement stmt2 = conn.createStatement();
            Thread.sleep(5000);
            ResultSet rs2  = stmt2.executeQuery("Select * from "+"TOTALIZATION_TRANSACTION"+" where ID ='"+value+"'");
            int nameColumnIndex2 = rs2.findColumn("SETTLEMENT_AMOUNT");

            while (rs2.next()) {
                amount=rs2.getInt(nameColumnIndex2);

            }
            System.out.println(amount);
            //  System.out.println("DB status="+status);
            // Close the result set, statement, and connection
            rs2.close();
            stmt2.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return amount;
    }

    public static int dbChecknetamount() {


        int intValue=0;
        int amount=0;
        try {
            // Load the Oracle JDBC driver

            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Create a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//qn-tx-or-scan.wirecard.diq:1521/txdbs_qa.wirecard", "ISM_APP", "InstantSettlementModule@123");

            // Create a statement object
            Statement stmt = conn.createStatement();

            // Execute a SQL command and get a result set
            ResultSet rs = stmt.executeQuery("Select * from "+"TOTALIZATION_STORE"+" where GUWID_ID ='"+PayloadStore.guwid+"'");


//            String columnName="";
            // Get the index of the "name" column by name
            int nameColumnIndex = rs.findColumn("TOTALIZATION_ID");

            // Loop through the result set and retrieve data by column name
            while (rs.next()) {
                value = rs.getString(nameColumnIndex);

            }
            System.out.println(value);
            rs.close();
            stmt.close();

            Statement stmt2 = conn.createStatement();
            Thread.sleep(5000);
            ResultSet rs2  = stmt2.executeQuery("Select * from "+"TOTALIZATION_TRANSACTION"+" where ID ='"+value+"'");
            int nameColumnIndex2 = rs2.findColumn("SETTLEMENT_AMOUNT");

            while (rs2.next()) {
                amount=rs2.getInt(nameColumnIndex2);
            }
            System.out.println(amount);
            //  System.out.println("DB status="+status);
            // Close the result set, statement, and connection
            rs2.close();
            stmt2.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return amount;
    }

    public static int dbCheckdiscountamount() {


        int intValue=0;
        int amount=0;
        try {
            // Load the Oracle JDBC driver

            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Create a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//qn-tx-or-scan.wirecard.diq:1521/txdbs_qa.wirecard", "ISM_APP", "InstantSettlementModule@123");

            // Create a statement object
            Statement stmt = conn.createStatement();

            // Execute a SQL command and get a result set
            ResultSet rs = stmt.executeQuery("Select * from "+"TOTALIZATION_STORE"+" where GUWID_ID ='"+PayloadStore.guwid+"'");
//            String columnName="";
            // Get the index of the "name" column by name
            int nameColumnIndex = rs.findColumn("TOTALIZATION_ID");

            // Loop through the result set and retrieve data by column name
            while (rs.next()) {
                value = rs.getString(nameColumnIndex);

            }
            System.out.println(value);
            rs.close();
            stmt.close();

            Statement stmt2 = conn.createStatement();
            Thread.sleep(5000);
            ResultSet rs2  = stmt2.executeQuery("Select * from "+"TOTALIZATION_TRANSACTION"+" where ID ='"+value+"'");
            int nameColumnIndex2 = rs2.findColumn("TOTAL_PAYOUT_AMOUNT");

            while (rs2.next()) {
                amount=rs2.getInt(nameColumnIndex2);

            }
            System.out.println(amount);
            //  System.out.println("DB status="+status);
            // Close the result set, statement, and connection
            rs2.close();
            stmt2.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return amount;
    }


    public static boolean dbCheck_OutboundMessage() {

        boolean allValuesfound=true;

        try {
            // Load the Oracle JDBC driver

            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Create a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//qn-tx-or-scan.wirecard.diq:1521/txdbs_qa.wirecard", "ISM_APP", "InstantSettlementModule@123");

            // Create a statement object
            Statement stmt = conn.createStatement();

            // Execute a SQL command and get a result set
            ResultSet rs = stmt.executeQuery("Select * from "+"TOTALIZATION_STORE"+" where GUWID_ID ='"+PayloadStore.guwid+"'");
//
            // Get the index of the "name" column by name
            int nameColumnIndex = rs.findColumn("TOTALIZATION_ID");
            while (rs.next()) {
                value = rs.getString(nameColumnIndex);
            }
            System.out.println(value);
            rs.close();
            stmt.close();
            Statement stmt2 = conn.createStatement();
            Thread.sleep(5000);

            String[] valueToSearch={"bcSignature","comments","discountFees","amount","currency",
                                    "minorUnits","instantPayoutFlag", "merchantId","netPayout",
                                    "currency", "minorUnits","sessionDate","sessionId","totalizationId",
                                    "turnoverVolume","currency","minorUnits","status"};
            ResultSet rs2  = stmt2.executeQuery("Select * from "+"ISM_PAYLOAD_STORE"+" where ID ='"+value+"'");

            if(rs2.next()){
                Blob blob=rs2.getBlob("CODA_OUTBOUND_PAYLOAD");
                byte[] blobBytes= blob.getBytes(1,(int)blob.length());
                String blobText=new String(blobBytes);

//                boolean allValuesfound=true;
                for(String values:valueToSearch){
                    if(!blobText.contains(values)){
                        allValuesfound=false;
                        System.out.print(values +"not found in the BLOB message");
                        break;
                    }
                }
                if(allValuesfound){
                    System.out.println("All values found in the BLOB message!");
                }
                else{
                    System.out.println("No record found with the specified ID.");
                }
            }

            // Close the result set, statement, and connection
            rs2.close();
            stmt2.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return allValuesfound;
    }

    public static boolean dbCheck_InboundMessage() {

        boolean allValuesfound=true;

        try {
            // Load the Oracle JDBC driver

            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Create a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//qn-tx-or-scan.wirecard.diq:1521/txdbs_qa.wirecard", "ISM_APP", "InstantSettlementModule@123");

            // Create a statement object
            Statement stmt = conn.createStatement();

            // Execute a SQL command and get a result set
            ResultSet rs = stmt.executeQuery("Select * from "+"TOTALIZATION_STORE"+" where GUWID_ID ='"+PayloadStore.guwid+"'");
//
            // Get the index of the "name" column by name
            int nameColumnIndex = rs.findColumn("TOTALIZATION_ID");
            while (rs.next()) {
                value = rs.getString(nameColumnIndex);
            }
            System.out.println(value);
            rs.close();
            stmt.close();
            Statement stmt2 = conn.createStatement();
            Thread.sleep(5000);

            ResultSet rs2  = stmt2.executeQuery("Select * from "+"ISM_PAYLOAD_STORE"+" where ID ='"+value+"'");

            String  nameColumnIndex2 = String.valueOf(rs.findColumn("CODA_INBOUND_PAYLOAD"));
            if(rs2.next()){
                Blob blob=rs2.getBlob("CODA_INBOUND_PAYLOAD");
                byte[] blobBytes= blob.getBytes(1,(int)blob.length());
                String blobText=new String(blobBytes);

//                boolean allValuesfound=true;
//                for(String values:valueToSearch){
//                    if(!blobText.contains(values)){
//                        allValuesfound=false;
//                        System.out.print(values +"not found in the BLOB message");
//                        break;
//                    }
//                }
                if(allValuesfound){
                    System.out.println("All values found in the BLOB message!");
                }
                else{
                    System.out.println("No record found with the specified ID.");
                }
            }

            // Close the result set, statement, and connection
            rs2.close();
            stmt2.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return allValuesfound;
    }




}
