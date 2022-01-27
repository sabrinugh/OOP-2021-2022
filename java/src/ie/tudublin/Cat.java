package ie.tudublin;
public class Cat extends Animal
{
    private int numLives;

    public int getNumLives() {
        return numLives;
    }

    public void setNumLives(int numLives) {
        this.numLives = numLives;
    }
    
    public Cat(String name) {
        super(name);
        numLives = 9;
    }

    public void kill()
    {
        if (numLives>0)
        {
            System.out.println("Ouch!");
            numLives--;
        }
        else
        {
            System.out.println("dead");
        }
        return;
    }
}