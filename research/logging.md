* http://blog.progs.be/593/logstash-kibana-java-log

* verschiedene Java-Logging-Frameworks

* Aufbau logfiles
* Konfiguration log4j, slf4j,...

* log4j directly to logstash
* https://www.monitis.com/blog/2012/08/07/monitor-your-java-application-logs-in-4-easy-steps

# Logging Frameworks

* Log4J
* SLF4J
* Logback

## logback vs. log4j

* Reasons to prefer logback over log4j: http://logback.qos.ch/reasonsToSwitch.html


# Logging Wrapper

* Apache Commons Logging
* Java Logging

# Java Loglevels

* FATAL	Severe errors that cause premature termination. Expect these to be immediately visible on a status console.
* ERROR	Other runtime errors or unexpected conditions. Expect these to be immediately visible on a status console.
* WARNING
* INFO	Interesting runtime events (startup/shutdown). Expect these to be immediately visible on a console, so be conservative and keep to a minimum.
* DEBUG	detailed information on the flow through the system. Expect these to be written to logs only.
* TRACE	more detailed information. Expect these to be written to logs only.

# dynamically set log level

* Kompromiss zwischen
    * notwendige Informationen
    * Resourcenverbrauch (I/O, Speicherplatz,...)
* logback unsterstützt reload der Konfiguration


# mehr Informationen

* Tomcat Thread-ID  
