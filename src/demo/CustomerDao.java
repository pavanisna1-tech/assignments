package demo;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class CustomerDao {

    HashSet<Customer> customerList = new HashSet<>();

    Scanner scanner = new Scanner(System.in);
    Customer customer = new Customer();
    
    String accountNo;
    String name;

    public void start() {

        int yourno;

        do {

            System.out.println("\nWelcome to BANK Management System");
            System.out.println("Select Following options");

            System.out.println("1 for Add Customer");
            System.out.println("2 for Update Customer");
            System.out.println("3 for Delete Customer");
            System.out.println("4 for Get Customer");
            System.out.println("5 for Get All Customers");
            System.out.println("6 for Customer Balance");
            System.out.println("7 for Exit");

            yourno = scanner.nextInt();

            switch (yourno) {

                case 1:
                    addCustomer();
                    break;

                case 2:
                	 System.out.println("Enter account number to update");
             	     accountNo = scanner.next();

             	    updateCustomer(accountNo);
             	    break;

                case 3:
                	 System.out.println("Enter account number");
                	     accountNo = scanner.next();

                	    deleteCustomer(accountNo);
                	    break;

                case 4:
                  
                    System.out.println("Enter customer name");
           	            name = scanner.next();

           	         getCustomer(name);
                    break;

                case 5:
                    getAllCustomers();
                    break;

                case 6:
                	System.out.println("Enter customer name");
       	            name = scanner.next();
       	            System.out.println("Enter Account No ");
    	            accountNo = scanner.next();
                    customerBalance(name, accountNo);
                    break;

                case 7:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid option");
            }

        } while (yourno != 7);
    }


public void addCustomer() {

    Customer customer = new Customer();

    System.out.println("Enter name");
    String name = scanner.next();

    customer.setCustomerName(name);

    System.out.println("Enter phone number");
    String phone = scanner.next();

    customer.setCustomerPhoneNo(phone);

    System.out.println("Enter account number");
    String accountNo = scanner.next();

    customer.setCustomerAccountNo(accountNo);

    System.out.println("Enter address");
    scanner.nextLine(); // Consume leftover newline
    String address = scanner.nextLine();

    customer.setCustomerAddress(address);

    System.out.println("Enter email");
    String email = scanner.next();

    customer.setCustomerEmail(email);

    System.out.println("Enter initial deposit");
    double balance = scanner.nextDouble();

    customer.setTotalBalance(
        java.math.BigDecimal.valueOf(balance)
    );

    customerList.add(customer);

    System.out.println("Customer added successfully!");
}
public void getAllCustomers() {

    for (Customer c : customerList) {

        System.out.println("Name: " + c.getCustomerName());
        System.out.println("Phone: " + c.getCustomerPhoneNo());
        System.out.println("Account: " + c.getCustomerAccountNo());
        System.out.println("Address: " + c.getCustomerAddress());
        System.out.println("Email: " + c.getCustomerEmail());
        System.out.println("Balance: " + c.getTotalBalance());

        System.out.println("----------------------");
    }
}



public void getCustomer(String name) {

    for (Customer c : customerList) {
    	
    	if(c.getCustomerName().equalsIgnoreCase(name)){
    		 System.out.println("Name: " + c.getCustomerName());
    	        System.out.println("Phone: " + c.getCustomerPhoneNo());
    	        System.out.println("Account: " + c.getCustomerAccountNo());
    	        System.out.println("Address: " + c.getCustomerAddress());
    	        System.out.println("Email: " + c.getCustomerEmail());
    	        System.out.println("Balance: " + c.getTotalBalance());
    	        
    	        System.out.println("customer details retrieved successfully");

    	}
    	else{
    		System.out.println("not found");
    	}
    }
}

public void deleteCustomer(String accountNo) {
    Iterator<Customer> iterator = customerList.iterator();

    while (iterator.hasNext()) {
        Customer c = iterator.next();

        if (c.getCustomerAccountNo().equals(accountNo)) {
            iterator.remove();

            System.out.println("Customer successfully removed");
            return;
        }
    }

    System.out.println("Customer not found");
}


public void updateCustomer(String accountNo) {
	for(Customer c : customerList) {
	
	     if(c.getCustomerAccountNo().equals(accountNo)) {
	    	
	    	 
	    	 Customer customer = new Customer();
	    	 scanner.nextLine();
	    	 System.out.println("Enter new name:");
	            String name = scanner.nextLine();
	            c.setCustomerName(name);

	            System.out.println("Enter new phone number:");
	            String phone = scanner.nextLine();
	            c.setCustomerPhoneNo(phone);

	            System.out.println("Enter new address:");
	            String address = scanner.nextLine();
	            c.setCustomerAddress(address);
	            System.out.println("customer updated sussccfu.ly ");
	     }
	}
	System.out.println("custoenr not found");
}


public void customerBalance(String name, String accountNo) {
	
	for(Customer c : customerList) {
		
		if(c.getCustomerName().equalsIgnoreCase(name) && c.getCustomerAccountNo().equalsIgnoreCase(accountNo) ) {
			System.out.println("Your balance is : "+c.getTotalBalance());
		}
		else {
			System.out.println("custoenr not found");
		}
		}
		
	}
	
}


