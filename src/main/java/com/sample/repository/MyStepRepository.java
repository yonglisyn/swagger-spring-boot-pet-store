package com.sample.repository;

import com.sample.models.MyStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class MyStepRepository {
    private static List<MyStep> stepStore = new ArrayList<>(Arrays.asList(
            new MyStep(1,"step1","test",new Date()),
            new MyStep(2,"step2","test",new Date()),
            new MyStep(3,"step3","test",new Date())
    ));

    @Autowired
    public MyStepRepository(){}

    public MyStep getStep(Integer id){
        return stepStore.stream().filter(x->x.getId() ==id).findFirst().get();
    }


}
