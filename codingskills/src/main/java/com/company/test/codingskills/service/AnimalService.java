package com.company.test.codingskills.service;

import com.company.test.codingskills.creatures.Animal;
import com.company.test.codingskills.creatures.AnimalTypes;
import com.company.test.codingskills.model.AnimalMap;
import com.company.test.codingskills.model.AnimalReq;
import com.company.test.codingskills.model.AnimalRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    @Autowired
    AnimalMap animalMap;

    public AnimalRes fetchAnimalCharactistics(AnimalReq req){


        AnimalRes res = new AnimalRes();
        Animal animal = getAnimal(AnimalTypes.valueOf(req.getAnimalName()));
        if(!req.getNearByAnimal().isEmpty()){
            animal.setNeighbourAnimal(getAnimal(AnimalTypes.valueOf(req.getNearByAnimal())));
        }
        res.setAnimalCaracteristicks(animal.fetchCharacteristics());
        return res;
    }

    public Animal getAnimal(AnimalTypes animalTypes){
        try {
            return (Animal) animalMap.getAnimalsMap().get(animalTypes).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
