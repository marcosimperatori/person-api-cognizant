package com.cognizant.imperatori.apipessoa.service;

import com.cognizant.imperatori.apipessoa.dto.MessageResponseDTO;
import com.cognizant.imperatori.apipessoa.dto.request.PersonDTO;
import com.cognizant.imperatori.apipessoa.entity.Person;
import com.cognizant.imperatori.apipessoa.exception.PersonNotFounException;
import com.cognizant.imperatori.apipessoa.mapper.PersonMapper;
import com.cognizant.imperatori.apipessoa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO person){
        Person personToSave = personMapper.toModel(person);

        Person personSaved = personRepository.save(personToSave);

        return createMessageResponse(personSaved.getId(), "Created person with ID: ");
    }

    public List<PersonDTO> listAll(){
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFounException {
       Person person = verifyIfExists(id);
       return personMapper.toDTO(person);
    }

    public void deleteById(Long id) throws PersonNotFounException {
        verifyIfExists(id);
        personRepository.deleteById(id);

    }

    private Person verifyIfExists(Long id) throws PersonNotFounException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFounException(id));
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFounException {
        verifyIfExists(id);

        Person personToUpdated = personMapper.toModel(personDTO);

        Person personUpdated = personRepository.save(personToUpdated);
        return createMessageResponse(personUpdated.getId(), "Updated person with ID: ");
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
