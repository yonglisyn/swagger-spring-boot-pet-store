package com.sample.api;

import com.sample.models.MyStep;
import com.sample.repository.MyStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class MyStepController {

    private MyStepRepository repository;

    @Autowired
    public MyStepController(MyStepRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "step/{id}", method = RequestMethod.GET,produces = "application/json")
    public MyStep getStep(@PathVariable Integer id){
        return repository.getStep(id);
    }


    @RequestMapping(value = "step2/{id}", method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<MyStep> getStepDiff(@PathVariable Integer id){
        return new ResponseEntity<>(repository.getStep(id),HttpStatus.OK);
    }

}
