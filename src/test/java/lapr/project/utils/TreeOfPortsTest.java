package lapr.project.utils;

import lapr.project.model.PortAndWareHouse;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeOfPortsTest {

    @Test
    void createListOfPorts() {
        TreeOfPorts treeOfPorts = new TreeOfPorts();

        List<KD_TREE.KD_NODE<PortAndWareHouse>> auxList = new ArrayList<>();

        PortAndWareHouse portAndWareHouse1 = new PortAndWareHouse("Europe", "United Kingdom", 29002, "Liverpool", 53.46666667, -3.033333333);
        PortAndWareHouse portAndWareHouse2 = new PortAndWareHouse("America", "United States", 14635, "Los Angeles", 33.71666667, -118.2666667);
        PortAndWareHouse portAndWareHouse3 = new PortAndWareHouse("America", "United States", 25007, "New Jersey", 40.66666667, -74.16666667);
        PortAndWareHouse portAndWareHouse4 = new PortAndWareHouse("America", "Brazil", 20301, "Rio Grande", -32.06666667, -52.06666667);
        PortAndWareHouse portAndWareHouse5 = new PortAndWareHouse("America", "Brazil", 20351, "Salvador", -12.96666667, -38.51666667);
        PortAndWareHouse portAndWareHouse6 = new PortAndWareHouse("America", "Brazil", 27248, "Santos", -23.93333333, -46.31666667);
        PortAndWareHouse portAndWareHouse7 = new PortAndWareHouse("America", "Canada", 22226, "Halifax", 44.65, -63.56666667);
        PortAndWareHouse portAndWareHouse8 = new PortAndWareHouse("America", "Canada", 25350, "Vancouver", 49.28333333, -123.1166667);
        PortAndWareHouse portAndWareHouse9 = new PortAndWareHouse("America", "Chile", 27792, "San Vicente", -36.73333333, -73.15);
        PortAndWareHouse portAndWareHouse10 = new PortAndWareHouse("America", "Chile", 28082, "Valparaiso", -33.01666667, -71.63333333);
        PortAndWareHouse portAndWareHouse11 = new PortAndWareHouse("America", "Colombia", 28261, "Buenaventura", 3.916666667, -77.05);
        PortAndWareHouse portAndWareHouse12 = new PortAndWareHouse("America", "Colombia", 28313, "Cartagena", 10.41666667, -75.53333333);
        PortAndWareHouse portAndWareHouse13 = new PortAndWareHouse("Europe", "France", 18012, "Brest", 48.4, -4.5);
        PortAndWareHouse portAndWareHouse14 = new PortAndWareHouse("Europe", "France", 18326, "Dunkirk", 51.05, 2.366666667);
        PortAndWareHouse portAndWareHouse15 = new PortAndWareHouse("Europe", "Portugal", 18476, "Ponta Delgada", 37.73333333, -25.66666667);
        PortAndWareHouse portAndWareHouse16 = new PortAndWareHouse("Europe", "Portugal", 23428, "Funchal", 32.65, -16.91666667);
        PortAndWareHouse portAndWareHouse17 = new PortAndWareHouse("Europe", "Portugal", 13012, "Leixoes", 41.18333333, -8.7);
        PortAndWareHouse portAndWareHouse18 = new PortAndWareHouse("Europe", "Portugal", 13390, "Setubal", 38.5, -8.916666667);
        PortAndWareHouse portAndWareHouse19 = new PortAndWareHouse("Europe", "Spain", 17386, "Barcelona", 41.33333333, 2.166666667);
        PortAndWareHouse portAndWareHouse20 = new PortAndWareHouse("Europe", "Spain", 18937, "Valencia", 39.45, -0.3);
        PortAndWareHouse portAndWareHouse21 = new PortAndWareHouse("America", "Peru", 30045, "Callao", -12.05, -77.16666667);
        PortAndWareHouse portAndWareHouse22 = new PortAndWareHouse("America", "Peru", 10860, "Matarani", -17, -72.1);


        KD_TREE.KD_NODE<PortAndWareHouse> node2D1 = new KD_TREE.KD_NODE<>(portAndWareHouse1.getLatitude(), portAndWareHouse1.getLongitude(), portAndWareHouse1, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D2 = new KD_TREE.KD_NODE<>(portAndWareHouse2.getLatitude(), portAndWareHouse2.getLongitude(), portAndWareHouse2, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D3 = new KD_TREE.KD_NODE<>(portAndWareHouse3.getLatitude(), portAndWareHouse3.getLongitude(), portAndWareHouse3, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D4 = new KD_TREE.KD_NODE<>(portAndWareHouse4.getLatitude(), portAndWareHouse4.getLongitude(), portAndWareHouse4, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D5 = new KD_TREE.KD_NODE<>(portAndWareHouse5.getLatitude(), portAndWareHouse5.getLongitude(), portAndWareHouse5, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D6 = new KD_TREE.KD_NODE<>(portAndWareHouse6.getLatitude(), portAndWareHouse6.getLongitude(), portAndWareHouse6, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D7 = new KD_TREE.KD_NODE<>(portAndWareHouse7.getLatitude(), portAndWareHouse7.getLongitude(), portAndWareHouse7, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D8 = new KD_TREE.KD_NODE<>(portAndWareHouse8.getLatitude(), portAndWareHouse8.getLongitude(), portAndWareHouse8, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D9 = new KD_TREE.KD_NODE<>(portAndWareHouse9.getLatitude(), portAndWareHouse9.getLongitude(), portAndWareHouse9, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D10 = new KD_TREE.KD_NODE<>(portAndWareHouse10.getLatitude(), portAndWareHouse10.getLongitude(), portAndWareHouse10, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D11 = new KD_TREE.KD_NODE<>(portAndWareHouse11.getLatitude(), portAndWareHouse11.getLongitude(), portAndWareHouse11, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D12 = new KD_TREE.KD_NODE<>(portAndWareHouse12.getLatitude(), portAndWareHouse12.getLongitude(), portAndWareHouse12, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D13 = new KD_TREE.KD_NODE<>(portAndWareHouse13.getLatitude(), portAndWareHouse13.getLongitude(), portAndWareHouse13, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D14 = new KD_TREE.KD_NODE<>(portAndWareHouse14.getLatitude(), portAndWareHouse14.getLongitude(), portAndWareHouse14, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D15 = new KD_TREE.KD_NODE<>(portAndWareHouse15.getLatitude(), portAndWareHouse15.getLongitude(), portAndWareHouse15, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D16 = new KD_TREE.KD_NODE<>(portAndWareHouse16.getLatitude(), portAndWareHouse16.getLongitude(), portAndWareHouse16, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D17 = new KD_TREE.KD_NODE<>(portAndWareHouse17.getLatitude(), portAndWareHouse17.getLongitude(), portAndWareHouse17, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D18 = new KD_TREE.KD_NODE<>(portAndWareHouse18.getLatitude(), portAndWareHouse18.getLongitude(), portAndWareHouse18, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D19 = new KD_TREE.KD_NODE<>(portAndWareHouse19.getLatitude(), portAndWareHouse19.getLongitude(), portAndWareHouse19, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D20 = new KD_TREE.KD_NODE<>(portAndWareHouse20.getLatitude(), portAndWareHouse20.getLongitude(), portAndWareHouse20, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D21 = new KD_TREE.KD_NODE<>(portAndWareHouse21.getLatitude(), portAndWareHouse21.getLongitude(), portAndWareHouse21, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D22 = new KD_TREE.KD_NODE<>(portAndWareHouse22.getLatitude(), portAndWareHouse22.getLongitude(), portAndWareHouse22, null, null);



        auxList.add(node2D1);
        auxList.add(node2D2);
        auxList.add(node2D3);
        auxList.add(node2D4);
        auxList.add(node2D5);
        auxList.add(node2D6);
        auxList.add(node2D7);
        auxList.add(node2D8);
        auxList.add(node2D9);
        auxList.add(node2D10);
        auxList.add(node2D11);
        auxList.add(node2D12);
        auxList.add(node2D13);
        auxList.add(node2D14);
        auxList.add(node2D15);
        auxList.add(node2D16);
        auxList.add(node2D17);
        auxList.add(node2D18);
        auxList.add(node2D19);
        auxList.add(node2D20);
        auxList.add(node2D21);
        auxList.add(node2D22);

        System.out.println(treeOfPorts.createListOfPorts(new File("Files/sports.csv")));
        System.out.println(auxList);


        assertEquals(treeOfPorts.createListOfPorts(new File("Files/sports.csv")).toString(), auxList.toString());

    }

    @Test
    void invalidPortParameters() {
        TreeOfPorts treeOfPorts = new TreeOfPorts();

        List<KD_TREE.KD_NODE<PortAndWareHouse>> list = treeOfPorts.createListOfPorts(new File("Files/invalidPortTest"));

        System.out.println(list);

        assertEquals(1,list.size());

    }

    @Test
    void wrongFilePath() {
        TreeOfPorts treeOfPorts = new TreeOfPorts();
        assertNull(treeOfPorts.createListOfPorts(new File("Files/ola.csv")));
    }

    @Test
    void sizeOfTree() {
        TreeOfPorts treeOfPorts = new TreeOfPorts();

        treeOfPorts.generateKDTREEOfPorts(new File("Files/sports.csv"));

        System.out.println(treeOfPorts);

        assertEquals(treeOfPorts.size(), 22);

    }

    @Test
    void selectMedianX() {

        TreeOfPorts treeOfPorts = new TreeOfPorts();

        List<KD_TREE.KD_NODE<PortAndWareHouse>> auxList = new ArrayList<>();

        PortAndWareHouse portAndWareHouse1 = new PortAndWareHouse("Europe", "United Kingdom", 29002, "Liverpool", 53.46666667, -3.033333333);
        PortAndWareHouse portAndWareHouse2 = new PortAndWareHouse("America", "United States", 14635, "Los Angeles", 33.71666667, -118.2666667);
        PortAndWareHouse portAndWareHouse3 = new PortAndWareHouse("America", "United States", 25007, "New Jersey", 40.66666667, -74.16666667);
        PortAndWareHouse portAndWareHouse4 = new PortAndWareHouse("America", "Brazil", 20301, "Rio Grande", -32.06666667, -52.06666667);
        PortAndWareHouse portAndWareHouse5 = new PortAndWareHouse("America", "Brazil", 20351, "Salvador", -12.96666667, -38.51666667);
        PortAndWareHouse portAndWareHouse6 = new PortAndWareHouse("America", "Brazil", 27248, "Santos", -23.93333333, -46.31666667);
        PortAndWareHouse portAndWareHouse7 = new PortAndWareHouse("America", "Canada", 22226, "Halifax", 44.65, -63.56666667);

        KD_TREE.KD_NODE<PortAndWareHouse> node2D1 = new KD_TREE.KD_NODE<>(portAndWareHouse1.getLatitude(), portAndWareHouse1.getLongitude(), portAndWareHouse1, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D2 = new KD_TREE.KD_NODE<>(portAndWareHouse2.getLatitude(), portAndWareHouse2.getLongitude(), portAndWareHouse2, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D3 = new KD_TREE.KD_NODE<>(portAndWareHouse3.getLatitude(), portAndWareHouse3.getLongitude(), portAndWareHouse3, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D4 = new KD_TREE.KD_NODE<>(portAndWareHouse4.getLatitude(), portAndWareHouse4.getLongitude(), portAndWareHouse4, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D5 = new KD_TREE.KD_NODE<>(portAndWareHouse5.getLatitude(), portAndWareHouse5.getLongitude(), portAndWareHouse5, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D6 = new KD_TREE.KD_NODE<>(portAndWareHouse6.getLatitude(), portAndWareHouse6.getLongitude(), portAndWareHouse6, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D7 = new KD_TREE.KD_NODE<>(portAndWareHouse7.getLatitude(), portAndWareHouse7.getLongitude(), portAndWareHouse7, null, null);

        auxList.add(node2D1);
        auxList.add(node2D2);
        auxList.add(node2D3);
        auxList.add(node2D4);
        auxList.add(node2D5);
        auxList.add(node2D6);
        auxList.add(node2D7);


        assertEquals(treeOfPorts.selectMedian(true,auxList),3);
        assertEquals(auxList.get(treeOfPorts.selectMedian(true,auxList)).coordinates.x,33.71666667);

    }

    @Test
    void selectMedianY() {

        TreeOfPorts treeOfPorts = new TreeOfPorts();

        List<KD_TREE.KD_NODE<PortAndWareHouse>> auxList = new ArrayList<>();

        PortAndWareHouse portAndWareHouse1 = new PortAndWareHouse("Europe", "United Kingdom", 29002, "Liverpool", 53.46666667, -3.033333333);
        PortAndWareHouse portAndWareHouse2 = new PortAndWareHouse("America", "United States", 14635, "Los Angeles", 33.71666667, -118.2666667);
        PortAndWareHouse portAndWareHouse3 = new PortAndWareHouse("America", "United States", 25007, "New Jersey", 40.66666667, -74.16666667);
        PortAndWareHouse portAndWareHouse4 = new PortAndWareHouse("America", "Brazil", 20301, "Rio Grande", -32.06666667, -52.06666667);
        PortAndWareHouse portAndWareHouse5 = new PortAndWareHouse("America", "Brazil", 20351, "Salvador", -12.96666667, -38.51666667);
        PortAndWareHouse portAndWareHouse6 = new PortAndWareHouse("America", "Brazil", 27248, "Santos", -23.93333333, -46.31666667);
        PortAndWareHouse portAndWareHouse7 = new PortAndWareHouse("America", "Canada", 22226, "Halifax", 44.65, -63.56666667);

        KD_TREE.KD_NODE<PortAndWareHouse> node2D1 = new KD_TREE.KD_NODE<>(portAndWareHouse1.getLatitude(), portAndWareHouse1.getLongitude(), portAndWareHouse1, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D2 = new KD_TREE.KD_NODE<>(portAndWareHouse2.getLatitude(), portAndWareHouse2.getLongitude(), portAndWareHouse2, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D3 = new KD_TREE.KD_NODE<>(portAndWareHouse3.getLatitude(), portAndWareHouse3.getLongitude(), portAndWareHouse3, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D4 = new KD_TREE.KD_NODE<>(portAndWareHouse4.getLatitude(), portAndWareHouse4.getLongitude(), portAndWareHouse4, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D5 = new KD_TREE.KD_NODE<>(portAndWareHouse5.getLatitude(), portAndWareHouse5.getLongitude(), portAndWareHouse5, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D6 = new KD_TREE.KD_NODE<>(portAndWareHouse6.getLatitude(), portAndWareHouse6.getLongitude(), portAndWareHouse6, null, null);
        KD_TREE.KD_NODE<PortAndWareHouse> node2D7 = new KD_TREE.KD_NODE<>(portAndWareHouse7.getLatitude(), portAndWareHouse7.getLongitude(), portAndWareHouse7, null, null);

        auxList.add(node2D1);
        auxList.add(node2D2);
        auxList.add(node2D3);
        auxList.add(node2D4);
        auxList.add(node2D5);
        auxList.add(node2D6);
        auxList.add(node2D7);


        assertEquals(treeOfPorts.selectMedian(false,auxList),3);
        assertEquals(auxList.get(treeOfPorts.selectMedian(true,auxList)).coordinates.y,-118.2666667);

    }


}

