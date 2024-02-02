package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportVerification {
    static String filepath= "C:\\Users\\mukesh.a\\IdeaProjects\\Totalization_Auto\\src\\main\\resources\\ISM_Totalization_202401200.csv";


    private static boolean isValidTime(String timeValue) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SSSSSS");
        Date date=sdf.parse(timeValue);
        return true;
    }
    public ReportVerification() throws IOException {
    }

    public static boolean isCSVFormat() throws IOException {

        BufferedReader reader=new BufferedReader(new FileReader(ReportVerification.filepath));
        String line= reader.readLine();
        if(line!=null && line.contains(";")){
            return true;
        }
               boolean isValidCSV =isCSVFormat();
        if(isValidCSV){
            System.out.println("The File is in CSV format and uses ';' as the delimeter");

        }
        else{
            System.out.println("The File is not in CSV format and not uses ';' as the delimeter");
        }
        return false;
    }

    public static boolean ExtractionTime(){
        String excelFilePath= "C:\\Users\\mukesh.a\\IdeaProjects\\Totalization_Auto\\src\\main\\resources\\Book1.xlsx";


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
        } catch (ParseException | FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return false;
    }


}
