package game.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Map {
    public ArrayList<Room> map = new ArrayList<Room>();

    public Map() {
        String desc = "";
        try (
                InputStream is = Map.class.getClassLoader().getResourceAsStream("map.txt");
                InputStreamReader isr = new InputStreamReader(Objects.requireNonNull(is), StandardCharsets.UTF_8);
                BufferedReader inStream = new BufferedReader(isr)
        ) {
            String line;
            while ((line = inStream.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ":");

                //reads intro 
                if (line.contains("Intro")) {
                    desc = "";
                    line = inStream.readLine();
                    do {
                        desc += line + "\n";
                        line = inStream.readLine();

                    } while (st.hasMoreTokens() && !line.contains("end"));
                    map.add(new Room(0, desc));
                } //reads act 1 storyline 
                if (line.contains("1")) {
                    desc = "";
                    line = inStream.readLine();
                    do {
                        desc += line + "\n";
                        line = inStream.readLine();

                    } while (st.hasMoreTokens() && !line.contains("end"));
                    map.add(new Room(1, desc));
                } // reads act 2 storyline
                if (line.contains("2")) {
                    desc = "";
                    line = inStream.readLine();
                    do {
                        desc += line + "\n";
                        line = inStream.readLine();

                    } while (st.hasMoreTokens() && !line.contains("end"));
                    map.add(new Room(2, desc));
                } // reads act 3 storyline
                if (line.contains("3")) {
                    desc = "";
                    line = inStream.readLine();
                    do {
                        desc += line + "\n";
                        line = inStream.readLine();

                    } while (st.hasMoreTokens() && !line.contains("end"));
                    map.add(new Room(3, desc));
                } // reads act 4 storyline
                if (line.contains("4")) {
                    desc = "";
                    line = inStream.readLine();
                    do {
                        desc += line + "\n";
                        line = inStream.readLine();

                    } while (st.hasMoreTokens() && !line.contains("end"));
                    map.add(new Room(4, desc));
                } // reads act 5 storyline
                if (line.contains("5")) {
                    desc = "";
                    line = inStream.readLine();
                    do {
                        desc += line + "\n";
                        line = inStream.readLine();

                    } while (st.hasMoreTokens() && !line.contains("end"));
                    map.add(new Room(5, desc));
                } // reads act 6 storyline
                if (line.contains("6")) {
                    desc = "";
                    line = inStream.readLine();
                    do {
                        desc += line + "\n";
                        line = inStream.readLine();

                    } while (st.hasMoreTokens() && !line.contains("end"));
                    map.add(new Room(6, desc));
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // gets room number 
    public Room getRoom(int roomNumber) {
        return map.get(roomNumber);
    }

}


