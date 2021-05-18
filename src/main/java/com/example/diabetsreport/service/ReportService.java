package com.example.diabetsreport.service;

import com.example.diabetsreport.client.MediscreenClient;
import com.example.diabetsreport.client.PatHistoryClient;
import com.example.diabetsreport.model.PatHistoryDto;
import com.example.diabetsreport.model.PatientDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Service

public class ReportService {
    private final MediscreenClient mediscreenClient;
    public final PatHistoryClient patHistoryClient;

    public ReportService(MediscreenClient mediscreenClient, PatHistoryClient patHistoryClient) {
        this.mediscreenClient = mediscreenClient;
        this.patHistoryClient = patHistoryClient;
    }
    /*
    méthode qui prend en param le patId et retourner un string ayant l 'age du patient et son assessement(état de risque)
    Cet état prend en considération l'age, le sex ainsi que le nombre de facteurs declanchants
     */

    public String getFeedback(Long patId) {
        PatientDto patient = mediscreenClient.findById(patId);
        List<PatHistoryDto> patHistories = patHistoryClient.findAllByPatId(patId);
        Integer age = calculateAge(patient.getDob());
        Long counter = 0L;

        for (PatHistoryDto patHistoryDto : patHistories) {
            counter = counter + checkTerms(patHistoryDto.getE());
        }

        String assessment = "";

        if (((patient.getSex().equals("M") && age < 30 && counter < 3L) ||
                (patient.getSex().equals("F") && age < 30 && counter < 4L)) || (age >= 30 && counter < 2)) {
            assessment = "None";
        }

        if (counter >= 2L && age >= 30) {
            assessment = "Borderline";
        }

        if ((patient.getSex().equals("M") && age < 30 && counter >= 3 && counter < 5L) ||
                (patient.getSex().equals("F") && age < 30 && counter >= 4 && counter < 7L) || (age >= 30 && counter >= 6L)) {
            assessment = "In Danger";
        }

        if ((patient.getSex().equals("M") && age < 30 && counter >= 5L) ||
                (patient.getSex().equals("F") && age < 30 && counter >= 7L) || (age >= 30 && counter >= 8L)) {
            assessment = "Early onset";
        }

        return String.format(
                "Patient: %s %s (age %d) diabetes assessment is: %s", patient.getGiven(), patient.getFamily(), age, assessment);
    }
 /*
    méthode qui prend en param le familyName et retourner une liste de string ayant le nom,le prénom, l'age de chaque patient et son assessement(état de risque)
    Cet état prend en considération l'age, le sex ainsi que le nombre de facteurs declanchants
     */

    public List<String> getFeedbackWithFamilyName(String family) {

        List<String> result = new ArrayList<>();
        List<PatientDto> patients = mediscreenClient.findByFamily(family);

        for (PatientDto patientDto : patients) {
            result.add(getFeedback(patientDto.getId()));
        }

        return result;

    }

    /*
    méthode pour calculer l'age du patient à partir de sa date d'anniversaire(parsée du String en date) puis calculée
    à partir de la différence entre la date actuelle et celle d'anniversaire
     */
    private Integer calculateAge(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(stringDate, formatter);
        return Period.between(localDate, LocalDate.now()).getYears();
    }

    /*
    methode qui permet de compter le nombre de terms (facteurs declanchants) présents dans les notes de médecin
    tout en tenant compte de transformer le tout en miniscule pour bien compter
     */
    private Long checkTerms(String noteMedecin) {
        List<String> terms = Arrays.asList("Hémoglobine A1C",
                "Microalbumine",
                "Taille",
                "Poids",
                "Fumeur",
                "Anormal",
                "Cholestérol",
                "Vertige",
                "Rechute",
                "Réaction",
                "Anticorps");

        return terms.stream().filter(term -> noteMedecin.toLowerCase().contains(term.toLowerCase())).count();
    }

}
