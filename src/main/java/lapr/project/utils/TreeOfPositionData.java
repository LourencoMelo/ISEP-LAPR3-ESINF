package lapr.project.utils;

import lapr.project.model.Distance;
import lapr.project.model.PositionData;
import lapr.project.model.Ship;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Tree of Positional Data, each Ship will have a tree of this kind, the tree will be ordered by BaseDateTime
 */
public class TreeOfPositionData extends AVL<PositionData> {

    /**
     * Returns total of movements of a ship
     *
     * @return total of movements
     */
    public Integer getTotalMovements() {
        int cont = 0;
        for (PositionData positionData : inOrder()) {
            cont++;
        }
        return cont;
    }

    /**
     * Returns the delta distance of a ship
     * @return delta distance
     */
    public double getDeltaDistance() {
        Iterator<PositionData> iterator = inOrder().iterator();
        PositionData initialPoint = iterator.next();
        PositionData finalPoint = null;

        if (!iterator.hasNext()) {
            return 0;
        }

        while (iterator.hasNext()) {
            finalPoint = iterator.next();
        }
        assert finalPoint != null;

        return Distance.distance(initialPoint.getLatitude(), initialPoint.getLongitude(), finalPoint.getLatitude(), finalPoint.getLongitude());
    }


    /**
     * Calculates the travelled distance
     *
     * @return travelled distance
     */
    public double travelledDistance() {
        double km = 0;
        int j = 0;
        List<PositionData> list = new ArrayList<>();
        inOrder().forEach(list::add);

        for (int i = 1; i < list.size(); i++) {
            j = i - 1;
            km += Distance.distance(list.get(j).getLatitude(), list.get(j).getLongitude(), list.get(i).getLatitude(), list.get(i).getLongitude());
        }
        return km;
    }

    /**
     * Calculates the travelled distance between the two given dates
     *
     * @param date1 first date
     * @param date2 second date
     * @return travelled distance
     */
    public double travelledDistanceBtDates(LocalDateTime date1, LocalDateTime date2) {
        double km = 0;
        int j = 0;
        List<PositionData> list = new ArrayList<>();
        inOrder().forEach(list::add);

        for (int i = 1; i < list.size() ; i++) {
            j = i - 1;
            if (list.get(j).getBaseDateTime().compareTo(date1) >= 0 && list.get(i).getBaseDateTime().compareTo(date2) <= 0) {
                km += Distance.distance(list.get(j).getLatitude(), list.get(j).getLongitude(), list.get(i).getLatitude(), list.get(i).getLongitude());
            }
        }
        return km;
    }


    /**
     * Gets the initial date of a ship's movement
     *
     * @return initial date
     */
    public LocalDateTime initialDate() {
        return initialDate(root);
    }

    /**
     * Gets the last date of a ship's movement
     *
     * @return final date
     */
    public LocalDateTime finalDate() {
        return finalDate(root);
    }

    /**
     * Gets the initial date of a ship's movement
     *
     * @param node node
     * @return initial date
     */
    private LocalDateTime initialDate(Node<PositionData> node) {
        // If the root is null returns null
        if (root == null) {
            return null;
        }
        //The initial date is the node more to the left, because the tree is ordered by BaseDateTime, so if the node has a left we call the method again (recursion)
        if (node.getLeft() != null) {
            return initialDate(node.getLeft());
        } else {
            //If the node doesn't have a left we can confirm that it is the initial date
            return node.getElement().getBaseDateTime();
        }
    }

    /**
     * Gets the last date of a ship's movement
     *
     * @param node node
     * @return final date
     */
    private LocalDateTime finalDate(Node<PositionData> node) {
        // If the root is null returns null
        if (root == null) {
            return null;
        }
        //The final date is the node more to the right, because the tree is ordered by BaseDateTime, so if the node has a right we call the method again
        if (node.getRight() != null) {
            return finalDate(node.getRight());
        } else {
            //If the node doesn't have a right we can confirm that it is the final date
            return node.getElement().getBaseDateTime();
        }
    }



    /**
     * Calculates the average speed between two dates
     *
     * @param date1 first date
     * @param date2 second date
     * @return mean
     */
    public double meanSOG(LocalDateTime date1, LocalDateTime date2) {
        double mean = 0;
        int aux = 0;
        for (PositionData positionData : inOrder()) {
            if (positionData.getBaseDateTime().compareTo(date1) >= 0 && positionData.getBaseDateTime().compareTo(date2) <= 0) {
                mean += positionData.getSog();
                aux++;
            }
        }
        return mean / aux;
    }


    /**
     * Calculates the max SOG
     *
     * @return max SOG
     */
    public double maxSOG() {
        double max = 0;

        for (PositionData positionData : inOrder()) {
            if (positionData.getSog() > max) max = positionData.getSog();
        }
        return max;
    }


    /**
     * Calculates the mean SOG
     *
     * @return mean SOG
     */
    public double meanSOG() {
        double mean = 0;
        int aux = 0;
        for (PositionData positionData : inOrder()) {
            mean += positionData.getSog();
            aux++;
        }
        return mean / aux;
    }


    /**
     * Calculates the max COG
     *
     * @return max COG
     */
    public double maxCOG() {
        double max = 0;

        for (PositionData positionData : inOrder()) {
            if (positionData.getCog() > max) max = positionData.getCog();
        }
        return max;
    }

    /**
     * Calculates the mean COG
     *
     * @return mean COG
     */
    public double meanCOG() {
        double mean = 0;
        int aux = 0;
        for (PositionData positionData : inOrder()) {
            mean += positionData.getCog();
            aux++;
        }
        return mean / aux;
    }


    /**
     * Calculates the total time travelled
     *
     * @return total movement time in Seconds
     */
    public long getTotalMovementTime() {
        return ChronoUnit.SECONDS.between(initialDate(), finalDate());
    }


    /**
     * Calculates the departure latitude of a vessel
     *
     * @return double departure latitude
     */
    public double departureLatitude() {
        return inOrder().iterator().next().getLatitude();
    }


    /**
     * Calculates the departure longitude of a vessel
     *
     * @return double departure longitude
     */
    public double departureLongitude() {
        return inOrder().iterator().next().getLongitude();
    }

    /**
     * Calculates the arrival latitude of a vessel
     *
     * @return double arrival latitude
     */
    public double arrivalLatitude() {

        Iterator<PositionData> iterator = inOrder().iterator();

        PositionData last = inOrder().iterator().next();

        while (iterator.hasNext()) last = iterator.next();

        return last.getLatitude();
    }

    /**
     * Calculates the arrival longitude of a vessel
     *
     * @return double arrival longitude
     */
    public double arrivalLongitude() {

        Iterator<PositionData> iterator = inOrder().iterator();

        PositionData last_longitude = inOrder().iterator().next();

        while (iterator.hasNext()) last_longitude = iterator.next();

        return last_longitude.getLongitude();
    }

    /**
     * Returns true if the ships has at least 2 messages send in the wanted period of time
     * @param date1 date 1
     * @param date2 date 2
     * @return true or false
     */
    public boolean atLeastTwo(LocalDateTime date1, LocalDateTime date2){
        int aux = 0;
        for (PositionData positionData : inOrder()) {
            if (positionData.getBaseDateTime().compareTo(date1) >= 0 && positionData.getBaseDateTime().compareTo(date2) <= 0) {
                aux++;
            }
        }
        return aux >= 2;
    }




}
