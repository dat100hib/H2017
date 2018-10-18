# DAT100: Java Programmering 8 - Uke 11 / 44

De tre oppgavene på denne programmeringslab er **obligatoriske** og kan løses i grupper med opptil tre studenter.  

Oppgavene bruker deler av oppgave 3 og 4 fra [Java Programmering 8](TODO).

### Start Java-kode

Startkoden finnes i et Eclipse-prosjekt som dere skal ta utgangspunkt i. Prosjektet legger på github og dere får tilgang via lenken:

https://classroom.github.com/a/FPdt7I9x

etterfulgt av å importere prosjektet inn i Eclipse på tilsvarende måte som i programmeringsprosjektet (se avsnitt i prosjektbeskrivelsen fra programmeringsprosjektet). TODO: LINK

### Innlevering

Besvarelsen leveres inn ved å pushe java-koden opp på oppbevaringsplassen på github (se avsnitt 4 i prosjektbeskrivelsen for programmeringsprosjektet) TODO legge inn lenke til oppbevaringsplassen som besvarelse på Canvas.

**Frist for innleverings er tirsdag i uke 45**.

### enhetstester

Som del av startkoden finnes en rekke enhetstester i pakken `no.hvl.dat100.jpl9.tests` som kan brukes på tilsvarende måte som i programmeringsprosjektet til å teste metoder etter hvert som dere får de implementert.

Tester for en klasse `X.java` finnes testklassen TestX.java. Avsnitt 5 fra programmeringsprosjekt beskrivelsen viser hvordan enhetstester kjøres i Eclipse.LINK: TODO

### Oppgave 1: Implementere klasser

Implementer den *abstrakte* klassen `Person` og to de subklassene `Student` og `Laerer` med følgende egenskaper:

-	Person            	

 - Objektvariabler: fodselsnummer (long), etternamn (String), fornamn (String)
 - Konstruktører: Standard konstruktør, konstruktør med tre parametre som kan gi verdi til alle objektvariablene
 - Metoder

      - `toString()` som returnerer data i objektet som en streng, eks: `"10100110700\nOlsen\nOle\n"`

      - `erLik(Person p)` som returnerer `true` hvis og kun hvis `p` har samme fødselsnummer som fodselsnummeret i objektvariablen `fodselsnummer`

      - `erKvinne()` som returnerer true om tredjesiste siffer i fødselsnummer er et partall.

      - `erMann()` som returnerer true om tredjesiste siffer i fødslesnummer er et oddetall.

- Student

  - Ekstra objektvariabler: studentnummer (int), klasse (String)
  - Standard konstruktør, konstruktør med fem parametre

  - `toString()`-metode som returnerer data i objektet som en streng, eks: `"STUDENT\n10100110700\nOlsen\nOle\n100\n1A\n"`

-	Laerer

  - Ekstra objektvariable: månadsløn (int), kontonummer (int)
  - Standard konstruktør, konstruktør med fem parametre
  - `toString()`-metode som returnerer data i objektet som en streng, eks: `"LAERER\n10100110700\nOlsen\nOle\n1000\n7676\n"`

Bruk private/protected på alle objektvariabler og lag public get-metoder / set-metoder.

### Oppgave 2: Objekt-samlinger

Gjør ferdig implementasjon av metoder i klassen `PersonSamling` som implementerer en samling av Personobjekter. For å løse denne oppgaven anbefales det å lese avsnitt 9.1 i java-boken.

Personobjektene skal lagres sammenhengene fra starten av tabellen og samlingen skal inneholde:

##### a)

Objektvariabler: nesteLedige/antall og en referanse til tabell med referanser til Person objekt.

##### b)

En standard konstruktør som der startstørrelsen på tabellen er 20.

##### c)

En konstruktør der man kan angi startstørrelsen på tabellen.

##### d)

En metode `getAntall()` som returnerer antall person- objekt som aktuelt er lagret i tabellen.

###### e)

En metode `getSamling()` som returnerer en peker til tabellen av person-objekt.

##### f)

En metode `finnPerson(Person p)` som returnerer indeks (plassering) i tabellen for en person i samlingen med samme fødselsnummer som p (om en slik finnes) og -1 ellers. Hint: bruk `erLik` metoden for person-objekt.

##### g)

En metode `finnes(Person p)` som returnerer `true` om der finnes en person i samlingen med samme fødselsnummer som `p`.

##### h)

En metode `toString()` som returnerer data i tabellen som en streng der første linje i strengen angir antall Person-objekt i tabellen, eks., tabell med to personer ( en student og en lærer):

```java
"2\nSTUDENT\n10100110701\nOlsen\nOle\n100\n1A\n
LAERER\n10200110702\nOlsen\nOle\n1000\n7676\n";
```

##### i)

En metode `utvid()` som oppretter en ny tabell av person-objekt som er dobbelt så stor og flytter elementene over i denne.

##### j)

En metode `ledigPlass()` som returnerer true om der er ledig plass i samlingen.

##### k)

En metode `leggTil(Person p)` som legger `p` inn i tabellen. Dersom der ikke finnes en person i tabellen med samme fødselsnummer som `p` skal metoden legge til personen på neste ledige plass i tabellen. Ellers skal ikke metoden legge inn `p` i tabellen. Dersom tabellen er full, skal metoden opprettet en utvidet tabell og deretter sette inn personen i den nye tabellen. Metoden skal returnere `true` om `p` ble lagt inn i tabellen.

##### l)

En metode `slett(Person p)` som sletter personen `p` fra samlingen. Vi antar at personer med samme fødselsnummer er den samme personen. Metoden skal returnere `true` om personen ble slettet.

### Oppgave 3: Skrive og lese filer

For å løse denne oppgaven anbefales det å lese avsnitt 9.1 i java-boken. + se forelesningsnotater fra TODO

Implementer følgende to metoder i klassen `Filer.java`:

##### a)

`skriv(PersonSamling samling, String filnavn)` som skriver ut samlingen til fil.

Eksempel på innhold av fil for en samling med to elementer:

```java
2
STUDENT
10100110701
Olsen
Ole
100
1A
LAERER
10200110702
Olsen
Ole
1000
7676
```

Metoden skal returnere `true` om filen ble skrevet og skal håndtere eventuelle unntak ifm. fil-håndtering ved å bruke try-catch. Hint: bruk `toString()`-metoden på person-samling.

##### b)

`PersonSamling les(String filnavn)` som leser inn samlingen fra en fil på formatet som i a) og returnerer en samling med de person-objekt som er lest inn.

Metoden skal håndtere eventuell unntak ifm.  filer vha. try-catch men det kan antas innholdet i filen er på korrekt format. Hint: les inn en person av gangen og hver gang en person leses inn, finn først ut om det er en student eller lærer. Dette bestemmer da hva som skal leses videre.
