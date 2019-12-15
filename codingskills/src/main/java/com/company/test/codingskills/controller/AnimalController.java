package com.company.test.codingskills.controller;

import com.company.test.codingskills.model.AnimalReq;
import com.company.test.codingskills.model.AnimalRes;
import com.company.test.codingskills.service.AnimalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("Set of endpoints for Creating, Retrieving, Updating and Deleting of Persons.")
public class AnimalController {

    @Autowired
    AnimalService animalService;


    @GetMapping("/fetchAnimalCharactistics")
    @ApiOperation("Returns list of all Persons in the system.")
    public @ResponseBody ResponseEntity<AnimalRes> fetchAnimalCharactistics(AnimalReq req){

        AnimalRes animalRes = animalService.fetchAnimalCharactistics(req);
        ResponseEntity res = new ResponseEntity(animalRes, HttpStatus.OK);
        return res;
    }

    @GetMapping("/hai")
    public String hello(){
        return "hai";
    }
}
