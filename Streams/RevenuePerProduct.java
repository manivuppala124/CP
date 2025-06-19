/*You have a list of customer orders. Each order has:
	A product name (String)
	A sales region (String)
	A quantity sold (int)
	A unit price (double)

Write a program that:

	1. Filters the orders to only those in the "US" region.

	2. Computes total revenue per product (i.e. quantity * unitPrice) across those US orders.

	3. Prints each product’s name and total revenue, sorted alphabetically by product.

Expected Output:
----------------
Headphones   -> $500.00
Laptop       -> $3,550.00
Smartphone   -> $2,460.00 */
import java.util.*;
import java.util.stream.*;
  
public class RevenuePerProduct {
    // Domain class
    static class Order {
        private final String product;
        private final String region;
        private final int quantity;
        private final double unitPrice;
        //WRITE YOUR HERE
        Order(String p,String r,int q,double u){
            this.product=p;
            this.region=r;
            this.quantity=q;
            this.unitPrice=u;
        }
        String getRegion(){
            return region;
        }
        int getQuantity(){
            return quantity;
        }
        double getUnitPrice(){
            return unitPrice;
        }
    }

    public static void main(String[] args) {
        List<Order> orders = List.of(
            new Order("Laptop",   "US",  2, 1200.00),
            new Order("Smartphone","EU",  5,  800.00),
            new Order("Laptop",   "US",  1, 1150.00),
            new Order("Headphones","US", 10,   50.00),
            new Order("Smartphone","US",  3,  820.00)
        );
        
       //WRITE YOUR CODE HERE
    }
}