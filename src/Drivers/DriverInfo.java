package Drivers;

import static Drivers.Verifications.verificationExperience;
import static Drivers.Verifications.verificationFullName;


public abstract class DriverInfo {
    private String fullName;
    private boolean havingLicense;
    private double experience;

    public DriverInfo(String fullName, boolean havingLicense, double experience) {
        setFullName(fullName);
        setHavingLicense(havingLicense);
        setExperience(experience);
    }

    public void startDriving() {

    }

    public void stopDriving() {

    }

    public void refuelCar() {

    }

    public void setFullName(String fullName) {
        this.fullName = verificationFullName(fullName);
    }

    public void setHavingLicense(boolean havingLicense) {
        this.havingLicense = havingLicense;
    }

    public void setExperience(double experience) {
        this.experience = verificationExperience(experience);
    }

    public String getFullName() {
        return fullName;
    }

    public boolean isHavingLicense() {
        return havingLicense;
    }

    public double getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return fullName +
                ", вод. уд. " + (havingLicense ? "есть" : "нет") +
                ", опыт " + experience;
    }
}