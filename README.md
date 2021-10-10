# Feladat_Torpedo

# Elvárások az első (7. heti) védésre:
* **Elvárások az első (7. heti) védésre:**
    * Egy publikus GitHub repository létrehozása
    * A létrehozott Git repository tartalmazza a beadandó forráskódját
    * A repository tartalmaz egy megfelelő .gitignore fájlt annak érdekébe, hogy IDE vagy Maven specifikus ideiglenes fájlok ne kerüljenek fel a repository-ba
    * Egy Java 11-es Maven projekt létrehozása (pom.xml és Maven folder struktúra)
    * A Maven projekt az alábbi konfigurációkat tartalmazza:
        * Plugin-ek:
            * org.apache.maven.plugins.maven-jar-plugin - annak érdekében, hogy felkonfiguráljuk az alkalmazásunk belépési pontját (Main Class)
            * org.apache.maven.plugins.maven-assembly-plugin - annak érdekében, hogy egy függőségeket tartalmazó, futtatható JAR fájl jöjjön létre az alkalmazás build-elése eredményeként
            * org.jacoco.jacoco-maven-plugin - annak érdekében, hogy a megírt Egység tesztek kód lefedettségét tudjuk mérni
            * org.apache.maven.plugins.maven-checkstyle-plugin - annak érdekében, hogy a projekten elkövetett kód formázási hibákat és egyéb rossz praktikák automatikus detektáljunk
        * Függőségek:
            * JUnit5
            * Mockito
            * Logback
    * Az alkalmazás Objektum Orientált modellezésének megkezdése
        * Az alkalmazásunkhoz szükséges VO (Value Object) osztályok létrehozása (ügyelve és figyelembe véve a "best practice"-eket: Object methods overriding, Immutability, stb)
    * Az alkalmazás képes kezdetleges felhasználói interakciókat fogadni
        * Például: Játékos nevének bekérése, Játék elindítása, Torepedó játéktér kiiratása, Hajók lerakásának interakciója, stb
        * Itt nem határozunk meg kötelező elvárásokat, tetszőleges kezdetleges interakciók elegendőek
    * Egység tesztek 80% lefedettséget biztosítanak üzleti logikát tartalmazó osztályokra (tehát például VO osztályokra nem szükséges Egység teszteket írni)
