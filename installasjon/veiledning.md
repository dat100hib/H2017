# DAT100: Installasjon av verktøy for Java programmering

Undervisning i DAT100 baserer seg på bruk av egen PC med Java programvareutviklingsmiljø installert. **Det er derfor viktig at alle får dette til.**

Ta kontakt med lab-assistant eller faglærer dersom du har problemer med installasjon. På Canvas-sidene for faget finnes i tillegg et forum for spørsmål og svar relatert til installasjon av programvaren.

Programvaren som skal installeres er Java Development Kit (JDK), Eclipse Integrated Development Environment (Eclipse IDE) og Git. Programvaren lastes ned fra nett og JDK **må installeres før** Eclipse installeres.

## Nedlastning

Begynn med å laste ned de filer du trenger fra nett. **Husk** å velge rett operativsystem (Windows, MacOS, Linux):

- JDK (husk å velge Accept License Agreement): <http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html>  
- Eclipse (om du har Windows, last ned Windows 64-bit versjonen): <http://www.eclipse.org/downloads/packages/release/photon/r/eclipse-ide-java-developers>
- Git: <https://git-scm.com/downloads> (gjelder **kun Windows** siden git allerede finnes på MacOS og Linux)

## Installasjon av Java Development Kit (JDK)

Detaljerte instruksjoner for installasjon av JDK finnes via: <http://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html>

#### Windows
1.	Dobbeltklikk på filen `jdk-10.0.2_windows-x64_bin.exe`  
2.	Følg instruksjonene. Foreslåtte valg vil vanligvis fungere fint.

#### MacOS
1.	Dobbeltklikk på filen `jdk-10.0.2_windows-x64_bin.dmg`
2.	Følg instruksjonene. Foreslåtte valg vil vanligvis fungere fint.
3.	Test installasjonen ved å utføre kommandoen:  `javac –version` i en terminal som bør gi følgende (eller tilsvarende output): `javac "10.0.2"``

#### Linux

Installasjon ved bruk av tar.gz filen

1.	Kopier tar.gz filen til den mappen hvor du ønsker å installere JDK.
2.	Pakk ut tar.gz filen med kommandoen

   ```tar -zxvf jdk-10.0.2-linux-x64_bin.tar.gz```

3. Tilføy bin mappen der JDK er installert til miljøvariablen PATH.  Dette er avhengig av Linux distribusjonen og shell. For bash shell kan det gjøres ved å tilføye:

   ```PATH=$HOME/Java/jdk-10.0.2:$PATH```

   til filen `~\.bash_profile`.

4. Test installasjonen ved å utføre kommandoen `javac –version` som bør gi følgende (eller tilsvarende) output: `javac "10.0.2"``

Installasjon via .rpm filen (krever RPM-basert Linux system) kan gjøres ved bruk av kommandoen

   ```rpm –ivh jdk-8u144-linux-x64.rpm```

## Installasjon av Eclipse IDE

**Husk:** det er viktig at JDK er installert først

1.	Pakk ut den filen som inneholder Eclipse (zip,dmg,tar.gz)
   - **Windows** Flyt .zip filen til den mappen der du ønsker å installere Eclipse. Høyre-klikk på .zip filen og velg *Pakk ut alle …*
   - **MacOS** Dobbel-klikk på .dmg filen og flyt Eclipse til den mappen der du ønsker å installere Eclipse.
   - **Linux** Flyt .tar.gz filen til den mappen der du ønsker å installere Eclipse. Pakk ut tar.gz filen ved bruk av `tar`-kommandoen.
2.	Nå kan man starte Eclipse ved å åpne mappen du valgte for å pakke ut filene. Der finner du en programfil som heter eclipse. Start denne.
3.	Når du får spørsmål om workspace, oppretter du et workspace som heter DAT100 (det er praktisk med ett workspace pr. fag og det er mulig å opprette flere workspaces senere).

## Installasjon av Git

Git-klient programmet brukes til å hente Java-programmer fra GitHub oppbevaringsplasen. Java-programmer kan også hentes direkte via Eclipse men Git-komponenten i Eclipse har i noen tilfelle begrenset funksjonalitet. I noen tilfeller trenger vi derfor Git-klienten.

#### Windows

1. Double-klikk på .exe filen lastet ned fra <https://git-scm.com/downloads>. Foreslåtte valg vil vanligvis fungere fint.

2. Test installasjonen ved å start programme Git Bash og kjør kommandoen

   `git --version`

  som vil gi output `git version 2.1` eller tilsvarende.

#### MacOS og Linux

Git vil i de fleste tilfelle allerede være installert på MacOS eller Linux. Dette kan sjekkes ved å åpne en terminal og skrive kommandoen

`git --version`

som vil gi output `git version 2.1` eller tilsvarende.

Om git ikke allerede er installert vil du få valg om å installere.

## Windows Installasjonsproblemer

#### PATH miljøvariablen

På noen Windows installasjoner kan det være nødvendig og sette miljøvariablen Path så den inneholder stien til bin mappen der JDK verktøyene er installert. Dette kan gjøres via *Control Panel → System → Advanced System Settings → Environment Variables…*

Stien til mappen vil avhengige av hvor du valgte å installere JDK. Som standard vil den være: C:\Program Files\Java\jdk10.0.2\bin.

**VIKTIG:** stien til JDK skal tilføyes til den eksisterende verdi av `PATH` dvs. ikke slett det eksisterende innholdet men tilføy følgende på enden (husk `;`` først):

```;C:\Program Files\Java\jdk1.8.0_144\bin```

Stien vil også avhenge av hvilken versjon av JDK du evt. har lastet ned. Hvis du har downloaded en nyere versjon av JDK må stien endres tilsvarende.
Test installasjonen via en Command Prompt (ledetekst) og kommandoen:

```javac –version```

Dette bør gi følgende (eller tilsvarende) output:

```javac "10.0.2```

Om man endrer i PATH da må man starte en ny kommando prompt for å få effekt av endringen. Den aktuelle verdi av Path kan man se ved å skrive Path i kommando prompten.

#### Konflikt med andre JVM installasjoner

På noen Windows-plattformer kan det forekomme at en versjon av java’s virtuelle maskin (JVM) er installert som forhindrer Eclipse i å starte. Da må man endre i oppstarts-filen `eclipse.ini` som finnes i eclipse-mappen ved å tilføye:

```-vm C:/Program Files/Java/jdk10.0.2/bin/javaw.exe```

før linjen som begynner med `–vmargs`. Husk å rette i linjen ovenfor om man har valgt å installere JDK i en annen folder eller har installert en annen versjon av JDK.

En endret versjon av [eclipse.ini](https://github.com/dat100hib/H2017/blob/master/eclipse/eclipse.ini) filen finnes også på GitHuB for faget.
