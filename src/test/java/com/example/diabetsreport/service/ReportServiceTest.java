package com.example.diabetsreport.service;

import com.example.diabetsreport.client.MediscreenClient;
import com.example.diabetsreport.client.PatHistoryClient;
import com.example.diabetsreport.model.PatHistoryDto;
import com.example.diabetsreport.model.PatientDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ReportServiceTest {
    @Mock
    private MediscreenClient mediscreenClient;

    @Mock
    private PatHistoryClient patHistoryClient;

    @InjectMocks
    ReportService reportService;

    @BeforeEach
    void setMockOutput() {
        PatientDto emily = new PatientDto(1L, "Jules", "emily", "09/05/1994", "F",
                "paris", "066666666");
        PatientDto john = new PatientDto(2L, "doe", "john", "05/05/1994", "M",
                "usa", "123-245-9000");
        PatientDto yara = new PatientDto(3L, "Jules", "yara", "05/05/1984", "F",
                "paris", "066666666");
        PatientDto joe = new PatientDto(4L, "Jules", "joe", "09/05/1984", "M",
                "paris", "066666666");
        PatientDto paola = new PatientDto(5L, "Jules", "paola", "09/05/1991", "F",
                "paris", "066666666");
        PatientDto med = new PatientDto(6L, "nacer", "med", "09/05/1991", "M",
                "paris", "066666666");
        //Liste patients catégorie borderline
        PatientDto alex = new PatientDto(7L, "Jules", "alex", "09/05/1991", "M",
                "paris", "066666666");
        PatientDto monika = new PatientDto(8L, "Jules", "monika", "09/05/1991", "F",
                "paris", "066666666");
        PatientDto day = new PatientDto(9L, "Jules", "day", "09/05/1991", "M",
                "paris", "066666666");
        PatientDto ritta = new PatientDto(10L, "Jules", "ritta", "09/05/1991", "F",
                "paris", "066666666");
        PatientDto gerome = new PatientDto(11L, "Jules", "gerome", "09/05/1970", "M",
                "paris", "066666666");
        PatientDto sophie = new PatientDto(12L, "Jules", "sophie", "09/05/1970", "F",
                "paris", "066666666");
        //Liste patients catégorie In Danger
        PatientDto laurie = new PatientDto(13L, "Jules", "laurie", "09/05/1994", "F",
                "paris", "066666666");
        PatientDto damien = new PatientDto(14L, "Jules", "damien", "05/05/1994", "M",
                "usa", "123-245-9000");
        PatientDto caroline = new PatientDto(15L, "Jules", "caroline", "09/05/1994", "F",
                "paris", "066666666");
        PatientDto christophe = new PatientDto(16L, "Jules", "christophe", "05/05/1994", "M",
                "usa", "123-245-9000");
        PatientDto anna = new PatientDto(17L, "Jules", "anna", "09/05/1991", "F",
                "paris", "066666666");
        PatientDto peter = new PatientDto(18L, "nacer", "peter", "09/05/1991", "M",
                "paris", "066666666");
        PatientDto diana = new PatientDto(19L, "Jules", "diana", "09/05/1991", "F",
                "paris", "066666666");
        PatientDto laurent = new PatientDto(20L, "nacer", "laurent", "09/05/1991", "M",
                "paris", "066666666");
        PatientDto julien = new PatientDto(21L, "jason", "julien", "09/05/1960", "M",
                "paris", "066666666");
        PatientDto assia = new PatientDto(22L, "jason", "assia", "09/05/1960", "F",
                "paris", "066666666");
        ////Liste en rapport du risque Early onset
        PatientDto nelly = new PatientDto(23L, "chris", "nelly", "09/05/1994", "F",
                "paris", "066666666");
        PatientDto sebastien = new PatientDto(24L, "doe", "sebastien", "05/05/1994", "M",
                "usa", "123-245-9000");
        PatientDto maria = new PatientDto(25L, "jones", "maria", "05/05/1994", "F",
                "usa", "123-245-9000");
        PatientDto bob = new PatientDto(26L, "marley", "bob", "05/05/1994", "M",
                "usa", "123-245-9000");
        PatientDto laila = new PatientDto(27L, "Jules", "laila", "09/05/1991", "F",
                "paris", "066666666");
        PatientDto cyril = new PatientDto(28L, "saga", "cyril", "09/05/1991", "M",
                "paris", "066666666");
        PatientDto sousane = new PatientDto(29L, "foch", "sousane", "09/05/1991", "F",
                "paris", "066666666");
        PatientDto omar = new PatientDto(30L, "say", "omar", "09/05/1991", "M",
                "paris", "066666666");
        PatientDto simone = new PatientDto(31L, "Jules", "simone", "09/05/1970", "M",
                "paris", "066666666");
        PatientDto maoura = new PatientDto(32L, "Jules", "maoura", "09/05/1970", "F",
                "paris", "066666666");
        PatientDto jacques = new PatientDto(33L, "San", "jacques", "09/05/1970", "M",
                "paris", "066666666");
        PatientDto julia = new PatientDto(34L, "soulat", "julia", "09/05/1970", "F",
                "paris", "066666666");


        List<PatHistoryDto> patHistoryDtoemily = new ArrayList<PatHistoryDto>();
        PatHistoryDto eEmily = new PatHistoryDto(1L, "vertige,rechute");
        patHistoryDtoemily.add(eEmily);
        List<PatHistoryDto> patHistoryDtojhon = new ArrayList<PatHistoryDto>();
        PatHistoryDto ejohn = new PatHistoryDto(2L, "rechute");
        patHistoryDtojhon.add(ejohn);
        List<PatHistoryDto> patHistoryDtoyara = new ArrayList<PatHistoryDto>();
        PatHistoryDto eYara = new PatHistoryDto(3L, "good state");
        patHistoryDtoyara.add(eYara);
        List<PatHistoryDto> patHistoryDtojoe = new ArrayList<PatHistoryDto>();
        PatHistoryDto eJoe = new PatHistoryDto(4L, "good state");
        patHistoryDtoyara.add(eJoe);
        List<PatHistoryDto> patHistoryDtopaola = new ArrayList<PatHistoryDto>();
        PatHistoryDto ePaola = new PatHistoryDto(5L, "good state");
        patHistoryDtoyara.add(ePaola);
        List<PatHistoryDto> patHistoryDtomed = new ArrayList<PatHistoryDto>();
        PatHistoryDto eMed = new PatHistoryDto(6L, "cholestérol");
        patHistoryDtomed.add(eMed);
        //Liste pathistorie catégorie borderline
        List<PatHistoryDto> patHistoryDtoalex = new ArrayList<PatHistoryDto>();
        PatHistoryDto eAlex = new PatHistoryDto(7L, "cholestérol" + " vertige");
        patHistoryDtoalex.add(eAlex);
        List<PatHistoryDto> patHistoryDtomonika = new ArrayList<PatHistoryDto>();
        PatHistoryDto eMonika = new PatHistoryDto(8L, "cholestérol" + " vertige");
        patHistoryDtomonika.add(eMonika);
        List<PatHistoryDto> patHistoryDtoday = new ArrayList<PatHistoryDto>();
        PatHistoryDto eDay = new PatHistoryDto(9L, "cholestérol" + " vertige");
        patHistoryDtoday.add(eDay);
        List<PatHistoryDto> patHistoryDtoritta = new ArrayList<PatHistoryDto>();
        PatHistoryDto eRitta = new PatHistoryDto(10L, "cholestérol" + " vertige");
        patHistoryDtoritta.add(eRitta);
        List<PatHistoryDto> patHistoryDtogerome = new ArrayList<PatHistoryDto>();
        PatHistoryDto eGerome = new PatHistoryDto(11L, "cholestérol" + " vertige/Poids= lourd");
        patHistoryDtogerome.add(eGerome);
        List<PatHistoryDto> patHistoryDtosophie = new ArrayList<PatHistoryDto>();
        PatHistoryDto eSophioe = new PatHistoryDto(12L, "cholestérol" + " vertige, rechute, taille petite");
        patHistoryDtosophie.add(eSophioe);
        ////Liste en rapport du risque In Danger
        List<PatHistoryDto> patHistoryDtolaurie = new ArrayList<PatHistoryDto>();
        PatHistoryDto eLaurie = new PatHistoryDto(13L, "cholestérol" + " vertige, rechute, taille petite");
        patHistoryDtolaurie.add(eLaurie);
        List<PatHistoryDto> patHistoryDtodamien = new ArrayList<PatHistoryDto>();
        PatHistoryDto eDamien = new PatHistoryDto(14L, "cholestérol" + " vertige, rechute");
        patHistoryDtodamien.add(eDamien);
        List<PatHistoryDto> patHistoryDtocaroline = new ArrayList<PatHistoryDto>();
        PatHistoryDto eCaroline = new PatHistoryDto(15L, "cholestérol" + " vertige, rechute, petite taille " +
                "Microalbumine/faible anticoprs");
        patHistoryDtocaroline.add(eCaroline);
        List<PatHistoryDto> patHistoryDtochristophe = new ArrayList<PatHistoryDto>();
        PatHistoryDto eChristophe = new PatHistoryDto(16L, "cholestérol" + " vertige, rechute, grande taille");
        patHistoryDtochristophe.add(eChristophe);
        List<PatHistoryDto> patHistoryDtoAnna = new ArrayList<PatHistoryDto>();
        PatHistoryDto eAnna = new PatHistoryDto(17L, "cholestérol" + " vertige, rechute, taille petite" + "poids faible" +
                "chute Anticorps");
        patHistoryDtoAnna.add(eAnna);
        List<PatHistoryDto> patHistoryDtoPeter = new ArrayList<PatHistoryDto>();
        PatHistoryDto ePeter = new PatHistoryDto(18L, "cholestérol" + " vertige, rechute, taille petite" + "poids faible" +
                "chute Anticorps");
        patHistoryDtoPeter.add(ePeter);
        List<PatHistoryDto> patHistoryDtoDiana = new ArrayList<PatHistoryDto>();
        PatHistoryDto eDiana = new PatHistoryDto(19L, "cholestérol" + " vertige, rechute, taille petite" + "poids faible" +
                "chute Anticorps" + "Hémoglobine A1C");
        patHistoryDtoDiana.add(eDiana);
        List<PatHistoryDto> patHistoryDtoLaurent = new ArrayList<PatHistoryDto>();
        PatHistoryDto elaurent = new PatHistoryDto(20L, "cholestérol" + " vertige, rechute, taille petite" + "poids faible" +
                "chute Anticorps" + "Hémoglobine A1C");
        patHistoryDtoLaurent.add(elaurent);
        List<PatHistoryDto> patHistoryDtoJulien = new ArrayList<PatHistoryDto>();
        PatHistoryDto eJulien = new PatHistoryDto(21L, "cholestérol" + " vertige, rechute, taille petite" + "poids faible" +
                "chute Anticorps");
        patHistoryDtoJulien.add(eJulien);
        List<PatHistoryDto> patHistoryDtoAssia = new ArrayList<PatHistoryDto>();
        PatHistoryDto eAssia = new PatHistoryDto(22L, "cholestérol" + " vertige, rechute, taille petite" + "poids faible" +
                "chute Anticorps" + "Hémoglobine A1C");
        patHistoryDtoAssia.add(eAssia);
        ////Liste en rapport du risque Early onset
        List<PatHistoryDto> patHistoryDtoNelly = new ArrayList<PatHistoryDto>();
        PatHistoryDto eNelly = new PatHistoryDto(23L, "cholestérol" + " vertige, rechute, taille petite" + "poids faible" +
                "chute Anticorps" + "Hémoglobine A1C");
        patHistoryDtoNelly.add(eNelly);
        List<PatHistoryDto> patHistoryDtoSebastien = new ArrayList<PatHistoryDto>();
        PatHistoryDto eSebastien = new PatHistoryDto(24L, "cholestérol" + " vertige, rechute, taille petite" + "poids faible");
        patHistoryDtoSebastien.add(eSebastien);
        List<PatHistoryDto> patHistoryDtoMaria = new ArrayList<PatHistoryDto>();
        PatHistoryDto eMaria = new PatHistoryDto(25L, "cholestérol" + " vertige, rechute, taille petite" + "poids faible"
                + "etat anormal, Microalbumine, Hémoglobine A1C, Réaction allergique");
        patHistoryDtoMaria.add(eMaria);
        List<PatHistoryDto> patHistoryDtoBob = new ArrayList<PatHistoryDto>();
        PatHistoryDto eBob = new PatHistoryDto(26L, "cholestérol" + " vertige, rechute, taille petite" + "poids faible," +
                "fumeur");
        patHistoryDtoBob.add(eBob);
        List<PatHistoryDto> patHistoryDtoLaila = new ArrayList<PatHistoryDto>();
        PatHistoryDto eLaila = new PatHistoryDto(27L, "cholestérol" + " vertige, rechute, taille petite" + "poids faible," +
                "fumeur , Microalbumine, Hémoglobine A1C");
        patHistoryDtoLaila.add(eLaila);
        List<PatHistoryDto> patHistoryDtoCyril = new ArrayList<PatHistoryDto>();
        PatHistoryDto eCyril = new PatHistoryDto(28L, "cholestérol" + " vertige, rechute, taille petite" + "poids faible," +
                "fumeur , Microalbumine, Hémoglobine A1C");
        patHistoryDtoCyril.add(eCyril);
        List<PatHistoryDto> patHistoryDtoSousane = new ArrayList<PatHistoryDto>();
        PatHistoryDto eSousane = new PatHistoryDto(29L, "cholestérol" + " vertige, rechute, taille petite" + "poids faible," +
                "fumeur , Microalbumine, Hémoglobine A1C ,réaction allergique,");
        patHistoryDtoSousane.add(eSousane);
        List<PatHistoryDto> patHistoryDtoOmar = new ArrayList<PatHistoryDto>();
        PatHistoryDto eOmar = new PatHistoryDto(30L, "cholestérol" + " vertige, rechute, taille petite" + "poids faible," +
                "fumeur , Microalbumine, Hémoglobine A1C , réaction allergique, etat anormal");
        patHistoryDtoOmar.add(eOmar);
        List<PatHistoryDto> patHistoryDtoSimone = new ArrayList<PatHistoryDto>();
        PatHistoryDto eSimone = new PatHistoryDto(31L, "cholestérol" + " vertige, rechute, taille petite" + "poids faible," +
                "fumeur , Microalbumine, Hémoglobine A1C");
        patHistoryDtoSimone.add(eSimone);
        List<PatHistoryDto> patHistoryDtoMaoura = new ArrayList<PatHistoryDto>();
        PatHistoryDto eMaoura = new PatHistoryDto(32L, "cholestérol" + " vertige, rechute, taille petite" + "poids faible," +
                "fumeur , Microalbumine, Hémoglobine A1C");
        patHistoryDtoMaoura.add(eMaoura);
        List<PatHistoryDto> patHistoryDtoJacques = new ArrayList<PatHistoryDto>();
        PatHistoryDto eJacques = new PatHistoryDto(33L, "cholestérol" + " vertige, rechute, taille petite" + "poids faible," +
                "fumeur , Microalbumine, Hémoglobine A1C, etat anormal");
        patHistoryDtoJacques.add(eJacques);
        List<PatHistoryDto> patHistoryDtoJulia = new ArrayList<PatHistoryDto>();
        PatHistoryDto eJulia = new PatHistoryDto(34L, "cholestérol" + " vertige, rechute, taille petite" + "poids faible," +
                "fumeur , Microalbumine, Hémoglobine A1C, etat anormal, peu d'Anticorps");
        patHistoryDtoJulia.add(eJulia);


        when(mediscreenClient.findById(1L))
                .thenReturn(emily);
        when(patHistoryClient.findAllByPatId(1L))
                .thenReturn(patHistoryDtoemily);

        when(mediscreenClient.findById(2L))
                .thenReturn(john);
        when(patHistoryClient.findAllByPatId(2L))
                .thenReturn(patHistoryDtojhon);

        when(mediscreenClient.findById(3L))
                .thenReturn(yara);
        when(patHistoryClient.findAllByPatId(3L))
                .thenReturn(patHistoryDtoyara);

        when(mediscreenClient.findById(4L))
                .thenReturn(joe);
        when(patHistoryClient.findAllByPatId(4L))
                .thenReturn(patHistoryDtojoe);

        when(mediscreenClient.findById(5L))
                .thenReturn(paola);
        when(patHistoryClient.findAllByPatId(5L))
                .thenReturn(patHistoryDtopaola);

        when(mediscreenClient.findById(6L))
                .thenReturn(med);
        when(patHistoryClient.findAllByPatId(6L))
                .thenReturn(patHistoryDtomed);

        when(mediscreenClient.findById(7L))
                .thenReturn(alex);
        when(patHistoryClient.findAllByPatId(7L))
                .thenReturn(patHistoryDtoalex);

        when(mediscreenClient.findById(8L))
                .thenReturn(monika);
        when(patHistoryClient.findAllByPatId(8L))
                .thenReturn(patHistoryDtomonika);

        when(mediscreenClient.findById(9L))
                .thenReturn(day);
        when(patHistoryClient.findAllByPatId(9L))
                .thenReturn(patHistoryDtoday);

        when(mediscreenClient.findById(10L))
                .thenReturn(ritta);
        when(patHistoryClient.findAllByPatId(10L))
                .thenReturn(patHistoryDtoritta);

        when(mediscreenClient.findById(11L))
                .thenReturn(gerome);
        when(patHistoryClient.findAllByPatId(11L))
                .thenReturn(patHistoryDtogerome);

        when(mediscreenClient.findById(12L))
                .thenReturn(sophie);
        when(patHistoryClient.findAllByPatId(12L))
                .thenReturn(patHistoryDtosophie);
        when(mediscreenClient.findById(13L))
                .thenReturn(laurie);
        when(patHistoryClient.findAllByPatId(13L))
                .thenReturn(patHistoryDtolaurie);
        when(mediscreenClient.findById(14L))
                .thenReturn(damien);
        when(patHistoryClient.findAllByPatId(14L))
                .thenReturn(patHistoryDtodamien);
        when(mediscreenClient.findById(15L))
                .thenReturn(caroline);
        when(patHistoryClient.findAllByPatId(15L))
                .thenReturn(patHistoryDtocaroline);
        when(mediscreenClient.findById(16L))
                .thenReturn(christophe);
        when(patHistoryClient.findAllByPatId(16L))
                .thenReturn(patHistoryDtochristophe);
        when(mediscreenClient.findById(17L))
                .thenReturn(anna);
        when(patHistoryClient.findAllByPatId(17L))
                .thenReturn(patHistoryDtoAnna);
        when(mediscreenClient.findById(18L))
                .thenReturn(peter);
        when(patHistoryClient.findAllByPatId(18L))
                .thenReturn(patHistoryDtoPeter);
        when(mediscreenClient.findById(19L))
                .thenReturn(diana);
        when(patHistoryClient.findAllByPatId(19L))
                .thenReturn(patHistoryDtoDiana);
        when(mediscreenClient.findById(20L))
                .thenReturn(laurent);
        when(patHistoryClient.findAllByPatId(20L))
                .thenReturn(patHistoryDtoLaurent);
        when(mediscreenClient.findById(21L))
                .thenReturn(julien);
        when(patHistoryClient.findAllByPatId(21L))
                .thenReturn(patHistoryDtoJulien);
        when(mediscreenClient.findById(22L))
                .thenReturn(assia);
        when(patHistoryClient.findAllByPatId(22L))
                .thenReturn(patHistoryDtoAssia);
        when(mediscreenClient.findById(23L))
                .thenReturn(nelly);
        when(patHistoryClient.findAllByPatId(23L))
                .thenReturn(patHistoryDtoNelly);
        when(mediscreenClient.findById(24L))
                .thenReturn(sebastien);
        when(patHistoryClient.findAllByPatId(24L))
                .thenReturn(patHistoryDtoSebastien);
        when(mediscreenClient.findById(25L))
                .thenReturn(maria);
        when(patHistoryClient.findAllByPatId(25L))
                .thenReturn(patHistoryDtoMaria);
        when(mediscreenClient.findById(26L))
                .thenReturn(bob);
        when(patHistoryClient.findAllByPatId(26L))
                .thenReturn(patHistoryDtoBob);
        when(mediscreenClient.findById(27L))
                .thenReturn(laila);
        when(patHistoryClient.findAllByPatId(27L))
                .thenReturn(patHistoryDtoLaila);
        when(mediscreenClient.findById(28L))
                .thenReturn(cyril);
        when(patHistoryClient.findAllByPatId(28L))
                .thenReturn(patHistoryDtoCyril);
        when(mediscreenClient.findById(29L))
                .thenReturn(sousane);
        when(patHistoryClient.findAllByPatId(29L))
                .thenReturn(patHistoryDtoSousane);
        when(mediscreenClient.findById(30L))
                .thenReturn(omar);
        when(patHistoryClient.findAllByPatId(30L))
                .thenReturn(patHistoryDtoOmar);
        when(mediscreenClient.findById(31L))
                .thenReturn(simone);
        when(patHistoryClient.findAllByPatId(31L))
                .thenReturn(patHistoryDtoSimone);
        when(mediscreenClient.findById(32L))
                .thenReturn(maoura);
        when(patHistoryClient.findAllByPatId(32L))
                .thenReturn(patHistoryDtoMaoura);
        when(mediscreenClient.findById(33L))
                .thenReturn(jacques);
        when(patHistoryClient.findAllByPatId(33L))
                .thenReturn(patHistoryDtoJacques);
        when(mediscreenClient.findById(34L))
                .thenReturn(julia);
        when(patHistoryClient.findAllByPatId(34L))
                .thenReturn(patHistoryDtoJulia);
/////////////
        List<PatientDto> patientDtos = new ArrayList<>();
        patientDtos.add(sebastien);
        patientDtos.add(john);

        when(mediscreenClient.findByFamily("doe"))
                .thenReturn(patientDtos);
    }

    ////Liste en rapport du risque None
    @Test
    //age<30 sex "F" + 2 Facteurs declancheurs(<4)  report=None
    void shouldReturnNoneForYonger30yoFemaleW2Facteur() {
        String report = reportService.getFeedback(1L);
        assertEquals("Patient: emily Jules (age 27) diabetes assessment is: None", report);
    }

    @Test
        //age<30 sex "M" + 1 Facteurs report=None
    void shouldReturnNoneForYonger30yoMaleW1Facteur() {
        String report = reportService.getFeedback(2L);
        assertEquals("Patient: john doe (age 27) diabetes assessment is: None", report);
    }

    @Test
        //age> 30 sex "F" + 0Facteurs(<2) report=None
    void shouldReturnNoneForOlder30yoFemaleW0Facteur() {
        String report = reportService.getFeedback(3L);
        assertEquals("Patient: yara Jules (age 37) diabetes assessment is: None", report);
    }

    @Test
        //age >30 sex "M" + 0Facteurs report=None
    void shouldReturnNoneForOlder30yoMaleW0Facteur() {
        String report = reportService.getFeedback(4L);
        assertEquals("Patient: joe Jules (age 37) diabetes assessment is: None", report);
    }

    @Test
        //age = 30 sex "F" + 0Facteurs(<2) report=None
    void shouldReturnNoneFor30yoFemaleW0Facteur() {
        String report = reportService.getFeedback(5L);
        assertEquals("Patient: paola Jules (age 30) diabetes assessment is: None", report);
    }

    @Test
        //age =30 sex "M" + 1Facteurs(<2) report = None
    void shouldReturnNoneFor30yoMaleW1Facteur() {
        String report = reportService.getFeedback(6L);
        assertEquals("Patient: med nacer (age 30) diabetes assessment is: None", report);
    }

    ////Test en rapport du risque Borderline
    @Test
    //age =30 sex "M" + 2Facteurs report =Borderline
    void shouldReturnBorderlineFor30yoMaleW2Facteurs() {
        String report = reportService.getFeedback(7L);
        assertEquals("Patient: alex Jules (age 30) diabetes assessment is: Borderline", report);
    }

    @Test
        //age =30 sex "F" + 2Facteurs report =Borderline
    void shouldReturnBorderlineFor30yoFemaleW2Facteurs() {
        String report = reportService.getFeedback(8L);
        assertEquals("Patient: monika Jules (age 30) diabetes assessment is: Borderline", report);
    }

    @Test
        //age =30 sex "M" + 3Facteurs(>2) report =Borderline
    void shouldReturnBorderlineFor30yoMaleW3Facteurs() {
        String report = reportService.getFeedback(9L);
        assertEquals("Patient: day Jules (age 30) diabetes assessment is: Borderline", report);
    }

    @Test
        //age =30 sex "F" + 5Facteurs(>2) report =Borderline
    void shouldReturnBorderlineFor30yoFemaleW5Facteurs() {
        String report = reportService.getFeedback(10L);
        assertEquals("Patient: ritta Jules (age 30) diabetes assessment is: Borderline", report);
    }

    @Test
        //age >30 sex "M" + 5Facteurs(>2) report =Borderline
    void shouldReturnBorderlineForOlder30yoMaleW5Facteurs() {
        String report = reportService.getFeedback(11L);
        assertEquals("Patient: gerome Jules (age 51) diabetes assessment is: Borderline", report);
    }

    @Test
        //age >30 sex "F" + 5Facteurs(>2) report =Borderline
    void shouldReturnBorderlineForOlder30yoFemaleW5Facteurs() {
        String report = reportService.getFeedback(12L);
        assertEquals("Patient: sophie Jules (age 51) diabetes assessment is: Borderline", report);
    }

    ////Liste en rapport du risque In Danger
    @Test
    //age <30 sex "F" + 4 Facteurs report =In Danger
    void shouldReturnInDangerForYonger30yoFemaleW4Facteurs() {
        String report = reportService.getFeedback(13L);
        assertEquals("Patient: laurie Jules (age 27) diabetes assessment is: In Danger", report);
    }

    @Test
        //age <30 sex "M" + 3 Facteurs report =In Danger
    void shouldReturnInDangerForYonger30yoMaleW3Facteurs() {
        String report = reportService.getFeedback(14L);
        assertEquals("Patient: damien Jules (age 27) diabetes assessment is: In Danger", report);
    }

    @Test
        //age <30 sex "M" + 6 Facteurs report =In Danger
    void shouldReturnInDangerForYonger30yoMaleW6Facteurs() {
        String report = reportService.getFeedback(15L);
        assertEquals("Patient: caroline Jules (age 27) diabetes assessment is: In Danger", report);
    }

    @Test
        //age <30 sex "M" + 4 Facteurs report =In Danger
    void shouldReturnInDangerForYonger30yoMaleW4Facteurs() {
        String report = reportService.getFeedback(16L);
        assertEquals("Patient: christophe Jules (age 27) diabetes assessment is: In Danger", report);
    }

    @Test
        //age = 30 sex "F" + 6 Facteurs report =In Danger
    void shouldReturnInDangerFor30yoFemaleW6Facteurs() {
        String report = reportService.getFeedback(17L);
        assertEquals("Patient: anna Jules (age 30) diabetes assessment is: In Danger", report);
    }

    @Test
        //age =30 sex "M" + 6 Facteurs report =In Danger
    void shouldReturnInDangerFor30yoMaleW6Facteurs() {
        String report = reportService.getFeedback(18L);
        assertEquals("Patient: peter nacer (age 30) diabetes assessment is: In Danger", report);
    }

    @Test
        //age =30 sex "F" + 7 Facteurs( 6 <F <8)report =In Danger
    void shouldReturnInDangerFor30yoFemaleW7Facteurs() {
        String report = reportService.getFeedback(19L);
        assertEquals("Patient: diana Jules (age 30) diabetes assessment is: In Danger", report);
    }

    @Test
        //age =30 sex "M" + 7 Facteurs( 6 <F <8) report =In Danger
    void shouldReturnInDangerFor30yoMaleW7Facteurs() {
        String report = reportService.getFeedback(20L);
        assertEquals("Patient: laurent nacer (age 30) diabetes assessment is: In Danger", report);
    }

    @Test
        //age >30 sex "M" + 6 Facteurs( 6 <F <8) report =In Danger
    void shouldReturnInDangerForOlder30yoMaleW6Facteurs() {
        String report = reportService.getFeedback(21L);
        assertEquals("Patient: julien jason (age 61) diabetes assessment is: In Danger", report);
    }

    @Test
        //age >30 sex "F" + 7 Facteurs( 6 <F <8) report =In Danger
    void shouldReturnInDangerForOlder30yoFemaleW7Facteurs() {
        String report = reportService.getFeedback(22L);
        assertEquals("Patient: assia jason (age 61) diabetes assessment is: In Danger", report);
    }

    ////Liste en rapport du risque Early onset
    @Test
    //age <30 sex "F" + 7 Facteurs report =Early onset
    void shouldReturnEarlyOnsetForYonger30yoFemaleW7Facteurs() {
        String report = reportService.getFeedback(23L);
        assertEquals("Patient: nelly chris (age 27) diabetes assessment is: Early onset", report);
    }

    @Test
        //age <30 sex "M" + 5 Facteurs report =Early onset
    void shouldReturnEarlyOnsetForYonger30yoMaleW5Facteurs() {
        String report = reportService.getFeedback(24L);
        assertEquals("Patient: sebastien doe (age 27) diabetes assessment is: Early onset", report);
    }

    @Test
        //age <30 sex "F" + 9 Facteurs(>7) report =Early onset
    void shouldReturnEarlyOnsetForYonger30yoFemaleW9Facteurs() {
        String report = reportService.getFeedback(25L);
        assertEquals("Patient: maria jones (age 27) diabetes assessment is: Early onset", report);
    }

    @Test
        //age <30 sex "M" + 6 Facteurs(>7) report =Early onset
    void shouldReturnEarlyOnsetForYonger30yoMaleW6Facteurs() {
        String report = reportService.getFeedback(26L);
        assertEquals("Patient: bob marley (age 27) diabetes assessment is: Early onset", report);
    }

    @Test
        //age =30 sex "F" + 8 Facteurs report =Early onset
    void shouldReturnEarlyOnsetFor30yoFemaleW8Facteurs() {
        String report = reportService.getFeedback(27L);
        assertEquals("Patient: laila Jules (age 30) diabetes assessment is: Early onset", report);
    }

    @Test
        //age =30 sex "M" + 8 Facteurs report =Early onset
    void shouldReturnEarlyOnsetFor30yoMaleW8Facteurs() {
        String report = reportService.getFeedback(28L);
        assertEquals("Patient: cyril saga (age 30) diabetes assessment is: Early onset", report);
    }

    @Test
       //supprimer //age =30 sex "F" + 8 Facteurs(>8) report =Early onset
    void shouldReturnEarlyOnsetFor30yoFemaleW8Facteur() {
        String report = reportService.getFeedback(29L);
        assertEquals("Patient: sousane foch (age 30) diabetes assessment is: Early onset", report);
    }

    @Test
        //age =30 sex "M" + 9 Facteurs(>8) report =Early onset
    void shouldReturnEarlyOnsetFor30yoMaleW9Facteurs() {
        String report = reportService.getFeedback(30L);
        assertEquals("Patient: omar say (age 30) diabetes assessment is: Early onset", report);
    }

    @Test
        //age >30 sex "M" + 8 Facteurs report =Early onset
    void shouldReturnEarlyOnsetForOlder30yoMaleW8Facteurs() {
        String report = reportService.getFeedback(31L);
        assertEquals("Patient: simone Jules (age 51) diabetes assessment is: Early onset", report);
    }

    @Test
        //age >30 sex "F" + 8 Facteurs report =Early onset
    void shouldReturnEarlyOnsetForOlder30yoFemaleW8Facteurs() {
        String report = reportService.getFeedback(32L);
        assertEquals("Patient: maoura Jules (age 51) diabetes assessment is: Early onset", report);
    }

    @Test
        //age >30 sex "M" + 9 Facteurs(>8) report =Early onset
    void shouldReturnEarlyOnsetForOlder30yoMaleW9Facteurs() {
        String report = reportService.getFeedback(33L);
        assertEquals("Patient: jacques San (age 51) diabetes assessment is: Early onset", report);
    }

    @Test
        //age >30 sex "F" + 10 Facteurs(>8) report =Early onset
    void shouldReturnEarlyOnsetForOlder30yoFemaleW10Facteurs() {
        String report = reportService.getFeedback(34L);
        assertEquals("Patient: julia soulat (age 51) diabetes assessment is: Early onset", report);
    }

    @Test
    void getFeedBackWithFamilyNameDoeShouldReturn2() {
        List<String> reports = reportService.getFeedbackWithFamilyName("doe");
        assertEquals(2, reports.size());

        assertTrue(reports.contains(
                reportService.getFeedback(2L)
        ));

        assertTrue(reports.contains(
                reportService.getFeedback(24L)
        ));
    }

    @Test
    void getFeedBackWithWrongFamilyNameShouldreturnNoPatient() {
        List<String> reports = reportService.getFeedbackWithFamilyName("lamouchi");
        assertEquals(0, reports.size());

        assertFalse(reports.contains(
                reportService.getFeedback(2L)
        ));

        assertFalse(reports.contains(
                reportService.getFeedback(24L)
        ));
    }
}
