import java.util.Random;
    public class SP1_Band_Sim {
        String bandName = "The Static Wawes";
        int fans = 8500;
        int maxFans = 15000;
        int fameLevel = 2;
        int experiencePoints = 3200;
        double money = 4750.50;
        boolean isActive = true;
        char genre = 'R';
        String[] songs = {"Midnight moon", "Imagine", "White Christmas", "Broken Heart", "Nightmare"};

        public static void main(String[] args) {
            //Opret objekt
            SP1_Band_Sim firstband = new SP1_Band_Sim();

            firstband.printProfile();
            firstband.printRepertoire();

            firstband.playGig(500, 420);
            firstband.addXP(300);

            if (firstband.spendMoney(2000)){
                System.out.println("Bought new equipment!");
            } else {
                System.out.println("Not enough money");
            }

            System.out.println("Fan base: " + firstband.getFranPercentage() + "% of max fans");

            if (firstband.isLosingRelevance()){
                System.out.println("WARNING: Plan a comeback");
            }

            firstband.checkStatus();
            firstband.fameSystem();
            firstband.repertoire();

            firstband.randomEvent();
            firstband.printProfile();
        }

        void printProfile() {
            System.out.println();
            System.out.println("=== FIRST BAND PROFILE ===");
            System.out.println("Bandname: " + bandName);
            System.out.println("Fans: " + fans);
            System.out.println("Max fans: " + maxFans);
            System.out.println("Famelevel: " + fameLevel);
            System.out.println("ExperiencePoints: " + experiencePoints);
            System.out.println("Money: " + money);
            System.out.println("Active: " + isActive);
            System.out.println("Genre: " + genre);
            System.out.println();
        }

        void printRepertoire() {
            System.out.println("=== SONGS ===");
            for (String song : songs) {
                System.out.println("- " + song);
            }
            System.out.println();
        }

        void checkStatus() {
            //Fans under 25 % - warning:
            System.out.println("=== STATUS CHECKS ===");

            if (fans <= 0) {
                System.out.println("The band has broken up");
                return;
            }

            if (fans < maxFans * 0.25) {
                System.out.println("WARNING: Losing relevance! Consider a comeback strategy");
            }

            char genre = 'R';
            switch (genre) {
                case 'R':
                    System.out.println("Rock on! Loud guitars and big crowd");
                    break;
                case 'E':
                    System.out.println("Electronic vibes - lights and beats");
                    break;
                case 'H':
                    System.out.println("Heavy sound! Headbang approved");
                    break;
                case 'P':
                    System.out.println("Pop appeal - catchy  and commerical!");
                    break;
                default:
                    System.out.println("Unknown genre");
            }
            System.out.println();
        }

        void fameSystem() {
            int threshold = 2000 * fameLevel;
            if (experiencePoints >= threshold) {
                System.out.println("Ready to level up!");
            }

            System.out.println("=== FAME LEVEL ===");
            switch (fameLevel) {
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
                    System.out.println("Superstar - Stadium!");
                    break;
                default:
                    System.out.println("Invalid fame level");
            }
        }

        void repertoire() {
            System.out.println();
            System.out.println("=== REPERTOIRE ====");

            for (String song : songs) {
                System.out.println("- " + song);
            }

            System.out.println("Total number of songs: " + songs.length);
            System.out.println();
        }

        void playGig(int venueCapacity, int attendance) {
            double percentage = ((double) attendance / venueCapacity * 100);

            System.out.println("=== GIG NIGHT ===");
            System.out.println("Playing at venue " + "(capacity: " + venueCapacity + ")");
            System.out.println("Attendance: " + attendance + " (" + percentage + "%)");

            if (percentage > 80) {
                fans += 200;
            } else {
                fans += 50;
            }
            System.out.println("New fans: " + fans);

            money += 1500;
            System.out.println("Concert Revenue: " + money + " kr.");
            System.out.println();
        }

        void randomEvent() {
            System.out.println("=== RANDOM EVENT ===");

            Random rand = new Random();
            int eventType = rand.nextInt(3);

            if (eventType == 0) {
                fans += 500;
                System.out.println("Great review! +500 fans");
            } else if (eventType == 1) {
                System.out.println("Quiet week. Nothing happens");
            } else {
                fans -= 300;
                if (fans < 0) fans = 0;
                System.out.println("Scandal! -300 fans");
            }
            System.out.println("Fans now: " + fans);
        }

        void addXP (int amount){
            experiencePoints += amount;
            int threshold = 2000 * fameLevel;
                if(experiencePoints >= threshold) {
                    levelUp();
                }
            }

        void levelUp(){
            fameLevel++;
            experiencePoints = 0;
            maxFans += 5000;
            System.out.println("LEVEL UP! Fame level is now " + fameLevel);
        }

        boolean spendMoney (double amount) {
            if (money >= amount) {
                money -= amount;
                return true;
            } else {
                return false;
            }
        }

        double getFranPercentage(){
            return ((double) fans / maxFans) * 100;
        }

        boolean isLosingRelevance (){
            return fans < maxFans * 0.25;
        }

        void gainFans (int amount) {
            fans += amount;
            if (fans > maxFans)
                fans = maxFans;
        }

        void loseFans (int amount) {
            fans -= amount;
            if (fans <= 0) {
                fans = 0;
            }
            if (!isActive()) {
                System.out.println("The band has broken up");
            }
        }

        boolean isActive (){
            return fans < 0;
        }

        void earnMoney (double amount) {
            money += amount;
        }
    }