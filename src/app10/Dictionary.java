package app10;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Dictionary {
	private HashMap<String, String> map = new HashMap<>();
	
	public Dictionary(){

	}
	
	private void init(){

		map.put("Save", "Сохранить");
		map.put("Remove", "Удалить");
		map.put("Cancel", "Отмена");
		map.put("Create", "Создать");
		map.put("Ok", null);

	}

    public void read(String fileName){

        File file  = new File(fileName);
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            String[] arr;
            while((line = reader.readLine()) != null){

                arr = line.split(" => ");

                if(arr.length >= 2){
                    map.put(arr[0], arr[1]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	
	public String getTranslate(String s){
		return (map.get(s) == null) ? s : map.get(s);
	}
}