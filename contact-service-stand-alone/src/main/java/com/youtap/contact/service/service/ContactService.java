package com.youtap.contact.service.service;

import com.youtap.contact.service.response.ThirdPartyUserResponse;
import com.youtap.contact.service.response.UserContactResponse;
import com.youtap.contact.service.util.ThirdPartyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ContactService {
    @Autowired
    private ThirdPartyUtil thirdPartyUtil;

    public ResponseEntity getUserContactByIdOrUsername(String query){

        log.info("Hitting Third Party API for users");
        ResponseEntity responseEntity =thirdPartyUtil.getUsersFromThirdPartyAPI();
        if(responseEntity.getStatusCodeValue()!=200){
            ///////////////////if status is not 200 return the Response
            return responseEntity;
        }else{
            log.info("Searching users using username");
            List<ThirdPartyUserResponse> users= (List<ThirdPartyUserResponse>)responseEntity.getBody();
            ThirdPartyUserResponse foundUser=    users.stream().filter(user -> user.getUsername().equalsIgnoreCase(query))
                    .findFirst()
                    .orElse(null);
            if(foundUser!=null){
                ////////////////////////return the found User///////////////////////////////
                return ResponseEntity.ok(this.mapThirdPartyResponseToContactResponse(foundUser));
            }else{
                ////////////////////////try searching by userId//////////////////////////////////////////////
                UserContactResponse foundUserById=this.getUserContactByUserId(query,users);
                return ResponseEntity.ok(foundUserById);
            }

        }

    }
    private UserContactResponse getUserContactByUserId(String query,List<ThirdPartyUserResponse> users ){
        log.info("Searching users using User Id");
        ////////////////////////try converting string User Id///////////////////////////////
        try{
            long userid=    Long.parseLong(query);
            ThirdPartyUserResponse foundUser=    users.stream().filter(user -> user.getId() ==userid)
                    .findFirst()
                    .orElse(null);
            if(foundUser!=null){
                //////////////////////return the found user//////////////////////
                return this.mapThirdPartyResponseToContactResponse(foundUser);

            }else{
                /////////////////////////return Not found Response//////////////////////
                return this.formulateNoResponse();
            }
        }catch(Exception e){
            return this.formulateNoResponse();
        }

    }
    private UserContactResponse mapThirdPartyResponseToContactResponse(ThirdPartyUserResponse thirdResponse){
        UserContactResponse response = new UserContactResponse();
        response.setEmail(thirdResponse.getEmail());
        response.setId(thirdResponse.getId());
        response.setPhone(thirdResponse.getPhone());
        return response;
    }
    private UserContactResponse formulateNoResponse(){
        UserContactResponse response = new UserContactResponse();
        response.setEmail("N/A");
        response.setId(-1);
        response.setEmail("N/A");
        response.setPhone("N/A");
        return response;
    }
}
