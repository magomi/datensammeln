# Was wollen wir eigentlich?

* Trennung zwischen Log-Eintrag erzeugen und formatierter Ausgabe
* Konfiguration zur Steuerung
    * was wird geloggt
    * wohin wird geloggt
    * wie wird formatiert

Note: wir leben nicht mehr in den 80ern



# Was verwenden wir?

* JUL (java.util.logging)
* Apache Java Commons Logging (jcl)
* Log4j 1 und 2
* LogBack

Note: 
* jcl: 2014 Support Java 1.1 eingestellt



# Grundlegene Konzepte

* Log Level
* Logger
* Appender
* Formatter / Layout
* Encoder


## Log level

* ERROR
* WARN (WARNING)
* INFO
* DEBUG
* TRACE


## Logger

* Hierarchie
* sind immer genau einem Log level zugewiesen
* ist mindestens einem Appender zugewiesen


## Appender

* Ziel der Ausgabe, z.B.:
  * File _(mit log rotation)_
  * Database
  * Socket
  * console
  * JMS
  * Unix Syslog
  * Mail
  * SNMP
  * ....


# Schauen wir mal...



### Asynchrone Appender (logback)

* Entkoplung Sender <--> Empfänger
* Arbeiten in der Regel mit einer DQueue
* Datenverlusst wenn Queue voll (80%)
  _studie zeigt das DQueues entweder voll oder leer sind_

++++++++++++++++++++++++
### Asynchrone Logger (Log4J)

_bild von http://logging.apache.org/log4j/2.x/manual/async.html#Performance einsetzen_


* nutzen LMAX Disruptors _ http://lmax-exchange.github.io/disruptor/ _
* kein Datenverlust

++++++++++++++++++++++++
## Encoder (logback))

* z.B. für JSON Output

_eventuell weglassen_

++++++++++++++++++++++++
## MDC

Mapped diagnostic Context
* Anreicherung des Logs mit MetaInformationen
* Speichern von Key / Values _z.B. session id, user id_
* automatischen Einfügen in die Logs per Konfiguration

_code?_

++++++++++++++++++++++++
## Wahl eines Logging Frameworks

* JUL und JCL nicht mehr aktuell und keine Weiterentwicklung.
* einzigster Vorteil JUL: keine zusätzliche Abhängigkeit
* _research warum von JUL and JUL abgeraten wird_
* Entscheidung zwischen Log4J und SLF4J/Logback
_ Argumente von http://logback.qos.ch/reasonsToSwitch.html (auszugsweise) übernehmen_
* SLF4J: config besser lesbar _beispiel einfügen?_
* Logack: SiftingAppender: separate Appender je nach Runtime Attribute _z.B. per user_

++++++++++++++++++++++++
### Konsolidierung Logging Framework

* Verwendung der SLF4J API im eigenen code
* Loggingframework wird zur Laufzeit durch Classpath bestimmt
* Fremdbibliotheken haben häufig feste Abhängigkeit zu bestimmmten Framework
* Auswahl per Build-Tool
* Ersetzen von JUL oder JCL durch SLF4J - Stubbs

```XML
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-core</artifactId>
  <version>${spring.version}</version>
  <exclusions>
    <exclusion>
      <groupId>commons-logging</groupId>
      <artifactId>commons-logging</artifactId>
    </exclusion>
  </exclusions>
</dependency>
<dependency>
  <groupId>org.slf4j</groupId>
  <artifactId>jcl-over-slf4j</artifactId>
</dependency>
```

++++++++++++++++++++++++

# Performance

* Kosten für Aufruf von .debug(), .info(),..:
  * API call
  * prüfen ob log level ausreichend
-> kleiner Overhead, wenn nicht Stringkonkatenation verwendet wird

```Java
logger.debug("found customer: " + customer);
```

```Java
logger.debug("found customer: {}", customer);
```

-> Prüfung im code selten sinnvoll
```Java
if(logger.isDebug()) {
    logger.debug("found customer:" + customer);
}
```

++++++++++++++++++++++++

* Was loggen wir?
* Auf welchem Level?
* Abstimmen mit Betrieb, NFR?
* An Schnittstellen, was ging rein / raus?
* Zeiten für externe Aufrufe
* Exceptions: dort wo behandelt wird.
* Vorgaben zu Beginn eines Projektes festhalten

++++++++++++++++++++++++
## Formating log Einträge

* durch das Frameworks
* Auswirkungen auf Performance beachten:
  * PatternLayout kein C , F, L, M vermeiden, da Aufwendig in Bestimmung
* Trennzeichen zwischen Teilen des Logs verwenden für einfacheres parsen
* gleiches Format auf allen Umgebungen
