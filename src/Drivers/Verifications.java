package Drivers;

public class Verifications {
    protected static String verificationFullName(String string) {
        if (string == null || string.isBlank() || string.isEmpty()) {
            return "default";
        }
        return string;
    }

    protected static double verificationExperience(double num) {
        return num < 0 ? 0 : num;
    }
}
