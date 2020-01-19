/*
 * Class Name:    Driver
 *
 * Student Number:        Khawab raghuvanshi - 20444727
 * 
 * Class Description:       This class contains info about driver such as the name of driver    
 *
 *
 */



public class Driver 
{

    //variables
    private String name;

    //constructor
    public Driver(String name) 
    {
        this.name = name;
    }

    //accessor
    public String getName() 
    {
        return name;
    }

    @Override
    public String toString() 
    {
        return "Driver[ driverName: "+name+" ]";
    }

}
