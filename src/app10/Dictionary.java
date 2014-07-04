package app10;

import java.util.HashMap;

public class Dictionary {
	private HashMap<String, String> map = new HashMap<>();
	
	public Dictionary(){
		this.init();
	}
	
	private void init(){
		map.put("Save", "");
		map.put("Remove", "");
		map.put("Cancel", "");
		map.put("Create", "�������");
		map.put("Ok", null);
	}
	
	public String getTranslate(String s){
		return (map.get(s) == null) ? s : map.get(s);
	}
}
