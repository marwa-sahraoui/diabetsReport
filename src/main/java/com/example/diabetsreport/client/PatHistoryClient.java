package com.example.diabetsreport.client;

import com.example.diabetsreport.model.PatHistoryDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PatHistoryClient {
    /*les clients rest vont se connecter aux services externes en utilisant le rest template qui a besoin d 'un url qui va joindre le service
    //Vue que l 'application peut s'executer en local et docker,  on utilise le méca du variable d'environnement pour définir l'url  de service
   selon l'environnement */
    @Value("${pathistory-server-url}")
    private String pathistoryServerUrl;

    public PatHistoryClient(){
    }

    public PatHistoryClient(String pathistoryServerUrl) {
        this.pathistoryServerUrl = pathistoryServerUrl;
    }

    public List<PatHistoryDto> getPatHistory() {
        RestTemplate restTemplate = new RestTemplate();

        String address = "http://" + pathistoryServerUrl + ":8082/patHistory";

        ResponseEntity<PatHistoryDto[]> response = restTemplate.getForEntity(address, PatHistoryDto[].class);

        return Arrays.asList(response.getBody());
    }

    public List<PatHistoryDto> findAllByPatId( Long patId) {
        RestTemplate restTemplate = new RestTemplate();

        String address = "http://" + pathistoryServerUrl + ":8082/patHistory/patId/" + patId;

        ResponseEntity<PatHistoryDto[]> response = restTemplate.getForEntity(address, PatHistoryDto[].class);

        return Arrays.asList(response.getBody());

    }

    //on peut pas utiliser sinn les fiches seront les mêmes pour tous les patients a même nom
    public List<PatHistoryDto> findByFamily(String family) {
        RestTemplate restTemplate = new RestTemplate();

        String address = "http://" + pathistoryServerUrl + ":8082/patHistory/family/" + family;

        ResponseEntity<PatHistoryDto[]> response = restTemplate.getForEntity(address, PatHistoryDto[].class);

        return Arrays.asList(response.getBody());
    }
}
