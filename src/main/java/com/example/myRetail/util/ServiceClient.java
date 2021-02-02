package com.example.myRetail.util;


import com.example.myRetail.dto.AbstractRequestDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ServiceClient {


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public <S extends AbstractRequestDTO, T> ResponseEntity<T> post(String urlSuffix,
                                                                    S requestObject,
                                                                    Class<T> responseClass) {
        try {
            return this.restTemplate().postForEntity(urlSuffix, new HttpEntity<>(requestObject), responseClass);
        } catch (Exception e) {
            throw e;
        }
    }

    public <S extends AbstractRequestDTO> void put(String urlSuffix,
                                                   S requestObject
    ) {
        try {
            this.restTemplate().put(urlSuffix, new HttpEntity<>(requestObject));
        } catch (Exception e) {
            throw e;
        }
    }

    public <T> ResponseEntity<T> get(String urlSuffix,
                                     Class<T> responseClass) {
        try {
            return this.restTemplate().getForEntity(urlSuffix, responseClass);
        } catch (Exception e) {
            throw e;
        }
    }
}
