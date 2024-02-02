Feature: Combine Totalization Message for a single instant payout.

#s
  Scenario: ISM-373 Verify ISM combines both domestic and international transactions when they are matching MID/TID, session ID and date
    When I trigger domestic transaction2 for scheme "MASTERCARD" amount "2000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger international transaction2 for scheme "VISA" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    Then I  wait for payment processing
    Then I check "TOTALIZATION_STORE" table for STATUS as "PROCESSED"
    Then I check Totalization Transaction table for amount as "3000"

#s
  Scenario: ISM-462 Verify ISM combines both 2 Sets of domestic and international transactions when they are matching MID/TID, session ID and date
    When I trigger domestic transaction2 for scheme "MASTERCARD" amount "2000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger international transaction2 for scheme "MASTERCARD" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger domestic transaction2 for scheme "VISA" amount "1500" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger international transaction2 for scheme "AMEX" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    Then I  wait for payment processing
    Then I check "TOTALIZATION_STORE" table for STATUS as "PROCESSED"
    Then I check Totalization Transaction table for amount as "3000"

#s
  Scenario: ISM-436 Verify ISM combines 2 domestic and 1 international transactions when they are matching MID/TID, session ID and date
    When I trigger domestic transaction2 for scheme "DINERS" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger domestic transaction2 for scheme "VISA" amount "1500" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger international transaction2 for scheme "MASTERCARD" amount "1200" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    Then I  wait for payment processing
    Then I check "TOTALIZATION_STORE" table for STATUS as "PROCESSED"
    Then I check Totalization Transaction table for amount as "2200"

  Scenario: ISM-437 Verify ISM combines 1 domestic and 2 international transactions when they are matching MID/TID, session ID and date
    When I trigger international transaction2 for scheme "MASTERCARD" amount "1300" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger international transaction2 for scheme "DINERS" amount "1200" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger domestic transaction2 for scheme "VISA" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    Then I  wait for payment processing
    Then I check "TOTALIZATION_STORE" table for STATUS as "PROCESSED"
    Then I check Totalization Transaction table for amount as "2300"
#s
  Scenario: ISM-372 Verify ISM separates both domestic and international transactions when they are matching MID/TID, session ID and date
    When I trigger domestic transaction2 for scheme "MASTERCARD" amount "1500" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    Then I  wait for payment processing
    When I trigger international transaction2 for scheme "VISA" amount "1400" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"

##
  Scenario: ISM-443 Verify ISM doesn't process the 2 international transactions when they are matching MID/TID, session ID and date
    When I trigger international transaction2 for scheme "MASTERCARD" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger international transaction2 for scheme "DINERS" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    Then I check "TOTALIZATION_STORE" table for STATUS as "PENDING"
    Then I check Totalization Transaction table for amount as "1000"

#s
  Scenario: ISM-442 Verify ISM doesn't process the 2 domestic transactions when they are matching MID/TID, session ID and date
    When I trigger domestic transaction2 for scheme "MASTERCARD" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger domestic transaction2 for scheme "VISA" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    Then I check "TOTALIZATION_STORE" table for STATUS as "PENDING"

#s
  Scenario:ISM-452 Verify ISM combines both domestic and international transactions with the negative amount when they are matching MID/TID, session ID and date
    When I trigger domestic transaction2 for scheme "DINERS" amount "-1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger international transaction2 for scheme "VISA" amount "-500" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    Then I  wait for payment processing
    Then I check "TOTALIZATION_STORE" table for STATUS as "PROCESSED"
    Then I check Totalization Transaction table for amount as "-1500"

#s
  Scenario: ISM-374 Verify ISM separates both domestic and international transactions when they are not matching MID/TID, session ID and date
    When I trigger domestic transaction2 for scheme "MASTERCARD" amount "1200" with currency as "EUR" and Merchant_ID as "Different_MerchantID" and TerminalID as "Different_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Different_Date"
    When I trigger international transaction2 for scheme "VISA" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    Then I  wait for payment processing
    Then I check "TOTALIZATION_STORE" table for STATUS as "PROCESSED"
#s
  Scenario: ISM-431 Verify ISM both domestic and international transactions are not matching MID
    When I trigger domestic transaction2 for scheme "AMEX" amount "1200" with currency as "EUR" and Merchant_ID as "Different_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger international transaction2 for scheme "MASTERCARD" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    Then I  wait for payment processing
    Then I check "TOTALIZATION_STORE" table for STATUS as "PROCESSED"

#s
  Scenario: ISM-433 Verify ISM both domestic and international transactions are not matching TID
    When I trigger domestic transaction2 for scheme "VISA" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Different_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger international transaction2 for scheme "MASTERCARD" amount "1500" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    Then I  wait for payment processing
    Then I check "TOTALIZATION_STORE" table for STATUS as "PROCESSED"

