package org.codefromhell.talks.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Grunert, Marco <marco@grnrt.org>
 */
public class Bob extends Person {
    Logger logger = LoggerFactory.getLogger(Bob.class);

    public Bob(int age, String profession) {
        super(age, profession);
        logger.info("[bob] was instantiated");

    }
}
