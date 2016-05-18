# Warum sammelen wir Daten

* Zustand von Anwendungen überwachen
* Abläufe nachvollziehen
* Entwickler unterstützen
* Performance Messen

Nachvollziehen

* Ablauf
* Zustände
    * Regel
    * Ausnahmen
    * Umgebung
* Ereignisse protokollieren
* Prognosen

# Übliche Herangehensweise

* Java bietet (glücklicherweise) passende Frameworks für einheitliches Logging
    * Anwendungen schreiben in Kanal
    * Ausgabe nach zu definierenden Regeln
* Sonderwege
    * 12-Factor-App -> System.out.println(...)

* Information in Datei schreiben

* Logviewer
* Textanalyse


# Problem

     Datenquelle -> Transformation -> Ablage
    \------------------\ /-----------------/ 
                        V
                      BRUCH
                        A
    /------------------/ \-----------------\
                  Datenauswertung

Auswertung nicht 

* automatisiert
* standardisiert

# Herausforderungen

* Daten schnell schreiben
* Verwalten großer Datenmenge
* performanter Zugriff
* 

# Lösungsskizze

* Blick über den Tellerrand
    * syslog
    * zentrale Log-Dienste
    * Datenbanken
    * Verteilung von Daten/Sharding

## Beschreibung und Demo

* kaum etwas muss neu implementiert werden
* Logging-Vorgehen
    * Generieren
    * Aufbereiten
    * Speichern
    * Analysieren

