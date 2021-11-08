package lapr.project.utils;

import lapr.project.model.PositionData;
import lapr.project.model.Ship;
import oracle.security.crypto.core.SHA;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Tree of Positional Data, each Ship will have a tree of this kind, the tree will be ordered by BaseDateTime
 */
public class TreeOfPositionData extends AVL<PositionData> {

    /**
     * Returns total of movements of a ship
     * @return total of movements
     */
    public Integer getTotalMovements() {
        return getTotalMovements(root);
    }

    /**
     * Returns total of movements of a ship
     * @return total of movements
     */
    private Integer getTotalMovements(Node<PositionData> node) {
        if (root == null) return null;

        if (node == null) return 0;

        return 1 + getTotalMovements(node.getLeft()) + getTotalMovements(node.getRight());
    }

    /**
     * Calculates the distance in km that the ship travelled between two points
     * @param latitudeA latitude first point
     * @param longitudeA longitude first point
     * @param latitudeB latitude second point
     * @param longitudeB latitude second point
     * @param unit unit
     * @return distance travelled in function of the latitude and longitude of two points
     */
    public static double distance(double latitudeA, double longitudeA, double latitudeB, double longitudeB, String unit){
        //The ship hasn't travelled any distance yet
        if ((latitudeA == latitudeB) && (longitudeA == longitudeB)) {
            return 0;
        } else {
            double aux = longitudeA - longitudeB;
            double distance = Math.sin(Math.toRadians(latitudeA)) * Math.sin(Math.toRadians(latitudeB)) + Math.cos(Math.toRadians(latitudeA)) * Math.cos((latitudeB)) * Math.cos(Math.toRadians(aux));
            distance = Math.acos(distance);
            distance = Math.toDegrees(distance);
            distance = distance * 60 * 1.1515;
            if (unit.equals("K")) {
                distance = distance * 1.609344;
            } else if (unit.equals("N")) {
                distance = distance * 0.8684;
            }
            return (distance);
        }
    }


    /**
     * Calculates the travelled distance
     * @return travelled distance
     */
    private double travelledDistance(){
        double distance = 0;
        Iterator<PositionData> iterator1 = inOrder().iterator();
        Iterator<PositionData> iterator2 = inOrder().iterator();
        iterator2.next();
        while (iterator2.hasNext()) {
            PositionData s1 = iterator1.next();
            PositionData s2 = iterator2.next();
            distance += distance(s1.getLatitude(), s1.getLongitude(), s2.getLatitude(), s2.getLatitude(), "K");
        }
        return distance;
    }

    /**
     * Calculates the travelled distance between the two given dates
     * @param date1 first date
     * @param date2 second date
     * @return travelled distance
     */
    public double travelledDistanceBtDates(LocalDateTime date1,LocalDateTime date2){
        double distance = 0;
        // In the start the Iterator doesn't point to anything
        Iterator<PositionData> iterator1 = inOrder().iterator();
        Iterator<PositionData> iterator2 = inOrder().iterator();
        iterator2.next();
        while (iterator2.hasNext()) {
            PositionData s1 = iterator1.next();
            PositionData s2 = iterator2.next();
            if(s1.getBaseDateTime().compareTo(date1) > 0 && s2.getBaseDateTime().compareTo(date2) < 0) {
                distance += distance(s1.getLatitude(), s1.getLongitude(), s2.getLatitude(), s2.getLatitude(), "K");
            }
        }
        return distance;
    }


    /**
     * Gets the initial date of a ship's movement
     * @return initial date
     */
    public LocalDateTime initialDate(){
        return initialDate(root);
    }

    /**
     * Gets the last date of a ship's movement
     * @return final date
     */
    public LocalDateTime finalDate(){
        return finalDate(root);
    }

    /**
     * Gets the initial date of a ship's movement
     * @param node node
     * @return initial date
     */
    private LocalDateTime initialDate(Node<PositionData> node){
        // If the root is null returns null
        if(root == null){
            return null;
        }
        //The initial date is the node more to the left, because the tree is ordered by BaseDateTime, so if the node has a left we call the method again (recursion)
        if(node.getLeft() != null){
            return initialDate(node.getLeft());
        }else{
            //If the node doesn't have a left we can confirm that it is the initial date
            return node.getElement().getBaseDateTime();
        }
    }

    /**
     * Gets the last date of a ship's movement
     * @param node node
     * @return final date
     */
    private LocalDateTime finalDate(Node<PositionData> node){
        // If the root is null returns null
        if(root == null){
            return null;
        }
        //The final date is the node more to the right, because the tree is ordered by BaseDateTime, so if the node has a right we call the method again
        if(node.getRight() != null){
            return finalDate(node.getRight());
        }else{
            //If the node doesn't have a right we can confirm that it is the final date
            return node.getElement().getBaseDateTime();
        }
    }

    /**
     * Calculates the average speed between two dates
     * @param date1 first date
     * @param date2 second date
     * @return mean
     */
    public double meanSOG(LocalDateTime date1,LocalDateTime date2){
        double mean = 0;
        int aux = 0;
        for(PositionData positionData : inOrder()){
            if(positionData.getBaseDateTime().compareTo(date1) > 0 && positionData.getBaseDateTime().compareTo(date2) < 0) {
                mean += positionData.getSog();
                aux++;
            }
        }
        return mean/aux;
    }








}
