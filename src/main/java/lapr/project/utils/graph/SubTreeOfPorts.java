package lapr.project.utils.graph;

import lapr.project.model.PortAndWareHouse;
import lapr.project.utils.KD_TREE;

import java.util.ArrayList;
import java.util.List;

public class SubTreeOfPorts extends KD_TREE<PortAndWareHouse> {

    /**
     * Fills the subtree of the country
     *
     * @param portAndWareHouseList list of all company's ports
     * @param countryName          name of the country
     */
    public void fillSubTree(List<PortAndWareHouse> portAndWareHouseList, String countryName) {
        create2DTreeOfPorts(getListOfPortsFromCountry(portAndWareHouseList, countryName), true);
    }

    /**
     * Finds the list of ports from a country
     *
     * @param portAndWareHouseList list of all company's ports
     * @param countryName          name of the country to find ports
     * @return list o 2d nodes of ports from the country
     */
    public List<KD_NODE<PortAndWareHouse>> getListOfPortsFromCountry(List<PortAndWareHouse> portAndWareHouseList, String countryName) {

        //Cria lista a retornar com nodes de ports
        List<KD_NODE<PortAndWareHouse>> listToReturn = new ArrayList<>();

        //Percorre todos os ports da company e verifica se pertencem ao país pretendido
        for (PortAndWareHouse portAndWareHouse : portAndWareHouseList) {
            if (portAndWareHouse.getCountry().equalsIgnoreCase(countryName)) {

                //Cria o node 2d para o port encontrado
                KD_NODE<PortAndWareHouse> node2D = new KD_NODE<>(portAndWareHouse.getLatitude(), portAndWareHouse.getLongitude(), portAndWareHouse, null, null);

                //Adiciona o node 2d caso a lista já não o contenha
                if (!listToReturn.contains(node2D)) listToReturn.add(node2D);
            }
        }

        return listToReturn;
    }


    /**
     * Creates recursively 2d-tree of ports
     *
     * @param list list of nodes2d
     * @param divx true for x and false for y values
     */
    public void create2DTreeOfPorts(List<KD_NODE<PortAndWareHouse>> list, boolean divx) {

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

        create2DTreeOfPorts(leftNodes2D, !divx);
        create2DTreeOfPorts(rightNodes2D, !divx);

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
}
