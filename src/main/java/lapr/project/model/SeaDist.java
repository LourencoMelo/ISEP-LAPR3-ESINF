package lapr.project.model;

import java.util.Objects;

public class SeaDist implements Comparable<SeaDist>{


    private PortAndWareHouse originPort;

    private PortAndWareHouse destinyPort;

    /**
     * Sea distance between both ports
     */
    private Double SeaDistance;

    public SeaDist(PortAndWareHouse originPort, PortAndWareHouse destinyPort, Double seaDistance) {
        setOriginPort(originPort);
        setDestinyPort(destinyPort);
        setSeaDistance(seaDistance);
    }

    public PortAndWareHouse getOriginPort() {
        return originPort;
    }

    public void setOriginPort(PortAndWareHouse originPort) {
        this.originPort = originPort;
    }

    public PortAndWareHouse getDestinyPort() {
        return destinyPort;
    }

    public void setDestinyPort(PortAndWareHouse destinyPort) {
        this.destinyPort = destinyPort;
    }

    public Double getSeaDistance() {
        return SeaDistance;
    }

    public void setSeaDistance(Double seaDistance) {
        SeaDistance = seaDistance;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(SeaDist o) {
        return Double.compare(this.SeaDistance, o.SeaDistance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeaDist seaDist = (SeaDist) o;
        return originPort.equals(seaDist.originPort) && destinyPort.equals(seaDist.destinyPort) && SeaDistance.equals(seaDist.SeaDistance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originPort, destinyPort, SeaDistance);
    }

    @Override
    public String toString() {
        return "SeaDist{" +
                "originPort=" + originPort +
                ", destinyPort=" + destinyPort +
                ", SeaDistance=" + SeaDistance +
                '}' + '\n';
    }
}
