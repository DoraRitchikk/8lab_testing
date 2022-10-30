import Planes.ExperimentalPlane;
import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends Plane> planes;



    //Сокращать названия переменных или классов - тоже является плохой практикой
    //Так как человек, плохо знакомый с кодом может легко запутаться
    // названия методов - с маленькой буквы, навзания классов - с большой
    public List<PassengerPlane> getPassengerPlane() {
        //Здесь название самолёта обозначается буквой l и PassengerPlane Буквой x - это не соотв. code convention
        //Название должно быть говорящим, лучше всего - имя класса с маленькой буквы
        List<? extends Plane> plane = this.planes;
        List<PassengerPlane> passengerPlane = new ArrayList<>();
        //Здесь так же меняем
        for (Plane p : plane) {if (p instanceof PassengerPlane) {passengerPlane.add((PassengerPlane) p);}}
            return passengerPlane;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
            //Здесь у нас соверщенно бесполезные комментарии о функциональности, которые очевидны
            //Их нужно убрать (было if,else,for)
            //Нет функционала else
            else {

            }
        }
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlane();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanes.get(i);
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
    List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
    List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
    for (int i = 0; i < militaryPlanes.size(); i++) {
        MilitaryPlane plane = militaryPlanes.get(i);
        if (plane.getType() == MilitaryType.TRANSPORT) {
            transportMilitaryPlanes.add(plane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            MilitaryPlane plane = militaryPlanes.get(i);
            if (plane.getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }
        return bomberMilitaryPlanes;

    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            //Совершенно непонятное название для Plane
            public int compare(Plane planeFirstForCompare, Plane planeSecondForCompare) {
                return planeFirstForCompare.getMaxFlightDistance() - planeSecondForCompare.getMaxFlightDistance();
            }
        });
        return this;
    }

//Здесь многострочный комментарий - плохая практика, лучше комментить каждую строчку по отдельности
    //Так будет легче отслеживать начало и конец комментария
    /**
     * Sorts by max speed
     * @return Airport
     */
    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxSpeed() - o2.getMaxSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            //Невразумительно название для Plane o1 и o2
            public int compare(Plane planeFirstForCompare, Plane planeSecondForCompare) {
                return planeFirstForCompare.getMinLoadCapacity() - planeSecondForCompare.getMinLoadCapacity();
            }
        });
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private void print(Collection<? extends Plane> collection) {
        Iterator<? extends Plane> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Plane plane = iterator.next();
            System.out.println(plane);
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    //Constructor
    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

}
