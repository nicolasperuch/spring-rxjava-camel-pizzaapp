package dev.peruch.rxjava.model;

public class OrderRequest {

    private String customerName;
    private String size;
    private String flavor;
    private boolean hasStuffedEdge;

    public String getCustomerName() {
        return customerName;
    }

    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    public boolean isHasStuffedEdge() {
        return hasStuffedEdge;
    }
}
