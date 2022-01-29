package com.cognizant.imperatori.apipessoa.service;

import com.cognizant.imperatori.apipessoa.dto.MessageResponseDTO;
import com.cognizant.imperatori.apipessoa.dto.request.PersonDTO;
import com.cognizant.imperatori.apipessoa.entity.Person;
import com.cognizant.imperatori.apipessoa.mapper.PersonMapper;
import com.cognizant.imperatori.apipessoa.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.cognizant.imperatori.apipessoa.utils.PersonUtils.createFakeDTO;
import static com.cognizant.imperatori.apipessoa.utils.PersonUtils.createFakeEntity;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivePersonDTOThenReturnSavedMessage(){
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavePerson = createFakeEntity();

        when(personMapper.toModel(personDTO)).thenReturn(expectedSavePerson);
        when(personRepository.save(any(Person.class))).thenReturn(expectedSavePerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavePerson.getId());
        MessageResponseDTO successMesssage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage,successMesssage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId) {
        return MessageResponseDTO.builder()
                .message("Person successfully created with id " + savedPersonId)
                .build();
    }
}
