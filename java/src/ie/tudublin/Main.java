package ie.tudublin;

public class Main
{
    // Create and call the loops class. Create a sketch and open window
    public static void loops()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Loops());
    }

    /*
    Main running code
    */
    public static void main(String[] args)
    {
        loops();
        
    }
}