#s
  Scenario: ISM-434 Verify ISM separates both domestic and international transactions when they are not matching Session_date
    When I trigger domestic transaction2 for scheme "MASTERCARD" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Different_Date"
    When I trigger international transaction2 for scheme "AMEX" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    Then I  wait for payment processing
    Then I check "TOTALIZATION_STORE" table for STATUS as "PROCESSED"
    Then I check Totalization Transaction table for amount as "1000"

 Scenario: ISM-435 Verify ISM separates both domestic and international transactions when they are not matching Session_ID
   When I trigger domestic transaction2 for scheme "AMEX" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Different_TerminalID" with SessionID "Different_SessionID" and Session_Date as "Same_Date"
   When I trigger international transaction2 for scheme "MASTERCARD" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
   Then I  wait for payment processing
   Then I check "TOTALIZATION_STORE" table for STATUS as "PROCESSED"
   Then I check Totalization Transaction table for amount as "1000"

  Scenario: ISM-438 Verify ISM separates when one domestic and international transactions is mapped with MID/TID and Session_ID & Date another domestic is not matched
    When I trigger domestic transaction2 for scheme "VISA" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger international transaction2 for scheme "AMEX" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger domestic transaction2 for scheme "MASTERCARD" amount "1000" with currency as "EUR" and Merchant_ID as "Different_MerchantID" and TerminalID as "Different_TerminalID" with SessionID "Different_SessionID" and Session_Date as "Different_Date"
    Then I  wait for payment processing
    Then I check "TOTALIZATION_STORE" table for STATUS as "PROCESSED"
    Then I check Totalization Transaction table for amount as "2000"

  Scenario: ISM-439 Verify ISM separates when one domestic and international transactions is mapped with MID/TID and Session_ID & Date another international is not matched
    When I trigger domestic transaction2 for scheme "VISA" amount "2000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger international transaction2 for scheme "MASTERCARD" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger international transaction2 for scheme "VISA" amount "1000" with currency as "EUR" and Merchant_ID as "Different_MerchantID" and TerminalID as "Different_TerminalID" with SessionID "Different_SessionID" and Session_Date as "Different_Date"
    Then I  wait for payment processing
    Then I check "TOTALIZATION_STORE" table for STATUS as "PROCESSED"
    Then I check Totalization Transaction table for amount as "3000"



  Scenario: ISM-470 Verify ISM separates 2 international transactions is not matching with MID/TID and Session_ID & Date
    When I trigger international transaction2 for scheme "DINERS" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger international transaction2 for scheme "MASTERCARD" amount "1200" with currency as "EUR" and Merchant_ID as "Different_MerchantID" and TerminalID as "Different_TerminalID" with SessionID "Different_SessionID" and Session_Date as "Different_Date"
    Then I  wait for payment processing
    Then I check "TOTALIZATION_STORE" table for STATUS as "PROCESSED"

##
  Scenario: ISM-471 Verify ISM separates 2 domestic transactions is not matching with MID/TID and Session_ID & Date
    When I trigger domestic transaction2 for scheme "MASTERCARD" amount "1500" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger domestic transaction2 for scheme "VISA" amount "1000" with currency as "USD" and Merchant_ID as "Different_MerchantID" and TerminalID as "Different_TerminalID" with SessionID "Different_SessionID" and Session_Date as "Different_Date"
    Then I  wait for payment processing
    Then I check "TOTALIZATION_STORE" table for STATUS as "PROCESSED"

  Scenario: ISM-440 Verify that ISM is processing D+1 settlement if the instant flag is ‘NO’ (False) for the totalization message with a time frame of 5–10 seconds
    When I trigger domestic transaction for scheme "VISA" amount "2000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date" and Instant_flag is "No"
    When I trigger international transaction for scheme "MASTERCARD" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date" and Instant_flag is "No"
    Then I  wait for payment processing
    Then I check "TOTALIZATION_STORE" table for STATUS as "PROCESSED"
    Then I check Totalization Transaction table for amount as "3000"

  Scenario: ISM-441 Verify that ISM is processing D+1 settlement if the instant flag is 'No' (False) for the totalization message with not a time frame of 5-10 seconds
    When I trigger domestic transaction for scheme "VISA" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date" and Instant_flag is "No"
    When I trigger international transaction for scheme "MASTERCARD" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date" and Instant_flag is "No"
    Then I  wait for payment processing
    Then I check "TOTALIZATION_STORE" table for STATUS as "PROCESSED"



  Scenario: ISM-444 Verify the ISM pays net amount when it combines both domestic and international transactions
    When I trigger domestic transaction2 for scheme "MASTERCARD" amount "2000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger international transaction2 for scheme "DINERS" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    Then I  wait for payment processing
    Then I check TOTALIZATION_TRANSACTION table for netamount as "3000"

  Scenario: ISM-445 Verify the ISM pays net amount when ISM separates both domestic and international transactions.
    When I trigger domestic transaction2 for scheme "DINERS" amount "1200" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Different_TerminalID" with SessionID "Different_SessionID" and Session_Date as "Same_Date"
    When I trigger international transaction2 for scheme "VISA" amount "1100" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    Then I  wait for payment processing
    Then I check TOTALIZATION_TRANSACTION table for netamount as "1100"

