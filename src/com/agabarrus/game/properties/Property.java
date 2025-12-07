package com.agabarrus.game.properties;

public class Property {
    private Player owner;

    private final PropertyGroupColor color;
    private boolean isInGame;
    private boolean isMoney;

    private final String name;

    Property(String name, PropertyGroupColor propertyGroupColor) {
        this.owner = null;
        this.color = propertyGroupColor;
        this.isInGame = false;
        this.isMoney = false;

        this.name = name;
    }

    public PropertyGroupColor getColor() {
        return color;
    }

    public boolean isInGame() {
        return isInGame;
    }

    public void setInGame(boolean inGame) {
        //TODO: Add Exception for this kind of error. See also line @40
        if (this.isInGame && !inGame) throw new RuntimeException("Property is already in game");
        isInGame = inGame;
    }

    public boolean isMoney() {
        return isMoney;
    }

    public void setMoney(boolean money) {
        if (this.isInGame) throw new RuntimeException("Property is already played. Can't be modified");
        isMoney = money;
        if (money)
            setInGame(true);
    }

    public String getName() {
        return name;
    }
}
