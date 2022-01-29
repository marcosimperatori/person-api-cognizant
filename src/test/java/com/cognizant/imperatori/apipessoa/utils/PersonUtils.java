package com.cognizant.imperatori.apipessoa.utils;

import com.cognizant.imperatori.apipessoa.dto.request.PersonDTO;
import com.cognizant.imperatori.apipessoa.entity.Person;
import jdk.jshell.PersistentSnippet;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    public static final String FIRST_NAME = "Marcos";
    public static final String LAST_NAME = "Vinicius";
    public static final String CPF = "000.111,222-99";
    public static final long PERSON_ID = 1l;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010,10,1);

    public static PersonDTO createFakeDTO(){
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF)
                .birthDate("04-04-2010")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity(){
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
