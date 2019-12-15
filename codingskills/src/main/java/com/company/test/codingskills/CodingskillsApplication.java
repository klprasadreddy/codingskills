package com.company.test.codingskills;

import com.company.test.codingskills.creatures.Animal;
import com.company.test.codingskills.creatures.AnimalTypes;
import com.company.test.codingskills.creatures.Creature;
import com.company.test.codingskills.model.AnimalMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This Class is the Test class to Show the code crafting skills
 * @author Lakshmi Prasad
 */
@SpringBootApplication
public class CodingskillsApplication {

	@Autowired
	AnimalMap animalMap;

	@Autowired
	Environment env;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CodingskillsApplication.class, args);

		CodingskillsApplication application = context.getBean(CodingskillsApplication.class);
		application.printFatures();
	}

	public void printFatures()  {
		int swimmerCount=0;
		int flyerCount=0;
		int dancerCount=0;
		int singerCount=0;

		Animal animal =getAnimal(AnimalTypes.PARROT);
		Animal neighbourAnimal = getAnimal(AnimalTypes.DOG);
		animal.setNeighbourAnimal(neighbourAnimal);

		List<Animal> animalsList = new ArrayList<Animal>();

		animalsList.add(getAnimal(AnimalTypes.PARROT));
		animalsList.add(getAnimal(AnimalTypes.DOG));
		animalsList.add(getAnimal(AnimalTypes.CAT));

		swimmerCount = animalsList.stream().filter(x->x.isSinger()).collect(Collectors.toList()).size();
		flyerCount = animalsList.stream().filter(x->x.isFlyer()).collect(Collectors.toList()).size();
		singerCount = animalsList.stream().filter(x->x.isSinger()).collect(Collectors.toList()).size();

		System.out.println(swimmerCount+" Animals Can Swim");
		System.out.println(flyerCount+" Animals Can Fly");
		System.out.println(singerCount+" Animals Can Sing");

		System.out.println(animal.fetchCharacteristics());
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
