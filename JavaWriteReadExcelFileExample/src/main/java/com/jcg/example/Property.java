package com.jcg.example;


public class Property {

    private String month;
    private String detached;
    private String semidetached;
    private String terraced;
    private String flat;

    public Property(){}

    public Property(String month, String detached, String semidetached, String terraced, String flat) {
        this.month = month;
        this.detached = detached;
        this.semidetached = semidetached;
        this.terraced = terraced;
        this.flat = flat;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDetached() {
        return detached;
    }

    public void setDetached(String detatched) {
        this.detached = detatched;
    }

    public String getSemi() {
        return semidetached;
    }

    public void setSemi(String semidetatched) {
        this.semidetached = semidetatched;
    }

    public String getTerraced() {
        return terraced;
    }

    public void setTerraced(String terraced) {
        this.terraced = terraced;
    }
    
    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }
   

    @Override
    public String toString() {
        return month+ ": Detatched "+detached+ " Semidetatched "+semidetached+" Terraced "+terraced+ "Flat"+flat;
    }
}
