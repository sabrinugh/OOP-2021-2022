package ie.tudublin;

public abstract class GameObject {
    float x, y;
    float fx, fy;
    float w;
    float halfW;

    YASC yasc;

    float rotation;

    public GameObject(YASC yasc) {
        this.yasc = yasc;
    }

    // Methods can be put on without any bodies
    // CAnnot make instance of method but methods in subclasses
    public abstract void render();
    public abstract void update();

}
