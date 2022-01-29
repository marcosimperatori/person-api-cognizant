package com.cognizant.imperatori.apipessoa.utils;

import com.cognizant.imperatori.apipessoa.dto.request.PhoneDTO;
import com.cognizant.imperatori.apipessoa.entity.Phone;
import com.cognizant.imperatori.apipessoa.enums.PhoneType;

public class PhoneUtils {
    public static final String PHONE_NUMBER = "11-2222-3333";
    public static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final Long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO(){
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity(){
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
