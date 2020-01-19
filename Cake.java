/*
 * Class Name:    Cake
 *
 * Student Number:        Khawab raghuvanshi - 20444727
 * 
 * Class Description:       This is the cake class where all the info related to cake and its
 *                          ingredients will be added.
 *
 */

public class Cake 
{
    private String name;
    private int eggs;
    private int sugarGrams;
    private int flourGrams;
    private int milkMilliLitres;

    public Cake(String name, int eggs, int sugarGrams, int flourGrams, int milkMilliLitres) 
    {
        this.name = name;
        this.eggs = eggs;
        this.sugarGrams = sugarGrams;
        this.flourGrams = flourGrams;
        this.milkMilliLitres = milkMilliLitres;
    }

    public String getName() 
    {
        return name;
    }

    public int getEggs() 
    {
        return eggs;
    }

    public int getSugarGrams() 
    {
        return sugarGrams;
    }

    public int getFlourGrams() 
    {
        return flourGrams;
    }

    public int getMilkMilliLitres() 
    {
        return milkMilliLitres;
    }
    @Override
    public String toString() 
    {
        return "Cake[ name: "+name+ ", eggs: "+eggs+", sugarGrams: "+sugarGrams+", flourGrams: "+flourGrams+", milkMilliLitres: "+milkMilliLitres+" ]";
    }

}
