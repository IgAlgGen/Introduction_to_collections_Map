package Maintenance;

import Transport.Transport;

public class Mechanic {
    private String firstName, secondName, company;

    public Mechanic(String firstName, String secondName, String company) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.company = company;
    }

    public <T extends Transport<?>> void doMaintenance(T vehicle) {
        System.out.println(vehicle.toString() + " обслуживается " + toString());
    }

    public <T extends Transport<?>> void fixTheVehicle(T vehicle) {
        System.out.println(vehicle.toString() + " ремонтируется " + this);
    }

    @Override
    public String toString() {
        return "механик" +
                " " + firstName +
                " " + secondName +
                ", компании " + company;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
