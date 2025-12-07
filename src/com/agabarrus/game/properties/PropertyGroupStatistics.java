package com.agabarrus.game.properties;

import com.agabarrus.game.exceptions.PropertyGroupException;

public class PropertyGroupStatistics implements IPropertyGroupStatistics{

    public static PropertyGroupStatistics from (PropertyGroupColor color){
        //TODO: Optimizar esto para que sea automático (un archivo de configuración)?
        switch(color){
            case BROWN -> new PropertyGroupStatistics(2, new int[] {1,3});
            case SKYBLUE -> new PropertyGroupStatistics(3,new int[] {1,2,4});
            case PURPLE -> new PropertyGroupStatistics(3, new int[] {2,3,4});
            case ORANGE -> new PropertyGroupStatistics(3, new int[] {2,3,5});
            case RED -> new PropertyGroupStatistics(3, new int[] {1,2,3});
            case YELLOW -> new PropertyGroupStatistics(3, new int[] {1,2,3});
            case GREEN -> new PropertyGroupStatistics(3, new int[] {1,2,3});
            case BLUE ->  new PropertyGroupStatistics(2, new int[] {1,2,3});
            case SERVICES ->  new PropertyGroupStatistics(2, new int[] {1,2,3});
            case STATIONS ->   new PropertyGroupStatistics(4, new int[] {1,2,3});
        }
        throw new PropertyGroupException("Unknown color");
    }


    private final int numberOfProperties;
    private final int[] typesOfRent;

    private PropertyGroupStatistics(int numberOfProperties, int[] typesOfRent) {
        this.numberOfProperties = numberOfProperties;
        this.typesOfRent = typesOfRent;
    }

    @Override
    public int getNumberOfPropertiesInGroup() {
        return numberOfProperties;
    }

    @Override
    public int[] getAllRentType() {
        return typesOfRent;
    }

    @Override
    public int getRentAccordingToPropertiesOwned(int propertiesOwned) throws PropertyGroupException {
        if (propertiesOwned > numberOfProperties) throw new PropertyGroupException("The properties owned is greater than number of properties in the group");
        if (propertiesOwned == 0)
            return 0;
        return typesOfRent[propertiesOwned-1];
    }
}
