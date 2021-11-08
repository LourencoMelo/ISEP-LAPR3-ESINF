package lapr.project.utils;

import lapr.project.model.PositionData;
import lapr.project.model.Ship;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TreeOfShips extends AVL<Ship> {

    /**
     * Imports ships from txt file
     *
     * @param file file with ships info
     */
    public void createTree(File file) {
        try {
            Scanner in = new Scanner(file);

            in.nextLine();

            while (in.hasNextLine()) {
                try {

                    String[] ship_info = in.nextLine().trim().split(",");

                    Ship ship = new Ship(Integer.parseInt(ship_info[0].trim()), ship_info[7].trim(), ship_info[8].trim(), ship_info[9].trim(), Integer.parseInt(ship_info[10].trim()), Double.parseDouble(ship_info[11].trim()), Double.parseDouble(ship_info[12].trim()), Double.parseDouble(ship_info[13].trim()));

                    insert(ship);

                    PositionData positionData = new PositionData(formatter(ship_info[1].trim()), Double.parseDouble(ship_info[2].trim()), Double.parseDouble(ship_info[3].trim()),Double.parseDouble(ship_info[4].trim()), Double.parseDouble(ship_info[5].trim()), Double.parseDouble(ship_info[6].trim()), Integer.parseInt(ship_info[14].trim()), ship_info[15].trim());

                    ship.addPositionData(positionData);


                } catch (NumberFormatException e) {
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    LocalDateTime formatter(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(str, formatter);
    }
}

