package dev.peruch.rxjava.model;

import dev.peruch.rxjava.business.PizzaBusiness;
import org.springframework.beans.factory.annotation.Autowired;

public class Pizza {

    @Autowired
    PizzaBusiness pizzaBusiness;
    private String size;
    private String flavor;
    private boolean hasStuffedEdge;
    private double value;

    public Pizza(String size, String flavor, boolean hasStuffedEdge) {
        this.size = size;
        this.flavor = flavor;
        this.hasStuffedEdge = hasStuffedEdge;
        this.value = pizzaBusiness.calculateTotalValue(size, hasStuffedEdge);
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isHasStuffedEdge() {
        return hasStuffedEdge;
    }

    public void setHasStuffedEdge(boolean hasStuffedEdge) {
        this.hasStuffedEdge = hasStuffedEdge;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "flavor='" + flavor + '\'' +
                ", size='" + size + '\'' +
                ", hasStuffedEdge=" + hasStuffedEdge +
                ", value=" + value +
                '}';
    }
}
