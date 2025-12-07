package com.agabarrus.game.properties;

import com.agabarrus.game.exceptions.PropertyGroupException;

public interface IPropertyGroupStatistics {
    int getNumberOfPropertiesInGroup();
    int[] getAllRentType();
    int getRentAccordingToPropertiesOwned(int propertiesOwned) throws PropertyGroupException;
}
