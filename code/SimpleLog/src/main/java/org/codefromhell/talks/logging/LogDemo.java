package org.codefromhell.talks.logging;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * @author Grunert, Marco <marco@grnrt.org>
 */
public class LogDemo {
    static final Logger logger = LoggerFactory.getLogger(LogDemo.class);

    public static void main(String[] args) {
        MDC.put("java.vm.name", System.getProperty("java.vm.name"));
        MDC.put("java.vm.version", System.getProperty("java.vm.version"));

        logger.info("application started");
        Alice alice = new Alice(23, "Naive Project Manager");
        Bob bob = new Bob(42, "Grumpy IT Guy");
    }
}
