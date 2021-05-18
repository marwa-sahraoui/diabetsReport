package com.example.diabetsreport.controller;

import com.example.diabetsreport.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/assess")
public class PatientController {

    @Autowired
    ReportService reportService;

    @PostMapping("/id")
    public String getFeedback(@RequestParam Long patId) {
        return reportService.getFeedback(patId);
    }
    @PostMapping("/familyName")
    public List<String> getFeedback(@RequestParam String familyName) {
        return reportService.getFeedbackWithFamilyName(familyName);
    }
}
