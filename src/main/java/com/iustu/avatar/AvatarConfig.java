package com.iustu.avatar;

import com.iustu.avatar.exception.AvatarException;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * configuration for avatar
 */
public class AvatarConfig {

    /**
     * padding of the avatar
     */
    private int padding;

    /**
     * the number of cells in a row / column
     */
    private int cellCount;

    /**
     * the side length of each cell
     */
    private int cellLength;

    /**
     * a list of foreground colors
     * foreColor will be chosen randomly in the list
     */
    private List<Color> foreColorList;

    /**
     * background color (about light-gray by default)
     */
    private Color backColor;

    /**
     * default foreground color
     * cannot be modified
     */
    private final Color defaultForeColor;

    /**
     * default configuration
     */
    public AvatarConfig() {
        cellCount = 5;
        padding = 32;
        cellLength = 64;
        backColor = new Color(241, 241, 241);
        defaultForeColor = Color.magenta;
        foreColorList = new ArrayList<>();
    }

    /**
     * set padding of avatar
     * @param padding
     */
    public void setPadding(int padding) {
        if(padding < 0) throw new AvatarException("padding must be positive!");
        this.padding = padding;
    }

    /**
     * set the number of cells of each row / column
     * odd would make the avatar look better
     * @param cellCount
     */
    public void setCellCount(int cellCount) {
        if(cellCount < 0) throw new AvatarException("cellCount must be positive!");
        this.cellCount = cellCount;
    }

    /**
     * set the length of each cell
     * @param cellLength
     */
    public void setCellLength(int cellLength) {
        if(cellLength < 0) throw new AvatarException("cellLength must be position");
        this.cellLength = cellLength;
    }

    /**
     * add foreground color into the foreColorList
     * final foreground color will be chosen at random int the list
     * @param color
     */
    public void addForeColor(Color color) {
        this.foreColorList.add(color);
    }

    /**
     * set background color
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

    /**
     * get foreground color
     * return defaultForeColor if foreColorList is empty
     * otherwise return a Color in the list at random
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
