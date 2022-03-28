package ie.tudublin;

import javax.swing.text.TableView.TableRow;

public class Star {
    private boolean hab;
    private String displayName;
    private float distance;
    private float Xg, Yg, zG;
    private float absMag;

    // Intantiating from table row parameter
    public Star(TableRow tr) {
        // Call other constructor
        this(
            tr.getInt("Hab?") == 1, 
            tr.getString("Display Name"), 
            tr.getFloat("Distance"), 
            tr.getFloat("Xg"), 
            tr.getFloat("Yg"), 
            tr.getFloat("Zg"), 
            tr.getFloat("AbsMag")
    }


    // Creating constructor
    public Star(boolean hab, String displayName, float distance, float xg, float yg, float zG, float absMag) {
        this.hab = hab; // Disambiguating between this instance and parameter 'hab'
        this.displayName = displayName;
        this.distance = distance;
        this.Xg = xg;
        this.Yg = yg;
        this.zG = zG;
        this.absMag = absMag;
    }


    // All encapsulation of important data fields
    public boolean isHab() {
        return Hab;
    }


    public void setHab(boolean hab) {
        Hab = hab;
    }


    public String getDisplayName() {
        return displayName;
    }


    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }


    public float getDistance() {
        return distance;
    }


    public void setDistance(float distance) {
        this.distance = distance;
    }


    public float getXg() {
        return Xg;
    }


    public void setXg(float xg) {
        Xg = xg;
    }


    public float getYg() {
        return Yg;
    }


    public void setYg(float yg) {
        Yg = yg;
    }


    public float getzG() {
        return zG;
    }


    public void setzG(float zG) {
        this.zG = zG;
    }


    public float getAbsMag() {
        return absMag;
    }


    public void setAbsMag(float absMag) {
        this.absMag = absMag;
    }



}
