package com.grok.utils;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class DataProviderUtil {

    @DataProvider(name = "excelData")
    public static Object[][] getExcelData() {
        String excelPath = "src/main/resources/testdata/testdata.xlsx";
        List<Object[]> data = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(excelPath);
             Workbook workbook = WorkbookFactory.create(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                String username = row.getCell(0).getStringCellValue();
                String password = row.getCell(1).getStringCellValue();
                data.add(new Object[]{username, password});
            }
        } catch (Exception e) {
            LogManager.error("Failed to read test data", e);
        }
        return data.toArray(new Object[0][]);
    }
}