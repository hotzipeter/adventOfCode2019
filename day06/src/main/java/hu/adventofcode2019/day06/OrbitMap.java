package hu.adventofcode2019.day06;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class OrbitMap {
    List<OrbitObject> orbitObjects;

    public OrbitMap(List<String> orbits) {
        orbitObjects = new ArrayList<>();
        orbits.forEach(orbit -> {
            String[] objects = orbit.split("\\)");
            OrbitObject orbitObject1 = new OrbitObject(objects[0]);
            OrbitObject orbitObject2 = new OrbitObject(objects[1]);

            if (!orbitObjects.contains(orbitObject1)) {
                orbitObjects.add(orbitObject1);
            }

            if (!orbitObjects.contains(orbitObject2)) {
                orbitObjects.add(orbitObject2);
            }
        });

        orbits.forEach(orbit -> {
            String[] objects = orbit.split("\\)");
            OrbitObject orbitObject1 = getOrbitObjectByString(objects[0]);
            OrbitObject orbitObject2 = getOrbitObjectByString(objects[1]);
            orbitObject1.getOrbitObjectList().add(orbitObject2);
            orbitObject2.setParentObject(orbitObject1);
        });


    }

    public void setOrbitNumbers() {
        OrbitObject com = getOrbitObjectByString("COM");
        int orbitCounter = 1;
        List<OrbitObject> searchList = com.getOrbitObjectList();
        List<OrbitObject> foundList = new ArrayList<>();

        while (!searchList.isEmpty()) {
            int finalOrbitCounter = orbitCounter;
            for (OrbitObject orbitObject: searchList){
                orbitObject.setOrbitNumber(finalOrbitCounter);
                foundList.addAll(orbitObject.getOrbitObjectList());
            }
            searchList = foundList;
            foundList = new ArrayList<>();
            orbitCounter++;
        }
    }

    public int getSumOfOrbits() {
        setOrbitNumbers();
        int sum = 0;
        for (OrbitObject orbitObject: orbitObjects) {
            sum += orbitObject.getOrbitNumber();
        }

        return sum;
    }

    public int getDistanceBetweenObjects(String firsObjectName, String secondObjectName) {
        OrbitObject firstObject = getOrbitObjectByString(firsObjectName);
        OrbitObject secondObject = getOrbitObjectByString(secondObjectName);
        int counter = 0;
        Set<OrbitObject> searchList = new LinkedHashSet<>(firstObject.getOrbitObjectList());
        searchList.add(firstObject.getParentObject());
        Set<OrbitObject> foundList = new LinkedHashSet<>();

        while (!searchList.contains(secondObject)) {
            for (OrbitObject orbitObject: searchList) {
                foundList.addAll(orbitObject.getOrbitObjectList());
                if (orbitObject.getParentObject() !=  null) {
                    foundList.add(orbitObject.getParentObject());
                }
            }
            searchList = foundList;
            foundList = new LinkedHashSet<>();
            counter++;
        }

        return counter-1;

    }

    public OrbitObject getOrbitObjectByString(String objectName) {
        int index = orbitObjects.indexOf(new OrbitObject(objectName));
        return orbitObjects.get(index);
    }
}
