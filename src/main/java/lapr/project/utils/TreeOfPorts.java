package lapr.project.utils;

import lapr.project.model.PortAndWareHouse;
import lapr.project.model.PositionData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class TreeOfPorts extends KD_TREE<PortAndWareHouse> {


    public void generateKDTREEOfPorts(File file) {
        create2TreeOfPorts(createListOfPorts(file), true);
    }

    /**
     * Creates list with file imported data
     *
     * @param file file with data
     */
    public List<KD_NODE<PortAndWareHouse>> createListOfPorts(File file) {

        try (Scanner in = new Scanner(file)) {

            in.nextLine();

            List<KD_NODE<PortAndWareHouse>> portAndWareHouseList = new ArrayList<>();

            while (in.hasNextLine()) {

                String[] ports_line = in.nextLine().trim().split(",");

                try {

                    PortAndWareHouse portAndWareHouse = new PortAndWareHouse(ports_line[0].trim(), ports_line[1].trim(), Integer.parseInt(ports_line[2].trim()), ports_line[3].trim(), Double.parseDouble(ports_line[4].trim()), Double.parseDouble(ports_line[5].trim()));

                    KD_NODE<PortAndWareHouse> node2D = new KD_NODE<>(portAndWareHouse.getLat(), portAndWareHouse.getLog(), portAndWareHouse, null, null);

                    if (!portAndWareHouseList.contains(node2D)) portAndWareHouseList.add(node2D);


                } catch (IllegalArgumentException exception) {
                    Logger.getLogger(exception.getMessage());
                }

            }

            return portAndWareHouseList;

        } catch (FileNotFoundException e) {
            Logger.getLogger(e.getMessage());
            return null;
        }
    }


    /**
     * Creates recursively kd-tree of ports
     *
     * @param list list of nodes2d
     * @param divx true for x and false for y values
     */
    public void create2TreeOfPorts(List<KD_NODE<PortAndWareHouse>> list, boolean divx) {

        if (list.isEmpty()) return;

        insert(list.get(selectMedian(divx, list)));

        List<KD_NODE<PortAndWareHouse>> leftNodes2D = new ArrayList<>();
        List<KD_NODE<PortAndWareHouse>> rightNodes2D = new ArrayList<>();
        for (int i = 0; i < selectMedian(divx, list); i++) {
            leftNodes2D.add(list.get(i));
        }

        for (int i = selectMedian(divx, list) + 1; i < list.size(); i++) {
            rightNodes2D.add(list.get(i));
        }

        create2TreeOfPorts(leftNodes2D, !divx);
        create2TreeOfPorts(rightNodes2D, !divx);

    }

    /**
     * Returns median
     *
     * @param eixo true for x and false for y values
     * @param list list of nodes2D
     * @return median node2D
     */
    public int selectMedian(boolean eixo, List<KD_NODE<PortAndWareHouse>> list) {

        list.sort(eixo ? cmpx : cmpy);

        return list.size() / 2;
    }

    /**
     * With the wanted message returns the closest port on that date
     * @param positionData wanted message
     * @return closest port
     */
    public PortAndWareHouse getClosest(PositionData positionData){
        return findNearestNeighbour(positionData.getLatitude(),positionData.getLongitude());
    }

}
