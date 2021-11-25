package lapr.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    /**
     * Instance Of a Container
     */
    Container container = new Container("BICU1234567", "G234", 9000, 4000, 2400, 1000, 16);

    /**
     * Testing getContainerID
     */
    @Test
    void getContainerID() {
        String containerIdAux = "BICU1234567";
        assertEquals(containerIdAux, container.getContainerID());
    }

    /**
     * Testing settingContainerID
     */
    @Test
    void setContainerIDAccepted() {
        String containerParameter = "BACZ7654321";
        int checkDigit = 1;
        container.setContainerID(containerParameter);
        assertEquals(containerParameter, container.getContainerID());
        assertEquals(checkDigit, container.getCheckDigit());
    }

    /**
     * Testing if length less than 11
     */
    @Test
    void setContainerIDRejected() {
        try {
            String containerParameter = "BACZ765432";
            container.setContainerID(containerParameter);
        }catch (Exception exception){
            assertEquals("The container ID is invalid", exception.getMessage());
        }
    }

    /**
     * Testing getCheckDigit
     */
    @Test
    void getCheckDigit() {
        int checkDigitAux = 7;
        assertEquals(checkDigitAux, container.getCheckDigit());
    }

    /**
     * Testing setCheckDigit
     */
    @Test
    void setCheckDigit() {
        int checkDigitAux = 7;
        container.setCheckDigit(container.getContainerID());
        assertEquals(checkDigitAux, container.getCheckDigit());
    }

    /**
     * Testing getIso
     */
    @Test
    void getIso() {
        String isoAux = "G234";
        assertEquals(isoAux, container.getIso());
    }

    /**
     * Testing ISOAccepted
     */
    @Test
    void setIsoAccepted() {
        String isoAux = "X323";
        container.setIso(isoAux);
        assertEquals(isoAux, container.getIso());
    }

    /**
     * Testing ISO withot 4 chars length
     */
    @Test
    void setIsoRejected() {
        try{
            String isoAux = "X32";
            container.setIso(isoAux);
        }catch (Exception exception){
            assertEquals("ISO needs to be a 4 alphanumeric unique number", exception.getMessage());
        }
    }

    /**
     * Testing getGross
     */
    @Test
    void getGross() {
        int grossAux = 9000;
        assertEquals(grossAux, container.getGross());
    }

    /**
     * Testing Bigger than 0
     */
    @Test
    void setGrossAccepted() {
        int grossAux = 10000;
        container.setGross(grossAux);
        assertEquals(grossAux, container.getGross());
    }

    /**
     * Testing 0 gross
     */
    @Test
    void setGrossAcceptedZero() {
        int grossAux = 0;
        container.setGross(grossAux);
        assertEquals(grossAux, container.getGross());
    }

    /**
     * Failing with a negative number
     */
    @Test
    void setGrossRejected() {
        try {
            container.setGross(-1);
        }catch (Exception exception){
            assertEquals("Gross needs to be 0 or a positive number", exception.getMessage());
        }
    }

    /**
     * Testing getTare
     */
    @Test
    void getTare() {
        int tareAux = 4000;
        assertEquals(tareAux, container.getTare());
    }

    /**
     * Testing a number bigger than 0
     */
    @Test
    void setTareAccepted() {
        int tareAux = 3000;
        container.setTare(tareAux);
        assertEquals(tareAux, container.getTare());
    }

    /**
     * Testing tare = 0
     */
    @Test
    void setTareAcceptedZero() {
        int tareAux = 0;
        container.setTare(tareAux);
        assertEquals(tareAux, container.getTare());
    }

    /**
     * Testing tare negative number
     */
    @Test
    void setTareRejected() {
        try{
            int tareAux = -1;
            container.setTare(tareAux);
        }catch (Exception exception){
            assertEquals("Tare needs to be 0 or a positive number", exception.getMessage());
        }
    }

    /**
     * Testing getPayload
     */
    @Test
    void getPayload() {
        int payloadAux = 2400;
        assertEquals(payloadAux, container.getPayload());
    }

    /**
     * Setting PayloadAcceptedZero
     */
    @Test
    void setPayloadAcceptedZero() {
        int payloadAux = 0;
        container.setPayload(payloadAux);
        assertEquals(payloadAux, container.getPayload());
    }

    /**
     * Setting payload to the max
     */
    @Test
    void setPayloadAcceptedMax() {
        int payloadAux = 30480;
        container.setPayload(payloadAux);
        assertEquals(payloadAux, container.getPayload());
    }

    /**
     * Testing setting payload between limits
     */
    @Test
    void setPayloadAcceptedBetween() {
        int payloadAux = 14000;
        container.setPayload(payloadAux);
        assertEquals(payloadAux, container.getPayload());
    }

    /**
     * Testing setting payload negative number
     */
    @Test
    void setPayloadRejectedNegative() {
        try{
            int payloadAux = -20;
            container.setPayload(payloadAux);
        }catch (Exception exception){
            assertEquals("That's not a valid payload. Can't be a negative number or exceed 30480 kg", exception.getMessage());
        }
    }

    /**
     * Testing setting payload bigger than max
     */
    @Test
    void setPayloadRejectedAboveMax() {
        try{
            int payloadAux = 30481;
            container.setPayload(payloadAux);
        }catch (Exception exception){
            assertEquals("That's not a valid payload. Can't be a negative number or exceed 30480 kg", exception.getMessage());
        }
    }

    /**
     * Testing getMaxVolume
     */
    @Test
    void getMaxVolume() {
        int maxVolumeAux = 1000;
        assertEquals(maxVolumeAux, container.getMaxVolume());
    }

    /**
     * Setting maxVolume
     */
    @Test
    void setMaxVolume() {
        int maxVolumeAux = 2000;
        container.setMaxVolume(maxVolumeAux);
        assertEquals(maxVolumeAux, container.getMaxVolume());
    }

    /**
     * Testing getRepairRecommendation
     */
    @Test
    void getRepairRecommendation() {
        int repairRecommendationAux = 16;
        assertEquals(repairRecommendationAux, container.getRepairRecommendation());
    }

    /**
     * Testing setRepairRecommendation
     */
    @Test
    void setRepairRecommendation() {
        int repairRecommendationAux = 26;
        container.setRepairRecommendation(repairRecommendationAux);
        assertEquals(repairRecommendationAux, container.getRepairRecommendation());
    }

    /**
     * Testing Container toString()
     */
    @Test
    void testToString() {
        assertEquals("Container{" +
                "containerID='" + "BICU1234567"  + '\'' +
                ", checkDigit=" + "7" +
                ", iso='" + "G234" + '\'' +
                ", gross=" + 9000 +
                ", tare=" + 4000 +
                ", payload=" + 2400 +
                ", maxVolume=" + 1000 +
                ", repairRecommendation=" + 16 +
                '}', container.toString());
    }

}