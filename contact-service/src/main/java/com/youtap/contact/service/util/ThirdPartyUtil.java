package com.youtap.contact.service.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtap.contact.service.response.ThirdPartyUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
@Slf4j
public class ThirdPartyUtil {
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity getUsersFromThirdPartyAPI() {

        try {
            String uri ="https://jsonplaceholder.typicode.com/users" ;

            ResponseEntity<JsonNode> response = restTemplate.getForEntity(uri,JsonNode.class);
            if(response.getStatusCodeValue()==200){
                ObjectMapper jsonObjectMapper = new ObjectMapper();
                List<ThirdPartyUserResponse> apiResponse = jsonObjectMapper.readValue(response.getBody().toString(), jsonObjectMapper.getTypeFactory().constructCollectionType(List.class, ThirdPartyUserResponse.class));

                return ResponseEntity.ok(apiResponse);
            }else{
                return  response;
            }



        } catch (Exception e) {
            return new ResponseEntity<>(new GenericApiError("Could Get Users from Third Party API"),
                    HttpStatus.EXPECTATION_FAILED);

        }
    }
}
