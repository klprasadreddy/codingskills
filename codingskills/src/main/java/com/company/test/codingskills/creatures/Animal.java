package com.company.test.codingskills.creatures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Animal implements Creature,Cloneable {

    private boolean isWalker;
    private boolean isSwimmer;

    public boolean isWalker() {
        return isWalker;
    }

    public boolean isFlyer() {
        return isFlyer;
    }

    public boolean isSinger() {
        return isSinger;
    }

    public boolean isJoker() {
        return isJoker;
    }

    private boolean isFlyer;
    private boolean isSinger;
    private boolean isJoker;
    private String sound;
    private Animal neighbourAnimal;

    public Animal getNeighbourAnimal() {
        return neighbourAnimal;
    }
    public boolean isSwimmer() {
        return isSwimmer;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void setNeighbourAnimal(Animal neighbourAnimal) {
        this.neighbourAnimal = neighbourAnimal;
    }

    public void setWalker(boolean walker) {
        isWalker = walker;
    }

    public void setSwimmer(boolean swimmer) {
        isSwimmer = swimmer;
    }

    public void setFlyer(boolean flyer) {
        isFlyer = flyer;
    }

    public void setSinger(boolean singer) {
        isSinger = singer;
    }

    public void setJoker(boolean joker) {
        isJoker = joker;
    }

    public void buildCreatureChars(boolean isWalker,boolean isSwimmer,
                              boolean isFlyer, boolean isSinger,
                              boolean isJoker, String sound ){

        setFlyer(isFlyer);
        setWalker(isWalker);
        setSinger(isSinger);
        setJoker(isJoker);
        setSwimmer(isSwimmer);
        setSound(sound);
    }

    private AnimalTypes animalName;

    public AnimalTypes getNeighbourAnimalName() {
        return neighbourAnimalName;
    }

    public void setNeighbourAnimalName(AnimalTypes neighbourAnimalName) {
        this.neighbourAnimalName = neighbourAnimalName;
    }

    private AnimalTypes neighbourAnimalName;

    public AnimalTypes getAnimalName() {
        return animalName;
    }

    public void setAnimalName(AnimalTypes animalName) {
        this.animalName = animalName;
    }

    @Override
    public String walk() {

        return !isWalker?"I Can't Walk": Creature.super.walk();
    }

    @Override
    public String fly() {
        return isFlyer?"I Can Fly": Creature.super.fly();
    }

    @Override
    public String swim() {
        return isSwimmer?"I Can Swim": Creature.super.swim();
    }

    @Override
    public String sing() {
        String tune ="";
        if(isSinger){
            tune = "I Can Sing..like..";
            if(animalName.name().equalsIgnoreCase(AnimalTypes.PARROT.name())){
                if(getNeighbourAnimal()!=null){
                    tune += getNeighbourAnimal().isSinger?getNeighbourAnimal().getSound():getSound();
                }
            }else{
                tune+=getSound();
            }
        }

        return tune.isEmpty()?"I Can't Sing":tune;
    }


    public String fetchCharacteristics() {
        return "I am a "+animalName.name()+"...\n"+ walk()+"...\n"+fly()+"...\n"+swim()+"...\n"+sing();
    }
    public Object clone() throws CloneNotSupportedException  {
        return super.clone();
    }
}
