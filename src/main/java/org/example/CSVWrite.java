package org.example;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CSVWrite {

    private static List<CSVRecord> readCSV(String filePath) throws IOException {
        FileReader fileReader=new FileReader(filePath);
        CSVParser csvParser=CSVFormat.DEFAULT.withDelimiter(';').parse(fileReader);
        System.out.println(csvParser);
        return  csvParser.getRecords();

    }

    private static void writeExcel(List<CSVRecord> records, String filePath){

        Workbook workbook=new XSSFWorkbook();
        Sheet sheet =workbook.createSheet("Sheet1");

        int rowNum=0;
        for(CSVRecord record: records){
            Row row=sheet.createRow(rowNum++);
            int cellNum=0;
            for(String value:record){
                Cell cell=row.createCell(cellNum++);
                cell.setCellValue(value);
            }
        }

        try(FileOutputStream fileWriter =new FileOutputStream(filePath)){
            workbook.write(fileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static boolean isValidTime(String timeValue) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SSSSSS");
        Date date=sdf.parse(timeValue);
        return true;
    }
    //
    public static void main(String[] args) throws IOException {

      /*  String excelFilePath= "C:\\Users\\mukesh.a\\IdeaProjects\\Totalization_Auto\\src\\main\\resources\\Book1.xlsx";

        try(FileInputStream fileInputStream=new FileInputStream(excelFilePath);
            Workbook workbook =new XSSFWorkbook(fileInputStream)) {
            Sheet sheet = workbook.getSheet("Sheet1");

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell createdOnCell = row.getCell(16);

                    if (createdOnCell != null && createdOnCell.getCellType() == CellType.STRING) {
                        String createdOnValue = row.getCell(16).getStringCellValue();
                        if (isValidTime(createdOnValue)) {
                            System.out.println("Valid Time: " + createdOnValue);
                        } else {
                            System.out.println("Invalid Time: " + createdOnValue);
                        }

                    }else{
                        System.out.println("Invalid or empty cell in 'create_On' column at Row"+ i);
                    }
                }else {
                    System.out.println("Row is null at index "+ i);
                }
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }*/

        //Sucess
       /* String excelFilePath= "C:\\Users\\mukesh.a\\IdeaProjects\\Totalization_Auto\\src\\main\\resources\\Book1.xlsx";

        try(FileInputStream fileInputStream=new FileInputStream(excelFilePath);
            Workbook workbook =new XSSFWorkbook(fileInputStream)){
            Sheet sheet = workbook.getSheet("Sheet1");

            for(int i=1;i<=sheet.getLastRowNum();i++){
                Row row=sheet.getRow(i);
                String createdOnValue=row.getCell(16).getStringCellValue();
                if(isValidTime(createdOnValue)){
                    System.out.println("Valid Time: "+ createdOnValue);
                }else{
                    System.out.println("Invalid Time: "+ createdOnValue);
                }
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }*/


//write data to excel
        String csvFilePath ="C:\\Users\\mukesh.a\\IdeaProjects\\Totalization_Auto\\src\\main\\resources\\ISM_Totalization_202401200.csv";
        String excelFilePath= "C:\\Users\\mukesh.a\\IdeaProjects\\Totalization_Auto\\src\\main\\resources\\Totalization_Report.xlsx";

        try{
            List<CSVRecord> records= readCSV(csvFilePath);
            writeExcel(records,excelFilePath);
            System.out.println("CSV Parsing Successfully.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //        try {
//            FileReader fileReader = new FileReader(csvFilePath);
//            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
//            List<CSVRecord> csvRecords= csvParser.getRecords();
//
//            Workbook workbook=new XSSFWorkbook();
//            Sheet sheet =workbook.createSheet("Sheet1");
//
//            Row headerRow =sheet.createRow(0);
//            int headerCellNumber=0;
//            for(String header: csvRecords.get(0)){
//                Cell cell=headerRow.createCell(headerCellNumber++);
//                cell.setCellValue(header);
//            }
//
//            for(int i=1; i<csvRecords.size();i++){
//                Row dataRow=sheet.createRow(i);
//                int dataCellNumber=0;
//                for(String value: csvRecords.get(i)){
//                    Cell cell=dataRow.createCell(dataCellNumber++);
//                    cell.setCellValue(value);
//                }
//            }
//
//            try(FileOutputStream fileWriter =new FileOutputStream(excelFilePath)){
//                workbook.write(fileWriter);
//            }
//            csvParser.close();
//            fileReader.close();
//            workbook.close();
//            System.out.println("Conversion completed successfully.");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


    }
}
