package com.sample.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.model.Pet;
import com.sample.repository.StoreRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class PetController implements PetApi {

    private final StoreRepository store;
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    @Autowired
    public PetController(StoreRepository store, ObjectMapper objectMapper, HttpServletRequest request) {
        this.store = store;
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public Optional<String> getAcceptHeader() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<String> addPet(@ApiParam(required=true )  @Valid @RequestBody Pet body) {
        store.add(body);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deletePet(@ApiParam(required=true) @PathVariable("petId") Integer petId) {
        store.delete((long)petId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Pet> getPetById(@ApiParam(required=true) @PathVariable("petId") Integer petId) {
        Pet mao = store.get((long)petId);
        return new ResponseEntity<>(mao, HttpStatus.OK);
    }
}
