package dev.peruch.rxjava.entity;

public class Pizza {

    private String flavor;
    private String size;
    private boolean hasStuffedEdge;
    private double value;

    public Pizza(String size, String flavor, boolean hasStuffedEdge) {

        this.size = size;
        this.flavor = flavor;
        this.hasStuffedEdge = hasStuffedEdge;
        this.value = calculateTotalValue();
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

    private double calculateTotalValue(){
        double currentValue = 25;

        if(hasStuffedEdge){
            currentValue += 5;
        }

        if(size.equalsIgnoreCase("G")){
            currentValue += 5;
        }

        return currentValue;
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
