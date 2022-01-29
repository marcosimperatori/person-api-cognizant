package com.cognizant.imperatori.apipessoa.controller;

import com.cognizant.imperatori.apipessoa.dto.MessageResponseDTO;
import com.cognizant.imperatori.apipessoa.dto.request.PersonDTO;
import com.cognizant.imperatori.apipessoa.exception.PersonNotFounException;
import com.cognizant.imperatori.apipessoa.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PessoaController {

    private PersonService personService;

    public PessoaController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO person){
      return personService.createPerson(person);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
       return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFounException {
        return personService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFounException {
        personService.deleteById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody PersonDTO personDTO) throws PersonNotFounException {
        return personService.updateById(id,personDTO);
    }
}
