package ro.unibuc.fooddeliveryapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
        int foo = in.nextInt();
        Interogations interogations = new Interogations();
        while (foo>0)
        {
            if(foo == 1){
                interogations.addDrivers(in);
            }

            if(foo == 2)
            {
                interogations.addOrders(in);
            }

            if(foo == 3)
            {
                interogations.addRestaurant(in);
            }

            if(foo == 4)
            {
                interogations.addUsers(in);
            }

            if(foo == 5)
            {
                System.out.println(interogations.getOrdersById(in.nextInt()));
            }

            if(foo == 6)
            {
                System.out.println(interogations.getRestaurantsById(in.nextInt()));
            }

            if(foo == 7)
            {
                System.out.println(interogations.getUser(in.nextInt()));
            }
        }
    }
}
