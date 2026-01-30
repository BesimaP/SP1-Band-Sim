import java.sql.SQLOutput;

void main() {
    //Iteration 1: Variables

    String bandName = "The Static Wawes";
    int fans = 8500;
    int maxFans = 15000;
    int fameLevel = 2;
    int experiencePoints = 3200;
    double money = 4750.50;
    boolean isActive = true;
    String[] genre = {"Rock","Electronic","HipHop","Pop"};
    String[] songs = {"Midnight moon", "Imagine", "White Christmas", "Broken Heart", "Nightmare"};

    System.out.println("=== BAND PROFILE ===");
    System.out.println("Bandname: " + bandName);
    System.out.println("Fans: " + fans);
    System.out.println("Max fans: " + maxFans);
    System.out.println("Famelevel: " + fameLevel);
    System.out.println("ExperiencePoints: " + experiencePoints);
    System.out.println("Money: " + money);
    System.out.println("Active: " + isActive);
    System.out.println("Genre: " + Arrays.toString(genre));
    System.out.println("Songs: " +  songs[0] +", "+ songs[1] + ", "+songs[2] +", "+ songs[3] +" and "+ songs[4]);
}