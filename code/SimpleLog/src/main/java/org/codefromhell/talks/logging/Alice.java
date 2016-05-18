package org.codefromhell.talks.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Grunert, Marco <marco@grnrt.org>
 */
public class Alice extends Person {

    // Logger logger = LoggerFactory.getLogger(Bob.class); -> prone to error (copy'n'paste will never die)
    //                                                     -> but one instance for every object
    static final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Alice(int age, String profession) {
        super(age, profession);
        logger.info("[alice] was instantiated");
    }
}
