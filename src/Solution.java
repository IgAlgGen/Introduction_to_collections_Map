import Drivers.License_B;
import Drivers.License_C;
import Drivers.License_D;
import Maintenance.Mechanic;
import Maintenance.ServiceStation;
import Transport.*;

import java.sql.Driver;
import java.util.*;


public class Solution {
    public static void main(String[] args) {
        Mechanic a1 = new Mechanic(
                "Геннадий",
                "Генадьев",
                "\"Рога и копыта\"");
        Mechanic a2 = new Mechanic(
                "Святослав",
                "Святов",
                "\"Чиним ломаем\"");
        Mechanic a3 = new Mechanic(
                "Добрыня",
                "Добров",
                "\"И так сойдет\"");

        List<Mechanic> mechanicList = new ArrayList<>(Arrays.asList(a1, a2, a3));

        Transport<License_B> car1 = new Car(
                "Lada",
                "Kalina",
                1.6,
                "Седан",
                new License_B(
                        "Ivan Ivanov",
                        true,
                        2.0),
                mechanicList);
        Bus bus1 = new Bus(
                "LIaZ",
                "Moon Rider",
                3.,
                45,
                new License_D(
                        "Petr Petrov",
                        true,
                        10.),
                mechanicList);

        Track track1 = new Track(
                "Kamaz",
                "6520",
                8.,
                50,
                new License_C(
                        "Sidor Sidorov",
                        true,
                        6.),
                mechanicList);

        List<Transport<?>> transportList = new ArrayList<>(Arrays.asList(car1, bus1, track1));
        System.out.println(transportList);

        Queue<Transport<?>> stoList = new ArrayDeque<>();
        ServiceStation serviceStation = new ServiceStation(stoList);
        for (Transport<?> transport : transportList) {
            serviceStation.addTransport(transport);
        }

        passingDiagnostics(car1);
        passingDiagnostics(bus1);
        passingDiagnostics(track1);

        System.out.println();

        for (int i = 0; i < 4; i++) {
            serviceStation.doService();
        }
        Map<String, Mechanic> transportMechanicHashMap = new HashMap<>();
        transportMechanicHashMap.put(String.valueOf(transportList.get(0)), a1);
        transportMechanicHashMap.put(String.valueOf(transportList.get(1)), a2);
        transportMechanicHashMap.put(String.valueOf(transportList.get(2)), a3);

        System.out.println();

        for (Map.Entry<String, Mechanic> objectObjectEntry: transportMechanicHashMap.entrySet()) {
            System.out.println(objectObjectEntry.getKey() + " - " + objectObjectEntry.getValue());
        }
        // Надеюсь, я правильно понял условие: "В консоль выводится информация об автомобилях без повтора.
        // В мапе в качестве ключей используется другой объект, который является полным аналогом уже существующего объекта."
    }

    public static void printSolution(Transport<?> transport) {
        System.out.println("Водитель " + transport.getDriverInfo() + ", управляет автомобилем " + transport + " и будет участвовать в заезде.");
    }

    public static void passingDiagnostics(Transport<?> transport) {

        try {
            if (transport.isNeedDiagnostics()) {
                System.out.println("Транспортное средство " + transport + " прошло диагностику.");
            } else {
                System.out.println("Транспортное средство " + transport + " не опознано.");
            }
        } catch (TransportTypeException e) {
            System.out.println("Автобусы не должны проходить диагностику.");
        }
    }


}

