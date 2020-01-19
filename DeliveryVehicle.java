/*
 * Class Name:    DeliveryVehicle
 *
 * Student Number:        Khawab raghuvanshi - 20444727
 * 
 * Class Description:       this is the deliveryVehicle class where info related to deliver vehicle
 *                          such as orders on board, driver are added.
 *
 */

public class DeliveryVehicle 
{

    private int vehicleID;
    private Driver driver;
    private Order order1;
    private Order order2;
    private Order order3;
    private int numOrdersDelivered;

    public DeliveryVehicle(int vehicleID) 
    {
        driver = null;
        order1 = null;
        order2 = null;
        order3 = null;
        numOrdersDelivered = 0;
        this.vehicleID = vehicleID;
    }

    public boolean hasDriver() 
    {
        if (driver != null) 
        {
            return true;
        }
        return false;
    }

    public void setDriver(Driver driver) 
    {
        this.driver = driver;
    }

    public int getVehicleID() 
    {
        return vehicleID;
    }

    public int getNumOrdersDelievered() 
    {
        return numOrdersDelivered;
    }

    public int getNumOrdersOnBoard() 
    {
        int onBoard = 0;
        if (order1 != null) 
        {
            onBoard++;
        }
        if (order2 != null) 
        {
            onBoard++;
        }
        if (order3 != null) 
        {
            onBoard++;
        }
        return onBoard;
    }

    void addOrder(Order order) 
    {
        if (order1 == null) 
        {
            order1 = order;
        } 
        else if (order2 == null) 
        {
            order2 = order;
        } 
        else if (order3 == null) 
        {
            order3 = order;
        } 
        else 
        {
            //orders full
        }
    }

    public String makeDelivery() 
    {
		updateDeliveredOrders();
        String deliveryTicket = this.toString();
        return deliveryTicket;
    }

    private void updateDeliveredOrders() 
    {
        if (order1 != null) 
        {
            numOrdersDelivered++;
            order1 = null;
        }
        if (order2 != null) 
        {
            numOrdersDelivered++;
            order2 = null;
        }
        if (order3 != null) 
        {
            numOrdersDelivered++;
            order3 = null;
        }
    }

    @Override
    public String toString() 
    {
        String orders = "";
        if(order1!=null)
        {
            orders = orders + order1.toString()+"\n";
        }
        if(order2!=null)
        {
            orders = orders + order2.toString()+"\n";
        }
        if(order3!=null)
        {
            orders = orders + order3.toString()+"\n";
        }
        
        String driverName = "";
        if(driver!=null)
        {
            driverName = driver.toString();
        }
        return "DeliveryVehicle[ vehicleID: "+vehicleID+"\n" +
                ", "+driverName+"\n" +
                ", "+orders+"\n" +
                ", numOrdersDelivered: "+numOrdersDelivered+" ]";
    }
}
