package Maintenance;

public class Verifications {

    protected static String verificationName (String string){
        if (string == null || string.isBlank()) {
            return "default";
        }
        return string;
    }
}
