package application;

import java.io.*;

public class SerializeClient {
	
	public static void Serialize(Client n) {
		try {
			FileOutputStream saveFile = new FileOutputStream("clients.ser");
			ObjectOutputStream outputStream = new ObjectOutputStream(saveFile);
			outputStream.writeObject(n);
			
			// closing outputStream
			outputStream.close();
			
			// closing saveFile
			saveFile.close();
		
			System.out.println("Serialized data to: "+saveFile);
		
		}catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public static Client Deserialize() {
		Client toBeDeserialized = new Client(null,null,null,null);
		try {
			// Only save one object.
			FileInputStream loadFile = new FileInputStream("clients.ser");
			ObjectInputStream ois = new ObjectInputStream(loadFile);
			toBeDeserialized = (Client) ois.readObject();
			System.out.println("SerialzeClient class: Value read in = "+toBeDeserialized.toString());
			ois.close();
			loadFile.close();
			System.out.println("Deserialize return");
			return toBeDeserialized;
			
		} catch (IOException i) {
			i.printStackTrace();
			System.out.println("IOException");
			return toBeDeserialized;
			
		} catch (ClassNotFoundException q) {
			System.out.println("Client class not found!");
			q.printStackTrace();
			System.out.println("ClassNotFoundException return");
			return toBeDeserialized;
		}
//		mainClientList2.addClient(toBeDeserialized);
	}
}
