package lapr.project.utils;

import java.awt.geom.Point2D;
import java.util.Comparator;


public class KD_TREE<E>{

    /**
     * Initializes root null
     */
    protected KD_NODE<E> root = null;


    /**
     * K-NODE class
     * @param <E> element
     */
    public static class KD_NODE<E>{

        protected Point2D.Double coordinates;
        protected E info;
        protected KD_NODE<E> left;
        protected KD_NODE<E> right;

        public KD_NODE(Double latitude, Double longitude, E info, KD_NODE<E> left, KD_NODE<E> right) {
            this.coordinates = new Point2D.Double(latitude,longitude);
            this.info = info;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "KD_NODE{" +
                    "coordinates=" + coordinates +
                    ", info=" + info +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    /**
     * Constructor that initializes root
     */
    public KD_TREE(){
        root = null;
    }

    /**
     * Getter for root
     * @return root
     */
    protected KD_NODE<E> root(){
        return root;
    }

    /**
     * Comparator for x values
     */
    public final Comparator<KD_NODE<E>> cmpx = new Comparator<KD_NODE<E>>() {
        @Override
        public int compare(KD_NODE<E> o1, KD_NODE<E> o2) {
            return Double.compare(o1.coordinates.x, o2.coordinates.x);
        }
    };

    /**
     * Comparator for y values
     */
    public final Comparator<KD_NODE<E>> cmpy = new Comparator<KD_NODE<E>>() {
        @Override
        public int compare(KD_NODE<E> o1, KD_NODE<E> o2) {
            return Double.compare(o1.coordinates.y, o2.coordinates.y);
        }
    };

    /**
     *
     * @param node node to insert
     */
    public void insert(KD_NODE<E> node) {

        if (root == null) root = insert2(root(), node, true);

        insert2(root(), node, true);

    }

    /**
     * private insert method that runs recursively
     * @param currentNode current node of the tree
     * @param node node to insert
     * @param divx boolean variable to check if level comparator is x or y
     * @return node added
     */
    private KD_NODE<E> insert2(KD_NODE<E> currentNode, KD_NODE<E> node, boolean divx) {

        if (root == null) return node;

        if (node.coordinates.equals(currentNode.coordinates)){
            return null;
        }

        int compareResult = (divx ? cmpx : cmpy).compare(node,currentNode);

        if (compareResult < 0){
            if (currentNode.left == null){
                currentNode.left = node;
            }else {
                insert2(currentNode.left, node, !divx);
            }
        }else{
            if (currentNode.right == null){
                currentNode.right = node;
            }else{
                insert2(currentNode.right, node, !divx);
            }
        }

        return node;
    }

    /**
     * Public method to find the nearest neighbour
     * @param latitude latitude of the ship
     * @param longitude longitude of the ship
     * @return nearest neighbour
     */
    public E findNearestNeighbour(double latitude, double longitude){
        return findNearestNeighbour2(root(), latitude, longitude, root(), true);
    }

    /**
     * Private method that runs recursively
     * @param node current node
     * @param x latitude of the ship
     * @param y longitude of the ship
     * @param closestNode closest node return
     * @param divx boolean variable to check if level comparator is x or y
     * @return nearest neighbour
     */
    private E findNearestNeighbour2(KD_NODE<E> node, double x, double y, KD_NODE<E> closestNode, boolean divx){

        if (node == null) return null;

        double d = Point2D.distanceSq(node.coordinates.x, node.coordinates.y, x, y);
        double closestDistance = Point2D.distanceSq(node.coordinates.x, node.coordinates.y, x, y);

        if (closestDistance > d) closestNode = node;

        double delta = divx ? x - node.coordinates.x : y - node.coordinates.y;
        double delta2 = delta * delta;

        KD_NODE<E> node1 = delta < 0 ? node.left : node.right;
        KD_NODE<E> node2 = delta < 0 ? node.right : node.left;

        findNearestNeighbour2(node1, x, y, closestNode, !divx);

        if (delta2 < closestDistance) findNearestNeighbour2(node2, x, y, closestNode, !divx);

        return closestNode.info;

    }

    /*
     * Returns the number of nodes in the tree.
     * @return number of nodes in the tree
     */
    public int size(){
        return size(root);
    }

    private int size(KD_NODE<E> node){
        if (node == null)
            return 0;
        else
            return(size(node.left) + 1 + size(node.right));
    }

    /**
     * Returns a string representation of the tree.
     * Draw the tree horizontally
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        toStringRec(root, 0, sb);
        return sb.toString();
    }

    private void toStringRec(KD_NODE<E> root, int level, StringBuilder sb){
        if(root==null)
            return;
        toStringRec(root.right, level+1, sb);
        if (level!=0){
            for(int i=0;i<level-1;i++)
                sb.append("|\t");
            sb.append("|-------"+root.info+"\n");
        }
        else
            sb.append(root.info+"\n");
        toStringRec(root.left, level+1, sb);
    }

}
