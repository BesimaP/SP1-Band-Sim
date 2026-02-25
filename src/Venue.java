// Venue klassen repræsenterer et spillested hvor bandet kan spille koncert
public class Venue {
    private String name;                // Spillestedets navn
    private int capacity;               // Hvor mange tilskuere der er plads til
    private double payoutAmount;        // Hvor meget bandet tjener på at spille her

    // Constructor - opretter et spillested med navn, kapacitet og udbetaling
    public Venue(String name, int capacity, double payoutAmount){
        this.name = name;
        this.capacity = capacity;
        this.payoutAmount = payoutAmount;
    }

    // Returnerer spillestedets navn
    public String getName (){
        return name;
    }

    //Returnerer spillestedets kapacitet (max tilskuere)
    public int getCapacity(){
        return capacity;
    }

    //Returnerer hvor meget bandet tjener ved at spille her
    public double payoutAmount(){
        return payoutAmount;
    }
}

//Det som en koncertsal i det virkelige liv. Hver koncertsal har:

//Et name (hvad hedder stedet? fx "City Arena")
//En capacity (hvor mange mennesker er der plads til?)
//En payoutAmount (hvor meget betaler stedet bandet for at spille?)

// Så Venue klassen samler alle oplysninger om ét spillested — så når bandet
// skal spille en koncert, ved programmet præcis hvor stort stedet er og
// hvor meget bandet tjener.

