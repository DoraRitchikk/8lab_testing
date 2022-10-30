package Planes;

import java.util.Objects;

public class PassengerPlane extends Plane{

    //Очевидные бесполезные комменатарии были такие же METHOD и CONSTRUCTORS

    //=================FIELDS=================
    private int passengersCapacity;

    public PassengerPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", passengersCapacity=" + passengersCapacity +
                '}');
    }

    //У нас нет пояснений, для чего нужен этот кусок кода, комментить код - плохая практика

//    @Override
//    public String toString() {
//        return super.toString().replace("}",
//                ", passengersCapacity=" + passengersCapacity +
//                        '}');
//    }

    @Override
    public boolean equals(Object object) {
        //Код был нечитаемый!Перенесла return на следующую строку
        if (this == object)
            return true;
        if (!(object instanceof PassengerPlane))
            return false;
        if (!super.equals(object))
            return false;
        PassengerPlane plane = (PassengerPlane) object;
            return passengersCapacity == plane.passengersCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }
}
