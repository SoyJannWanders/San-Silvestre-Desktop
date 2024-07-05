package com.sansilvestre.desktop.app;

public class NavigationData {

    private final Object[] data;
    private final Class<?>[] type;

    public NavigationData(Object[] data, Class<?>[] type) {
        this.data = data;
        this.type = type;
    }

    public Object[] getData() {
        return data;
    }

    public Class<?>[] getType() {
        return type;
    }

    public <T> T getDataAs(int index, Class<T> type) {
        if (type.isInstance(data[index])) {
            return type.cast(data[index]);
        }
        throw new IllegalArgumentException("Data at index " + index + " is not of type " + type.getName());
    }

}