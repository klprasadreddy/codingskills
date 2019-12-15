package com.company.test.codingskills.model;

public class AnimalReq {

    public String animalName;
    public String nearByAnimal="";

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getNearByAnimal() {
        return nearByAnimal;
    }

    public void setNearByAnimal(String nearByAnimal) {
        this.nearByAnimal = nearByAnimal;
    }
}
