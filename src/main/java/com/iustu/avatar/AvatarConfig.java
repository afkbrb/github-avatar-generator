package com.iustu.avatar;

import com.iustu.avatar.exception.AvatarException;
import com.iustu.avatar.util.ColorGenerator;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
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
     * The size of each cell.
     * Both height and width of cell are equal to it.
     */
    private int cellSize;

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
     * Default configuration.
     */
    public AvatarConfig() {
        cellCount = 5;
        padding = 32;
        cellSize = 64;
        backColor = new Color(241, 241, 241);
        transparent = false;
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
     * Set the size of each cell.
     * @param cellSize
     */
    public void setCellSize(int cellSize) {
        if(cellSize < 0) throw new AvatarException("cellSize must be position");
        this.cellSize = cellSize;
    }

    /**
     * Set foreground color list,
     * the list contains only this color.
     * @param color
     */
    public void setForeColor(Color color) {
        foreColorList = new ArrayList<>();
        foreColorList.add(color);
    }

    /**
     * Set foreground color list,
     * final foreground color will be chosen at random int the list.
     * @param colors
     */
    public void setForeColors(Color... colors) {
        foreColorList = Arrays.asList(colors);
    }

    /**
     * Set foreground color list,
     * final foreground color will be chosen at random int the list.
     * @param colors
     */
    public void setForeColors(List<Color> colors) {
        // shouldn't be written as: foreColorList = colors;
        // otherwise, if colors change, foreColorList will also change
        foreColorList = new ArrayList<>(colors);
    }

    /**
     * Set background color.
     * @param color
     */
    public void setBackColor(Color color) {
        this.backColor = color;
    }

    /**
     * Note that setting the avatar transparent will disable the background color setting.
     * @param transparent
     */
    public void setTransparent(boolean transparent) {
        this.transparent = transparent;
    }

    public int getPadding() {
        return padding;
    }

    public int getCellCount() {
        return cellCount;
    }

    public int getCellSize() {
        return cellSize;
    }

    public boolean getTransparent() {
        return transparent;
    }

    /**
     * Get foreground color.
     * Return a color in foreColorList at random if the list is not empty,
     * otherwise return a random color that meets certain condition.
     * @return
     */
    public Color getForeColor() {
        if (foreColorList == null || foreColorList.size() == 0) return ColorGenerator.generateColor();
        return foreColorList.get((new Random()).nextInt(foreColorList.size()));
    }

    public Color getBackColor() {
        return backColor;
    }

}
