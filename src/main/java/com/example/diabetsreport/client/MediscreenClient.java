package com.example.diabetsreport.client;

import com.example.diabetsreport.model.PatientDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class MediscreenClient {
   /* les clients rest vont se connecter aux services externes en utilisant le rest template qui a besoin d 'un url qui va joindre le service
    Vue que l 'application peut s'executer en local et docker,  on utilise le méca du variable d'environnement pour définir l'url  de service
    selon l'environnement */
    @Value("${mediscreen-server-url}")
    private String mediscreenServerUrl;

    public MediscreenClient(){
    }

    public MediscreenClient(String mediscreenServerUrl) {
        this.mediscreenServerUrl = mediscreenServerUrl;
    }

    public List<PatientDto> getPatients() {
        RestTemplate restTemplate = new RestTemplate();

        String address = "http://" + mediscreenServerUrl + ":8081/patient";
        ResponseEntity<PatientDto[]> response = restTemplate.getForEntity(address, PatientDto[].class);

        return Arrays.asList(response.getBody());
   }

    public PatientDto findById(Long id) {
        RestTemplate restTemplate = new RestTemplate();

        String address = "http://" + mediscreenServerUrl + ":8081/patient/" + id;
        ResponseEntity<PatientDto> response = restTemplate.getForEntity(address , PatientDto.class) ;

        return response.getBody();

    }

     //créer pour satisfaire les exemples de client
    public List<PatientDto> findByFamily(String family) {
        RestTemplate restTemplate = new RestTemplate();

        String address = "http://" + mediscreenServerUrl + ":8081/patient/familyName/" + family;
        ResponseEntity<PatientDto> response = restTemplate.getForEntity(address , PatientDto.class) ;

        return Arrays.asList(response.getBody());
    }
}
