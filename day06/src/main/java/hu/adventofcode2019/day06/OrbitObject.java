package hu.adventofcode2019.day06;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrbitObject {
    private final String name;
    private List<OrbitObject> orbitObjectList;
    @Setter
    @Getter
    private OrbitObject parentObject;
    @Setter
    @Getter
    private int orbitNumber = 0;

    public OrbitObject(String name) {
        this.name = name;
    }

    public OrbitObject(String name, List<OrbitObject> orbitObjectList) {
        this.name = name;
        this.orbitObjectList = orbitObjectList;
    }

    public List<OrbitObject> getOrbitObjectList() {
        if (orbitObjectList == null) {
            orbitObjectList = new ArrayList<>();
        }
        return orbitObjectList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrbitObject that = (OrbitObject) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
