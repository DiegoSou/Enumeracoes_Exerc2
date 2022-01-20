package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner scan = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		

		
		
//		Cliente Data
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = scan.next();
		System.out.print("Email: "); scan.nextLine();
		String email = scan.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date data = sdf.parse(scan.next());
		
		Client client = new Client(name, email, data);
		
		
//		Produto Data
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = scan.next();
		System.out.print("How many itens do this order? ");
		int qntItem = scan.nextInt();
		
		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);

		
		for(int i = 0; i<qntItem; i++) {
			System.out.println("Enter #"+(i+1)+" item data: ");
			System.out.print("Product name: ");
			String prdcName = scan.next();
			System.out.print("Product price: ");
			double prdcPrice = scan.nextDouble();
			System.out.print("Quantity: ");
			int prdcQuantity = scan.nextInt();
			
			Product product = new Product(prdcName, prdcPrice);
			OrderItem item = new OrderItem(prdcQuantity, prdcPrice, product);
			order.addItem(item);
		}
		
		System.out.println();
		
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order);
		scan.close();
	}

}
