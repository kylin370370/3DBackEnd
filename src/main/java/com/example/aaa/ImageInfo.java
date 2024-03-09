package com.example.aaa;
public class ImageInfo {
    private String imagePath;
    private String binaryImagePath;
    private boolean hasCrack;
    private Double crackArea;
    private Double crackLength;
    private Double crackAverageWidth;
    private String crackMaxWidth;

    public ImageInfo() {
        // 默认构造器
    }

    public ImageInfo(String imagePath, String binaryImagePath, boolean hasCrack,
                     Double crackArea, Double crackLength, Double crackAverageWidth, String crackMaxWidth) {
        this.imagePath = imagePath;
        this.binaryImagePath = binaryImagePath;
        this.hasCrack = hasCrack;
        this.crackArea = crackArea;
        this.crackLength = crackLength;
        this.crackAverageWidth = crackAverageWidth;
        this.crackMaxWidth = crackMaxWidth;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getBinaryImagePath() {
        return binaryImagePath;
    }

    public void setBinaryImagePath(String binaryImagePath) {
        this.binaryImagePath = binaryImagePath;
    }

    public boolean isHasCrack() {
        return hasCrack;
    }

    public void setHasCrack(boolean hasCrack) {
        this.hasCrack = hasCrack;
    }

    public Double getCrackArea() {
        return crackArea;
    }

    public void setCrackArea(Double crackArea) {
        this.crackArea = crackArea;
    }

    public Double getCrackLength() {
        return crackLength;
    }

    public void setCrackLength(Double crackLength) {
        this.crackLength = crackLength;
    }

    public Double getCrackAverageWidth() {
        return crackAverageWidth;
    }

    public void setCrackAverageWidth(Double crackAverageWidth) {
        this.crackAverageWidth = crackAverageWidth;
    }

    public String getCrackMaxWidth() {
        return crackMaxWidth;
    }

    public void setCrackMaxWidth(String crackMaxWidth) {
        this.crackMaxWidth = crackMaxWidth;
    }

    @Override
    public String toString() {
        return "ImageInfo{" +
                "imagePath='" + imagePath + '\'' +
                ", binaryImagePath='" + binaryImagePath + '\'' +
                ", hasCrack=" + hasCrack +
                ", crackArea=" + crackArea +
                ", crackLength=" + crackLength +
                ", crackAverageWidth=" + crackAverageWidth +
                ", crackMaxWidth=" + crackMaxWidth +
                '}';
    }
}
