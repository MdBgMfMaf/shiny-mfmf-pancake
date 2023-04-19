package enigmasrc;

import java.util.HashMap;

public class Scrambler {
	private HashMap<Integer, Integer>map;
	private HashMap<Integer, Integer>reverseMap;

	Scrambler(int n){
		map =CodeTables.setScramblerTable(n);
		reverseMap=CodeTables.setScramblerReverseTable(n);
	}

	CirculatingNumber scramble(CirculatingNumber n) {
		int value=this.map.get(n.getValue());
		return (CirculatingNumber.setNumber(value));
	}
	CirculatingNumber reverseScramble(CirculatingNumber n) {
		int value=this.reverseMap.get(n.getValue());
		return (CirculatingNumber.setNumber(value));
	}
}

