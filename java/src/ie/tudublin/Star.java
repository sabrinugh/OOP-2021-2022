package ie.tudublin;

import processing.data.TableRow;
import processing.core.PApplet;

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
        );
    }

    
    // toString gets called implicitly regardless
    @Override
    public String toString() {
        return "Star [Xg=" + Xg + ", Yg=" + Yg + ", absMag=" + absMag + ", displayName=" + displayName + ", distance="
                + distance + ", hab=" + hab + ", zG=" + zG + "]";
    }


    // Creating constructor
    public Star(boolean hab, String displayName, float distance, float xg, float yg, float zG, float absMag) {
        this.hab = hab; // Disambiguating between 'this' instance and parameter 'hab'
        this.displayName = displayName;
        this.distance = distance;
        this.Xg = xg;
        this.Yg = yg;
        this.zG = zG;
        this.absMag = absMag;
    }


    // All encapsulation of important data fields
    public boolean isHab() {
        return hab;
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
    package ie.tudublin;

    import processing.core.PApplet;
    import processing.data.TableRow;
    
    public class Star
    {
        private boolean hab;
        private String displayName;
        private float distance;
        private float xG;
        private float yG;
        private float zG;
        private float absMag;
    
        
    
        @Override
        public String toString() {
            return "Star [absMag=" + absMag + ", displayName=" + displayName + ", distance=" + distance + ", hab=" + hab
                    + ", xG=" + xG + ", yG=" + yG + ", zG=" + zG + "]";
        }
    
        public Star(TableRow tr)
        {
            this(
                tr.getInt("Hab?") == 1, 
                tr.getString("Display Name"), 
                tr.getFloat("Distance"),
                tr.getFloat("Xg"),
                tr.getFloat("Yg"),
                tr.getFloat("Zg"),
                tr.getFloat("AbsMag")
            );
        }
        
        public Star(boolean hab, String displayName, float distance, float xG, float yG, float zG, float absMag) {
            this.hab = hab;
            this.displayName = displayName;
            this.distance = distance;
            this.xG = xG;
            this.yG = yG;
            this.zG = zG;
            this.absMag = absMag;
        }
    
        public boolean isHab() {
            return hab;
        }
        public void setHab(boolean hab) {
            this.hab = hab;
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
        public float getxG() {
            return xG;
        }
        public void setxG(float xG) {
            this.xG = xG;
        }
        public float getyG() {
            return yG;
        }
        public void setyG(float yG) {
            this.yG = yG;
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
    
        public void render(StarMap pa)
        {
            float x = PApplet.map(xG, -5, 5, pa.border, pa.width - pa.border);
            float y = PApplet.map(yG, -5, 5, pa.border, pa.height - pa.border);
    
            
            pa.stroke(255, 255, 0);
            pa.line(x, y -5, x, y + 5);
            pa.line(x-5, y, x + 5, y);
            pa.stroke(255, 0, 0);
            pa.noFill();
            pa.circle(x, y, absMag);
            pa.fill(255);
            pa.textSize(16);
            pa.textAlign(PApplet.LEFT, PApplet.CENTER);
            pa.text(displayName, x + 20, y);
        }
    }

    public void setAbsMag(float absMag) {
        this.absMag = absMag;
    }

    
    // Drawing location of stars on grid
    public void render(StarMap pa) {
        float x = PApplet.map(Xg, -5, -5, pa.border, pa.width-pa.border);
        float y= PApplet.map(Yg, -5, 5, pa.border, pa.height-pa.border);
    
        pa.stroke(255, 255, 0);
        pa.line(x, y-5, x, y+5);
        pa.line(x-5, y, x+5, y);

        pa.stroke(255, 0, 0); // red circle
        pa.noFill();
        pa.circle(x, y, absMag);
        pa.fill(255);
        pa.textAlign(PApplet.LEFT, PApplet.CENTER);  
        pa.text(displayName, x+20, y);  
    }
    


}
