import java.util.ArrayList;
import java.util.Random;

    // Band klassen repræsenterer et musikband med alle dets egenskaber og handlinger
    public class Band {

        // ~~~~~~ FELTER ~~~~~~
        // Disse variabler gemmer bandets data (kaldes instance fields i en klasse)
        private String bandName;
        private char genre;
        private int fans;
        private int maxFans;
        private int fameLevel;
        private int experiencePoints;
        private double money;
        private boolean isActive;
        private ArrayList<Song> songs = new ArrayList<>();
        private Random random;



        public String getBandName() {
            return bandName;
        }


        public int getFans() {
            return fans;
        }



        // ~~~~~~ CONSTRUCTOR ~~~~~~
        // Constructor kaldes når man opretter et nyt Band objekt med "new Band(...)"
        // Den tager alle startværdier som parametre og gemmer dem i felterne ovenfor
        public Band(String bandName, char genre, int fans, int maxFans, int fameLevel,
                    int experiencePoints, double money, ArrayList<Song> songs) { //initialiseer felterne med startværdi
            this.bandName = bandName;
            this.genre = genre;
            this.fans = fans;
            this.maxFans = maxFans;
            this.fameLevel = fameLevel;
            this.experiencePoints = experiencePoints;
            this.money = money;
            this.isActive = true;
            this.songs = songs;
            this.random = new Random();
        }

        // ~~~~~~ METODER ~~~~~~

        //Udskriver en komplet profil over bandet med alle stats
        void printProfile() { //printer objekternes data
            System.out.println();
            System.out.println("~~~~~~ BAND PROFILE ~~~~~~");
            System.out.println("Bandname: " + bandName);
            System.out.println("Fans: " + fans);
            System.out.println("Max fans: " + maxFans);
            System.out.println("Famelevel: " + fameLevel);
            System.out.println("ExperiencePoints: " + experiencePoints);
            System.out.println("Money: " + money);
            System.out.println("Active: " + isActive);
            System.out.println("Genre: " + genre);


            System.out.println("~~~~~~~~~ SONGS ~~~~~~~~~");
            printRepertoire();


            //Advarsel hivs bandet klarer det dårligt
            if (isLosingRelevance()) {
                System.out.println("WARNING: Losing relevance! Consider a comeback strategy.");
            }
            if (!isActive()) System.out.println("The band has broken up…");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");



            //Udskriver en besked baseret på bandets genre
            switch (genre) {
                case 'R':
                    System.out.println("Genre R: Rock on!");
                    break;
                case 'E':
                    System.out.println("Genre E: Electronic vibes.");
                    break;
                case 'H':
                    System.out.println("Genre H: HipHop in the house!");
                    break;
                case 'P':
                    System.out.println("Genre P: Pop sensation!");
                    break;
                default:
                    System.out.println("Invalid genre");
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

        // Udskriver alle sange i bandets repertoire med et for-each loop
        void printRepertoire(){
            for(Song song : songs){
                System.out.println("- " + song.getTitle());
            }
        }


        // Tjekker bandets nuværende status og udskriver relevante advarsler
        void checkStatus() {
            System.out.println("~~~~~~ STATUS CHECK ~~~~~~");
            // Hvis bandet har 0 fans, er det opløst - stop metoden med return
            if (fans <= 0) {
                System.out.println("The band has broken up");
                return;
            }
            // // Advarsel hvis bandet mister relevans (under 25% af maxFans)
            if (isLosingRelevance()) {
                System.out.println("WARNING: Losing relevance! Consider a comeback strategy");
            }
            switch (genre) { //printer en besked baseret på genre
                case 'R':
                    System.out.println("Rock on!");
                    break;
                case 'E':
                    System.out.println("Electronic vibes");
                    break;
                case 'H':
                    System.out.println("Heavy sound!");
                    break;
                case 'P':
                    System.out.println("Pop appeal");
                    break;
                default:
                    System.out.println("Genre unkown");
                    break;
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
        }



        // Viser bandets fame system status og om de er klar til at stige i level
        void fameSystem() {
            // Threshold er den mængde XP der kræves for at stige i level
            int threshold = 2000 * fameLevel;
            if (experiencePoints >= threshold) { //tjekker om man kan level op. Hvis bandets XP er større eller lig med threshold, printes en besked.
                System.out.println("Ready to level up!");
            }
            System.out.println("~~~~~~ FAME LEVEL ~~~~~~");
            // Udskriver en beskrivelse baseret på bandets nuværende fame level
            switch (this.fameLevel) {
                case 1:
                    System.out.println("Unknown - Playing in garages");
                    break;
                case 2:
                    System.out.println("Local Hero - Small venues await");
                    break;
                case 3:
                    System.out.println("Rising Star - Festival invitations coming in");
                    break;
                case 4:
                    System.out.println("Mainstream - Arena tour possible");
                    break;
                case 5:
                    System.out.println("Superstar - Stadium");
                    break;
                default:
                    System.out.println("Invalid fame level");
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }



        // Tilføjer XP til bandet og tjekker automatisk om bandet kan stige i level
        void addXP(int amount) {
            experiencePoints += amount;
            System.out.println(bandName + ": " + amount + " XP added! Total XP: " + experiencePoints);
            levelUp(); // kalder levelUp for at tjekke om bandet kan stige i famelevel
        }



        // Stiger i fame level hvis bandet har nok XP
        // Nulstiller XP og fordobler maxFans når bandet stiger i level
        void levelUp() {
            int threshold = 2000 * fameLevel;   //XP krav stiger med fame level
            if (experiencePoints >= threshold) {
                fameLevel++;                //hvis ja, øger fameLevel med 1 og printer en besked
                experiencePoints = 0;       //Nustil XP
                maxFans = maxFans * 2;      // Fordobl max fans
                System.out.println(bandName + ": Congratulations! Levelled up to fame level " + fameLevel);
                System.out.println(" New status: " + getStatusTitle());
                System.out.println(" New max fans: " + maxFans);
            }
        }



        // Trækker penge fra bandet - returnerer true hvis det lykkedes, false hvis ikke nok penge
        boolean spendMoney(double amount) {
            if (money >= amount) {
                money -= amount;    // Træk pengene fra
                return true;
            } else {
                return false;       // Ikke nok penge
            }
        }



        // Tilføjer penge til bandets pengebeholdning
        void earnMoney(double amount) {
            money += amount;
            System.out.println("Earned $" + amount + "! Total money: $" + money);
        }



        // Simulerer en koncert på et bestemt spillested med et bestemt antal tilskuere
        // Venue objektet indeholder spillestedets navn, kapacitet og udbetaling
        void playGig(Venue venue, int attendance) {
            // Math.min sikrer, at publikum ikke overstiger lokalet
            int audience = Math.min(attendance, venue.getCapacity());

            // Fans stiger: 1 ny fan for hver 5 tilskuere
            gainFans(audience / 5);

            // Bandet tjener penge fra spillestedets faste udbetaling
            earnMoney(venue.payoutAmount());

            //XP stiger: 1 XP per tilskuer
            experiencePoints += audience;

            // Beregn hvor fyldt lokalet var i procent
            double fillPercent = (double) audience / venue.getCapacity() * 100;
            System.out.println(bandName + " spillede på " + venue.getName() + "!");
            System.out.println("  Publikum: " + audience + " / " + venue.getCapacity()
                    + " (" + String.format("%.1f", fillPercent) + "% fyldt)");
            System.out.println("  Nye fans: " + (audience / 5));
            System.out.println("  Tjente: $" + venue.payoutAmount());
        }


        // Simulerer en tilfældig begivenhed ved hjælp af Event klassen
        // Der er 3 mulige events: god anmeldelse, rolig uge, eller skandale
        void randomEvent() {
            // Opret et array med 3 mulige begivenheder som Event objekter
            Event[] events = {
                    new Event(1, "Great review! Fans +500", 500, 0),
                    new Event(2, "Quiet week. Nothing happens.", 0, 0),
                    new Event(3, "Scandal! Fans -300", -300, 0)
            };

            // Vælg en tilfældig begivenhed fra arrayet
            //Vælger en tilfældig begivenhed fra arrayet. random.nextInt(3) giver et tilfældigt tal mellem 0 og 2, og det bruges til at vælge én af de 3 events.
            Event e = events[random.nextInt(events.length)];
            System.out.println(bandName + ": Random Event: " + e.getDescription());

            // Anvend begivenhedens effekt på fans og penge
            //Tjekker om begivenheden påvirker fans. Math.abs bruges fordi loseFans() forventer et positivt tal — så -300 bliver til 300.
            if (e.getFanImpact() > 0) {
                gainFans(e.getFanImpact());
            } else if (e.getFanImpact() < 0) {
                loseFans(Math.abs(e.getFanImpact())); // Math.abs sikrer at vi altid sender et positivt tal ind i loseFans(). betyder bare "den absolutte værdi"
            }

            //Tjekker om begivenheden påvirker penge — kun hvis det ikke er 0.
            if (e.getMoneyImpact() != 0) {
                money += e.getMoneyImpact();
                System.out.println("  Money impact: $" + e.getMoneyImpact());
            }

        }



        // Tilføjer fans til bandet - men aldrig over maxFans
        void gainFans(int amount) {
            fans = Math.min(fans + amount, maxFans);
            System.out.println(amount + " fans gained! Total fans: " + fans);
        }



        // Fjerner fans fra bandet og tjekker om bandet opløses
        void loseFans(int amount) {
            fans -= amount;
            // Fans kan ikke blive negativt
            if (fans < 0)
                fans = 0;

            // Print hvor mange fans der blev mistet og totalen
            System.out.println(amount + " fans lost! Total fans: " + fans);

            // Hvis bandet ikke længere har fans, opløses det
            if(! isActive()) {
                isActive = false;
                System.out.println("Bandet er opløst");
            }
        }



        // Returnerer true hvis bandet stadig har fans (er aktivt)
        boolean isActive() {
            return fans > 0;
            // true = bandet kan spille koncerter, false = bandet er opløst
        }



        // Beregner og returnerer fans som procent af maxFans
        // Fx: 8500 fans / 15000 maxFans * 100 = 56.7%
        double getFanPercentage() {
            return (double) fans / maxFans * 100;
        }



        // Returnerer true hvis bandet har under 25% af maxFans
        // Det betyder at bandet er ved at miste sin relevans
        boolean isLosingRelevance() {
            return fans < maxFans * 0.25;
        }

        // Returnerer en statustitel baseret på bandets fame level
        public String getStatusTitle(){
            switch (fameLevel) {
                case 1:
                    return "Unknown - Playing in garages";
                case 2:
                    return "Local Hero - Small venues await";
                case 3:
                    return "Rising Star - Festival invitations coming in";
                case 4:
                    return "Mainstream - Arena tours possible";
                case 5:
                    return "Superstar - Stadium glory!";
                default:
                    return "Legend";
            }
        }
    }
