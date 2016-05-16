
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
* Software/Analysetools? _(Warnung bei bestimenten Ereignissen)_

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

* Logger
* Appender
* Formatter / Layout
* Encoder
* Log Level

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
  * ....

++++++++++++++++++++++++
## Encoder _nur logback

* 

++++++++++++++++++++++++
# Performance
