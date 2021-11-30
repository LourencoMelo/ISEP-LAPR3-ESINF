package lapr.project.utils;

import lapr.project.model.PortAndWareHouse;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class KD_TREETest {


    public KD_TREETest(){

    }

    @Test
    void Create2DNodeTest() {
        PortAndWareHouse portAndWareHouse1 = new PortAndWareHouse("Europe", "United Kingdom", 29002, "Liverpool", 53.46666667, -3.033333333);

        KD_TREE.KD_NODE<PortAndWareHouse> node2D = new KD_TREE.KD_NODE<>(53.46666667, -3.033333333,portAndWareHouse1,null,null);

        assertEquals(node2D.coordinates, new Point2D.Double(53.46666667, -3.033333333));
        assertNull(node2D.left);
        assertNull(node2D.right);
        assertEquals(portAndWareHouse1,node2D.info);
    }

    @Test
    void root() {
        KD_TREE<PortAndWareHouse> kd_tree = new KD_TREE<>();

        assertNull(kd_tree.root());
    }


    @Test
    void size0() {
        KD_TREE<PortAndWareHouse> kd_tree = new KD_TREE<>();

        assertEquals(0,kd_tree.size());
    }

}