package com.company.test.codingskills.config;

import com.company.test.codingskills.creatures.Animal;
import com.company.test.codingskills.creatures.AnimalTypes;
import com.company.test.codingskills.model.AnimalMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@Configuration
@EnableSwagger2
@ComponentScan
public class ApplicationConfig {


    @Value("${testapp.fly.animals}")
    public List<String> flyers;

    @Value("${testapp.swim.animals}")
    public List<String> swimmers;

    @Value("${testapp.sing.animals}")
    public List<String> singers;

    @Value("${testapp.nowalk.animals}")
    public List<String> noWalkers;

    @Value("${testapp.animal.sound.cock}")
    public String cockSound;

    @Autowired
    private Environment env;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public AnimalMap animalMap(){
        AnimalMap animalsMap = new AnimalMap();
        Map<AnimalTypes,Animal>  animalMap = new HashMap<>();
        Arrays.asList(AnimalTypes.values()).forEach(x->{
                Animal animal = new Animal();
                animal.setAnimalName(x);
            animalMap.put(x,buildAnimal(animal));
        });
        animalsMap.setAnimalsMap(animalMap);
        return animalsMap;
    }

    private Animal buildAnimal(Animal animal){

        boolean isSing = singers.contains(animal.getAnimalName().name());
        boolean isSwim = swimmers.contains(animal.getAnimalName().name());
        boolean isWalk = !noWalkers.contains(animal.getAnimalName().name());
        boolean isFly = flyers.contains(animal.getAnimalName().name());
        String propName = "testapp.animal.sound."+animal.getAnimalName().name().toLowerCase();
        String sound = env.getProperty(propName);
        //System.out.println(animal.getAnimalName().name()+"====>"+ sound);
        animal.buildCreatureChars(isWalk,isSwim,isFly,isSing,false,sound);

        return animal;


    }





}
