import java.util.Scanner;

class CashRegisterTester{
	public static void main(String[] args){
		
		Product[] products = new Product[5];
	
		products[0] = new Product();
		products[0].setCode(0);
		products[0].setName("Psomi");
		products[0].setPrice(0.50);

		products[1] = new Product();
		products[1].setCode(1);
		products[1].setName("Gala");
		products[1].setPrice(1.30);
		
		products[2] = new Product();
		products[2].setCode(2);
		products[2].setName("Mila");
		products[2].setPrice(1.80);
		
		products[3] = new Product();
		products[3].setCode(3);
		products[3].setName("Zaxari");
		products[3].setPrice(2.40);

		products[4] = new Product();
		products[4].setCode(4);
		products[4].setName("Krasi");
		products[4].setPrice(13.20);


		for (int i=0;i<5;i++){
			System.out.println("\n Product code: "+products[i].getCode()+" \n Product Name: "+products[i].getName()+ "\n Product Price: " + products[i].getPrice()); 
		}

		System.out.println("Which product would you like to buy?");
		Scanner myscanner = new Scanner(System.in);
		int iEntered;
		iEntered = myscanner.nextInt();
		
		CashRegister register = new CashRegister(products);

		register.recordPurchase(iEntered, products);

		System.out.println("Would you like to buy something more? [y/n]");
		String answer;
		answer = myscanner.next();

			
		while(answer.equals("y")){
			System.out.println("Which product would you like to buy?");
			iEntered = myscanner.nextInt();

			register.recordPurchase(iEntered, products);

			System.out.println("Would you like to buy something more? [y/n]");
			answer = myscanner.next();

		}

		System.out.println("How much money will you give?");
		double pay = myscanner.nextDouble();

		register.enterPayment(pay);
		String check;
		check=register.checkPayment();

		while (check=="false"){
			System.out.println("You didn't give enough money!");
			System.out.println("So, how much money will you give?");
			pay = myscanner.nextDouble();
			register.enterPayment(pay);
			check=register.checkPayment();
		}
		register.finalReceipt();
	}
}
class Product{

	//Product fields
	public int code;
	public String name;
	public double price;


	//Getters & setters
	public int getCode(){
		return code;
	}

	public void setCode(int scode){
		code = scode;
	}

	public String getName(){
		return name;
	}

	public void setName(String sname){
		name = sname;
	}

	public double getPrice(){
		return price;
	}

	public void setPrice(double sprice){
		price = sprice;
	}
}

public class CashRegister extends Product{
	public CashRegister(Product[] products){
		purchase = 0;
		payment = 0;
	}
	public void recordPurchase(int i, Product[] products){
		double iprice = products[i].getPrice();
		double total = purchase + iprice;
		purchase = total;
	}
	public void enterPayment(double amount){
		payment = amount;
	}
	public String checkPayment(){

		if (payment < purchase)
		{
			return "false";	
		}
		else
		{
			return "true";
		}
	}
	public void finalReceipt(){
			double change = payment - purchase;
			System.out.println("You gave "+ payment + " euro for a total purchase of "+ purchase + " euro. \nSo you get "+ change + " euro for change.");
			purchase = 0;
			payment = 0;
	}
	private double purchase;
	private double payment;
}