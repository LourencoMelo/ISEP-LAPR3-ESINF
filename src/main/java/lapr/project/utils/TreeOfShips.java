package lapr.project.utils;

import lapr.project.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class TreeOfShips extends AVL<Ship> {

    /**
     * Imports ships from txt file
     *
     * @param file file with ships info
     */
    public void createTreeMMSI(File file) {

        try (Scanner in = new Scanner(file)) {

            in.nextLine();

            List<Ship> list_of_existent_ships = new ArrayList<>();

            while (in.hasNextLine()) {
                try {

                    String[] ship_info = in.nextLine().trim().split(",");

                    ShipByMMSI ship = new ShipByMMSI(Integer.parseInt(ship_info[0].trim()), ship_info[7].trim(), ship_info[8].trim(), ship_info[9].trim(), Integer.parseInt(ship_info[10].trim()), Double.parseDouble(ship_info[11].trim()), Double.parseDouble(ship_info[12].trim()), Double.parseDouble(ship_info[13].trim()));

                    PositionData positionData = new PositionData(formatter(ship_info[1].trim()), Double.parseDouble(ship_info[2].trim()), Double.parseDouble(ship_info[3].trim()), Double.parseDouble(ship_info[4].trim()), Double.parseDouble(ship_info[5].trim()), Double.parseDouble(ship_info[6].trim()), ship_info[14].trim(), ship_info[15].trim());

                    for (Ship ship1 :
                            list_of_existent_ships) {
                        if (ship1.getMMSI() == ship.getMMSI()) {
                            ship1.addPositionData(positionData);
                        }
                    }

                    insert(ship);
                    list_of_existent_ships.add(ship);
                    ship.addPositionData(positionData);

                } catch (NumberFormatException e) {
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Imports ships from txt file
     *
     * @param file file with ships info
     */
    public void createTreeIMO(File file) {

        try (Scanner in = new Scanner(file)) {

            in.nextLine();

            List<Ship> list_of_existent_ships = new ArrayList<>();

            while (in.hasNextLine()) {
                try {

                    String[] ship_info = in.nextLine().trim().split(",");

                    ShipByIMO ship = new ShipByIMO(Integer.parseInt(ship_info[0].trim()), ship_info[7].trim(), ship_info[8].trim(), ship_info[9].trim(), Integer.parseInt(ship_info[10].trim()), Double.parseDouble(ship_info[11].trim()), Double.parseDouble(ship_info[12].trim()), Double.parseDouble(ship_info[13].trim()));

                    PositionData positionData = new PositionData(formatter(ship_info[1].trim()), Double.parseDouble(ship_info[2].trim()), Double.parseDouble(ship_info[3].trim()), Double.parseDouble(ship_info[4].trim()), Double.parseDouble(ship_info[5].trim()), Double.parseDouble(ship_info[6].trim()), ship_info[14].trim(), ship_info[15].trim());

                    for (Ship ship1 :
                            list_of_existent_ships) {
                        if (ship1.getMMSI() == ship.getMMSI()) {
                            ship1.addPositionData(positionData);
                        }
                    }

                    insert(ship);
                    list_of_existent_ships.add(ship);
                    ship.addPositionData(positionData);

                } catch (NumberFormatException e) {
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Imports ships from txt file
     *
     * @param file file with ships info
     */
    public void createTreeCallSign(File file) {

        try (Scanner in = new Scanner(file)) {

            in.nextLine();

            List<Ship> list_of_existent_ships = new ArrayList<>();

            while (in.hasNextLine()) {
                try {

                    String[] ship_info = in.nextLine().trim().split(",");

                    ShipByCallSign ship = new ShipByCallSign(Integer.parseInt(ship_info[0].trim()), ship_info[7].trim(), ship_info[8].trim(), ship_info[9].trim(), Integer.parseInt(ship_info[10].trim()), Double.parseDouble(ship_info[11].trim()), Double.parseDouble(ship_info[12].trim()), Double.parseDouble(ship_info[13].trim()));

                    PositionData positionData = new PositionData(formatter(ship_info[1].trim()), Double.parseDouble(ship_info[2].trim()), Double.parseDouble(ship_info[3].trim()), Double.parseDouble(ship_info[4].trim()), Double.parseDouble(ship_info[5].trim()), Double.parseDouble(ship_info[6].trim()), ship_info[14].trim(), ship_info[15].trim());

                    for (Ship ship1 :
                            list_of_existent_ships) {
                        if (ship1.getMMSI() == ship.getMMSI()) {
                            ship1.addPositionData(positionData);
                        }
                    }

                    insert(ship);
                    list_of_existent_ships.add(ship);
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

    public Ship getShipByMMSI(int mMSI) {

        return getShipByMMSI(root, mMSI);

    }

    public Ship getShipByMMSI(Node<Ship> node, int mMSI) {

        if (root == null) {
            return null;
        }

        if (mMSI == node.getElement().getMMSI()) return node.getElement();

        /**
         * If mMSI searched is higher than the current element's mmsi then we need to go to the right node that has higher.
         */
        if (mMSI > node.getElement().getMMSI()) return getShipByMMSI(node.getRight(), mMSI);
        /**
         * If mMSI searched is lower than the current element's mmsi then we need to go to the right node that has lower.
         */
        if (mMSI < node.getElement().getMMSI()) return getShipByMMSI(node.getLeft(), mMSI);

        return null;

    }

    public Ship getShipByImo(String iMO) {
        return getShipByImo(root, iMO);
    }

    public Ship getShipByImo(Node<Ship> node, String iMO) {

        if (root == null) {
            return null;
        }

        if (iMO.compareTo(node.getElement().getIMO()) == 0) return node.getElement();

        /**
         * If iMO searched is higher than the current element's mmsi then we need to go to the right node that has higher.
         */
        if (iMO.compareTo(node.getElement().getIMO()) > 0) return getShipByImo(node.getRight(), iMO);
        /**
         * If iMO searched is lower than the current element's mmsi then we need to go to the right node that has lower.
         */
        if (iMO.compareTo(node.getElement().getIMO()) < 0) return getShipByImo(node.getLeft(), iMO);

        return null;
    }

    public Ship getShipByCallSign(String callSign) {
        return getShipByCallSign(root, callSign);
    }

    public Ship getShipByCallSign(Node<Ship> node, String callSign) {

        if (root == null) {
            return null;
        }

        if (callSign.compareTo(node.getElement().getCallSign()) == 0) return node.getElement();

        /**
         * If iMO searched is higher than the current element's mmsi then we need to go to the right node that has higher.
         */
        if (callSign.compareTo(node.getElement().getCallSign()) > 0)
            return getShipByCallSign(node.getRight(), callSign);
        /**
         * If iMO searched is lower than the current element's mmsi then we need to go to the right node that has lower.
         */
        if (callSign.compareTo(node.getElement().getCallSign()) < 0) return getShipByCallSign(node.getLeft(), callSign);

        return null;

    }


}

