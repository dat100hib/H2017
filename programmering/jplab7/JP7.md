# DAT100: Java Programmering 7 - Uke 9 / 42

### Oppgave 1 - Klasser

Oppgave 6.2 i java-boken

### Oppgave 2 - Klasser

Oppgave 6.3 i java-boken

### Oppgave 3 - Klasser

Lag en klasse `Vare` der vi har følgende objektvariabler

-	varenr (heltall)
-	navn (streng)
-	pris (desimaltall)

Alle objektvariablene skal være private og de skal ha get/set metoder. Klassen har skal ha to konstruktører, en *standard konstruktør* og en konstruktør der vi kan gi verdi til alle objektvariablene.  

Videre skal klassen ha følgende metoder som skal være synlige utenfor klassen (du skal bestemme returtype selv)

- `moms()` – I denne oppgaven regner at moms-delen er 20% av prisen som er gitt ved objektvariabelen pris. Dersom pris er 100 kr, skal moms være 20 kr.
- `billigereEnn(Vare v)` – skal sammenligne prisen på en vare med en annen vare v gitt som parameter.
- `toString()` –  som returnerer en strengrepresentasjon av objektvariablene

Implementer en klient-klasse med en main-metode som tester ut metodene i klassen `Vare`. Du kan legge data direkte inn i klienten i stedet for å lese inn.

### Oppgave 4 - Referansetabeller

Ta utgangspunkt i oppgave 3 og definer en klasse `Varelager` der vi kan lagre varer med bruk av referansetabell. Vi lagrer varene i starten av tabellen og har en objektvariabel `antall` som holder rede på hvor mange varer som faktisk er lagret.

For å løse denne oppgaven kan det anbefales det å se på notater fra forelesning F12 på Canvas og koden for student-samling som er tilgjengelig via:
https://github.com/dat100hib/H2017/tree/master/forelesninger/F12/Studentsamling/src/no/hvl/dat100

##### a)

Lag to konstruktører for klassen. en standardkonstruktør og en med parameter.

##### b)

Lag metoden `leggTil(Vare v)`. Denne metoden skal legge en ny vare (gitt som parameter) til på neste ledige plass i tabellen. Husk å oppdatere objektvariabelen `antall`.

##### c)

Lag en metode `soekVare(int vareNr)` som finner ut ved å søke igjennom tabellen om en bestemt vare gitt ved `vareNr` finnes i varelageret.

##### d)

Lag metoden `totalPris()` som beregner og returnerer summen av prisen for varene i lageret. Tips: Bruk en metode fra klassen `Vare`.

##### e)

Lag metoden `slett(int vareNr)` som sletter en vare fra lageret dersom den finnes. Husk at etter at varen er slettet, så skal fremdeles alle varene ligge i starten av tabellen.

##### f)

Lag en klientklasse som inneholder en main-metode for å teste klassen `Varelager`. Opprett et varelager med plass til 10 varer, lag 5 varer som du legger til lageret, vis dem på skjermen og skriv ut samlet pris. Slett en vare og skriv ut lageret på nytt. Du kan legge data direkte inn i programkoden i stedet for å lese inn.

##### g)

Lag så en klasse `Grensesnitt` som leser inn og som skriver ut info om varene. Se eksempel i https://github.com/dat100hib/H2017/tree/master/forelesninger/F12/Studentsamling/src/no/hvl/dat100

Lag også en metode som viser alle varene sortert etter varenr. Husk, at i `StudentSamling` måtte vi ha at alle studentnr må registres med like mange sifre fordi vi sorterte etter en streng for eksempel: `"8" > "40"`

##### h)

Lag en klasse `Meny` som kaller på metodene. Se eksempel i https://github.com/dat100hib/H2017/tree/master/forelesninger/F12/Studentsamling/src/no/hvl/dat100

### Oppgave 5 - Random-klassen og Simulering

I denne oppgaven skal vi simulere terningkast. Et alternativ til å bruke `Math.random()` er å bruke Random-klassen. Denne klassen inneholder en metode `nextInt(int grense)` som returnerer et tilfeldig heltall fra og med 0 til (men ikke med) grense. Dette er en objekt-metode, så det må lages et Random-objekt før metoden kan brukes. Samme objektet kan brukes for å generere flere tilfeldige tall.

Få å løse denne oppgaven anbefales det å se på Eksempel 5.2, side 176 i java-boken. Skisse:

```java
import java.util.Random;
…
Random terning = new Random();
…
terning.nextInt(6) + 1;

```

Du skal lage et program som kaster terninger og viser diverse resultater på skjermen. Skjermbildet skal se ut omtrent som nedenfor

```
TERNINGKASTSIMULATOR

3   2   6   1 ..	.. 1   6
5   2   1   6 ..	.. 5   6
.
.
6   3 ..	.. 3   1   1   4

Antall kast  : 100
Antall 6-ere :  14
Antall 5-ere :  16
.
.
Antall 1-ere :  20

Gjennomsnittskast : 3.56

Antall kast for å få den første 6-eren : 3

Terningverdien det var flest av : 1

```

Programmet skal gjøre følgende

1.	Kaste terningen 100 ganger. Verdiene legges inn i tabellen kast[0..99]. Deretter skrives tabellinnholdet ut på skjermen, 20 kast pr. linje

-	Finne ut hvor mange kast det ble av hver verdi. Svarene legges inn i tabellen antall[0..5]. (Nøtt: Prøv å få det til uten å bruke if eller switch). Svarene skrives ut på skjermen.

-	Beregne gjennomsnittsverdien av kastene. Svaret skrives ut med 3 desimaler.

-	Finne ut hvor mange kast det måtte til for å få den første sekseren. Svaret skrives ut på skjermen.

-	Finne ut hvilken terningverdi det var flest av. Svaret skrives ut på skjermen.

#### Ekstra oppgave (frivillig)

For de av dere som ønsker å ta det litt videre:

-	Lag en objektorientert løsning med flere klasser.

Tips i retning av en mer objekt-orientert løsning

- Lag en klasse `Terning` som representerer terninger i programmet. Lag også en klasse `Simulering` som representerer resultater fra én simulering.

- Videre, lag en klasse `SimulerUtskrift` som har ansvar for utskrift av en simulering.

Klassen Terning kan se slik ut:

```java
public class Terning {

    //Static - konstanter
    private static final String[] TERNINGSYMBOL =
            {"", "[ . ]", "[ : ]", "[...]", "[: :]", "[:.:]", "[:::]"};

    private int oyne;


    public Terning(){
    	 oyne = 0;
    }

    //Static - nyttemetode
    public static String symbol(int oyne) {

        if (oyne >= 1  && oyne <= 6) {
            return TERNINGSYMBOL[oyne];
        } else {
            return TERNINGSYMBOL[0];
        }
    }

    public void trill() {
        oyne = (int)(Math.random() * 6 + 1);
    }

    public String symbol() {

        return symbol(oyne);
    }

    public static String[] getTerningsymbol() {

		return TERNINGSYMBOL;

    }

    public int getOyne() {

	      return oyne;
	  }   

  }

  ```
