package com.company.test.codingskills.model;

import com.company.test.codingskills.creatures.Animal;
import com.company.test.codingskills.creatures.AnimalTypes;

import java.util.List;
import java.util.Map;

public class AnimalMap {

    public Map<AnimalTypes, Animal> getAnimalsMap() {
        return animalsMap;
    }

    public void setAnimalsMap(Map<AnimalTypes, Animal> animalsMap) {
        this.animalsMap = animalsMap;
    }

    Map<AnimalTypes,Animal> animalsMap;
}
