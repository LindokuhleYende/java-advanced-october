package Chap12.Excercise;

import java.util.*;

class Songs {
    public List<Song> getSongs() {
        return List.of(
                new Song("$10", "Hitchhiker", "Electronic", 2016, 183),
                new Song("Havana", "Camila Cabello", "R&B", 2017, 324),
                new Song("Cassidy", "Grateful Dead", "Rock", 1972, 123),
                new Song("50 ways", "Paul Simon", "Soft Rock", 1975, 199),
                new Song("Hurt", "Nine Inch Nails", "Industrial Rock", 1995, 257),
                new Song("Silence", "Delerium", "Electronic", 1999, 138),
                new Song("Hurt", "Johnny Cash", "Soft Rock", 2002, 257),
                new Song("Watercolour", "Pendulum", "Electronic", 2010, 155),
                new Song("The Outsider", "A Perfect Circle", "Alternative Rock", 2004, 312),
                new Song("With a Little Help from My Friends", "The Beatles", "Rock", 1967, 168),
                new Song("Come Together", "The Beatles", "Blues rock", 1968, 173),
                new Song("Come Together", "The & Tina Turner", "Rock", 1970, 165),
                new Song("With a Little Help from My Friends", "Joe Cocker", "Rock", 1968, 46),
                new Song("Immigrant Song", "Karen O", "Industrial Rock", 2011, 12),
                new Song("Breathe", "The Prodigy", "Electronic", 1996, 337),
                new Song("What's Going On", "Raye", "R&B", 1971, 420),
                new Song("Hallucinate", "Dua Lipa", "Pop", 2020, 75),
                new Song("Walk Me Home", "P!nk", "Pop", 2019, 459),
                new Song("I am not a Woman, I'm a god", "Halsey", "Alternative Rock", 2021, 384),
                new Song("Pasos de cero", "Pablo Alborán", "Latin", 2014, 117),
                new Song("Smooth", "Santana", "Latin", 1999, 244),
                new Song("Immigrant song", "Led Zeppelin", "Rock", 1970, 484)
        );
    }
}

public class Song {
    private final String title;
    private final String artist;
    private final String genre;
    private final int year;
    private final int timesPlayed;

    public Song(String title, String artist, String genre, int year, int timesPlayed) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        this.timesPlayed = timesPlayed;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    @Override
    public String toString() {
        return title + " by " + artist + " (" + year + ")";
    }

    public static void main(String[] args) {
        Songs songs = new Songs();
        List<Song> songList = songs.getSongs();

        System.out.println("All Songs:");
        System.out.println("==========");
        for (Song song : songList) {
            System.out.println(song);
        }

        System.out.println("\n===================");
        System.out.println("All Unique Genres:");
        System.out.println("===================");

        songList.stream()
                .map(Song::getGenre)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}

/* EXPECTED OUTPUT:
All Songs:
==========
$10 by Hitchhiker (2016)
Havana by Camila Cabello (2017)
Cassidy by Grateful Dead (1972)
50 ways by Paul Simon (1975)
Hurt by Nine Inch Nails (1995)
Silence by Delerium (1999)
Hurt by Johnny Cash (2002)
Watercolour by Pendulum (2010)
The Outsider by A Perfect Circle (2004)
With a Little Help from My Friends by The Beatles (1967)
Come Together by The Beatles (1968)
Come Together by The & Tina Turner (1970)
With a Little Help from My Friends by Joe Cocker (1968)
Immigrant Song by Karen O (2011)
Breathe by The Prodigy (1996)
What's Going On by Raye (1971)
Hallucinate by Dua Lipa (2020)
Walk Me Home by P!nk (2019)
I am not a Woman, I'm a god by Halsey (2021)
Pasos de cero by Pablo Alborán (2014)
Smooth by Santana (1999)
Immigrant song by Led Zeppelin (1970)


================================================================================
                        MEMORY STATE DIAGRAM
================================================================================

HEAP MEMORY:
-----------
Songs object: Songs@1a2b3c

List<Song> object: List@9z8y7x
  ├─ [0] → Song@4d5e6f {"$10", "Hitchhiker", "Electronic", 2016, 183}
  ├─ [1] → Song@7a8b9c {"Havana", "Camila Cabello", "R&B", 2017, 324}
  ├─ [2] → Song@1e2f3d {"Cassidy", "Grateful Dead", "Rock", 1972, 123}
  └─ ... (22 total Song objects)

STACK MEMORY (during loop):
---------------------------
main() frame:
  ├─ songs: reference to Songs@1a2b3c
  ├─ songList: reference to List@9z8y7x
  └─ song: reference to current Song object (changes each iteration)

================================================================================
                        KEY DEBUGGER OBSERVATIONS
================================================================================

1. OBJECT CREATION: Each "new Song(...)" allocates memory on the heap
2. IMMUTABLE LIST: List.of() creates an unmodifiable list
3. toString() INVOCATION: println() automatically calls toString()
4. LOOP ITERATION: "song" variable gets reassigned to each Song in sequence
5. STRING CONCATENATION: The + operator creates new String objects
6. ENCAPSULATION: Private fields accessed through getters (not shown but available)

================================================================================

*/