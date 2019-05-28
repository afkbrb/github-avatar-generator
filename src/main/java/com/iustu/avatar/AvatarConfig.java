package com.iustu.avatar;

import com.iustu.avatar.exception.AvatarException;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Configuration for avatar.
 */
public class AvatarConfig {

    /**
     * Padding of the avatar.
     */
    private int padding;

    /**
     * The number of cells in a row / column.
     */
    private int cellCount;

    /**
     * The side length of each cell.
     */
    private int cellLength;

    /**
     * A list of foreground colors,
     * foreColor will be chosen randomly in the list.
     */
    private List<Color> foreColorList;

    /**
     * Background color (about light-gray by default).
     */
    private Color backColor;

    /**
     * Whether the avatar is transparent or not.
     */
    private boolean transparent;

    /**
     * Default foreground color,
     * cannot be modified.
     */
    private final Color defaultForeColor;

    /**
     * Default configuration.
     */
    public AvatarConfig() {
        cellCount = 5;
        padding = 32;
        cellLength = 64;
        backColor = new Color(241, 241, 241);
        foreColorList = new ArrayList<>();
        transparent = false;
        defaultForeColor = Color.magenta;
    }

    /**
     * Set padding of avatar.
     * @param padding
     */
    public void setPadding(int padding) {
        if(padding < 0) throw new AvatarException("padding must be positive!");
        this.padding = padding;
    }

    /**
     * Set the number of cells of each row / column.
     * @param cellCount
     */
    public void setCellCount(int cellCount) {
        if(cellCount < 0) throw new AvatarException("cellCount must be positive!");
        this.cellCount = cellCount;
    }

    /**
     * Set the length of each cell.
     * @param cellLength
     */
    public void setCellLength(int cellLength) {
        if(cellLength < 0) throw new AvatarException("cellLength must be position");
        this.cellLength = cellLength;
    }

    /**
     * Add foreground color into the foreColorList,
     * final foreground color will be chosen at random int the list.
     * @param color
     */
    public void addForeColor(Color color) {
        this.foreColorList.add(color);
    }

    /**
     * Note that setting the avatar transparent will disable the background color setting.
     * @param transparent
     */
    public void setTransparent(boolean transparent) {
        this.transparent = transparent;
    }

    /**
     * Set background color.
     * @param color
     */
    public void setBackColor(Color color) {
        this.backColor = color;
    }

    public int getPadding() {
        return padding;
    }

    public int getCellCount() {
        return cellCount;
    }

    public int getCellLength() {
        return cellLength;
    }

    public boolean getTransparent() {
        return transparent;
    }

    /**
     * Get foreground color,
     * return defaultForeColor if foreColorList is empty,
     * otherwise return a color in the list at random.
     * @return
     */
    public Color getForeColor() {
        if(foreColorList == null || foreColorList.size() == 0) return defaultForeColor;
        return foreColorList.get((new Random()).nextInt(foreColorList.size()));
    }

    public Color getBackColor() {
        return backColor;
    }

}
