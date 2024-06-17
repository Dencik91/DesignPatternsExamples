package student.examples;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestListener implements ITestListener {

    private List<String> results;

    @Override
    public void onStart(ITestContext context) {
        results = new ArrayList<>();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        results.add("Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        results.add("Failed");
    }
    @Override
    public void onFinish(ITestContext context) {
        File file = new File("C:\\Users\\denisa\\IdeaProjects\\Domashka\\src\\test\\resources\\results.xlsx");
        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("excel-sheet");

            int rowIndex = 0;
            for (String result : results) {
                Row row = sheet.createRow(rowIndex);
                if (row != null) {
                    Cell cell = row.createCell(0);
                    cell.setCellValue(result);
                }
                rowIndex++;
            }
            FileOutputStream fos = new FileOutputStream(file);
            System.out.println(fos);
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
