import java.util.ArrayList;
import java.util.Scanner;

public class onlineshoppingsystem 
{
    
    static class Product
	{
        String name;
        double price;

        Product(String name, double price)
		{
            this.name = name;
            this.price = price;
        }
    }

    public static void main(String[] args)
	{
        
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("laptop", 50000.00));
        products.add(new Product("smartphone", 20000.00));
        products.add(new Product("headphones", 1000.00));
        products.add(new Product("tablet", 15000.00));
        products.add(new Product("smartwatch",5000.00));

        
        ArrayList<Product> cart = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean shopping = true;

        System.out.println("Welcome to the Online Shopping System!");

        
        while (shopping) 
		{
            System.out.println("\nMenu:");
            System.out.println("1. View Products");
            System.out.println("2. View Cart");
            System.out.println("3. Add Product to Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice)
			{
                case 1:

                    System.out.println("\nAvailable Products:");
                    for (int i = 0; i < products.size(); i++)
					{
                        System.out.println((i + 1) + ". " + products.get(i).name + " - Rs" + products.get(i).price);
                    }
                    break;

                case 2:
                   
                    if (cart.isEmpty())
					{
                        System.out.println("\nYour cart is empty.");
                    }
					else
					{
                        System.out.println("\nYour Cart:");
                        double total = 0;
                        for (Product p : cart)
						{
                            System.out.println("- " + p.name + " - Rs" + p.price);
                            total += p.price;
                        }
                        System.out.println("Total: $" + total);
                    }
                    break;

                case 3:
                    
                    System.out.println("\nEnter the number of the product to add to your cart:");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println((i + 1) + ". " + products.get(i).name + " - rs" + products.get(i).price);
                    }
                    System.out.print("Your choice: ");
                    int productChoice = scanner.nextInt();
                    if (productChoice > 0 && productChoice <= products.size())
					{
                        cart.add(products.get(productChoice - 1));
                        System.out.println(products.get(productChoice - 1).name + " has been added to your cart.");
                    }
					else 
					{
                        System.out.println("Invalid choice. Please try again.");
                    }
                    break;

                case 4:
                    
                    if (cart.isEmpty())
					{
                        System.out.println("\nYour cart is empty. Add items to your cart before checking out.");
                    }
					else
					{
                        System.out.println("\nCheckout Summary:");
                        double total = 0;
                        for (Product p : cart)
						{
                            System.out.println("- " + p.name + " - rs" + p.price);
                            total += p.price;
                        }
                        System.out.println("Total: rs" + total);
                        System.out.println("Thank you for your purchase!");
                        shopping = false; 
                    }
                    break;

                case 5:
                    
                    System.out.println("Thank you for visiting. Goodbye!");
                    shopping = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}