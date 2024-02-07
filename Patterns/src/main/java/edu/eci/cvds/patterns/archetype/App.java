package edu.eci.cvds.patterns.archetype;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String name = (args.length > 0) ? args[0] : "World";
        String lastName = (args.length > 1) ? args[1] : " ";
        System.out.println("Hello " + name + " " + lastName + "!");
    }
}
