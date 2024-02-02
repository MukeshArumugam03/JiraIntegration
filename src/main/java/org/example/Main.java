package org.example;

//import com.jcraft.jsch.ChannelSftp;
//import com.jcraft.jsch.JSch;
//import com.jcraft.jsch.JSchException;
//import com.jcraft.jsch.Session;

//import com.opencsv.CSVParser;
//import com.opencsv.CSVParserBuilder;
//import com.opencsv.CSVReader;
//import com.opencsv.CSVReaderBuilder;
//import com.opencsv.exceptions.CsvException;
//
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVPrinter;
//import org.apache.commons.csv.CSVRecord;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static String strCurrentdate;
    public static void generatedate() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Date date = new Date();
        strCurrentdate = format.format(date);

    }

    private static String extractTimeString(String line){
        return line.substring(11,19);
    }

    private static boolean isWithinPreviousDay(Date entryDate, Date currentDate){
        long oneDayInMillis =24*60*60*1000;
        long timeDifference =currentDate.getTime()-entryDate.getTime();
        return timeDifference <= oneDayInMillis;
    }

//377
    private static boolean isCSVFormat(String filepath) throws IOException {
        BufferedReader reader=new BufferedReader(new FileReader(filepath));
        String line= reader.readLine();
        if(line!=null && line.contains("CREATED_ON")){
            return true;
        }
        return false;
    }

    //378
    private static boolean verifyTimeRange(String filepath) throws IOException, ParseException {

        BufferedReader reader=new BufferedReader(new FileReader(filepath));
        String line;
        boolean isFirstLine=true;
        while((line =reader.readLine())!=null){
            if(isFirstLine){
                isFirstLine =false; //skip header line
                continue;
            }
            String[] columns=line.split(";");
            String createdOnValue=columns[4].trim();
            if(!isValidTime(createdOnValue)){
                return false;
            }
        }
        return true;
    }

    private static boolean isValidTime(String timeValue) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SSSSSS");
        Date date=sdf.parse(timeValue);
        return true;
    }

