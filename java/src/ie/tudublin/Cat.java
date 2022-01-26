package ie.tudublin;
public class Cat extends Animal
{
    public Cat(String name)
    {
        super(name);
    }

    private int numLives=9;

    public int getLives()
    {
        return this.numLives;
    }

    public void kill()
    {
        if (numLives>0)
        {
            numLives--;
            System.out.println("Ouch!");
        }
        else
        {
            System.out.println("dead");
        }
        return;
    }
}