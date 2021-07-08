package edu.team04.crucible;

/**
 * This abstract class lets Cards and Categories be selectable on ListViews, which will be useful
 * for several activities with item selection via ListView.
 */
public abstract class Selectable {
    boolean isSelected;

    public boolean isSelected() {return isSelected;}

    public void setSelected(boolean selected) {isSelected = selected;}
}
