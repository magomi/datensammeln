package org.codefromhell.talks.logging;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Grunert, Marco <marco@grnrt.org>
 */
public class LogDemo {
    static final Logger logger = LoggerFactory.getLogger(LogDemo.class);

    public static void main(String[] args) {
        logger.info("application [] started")
        Alice alice = new Alice(23, "Naive Project Manager");
        Bob bob = new Bob(42, "Grumpy IT Guy");
    }
}
