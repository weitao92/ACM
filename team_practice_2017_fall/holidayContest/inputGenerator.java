package holidayContest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class inputGenerator {
	
	public static void main(String args[]) throws IOException
	{
		File text = new File("in.txt");
		FileWriter writer = new FileWriter(text);
		writer.write("5000 5000\n");
		
			for(int i = 0; i < 9999; i++)
			{
				
				writer.write("1 100\n");

			}
			writer.write("1000 99");
		writer.close();
	}

}
