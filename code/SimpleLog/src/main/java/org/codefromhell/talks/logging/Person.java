package org.codefromhell.talks.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by marco on 03/05/16.
 */
public class Person {
    static final Logger logger = LoggerFactory.getLogger(Person.class);

    private int age;
    private String profession;

    public Person(final int age, final String profession) {
        this.age = age;
        this.profession = profession;
        logger.info("a [person] was instantiated");
    }
}
