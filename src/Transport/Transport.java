package Transport;

import Drivers.DriverInfo;
import Maintenance.Mechanic;

import java.util.List;

import static Transport.Verifications.*;


public abstract class Transport<T extends DriverInfo> implements Emulous {
    private String mark, model;
    private double engineVolume;
    private T driverInfo;
    private List<Mechanic> mechanicList;


    public Transport(String mark, String model, double engineVolume, T driverInfo, List<Mechanic> mechanicList) {
        setMark(mark);
        setModel(model);
        setEngineVolume(engineVolume);
        setDriverInfo(driverInfo);
        this.mechanicList = mechanicList;

    }

    abstract public void printType();

    public void startMoving() {

    }

    public void finishMoving() {

    }

    abstract public boolean isNeedDiagnostics() throws TransportTypeException;

    public boolean isNeedService() {
        try {
            isNeedDiagnostics();
        } catch (TransportTypeException e) {
            return false;
        }
        return true;
    }

    public List<Mechanic> getMechanicList() {
        return mechanicList;
    }

    public void setDriverInfo(T driverInfo) {
        this.driverInfo = driverInfo;
    }

    public void setMark(String mark) {
        this.mark = verificationMark(mark);
    }

    public void setModel(String model) {
        this.model = verificationModel(model);
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = verificationEngineVolume(engineVolume);
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public T getDriverInfo() {
        return driverInfo;
    }

    @Override
    public String toString() {
        return "марка " + mark +
                ", модель " + model +
                ", объем двигателя " + engineVolume;
    }


}
