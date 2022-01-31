package ie.tudublin;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello world");

        Animal misty = new Animal("Misty");
        Animal lucy = new Animal("Lucy");

        lucy = misty;
        misty.setName("Tara");

        System.out.println(misty);
        System.out.println(lucy);

        // Tara Misty
        // Tara Tara
        Cat ginger = new Cat("Ginger");

        while (ginger.getNumLives() > 0)
        {
            ginger.kill();
        }
        ginger.kill();
    }

    // Tutorial java intro week 1
    public boolean sleepIn(boolean weekday, boolean vacation) {
        // false false
        // true false
        // true true
        return (!weekday || vacation);
    }

    public int diff21(int n) {
        // dif21(19); -> 2
        // dif21(10); -> 11
        // dif21(21); -> 0
        if (n<=21) {
            return (21-n);
        }
        else {
            return (n-21)*2;
        }
        /*
        Inline if statement
        // If A, then B else C
        return (n<=21) ? (21-n) : (n-21)*2;
        */
    }

    public boolean parrotTrouble(boolean talking, int hour) {
        //true, 6 -> true
        // true, 7 -> false
        // false, 6 -> false
        return (talking==true && (hour<7 || hour>20));
    }

    public boolean makes10(int a, int b) {
        // Return true if sum is 10 or any number a or b is 10
        return (a+b==10 || a==10 || b==10);
    }
}