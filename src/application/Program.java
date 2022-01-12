package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> products = new ArrayList<>();
		
		System.out.println("Enter a folder path:");
		String strPath = sc.nextLine();
		File path = new File(strPath);		
		
		try(BufferedReader br = new BufferedReader(new FileReader(strPath))){
			String line = br.readLine();
			while(line != null) {
				String[] data = line.split(",");
				String name = data[0];
				Double price = Double.parseDouble(data[1]);
				Integer quantity = Integer.parseInt(data[2]);
				Product product = new Product(name, price, quantity);
				products.add(product);
				line = br.readLine();
			}
			
			if(new File(path.getParent() + "\\out").mkdir()) {
				String outPath = path.getParent() + "\\out\\summary.csv";
				try(BufferedWriter bw = new BufferedWriter(new FileWriter(outPath))) {
					for(Product product : products) {
						bw.write(product.outputString());
						bw.newLine();
					}
				}catch(IOException e) {
					System.out.println("System error: " + e.getMessage());
				}
			}
		}catch(IOException e) {
			System.out.println("System error: " + e.getMessage());
		}
		
		sc.close();
	}

}
