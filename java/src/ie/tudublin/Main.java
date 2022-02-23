package ie.tudublin;

public class Main
{
    public static void drawing()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new DrawingExercise());
    }

    public static void main(String[] args)
    {
        drawing();
        
    }
}