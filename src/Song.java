    public class Song {
        private String title;           //Sangens titel
        private int durationSeconds;    //Varighed i sekunder
        private int streams;           // Antal streams sangen har fået

        //Constructor - opretter en sang med en titel
        // durationSeconds og streams sættes til 0 som standard
        public Song(String title){
            this.title = title;
            this.durationSeconds = 0;
            this.streams = 0;
        }

        //Returnerer sagens titel
        public  String getTitle(){
            return title;
        }

        //Returnerer sangens varighed i sekunder
        public int getDurationSeconds(){
            return durationSeconds;
        }

        //Returnerer antal streams
        public int getStreams(){
            return streams;
        }
    }

    //Tænk på det som et musikspor på Spotify. Hver sang har:

    //Et title (hvad hedder sangen?)
    //En durationSeconds (hvor lang er den?)
    //Et streams antal (hvor mange gange er den blevet spillet?)

    //Så Song klassen er bare en måde at samle alle oplysninger om
    // én sang på ét sted — i stedet for at have en masse løse
    // variabler der flyder rundt i koden.
