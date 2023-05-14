package com.sliu.JPADemo.controller;

import com.sliu.JPADemo.entity.StudentEntity;
import com.sliu.JPADemo.service.RestService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class TestController {

    @Autowired
    private RestService restService;

    @GetMapping(value = "/export/excel")
    public void exportTemplate(HttpServletResponse response) throws IOException {
        String[] options = new String[]{"A", "B", "C", "D", "E"};
        Workbook wb = new XSSFWorkbook();
        XSSFSheet sheet = (XSSFSheet) wb.createSheet("Sheet");
        XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper(sheet);
        XSSFDataValidationConstraint dvConstraint = (XSSFDataValidationConstraint) dvHelper.createExplicitListConstraint(options);
        CellRangeAddressList list = new CellRangeAddressList(0, 65535, 0, 0);
        XSSFDataValidation validation = (XSSFDataValidation) dvHelper.createValidation(dvConstraint, list);
        sheet.addValidationData(validation);
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment; filename=test.xlsx");
        ServletOutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }

    @GetMapping(value = "/test/rest/{id}")
    public StudentEntity get(@PathVariable("id") String id) {
        return restService.findByRest(id);
    }
}
