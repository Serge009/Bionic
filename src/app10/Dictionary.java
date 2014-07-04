package app10;

import java.util.HashMap;

public class Dictionary {
	private HashMap<String, String> map = new HashMap<>();
	
	public Dictionary(){
		this.init();
	}
	
	private void init(){
		map.put("Save", "Запомнить");
		map.put("Remove", "Удалить");
		map.put("Cancel", "Прервать");
		map.put("Create", "Создать");
		map.put("Ok", null);
	}
	
	public String getTranslate(String s){
		return (map.get(s) == null) ? s : map.get(s);
	}
}
