package enigmasrc;

import java.util.HashMap;

class Plugboard {
	private HashMap<Integer, Integer>map;
	private String currentWiring;
	private AbstractRotor nextRotor;
	
	Plugboard() {
		this("");
	}
	Plugboard(String str) {
		currentWiring=str;
		this.map =CodeTables.setPlugboardWiring(str);
	}

	CirculatingNumber goThrough(CirculatingNumber n) {
		this.nextRotor.rotate();
		n=this.nextRotor.goThrough(exchange(n));
		return exchange(n);
	}
	CirculatingNumber exchange(CirculatingNumber n) {
		int value =n.getValue();
		if(this.map.get(value)!=null) {
			value= this.map.get(value);
		}
		return CirculatingNumber.setNumber(value);
	}
	
	String getWiring() {
		return currentWiring;
	}
	void setNextRotor(AbstractRotor r) {
		this.nextRotor=r;
	}



}

