
mock presi using simple formating:
  * '++..+' Zeilen sind Folientrenner
  * _italic für Anmerkungen / Tonspur_


++++++++++++++++++++++++

```Java
System.out.println("no customer found")
```
_alles was man braucht? Vortrag zu Ende?_

_was fehlt:_
* wo ist das aufgetreten
* wann ist das aufgetreten?
* ist das ein Fehler? ein Hinweis? Oder nur Debug?
* Steurung/Konfiguration ohne SW Änderung

++++++++++++++++++++++++
Für wen loggen wir?
* Entwickler?
* Betrieb?
* Software/Analysetools? _(Warnung bei bestimmmten Ereignissen)_

++++++++++++++++++++++++
### Logging Frameworks
_wir leben nicht mehr in den 80ern_
* Trennung zwischen Log-Eintrag erzeugen und formatierter Ausgabe
* Konfiguration zur Steuerung
   * was wird geloggt
   * wohin wird geloggt
   * wie wird formatiert

++++++++++++++++++++++++
### Heute verwendete Frameworks

* JUL (java.util.logging)
* Apache Java Commons Logging (jcl) _letzte Änderung 2014 dropped Support für Java 1.1)_
* Log4j 1 und 2
* SLF4J / logback

++++++++++++++++++++++++
# Grundlegene Konzepte

* Log Level
* Logger
* Appender
* Formatter / Layout
* Encoder

++++++++++++++++++++++++
## Log level

* ERROR
* WARN (WARNING)
* INFO
* DEBUG
* TRACE

++++++++++++++++++++++++

## Logger

* Hirarchie
* sind immer genau einem Log level zugewiesen
* ist mindestens einem Appender zugewiesen

++++++++++++++++++++++++
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

++++++++++++++++++++++++

_kurze Beispiele für logs im code und formatierte Ausgabe?_

++++++++++++++++++++++++
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