##
@ISM-463
  Scenario: ISM-463 Verify the ISM pays net amount with discount amount(250) when it combines both domestic and international transactions
    When I trigger domestic transaction2 for scheme "MASTERCARD" amount "4000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger international transaction2 for scheme "VISA" amount "3000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    Then I  wait for payment processing
    Then I check TOTALIZATION_TRANSACTION table for TotalPayOutAmount as "6750"

  Scenario: ISM-446 Verify the ISM provides the required fields to CODA
    When I trigger domestic transaction2 for scheme "MASTERCARD" amount "2000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger international transaction2 for scheme "VISA" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    Then I  wait for payment processing
    Then I check ISM_PAYLOAD_STORE to check CODA_OUTBOUND_PAYLOAD Blob message


  Scenario: ISM-447 Verify the response read from the CODA is getting stored in the ISM-DB
    When I trigger domestic transaction2 for scheme "MASTERCARD" amount "2000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger international transaction2 for scheme "VISA" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    Then I  wait for payment processing
    Then I check ISM_PAYLOAD_STORE to check CODA_INBOUND_PAYLOAD Blob message


  Scenario: ISM-466 Verify the report for totalization should contain the transaction from 8.45 Pm D -2 to 8.45pm D-1 stored in ISM- DB
    When I trigger domestic transaction2 for scheme "MASTERCARD" amount "1500" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger domestic transaction2 for scheme "DINERS" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    Then I  wait for payment processing
    Then I check ISM_PAYLOAD_STORE to check CODA_OUTBOUND_PAYLOAD Blob message

  Scenario: ISM-466 Verify the report for totalization should contain the transaction from 8.45 Pm D -2 to 8.45pm D-1 stored in ISM- DB
    When I trigger domestic transaction2 for scheme "MASTERCARD" amount "1500" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger domestic transaction2 for scheme "DINERS" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    Then I  wait for payment processing
    Then I check ISM_PAYLOAD_STORE to check CODA_OUTBOUND_PAYLOAD Blob message

  Scenario: ISM-377 Verify the report is in CSV format(UTF-8), the data is separated in delimiter ";" and has the report name as per the requirement
    When I check the report is as per the requirement

  Scenario: ISM-378 Verify that the report contains previous day totalization data extracted from 00:00 to 24:00
    When I check the report is as per the ExtractedTime


  Scenario: ISM-379 Verify the 'Status' field is showing CODA response Status
    When I trigger domestic transaction2 for scheme "MASTERCARD" amount "2000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger international transaction2 for scheme "VISA" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    Then I  wait for payment processing
    Then I check ISM_PAYLOAD_STORE to check CODA_INBOUND_PAYLOAD Blob message

  Scenario: ISM-380 Verify the Totalization report contain all the fields mentioned in the requirements and extract data correctly from ISM table (TOTALIZATION_TRANSACTION)
    When I trigger domestic transaction2 for scheme "MASTERCARD" amount "2000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    When I trigger international transaction2 for scheme "VISA" amount "1000" with currency as "EUR" and Merchant_ID as "Same_MerchantID" and TerminalID as "Same_TerminalID" with SessionID "Same_SessionID" and Session_Date as "Same_Date"
    Then I  wait for payment processing
    Then I check ISM_PAYLOAD_STORE to check CODA_INBOUND_PAYLOAD Blob message

  Scenario: ISM-486 Verify that the report contains previous day totalization data extracted from 00:00 to 24:00
    When I check the report is as per the ExtractedTime


  Scenario: ISM-487 Verify the report is in CSV format(UTF-8), the data is separated in delimiter ";"
    When I check the report is as per the requirement

  Scenario: ISM-488 Verify the report is in CSV format(UTF-8), the data is separated in delimiter ";" and has the report name as per the requirement
    When I check the report is as per the requirement

  Scenario: ISM-489  Verify that separate reports are generated for Global EU.
    When I check the report is as per the requirement

  Scenario: ISM-501 Verify that separate reports are generated for Global EU.
    When I check the report is as per the requirement

  Scenario: ISM-448 Verify the TOTALIZATION_TRANSACTION table move to the TOTALIZATION_TRANSACTION_ARCHIVE table in the DB when the totalizations are archived as per the cut-off time.



