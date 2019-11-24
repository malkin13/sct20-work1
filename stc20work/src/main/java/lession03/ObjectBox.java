package lession03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class ObjectBox {
    private HashSet<Object> mainObj;

    public ObjectBox(Object[] objects) {
        mainObj = new HashSet<>(Arrays.asList(objects));
    }


    public void addObject(Object toAdd) {
        mainObj.add(toAdd);
    }


    public void deleteObject(Object toRemove) {
        mainObj.remove(toRemove);
    }


    private String dump() {
        return "ObjectBox{" +
                "objects=" + mainObj +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectBox objectBox = (ObjectBox) o;
        return Objects.equals(mainObj, objectBox.mainObj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainObj);
    }

    @Override
    public String toString() {
        return dump();
    }
}
