
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * This program demonstrates how to read char
 * 
 * as
 * dfkhbacters from a text file using
 * a specified charset.
 * @author www.codejava.net
 *
 */
public class ReadTextFile {

	public static void printFile(String path){
		try {
			FileReader reader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;

			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static HashMap<String, ArrayList<Integer>>  readFileAndGiveMap(){
		HashMap<String, ArrayList<Integer>> map = new HashMap<>();
		try {
			String path = "C:\\Users\\Meha Verma\\Desktop\\New folder (5)\\materials\\ps2\\data\\processed\\train-files.txt";

			FileReader reader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;

			while ((line = bufferedReader.readLine()) != null) {

				String[] splitLine = line.split("/");
				String key = splitLine[0];
				int len = splitLine[1].length()-1;
				String value = splitLine[1].substring(0,len);
				int valueInt = Integer.parseInt(value);

				if(!map.containsKey(key)){
					ArrayList<Integer> docList = new ArrayList<>();
					docList.add(valueInt);
					map.put(key,docList);
				}else{
					ArrayList<Integer> list = map.get(key);
					list.add(valueInt);
					map.put(key,list);
				}

			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;

	}

	public static HashMap<String,Integer> countFrequency(String path){

		HashMap<String,Integer>  map = new HashMap<String,Integer>();
		try {
			FileReader reader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;

			while ((line = bufferedReader.readLine()) != null) {
				// System.out.println(line);

				String[] splitLine = line.split("\\s+");
				String key = splitLine[0];

				int value = Integer.parseInt(splitLine[1]);

				map.put(key, value);

			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;

	}
	
	public static void writeOutputFile(){
		
		try {
			
			
			String path = "C:\\Users\\Meha Verma\\Desktop\\New folder (5)\\materials\\ps2\\data\\processed\\vocabulary.txt";

			final String FILENAME = "C:\\Users\\Meha Verma\\Desktop\\New folder (5)\\output.txt";
			
			HashMap<String,Integer> content = countFrequency(path);
			
			
			FileWriter fw = new FileWriter(FILENAME);
			BufferedWriter bw = new BufferedWriter(fw);
			
			Set<String> keySet = content.keySet();

			//System.out.println(content.size());
			int i = 0;
			for(String s : keySet){
				i++;
				String value = "key: " + s + " Value: " + content.get(s) + "\n";
				//System.out.println("==============");
				bw.write(value);
			}
			System.out.println(i);
			
			bw.close();
			
			

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} 
		  

	}

	public static void main(String[] args) {

		String path = "C:\\Users\\Meha Verma\\Desktop\\New folder (5)\\materials\\ps2\\data\\processed\\vocabulary.txt";
		//printFile(path);
		HashMap<String, Integer> hMap = countFrequency(path);  
		Set<String> keySet = hMap.keySet();
		//System.out.println("key is: " + hMap.keySet());
		//writeOutputFile();
		//System.out.println(hMap.size());
		for(String s : keySet){
			//System.out.println("key is: " + s + " Value is: " + hMap.get(s));
		}

		HashMap<String, ArrayList<Integer>> map = readFileAndGiveMap();
			
	}
}