package enigmasrc;

import java.util.HashMap;

public class Reflector implements AbstractRotor{
	
	private HashMap<Integer, Integer>map;
	private String wiring;
	
	Reflector(int reflectorType) {
		this.map=CodeTables.setReflectorTable(reflectorType);
	}
	Reflector(String str){
		this.wiring=str;
		this.map=CodeTables.setUKWDTable(str);
	}
	@Override
	public CirculatingNumber goThrough(CirculatingNumber n) {
		int value=(this.map.get(n.getValue()));
		return CirculatingNumber.setNumber(value);
	}		
	@Override
	public void rotate() {
		
	}
	@Override
	public void setNextRotor(AbstractRotor abstractRotor) {
		
	}
	@Override
	public String getWiring() {
		return wiring;
	}
}