//    private static List<List<String>>  readCSVData(String filePath) throws FileNotFoundException {
//        List<List<String>> data =new ArrayList<>();
//        FileInputStream fis= new FileInputStream(new File(filePath));
//        CSVParser parser = CSVFormat.DEFAULT.parse(fis){
//            for(CSVRecord record: parser){
//
//            }
//        }
//    }

    public static <CSVRecord> void main(String[] args) throws IOException, ParseException {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
//        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
//            System.out.println("i = " + i);

//        String remotefile2 ="C:\\Users\\mukesh.a\\IdeaProjects\\Totalization_Auto\\ISM_Totalization_20240116.xlsx";
//        String LocalFilepath="C:\\Users\\mukesh.a\\IdeaProjects\\Totalization_Auto\\src\\main\\resources.xlsx";
//            JSch jsch=new JSch();
//
//            jsch.addIdentity("C:\\Users\\mukesh.a\\IdeaProjects\\Totalization_Auto\\src\\main\\resources\\totalization_report 2.ppk");
//            Session session=jsch.getSession("ISM_totalisation_report","sftp-qa.getnet.diq",22);
//            Properties config=new Properties();
//            config.put("StrictHostKeyChecking","no");
//            session.setConfig(config);
//            session.connect();
//
//            ChannelSftp sftpChannel= (ChannelSftp) session.openChannel("sftp");
//            sftpChannel.connect();
////            sftpChannel.get();

//            String winscppath="\"C:\\Program Files (x86)\\WinSCP\\WinSCP.exe\" \"ISM_totalisation_report%40sftp-qa.getnet.diq\" /Desktop /UploadIfAny";
//
//            String script="option batch abort\n" +
//                          "option confirm off\n" +
//                          "open sftp://"



   /*         Date currentdate= new Date();
            Calendar calender= Calendar.getInstance();
            calender.setTime(currentdate);

            calender.add(Calendar.DAY_OF_MONTH, -2);

            Date updatedDate=calender.getTime();
            calender.add(Calendar.DAY_OF_MONTH, -1);
           Date updatedDate2=calender.getTime();

        //2024-01-19 11:23:24                                        2024-01-19 10:09:23.715914
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
            String currentDateString =dateFormat.format(currentdate);
            String updatedDateString=dateFormat.format(updatedDate);
        String updatedDateString2=dateFormat.format(updatedDate2);

            System.out.println("current Date: "+ currentDateString);
            System.out.print("updated Date(minus two days): "+ updatedDateString);


        String filePath = "C:\\Users\\mukesh.a\\IdeaProjects\\Totalization_Auto\\src\\main\\resources\\ISM_Totalization_20240120.csv";


        BufferedReader reader= new BufferedReader(new FileReader(filePath));
        String line;
        while((line= reader.readLine()) !=null){
            String[] values=line.split(",");
            String timestampStr= values[0];

            Date transactionTime= dateFormat.parse(timestampStr);
            Date startTime =dateFormat.parse(updatedDateString);
            Date endTime =dateFormat.parse(updatedDateString2);

            if(transactionTime.after(startTime) && transactionTime.before(endTime)){
                System.out.println("verified Transaction: "+ line);
            }


        }*/

    //read csv file
     /*   String file= "C:\\Users\\mukesh.a\\IdeaProjects\\Totalization_Auto\\src\\main\\resources\\ISM_Totalization_20240120.csv";
        FileReader filereader = new FileReader(file);

        // create csvParser object with
        // custom separator semi-colon
        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

        // create csvReader object with parameter
        // filereader and parser
        CSVReader csvReader = new CSVReaderBuilder(filereader)
                .withCSVParser(parser)
                .build();

        // Read all data at once
        List<String[]> allData = csvReader.readAll();

        // Print Data.
        for (String[] row : allData) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }

            System.out.println();
        }*/
//read csv file


        //Verify data in valid CSV and delimeter  377
     /*  String filepath= "C:\\Users\\mukesh.a\\IdeaProjects\\Totalization_Auto\\src\\main\\resources\\ISM_Totalization_20240120.csv";
        boolean isValidCSV =isCSVFormat(filepath);
        if(isValidCSV){
            System.out.println("The File is in CSV format and uses ';' as the delimeter");

        }
        else{
            System.out.println("The File is not in CSV format and not uses ';' as the delimeter");
        }*/


        //378 verify data extracted from 00:00 to 24:00
      /*  String filepath= "C:\\Users\\mukesh.a\\IdeaProjects\\Totalization_Auto\\src\\main\\resources\\ISM_Totalization_20240120.csv";
        boolean isValidTimeRange =verifyTimeRange(filepath);

        if (isValidTimeRange) {

            System.out.println("The 'created_on' column values are within the range of 00:00 to 24:00");
        }
        else{
            System.out.println("The 'created_on' column values are not within the specified time range");
        }*/

//read & write
/*
        String csvFilePath ="C:\\Users\\mukesh.a\\IdeaProjects\\Totalization_Auto\\src\\main\\resources\\ISM_Totalization_20240120.csv";
        String excelFilePath= "C:\\Users\\mukesh.a\\IdeaProjects\\Totalization_Auto\\src\\main\\resources\\ISM_Totalization_20240120.csv";
        BufferedReader reader= new BufferedReader(new FileReader(csvFilePath));
        CSVPrinter printer =new CSVPrinter(new FileWriter(excelFilePath), CSVFormat.EXCEL){
                String headerLine =reader.readLine();
                String[] header = headerLine.split(";");
                printer.printRecord(header);
        }*/





//        String line;
//        while((line= reader.readLine()) !=null) {
//
//            String timeString = extractTimeString(line);
//            System.out.print(timeString);
//        }

//        String filepath= "C:\\Users\\mukesh.a\\IdeaProjects\\Totalization_Auto\\src\\main\\resources\\ISM_Totalization_20240120.csv";
//
//        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
//        Date currentDate=new Date();
//        BufferedReader reader= new BufferedReader(new FileReader(filepath));
//        String line;
//        while((line= reader.readLine()) !=null){
//            String timeString = extractTimeString(line);
//
//            Date entryDate =dateFormat.parse(timeString);
//            if(isWithinPreviousDay(entryDate,currentDate)){
//                System.out.println("date is valid.");
//            }
//            else {
//                System.out.println("date is not valid.");
//            }
//
//        }


    }
    }


