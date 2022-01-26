package ie.tudublin;
public class Cat extends Animal
{
    public Cat(String name)
    {
        super(name);
    }

    private int numLives;

    public int getLives()
    {
        return this.numLives=9;
    }

    public void kill()
    {
        if (numLives==0)
        {
            this.numLives--;
            System.out.println("dead");
        }
        else
        {
            System.out.println("Ouch!");
        }

        return;
    }
}