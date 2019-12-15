package com.company.test.codingskills.creatures;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;


public interface Creature {


    default String walk(){
        return "I Can Walk";
    }
    default String fly(){
        return "I Can't fly";
    }
    default String swim(){
        return "I Can't swim";
    }
    String sing();
}
