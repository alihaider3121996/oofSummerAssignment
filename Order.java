/*
 * Class Name:    Order
 *
 * Student Number:        Khawab raghuvanshi - 20444727
 * 
 * Class Description:       this class contains info about order such as number of order, what has
 *                          been ordered and order address.
 *
 *
 */


public class Order 
{

    private int orderNumber;
    private String orderAddress;
    private int numberOfCakes;
    public static int totalNumOfOrders = 0;
    private Cake cake;

    public Order(String orderAddress, Cake cake) 
    {
        this.orderAddress = orderAddress;
        this.cake = cake;
        totalNumOfOrders++;
        orderNumber = totalNumOfOrders;
        numberOfCakes = 1;
    }

    public int getOrderNumber() 
    {
        return orderNumber;
    }

    public String getOrderAddress() 
    {
        return orderAddress;
    }

    public int getNumberOfCakes() 
    {
        return numberOfCakes;
    }

    public Cake getCake() 
    {
        return cake;
    }

    public static int getTotalNumOfOrders() 
    {
        return totalNumOfOrders;
    }
    @Override
    public String toString() 
    {
        return "Order[ orderNumber: "+orderNumber+", orderAddress: " +orderAddress+", numberOfCakes: "+numberOfCakes+",\n"
			+cake.toString()+" ]";
    }
}
