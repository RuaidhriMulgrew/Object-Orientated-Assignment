package application;

import java.util.ArrayList;

public class ClientCollection {
	ArrayList <Client> clientList = new ArrayList<Client>();
	
	// create arraylist of objects reference
	// ArrayList<MyObject> list = new ArrayList<MyObject>();
	
	
	// ClientCollection constructor
	public ClientCollection() {
		clientList = new ArrayList<Client>();
	}
	
	
	// adding a Client object to the clientList
	public void addClient(Client obj) {
		clientList.add(obj);
	}
	
	
	// removing Client at index 0.
	public void removeClient() {
		clientList.remove(0);
		
		// automatically removes first element from clientList.
	}
	
	// add a size()/length() method
	public int getSize() {
		int sizeOfClientList;
		sizeOfClientList = clientList.size();
		return sizeOfClientList;
	}
	
	public Client getClient(int index) {
		Client clientToGet = clientList.get(index);
		return clientToGet;
	}
	
	
	// printing clientList.
	public void showClients() {
		for(int i = 0; i <= clientList.size()-1; i++) {
			System.out.println(" " + clientList.get(i));
		}
	}
	
	
	// find and display a particular client
	public void findClientByID(String id) {
		/*	Since we don't need to return client going to change method to void return type
		 * 	and just print the client with id in method.
		 * */
		Client client;
		// creating variable for String param id
		String idWeAreLookingFor = id;
		
		// Looping through clientList
		for(int n = 0; n <= clientList.size()-1; n++) {
			Client testObj = clientList.get(n);
			System.out.println("What are we getting for testObj = "+testObj.toString());
			System.out.println("Current Id= " + testObj.getID());
			
			
			String testObj_getID = testObj.getID();
			int comparison = testObj_getID.compareToIgnoreCase(idWeAreLookingFor);
			System.out.println("int comparison: "+comparison);
			
			if(comparison == 0) {
				int testObjPosn = clientList.indexOf(testObj);
				
				// client = testObj;
				client = clientList.get(testObjPosn);
				
				// instead of returning type client, printing instead.
				System.out.println("Client with id: "+idWeAreLookingFor+" is: ");
				System.out.println(client.toString());
				break;
				
			}
			else {
				System.out.println("Id is not in list, client does not exist.");
				
			}
		}
	}
}
