package Transport;

public class Verifications {

    protected static String verificationMark(String string) {
        if (string == null || string.isBlank()) {
            return "default";
        }
        return string;
    }

    protected static String verificationModel(String string) {
        if (string == null || string.isBlank()) {
            return "default";
        }
        return string;
    }

    protected static double verificationEngineVolume(double num) {
        return num <= 0 ? 1.5 : num;
    }




}
