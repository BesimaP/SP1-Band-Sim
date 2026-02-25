import java.util.ArrayList;

public class Main {
    static ArrayList<Song> songs1 = new ArrayList<>();
    static ArrayList<Song> songs2 = new ArrayList<>();
    static Venue smallClub;
    static Venue arena;
    static Band band1;
    static Band band2;

    public static void main(String[] args) {
        createSongs();
        createVenue();
        createBandProfile();

        // Udskriv startprofiler for begge bands
        band1.printProfile();
        band2.printProfile();

        // ~~~~~~ SIMULER KONCERTER ~~~~~~
        // playGig tager et Venue objekt og antal tilskuere som parametre
        System.out.println("\n* * * * * * * *  CONCERTS * * * * * * * *");
        band1.playGig(arena, 420);
        band2.playGig(smallClub, 480);

        // ~~~~~~ STATUS CHECK ~~~~~~
        // Tjekker bandenes nuværende status efter koncerterne
        System.out.println("\n* * * * * * * STATUS CHECK * * * * * * *");
        band1.checkStatus();
        band2.checkStatus();

        // ~~~~~~ XP OG LEVEL UP ~~~~~~
        // Tilføjer XP til bandene - addXP kalder automatisk levelUp()
        System.out.println("\n* * * * * * * XP & LEVEL UP * * * * * * *");
        band1.addXP(2000);
        band2.addXP(1500);

        // ~~~~~~ FAME SYSTEM ~~~~~~
        // Viser bandenes fame level status
        System.out.println("\n* * * * * * * FAME SYSTEM * * * * * * * *");
        band1.fameSystem();
        band2.fameSystem();

        // ~~~~~~ KØB UDSTYR ~~~~~~
        // spendMoney returnerer true hvis bandet har råd, false hvis ikke
        System.out.println("\n* * * * * * * SPENDING MONEY * * * * * * *");
        if (band1.spendMoney(2000.0)) {
            System.out.println(band1.bandName + " bought new equipment!");
        } else {
            System.out.println(band1.bandName + " doesn't have enough money!");
        }


        // ~~~~~~ RANDOM EVENTS ~~~~~~
        // En tilfældig begivenhed sker for hvert band
        System.out.println("\n* * * * * * * RANDOM EVENTS * * * * * * *");
        band1.randomEvent();
        band2.randomEvent();

        // ~~~~~~ ENDELIGE PROFILER ~~~~~~
        // Udskriv de endelige profiler efter alle begivenheder
        System.out.println("\n                       * * * * * * * FINAL PROFILES * * * * * * *");
        band1.printProfile();
        band2.printProfile();

        // ~~~~~~ FAN SHOWDOWN ~~~~~~
        // Sammenlign de to bands og find ud af hvem der har flest fans
        System.out.println("\n                      * * * * FAN SHOWDOWN * * * * *");
        if (band1.fans > band2.fans) {
            System.out.println(band1.bandName + " has more fans!");
        } else if (band2.fans > band1.fans) {
            System.out.println(band2.bandName + " has more fans!");
        } else {
            System.out.println("Both bands have the same number of fans!");
        }
    }

    public static void createSongs(){
        // ~~~~~ OPRET REPERTOIRE ~~~~~
        // ArrayList er en liste der kan gemme flere objekter af samme type

        songs1.add(new Song("Midnight moon"));
        songs1.add(new Song("Imagine"));
        songs1.add(new Song("Nightmare"));

        songs2.add(new Song("Neon Lights"));
        songs2.add(new Song("Pulse Wave"));
        songs2.add(new Song("Synth Dreams"));
    }

    public static void createVenue(){
        // ~~~~~ OPRET VENUES ~~~~~
        // Venue objekter repræsenterer de spillesteder bandene kan spille på
        // Parametre: navn, kapacitet, udbetaling til bandet
        smallClub = new Venue ("The small Club", 300,800.0);
        arena = new Venue ("City Arena", 500, 1500.0);
    }

    public static void createBandProfile(){
        // ~~~~~~ OPRET BANDS ~~~~~~
        // Band objekter oprettes med alle startværdier
        // Parametre: navn, genre, fans, maxFans, fameLevel, XP, penge, sange
        System.out.println("                       * * * * START PROFILES * * * *");
        band1 = new Band("The Static Waves", 'R', 8500, 15000, 2, 3200, 4750.50, songs1);
        band2 = new Band("Neon Pulse", 'E', 6000, 12000, 1, 1000, 3000.0, songs2);
    }
}
