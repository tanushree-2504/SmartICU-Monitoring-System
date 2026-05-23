package com.smarticu.smarticu.controller;


import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import com.smarticu.smarticu.entity.Patient;
import com.smarticu.smarticu.repository.PatientRepository;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PdfController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/download/{id}")
    public void downloadPdf(@PathVariable Long id,
                            HttpServletResponse response) {

        try {

            Patient patient =
                    patientRepository.findById(id).orElse(null);

            if (patient == null) {
                return;
            }

            response.setContentType("application/pdf");

            response.setHeader(
                    "Content-Disposition",
                    "attachment; filename=patient_report.pdf"
            );

            Document document = new Document();

            PdfWriter.getInstance(
                    document,
                    response.getOutputStream()
            );

            document.open();

            document.add(new Paragraph("SMART ICU PATIENT REPORT"));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Patient Name: " + patient.getName()));
            document.add(new Paragraph("Age: " + patient.getAge()));
            document.add(new Paragraph("Disease: " + patient.getDisease()));
            document.add(new Paragraph("Heart Rate: " + patient.getHeartRate()));
            document.add(new Paragraph("Oxygen Level: " + patient.getOxygenLevel()));
            document.add(new Paragraph("Blood Pressure: " + patient.getBloodPressure()));
            document.add(new Paragraph("Status: " + patient.getStatus()));

            document.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}