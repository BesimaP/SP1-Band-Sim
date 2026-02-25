    public class Event {
        private int type;               //  Begivenhedens type (1,2 elelr 3)
        private String description;     //  Beskrivelse af hvad der sker
        private int fanImpact;          //  Hvor mange fans bandet vinder eller mister (positiv/negativ)
        private double moneyImpact;     //  Hvor mange penge bandet vinder eller mister (positiv/negativ)

        // Constructor - opretter en begivenhed med alle oplysninger
        public Event(int type, String description, int fanImpact, double moneyImpact){
            this.type = type;
            this.description = description;
            this.fanImpact = fanImpact;
            this.moneyImpact = moneyImpact;
        }

        public String getDescription() {
            return description;
        }

        public int getType() {
            return type;
        }

        public int getFanImpact() {
            return fanImpact;
        }

        public double getMoneyImpact() {
            return moneyImpact;
        }
    }

    // Tænk på det som en nyhedsartikel om bandet. Hver artikel har:

    // En type (hvilken slags nyhed er det?)
    // En beskrivelse (hvad skete der?)
    // En fanImpact (mistede eller vandt bandet fans?)
    // En moneyImpact (mistede eller tjente bandet penge?)

    // Så i stedet for at skrive al logikken direkte ind i randomEvent(),
    // samler vi det i et Event objekt — ligesom man samler en nyhed i én
    // artikel i stedet for at sprede den ud over hele avisen
