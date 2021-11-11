package lapr.project.model;

public class Distance {

    /**
     * Calculates the distance in km that the ship travelled between two points
     *
     * @param latitudeA  latitude first point
     * @param longitudeA longitude first point
     * @param latitudeB  latitude second point
     * @param longitudeB latitude second point
     * @return distance travelled in function of the latitude and longitude of two points
     */
    public static double distance(double latitudeA, double longitudeA, double latitudeB, double longitudeB) {
        //The ship hasn't travelled any distance yet
        if ((latitudeA == latitudeB) && (longitudeA == longitudeB)) {
            return 0;
        } else {
            double aux = longitudeA - longitudeB;
            double distance = Math.sin(Math.toRadians(latitudeA)) * Math.sin(Math.toRadians(latitudeB)) + Math.cos(Math.toRadians(latitudeA))
                    * Math.cos(Math.toRadians(latitudeB)) * Math.cos(Math.toRadians(aux));
            distance = Math.acos(distance);
            distance = Math.toDegrees(distance);
            distance = distance * 60 * 1.1515;
            distance = distance * 1.609344;
            return (distance);
        }
    }
}
