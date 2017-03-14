
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
import java.util.DoubleSummaryStatistics;
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

	public static HashMap<Integer,Integer>  calculateClassVocab(){
		int totalVocab = 0;
		HashMap<Integer,Integer> bigMap = new HashMap<>();

		String path1 = "C:\\Users\\Meha Verma\\Desktop\\New folder (5)\\materials\\ps2\\data\\processed\\articles.train.txt";
		int articlesVocab = calculateClassVocabHelper(path1,totalVocab);
		bigMap.put(1,articlesVocab);
		totalVocab = 0;

		String path2 = "C:\\Users\\Meha Verma\\Desktop\\New folder (5)\\materials\\ps2\\data\\processed\\corporate.train.txt";
		int corporateVocab = calculateClassVocabHelper(path2,totalVocab);
		bigMap.put(2,corporateVocab);
		totalVocab = 0;

		String path3 = "C:\\Users\\Meha Verma\\Desktop\\New folder (5)\\materials\\ps2\\data\\processed\\enron_t_s.train.txt";
		int enron_t_sVocab = calculateClassVocabHelper(path3,totalVocab);
		bigMap.put(3,enron_t_sVocab);
		totalVocab = 0;

		String path4 = "C:\\Users\\Meha Verma\\Desktop\\New folder (5)\\materials\\ps2\\data\\processed\\enron_travel_club.train.txt";
		int enron_travel_club = calculateClassVocabHelper(path4,totalVocab);
		bigMap.put(4,enron_travel_club);
		totalVocab = 0;

		String path5 = "C:\\Users\\Meha Verma\\Desktop\\New folder (5)\\materials\\ps2\\data\\processed\\hea_nesa.train.txt";
		int hea_nesa = calculateClassVocabHelper(path5,totalVocab);
		bigMap.put(5,hea_nesa);
		totalVocab = 0;

		String path6 = "C:\\Users\\Meha Verma\\Desktop\\New folder (5)\\materials\\ps2\\data\\processed\\personal.train.txt";
		int personal = calculateClassVocabHelper(path6,totalVocab);
		bigMap.put(6,personal);
		totalVocab = 0;

		String path7 = "C:\\Users\\Meha Verma\\Desktop\\New folder (5)\\materials\\ps2\\data\\processed\\systems.train.txt";
		int systems = calculateClassVocabHelper(path7,totalVocab);
		bigMap.put(7,systems);
		totalVocab = 0;

		String path8 = "C:\\Users\\Meha Verma\\Desktop\\New folder (5)\\materials\\ps2\\data\\processed\\tw_commercial_group.train.txt";
		int tw_commercial_group = calculateClassVocabHelper(path7,totalVocab);
		bigMap.put(8,tw_commercial_group);
		totalVocab = 0;

		return bigMap;
	}

	public static int calculateClassVocabHelper(String path, int totalVocab){


		try {
			HashMap<String,Integer> vocabMap = new HashMap<>();
			FileReader reader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			while ((line = bufferedReader.readLine())!=null){
				String[] splitLine = line.split(" ");
				String key = splitLine[0];
				String value = splitLine[1];
				int valueInt = Integer.parseInt(value);
				vocabMap.put(key,valueInt);
			}
			Set<String> keySet = vocabMap.keySet();
			for(String s : keySet){
				totalVocab = totalVocab + vocabMap.get(s);
			}
		} catch (IOException e){
			e.printStackTrace();
		}

		return totalVocab;
	}




	public static int calculateVocab(){
		int totalVocab = 0;
		try {
			String path = "C:\\Users\\Meha Verma\\Desktop\\New folder (5)\\materials\\ps2\\data\\processed\\vocabulary.txt";
			HashMap<String,Integer> vocabMap = new HashMap<>();

			FileReader reader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;

			while ((line = bufferedReader.readLine())!=null){
				String[] splitLine = line.split(" ");
				String key = splitLine[0];
				String value = splitLine[1];
				int valueInt = Integer.parseInt(value);
				vocabMap.put(key,valueInt);
			}
			Set<String> keySet = vocabMap.keySet();
			for(String s : keySet){
				totalVocab++;
			}
		} catch (IOException e){
			e.printStackTrace();
		}

		return totalVocab;
	}





	public static HashMap<String,Double> priorProbabilities(HashMap<String,ArrayList<Integer>> map){

		HashMap<String,Double> prob = new HashMap<>();
		Set<String> keySet = map.keySet();
		double totalNumDoc = 0;

		for(String classLabel : keySet){
			double value = map.get(classLabel).size();
			totalNumDoc = totalNumDoc + value;
		}

		for(String classLabel : keySet){
			double probability = (map.get(classLabel).size())/totalNumDoc;
			prob.put(classLabel,probability);
		}

		return prob;
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
		calculateClassVocab();
		int vocabulary = calculateVocab();

		HashMap<String, ArrayList<Integer>> map = readFileAndGiveMap();

		HashMap<String, Double> map2 = priorProbabilities(map);
			
	}
}