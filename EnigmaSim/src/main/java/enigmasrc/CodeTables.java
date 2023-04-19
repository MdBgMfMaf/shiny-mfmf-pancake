package enigmasrc;

import java.util.HashMap;

/* EnigmaのCodeTable(暗号表）の管理クラス*/
public class CodeTables {

	static char[]letters ={'A','B','C','D','E','F','G','H','I','J',
			'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};


	static HashMap<Integer,Integer> setScramblerTable(int n) {		
		HashMap<Integer,Integer>map = new HashMap<>();
		map = getWiring(n);
		return map;
	}
	static HashMap<Integer,Integer> setScramblerReverseTable(int n) {
		HashMap<Integer,Integer>map = new HashMap<>();
		map =getReverseWiring(n);
		return map;
	}
	static HashMap<Integer,Integer>setReflectorTable(int n){
		HashMap<Integer,Integer>map = new HashMap<>();
		//リフレクター用配線
		map =getReflectorWiring(n);
		return map;
	}
	static HashMap<Integer,Integer>setUKWDTable(String str){
		String[]strs =str.split("/");
		str="JY";
		for(String s:strs) {
			str+=s;
		}
		char[]pairs = str.toCharArray();
		HashMap<Integer, Integer>map =new HashMap<>();
		int[]array =new int[pairs.length];

		for (int i = 0; i < pairs.length; i++) {
			array[i]=(convert(pairs[i]));			
		}

		for(int i=0;i<array.length;i++) {
			map.put(array[i], array[i+1]);
			map.put(array[i+1], array[i]);
			i++;
		}
		return map;
	}

	static HashMap<Integer, Integer> setPlugboardWiring(String str){
		String[]strs =str.split("/");
		str="";
		for(String s:strs) {
			str+=s;
		}
		char[]pairs = str.toCharArray();
		HashMap<Integer, Integer>map =new HashMap<>();
		int[]array =new int[pairs.length];

		for (int i = 0; i < pairs.length; i++) {
			array[i]=(convert(pairs[i]));			
		}

		for(int i=0;i<array.length;i++) {
			map.put(array[i], array[i+1]);
			map.put(array[i+1], array[i]);
			i++;
		}
		return map;
	}

	static int convert(char c) {
		int n =0;
		for (int i = 0; i < getLetters().length; i++) {
			if(getLetters()[i]== c) {
				n=i;
				break;
			}
		}
		return n;
	}
	static char convert(int n) {
		char c =getLetters()[n];
		return c;
	}

	static HashMap<Integer, Integer> getWiring(int n) {
		char[]array;
		array =getRoterWiring(n);
		int[]wiring =new int[CodeTables.getLetters().length];
		for (int i = 0; i <CodeTables.getLetters().length; i++) {
			for (int j = 0; j < array.length; j++) {
				if(array[i] == CodeTables.getLetters()[j]) {
					wiring[i]= j;
					break;
				}
			}
		}
		HashMap<Integer,Integer>map = new HashMap<>();
		for (int i = 0; i < wiring.length; i++) {
			map.put(i,wiring[i]);
		}
		return map;
	}

	static HashMap<Integer, Integer> getReverseWiring(int n){
		char[]array;
		array =getRoterWiring(n);
		int[]wiring =new int[CodeTables.getLetters().length];
		for (int i = 0; i < CodeTables.getLetters().length; i++) {
			for (int j = 0; j <array.length; j++) {
				if(CodeTables.getLetters()[i] ==array[j]) {
					wiring[i]= j;
					break;
				}
			}
		}
		HashMap<Integer,Integer>map = new HashMap<>();
		for (int i = 0; i < wiring.length; i++) {
			map.put(i,wiring[i]);
		}
		return map;
	}
	static HashMap<Integer, Integer> getReflectorWiring(int n) {
		char[]array;
		array=getUKWWiring(n);
		int[]wiring =new int[CodeTables.getLetters().length];
		for (int i = 0; i <CodeTables.getLetters().length; i++) {
			for (int j = 0; j < array.length; j++) {
				if(array[i] == CodeTables.getLetters()[j]) {
					wiring[i]= j;
					break;
				}
			}
		}
		HashMap<Integer,Integer>map = new HashMap<>();
		for (int i = 0; i < wiring.length; i++) {
			map.put(i,wiring[i]);
		}
		return map;
	}
	static int getNotch(int n) {
		int[]notches= {17,5,22,10,0,13,13,13};
		return notches[n];
	}

	//ローターの内部配線、アルファベットの列を得るためのメソッド
	static char[] getRoterWiring(int n) {
		//各ローターの内部配線はEnigma I型のローターI,II,III、および後に追加された 
		//IV,V、海軍限定のVI,VII,VIII、薄いローターβ,γを参照している。
		//https://en.wikipedia.org/wiki/Enigma_wireOfRotor_details#wireOfRotor_wireOfRotor_tables
		char[]wiring;
		switch(n) {
		//ローター用配線
		//I,II,III,IV,V.
		case 0:
			wiring = new char[]{'E','K','M','F','L','G','D','Q','V','Z','N',
					'T','O','W','Y','H','X','U','S','P','A','I','B','R','C','J',};
			break;
		case 1:
			wiring = new char[]{'A','J','D','K','S','I','R','U','X','B','L',
					'H','W','T','M','C','Q','G','Z','N','P','Y','F','V','O','E',};
			break;
		case 2:	
			wiring = new char[]{'B','D','F','H','J','L','C','P','R','T',
					'X','V','Z','N','Y','E','I','W','G','A','K','M','U','S','Q','O',};
			break;
		case 3:	
			wiring = new char[]{'E','S','O','V','P','Z','J','A','Y','Q','U',
					'I','R','H','X','L','N','F','T','G','K','D','C','M','W','B',};
			break;
		case 4:	
			wiring = new char[]{'V','Z','B','R','G','I','T','Y','U','P','S',
					'D','N','H','L','X','A','W','M','J','Q','O','F','E','C','K',};
			break;
			//VI,VII,VIII.
		case 5:
			wiring =new char[]{'J','P','G','V','O','U','M','F','Y','Q','B',
					'E','N','H','Z','R','D','K','A','S','X','L','I','C','T','W',};
			break;
		case 6:
			wiring =new char[]{'N','Z','J','H','G','R','C','X','M','Y','S',
					'W','B','O','U','F','A','I','V','L','P','E','K','Q','D','T',};
			break;
		case 7:
			wiring =new char[]{'N','Z','J','H','G','R','C','X','M','Y','S',
					'W','B','O','U','F','A','I','V','L','P','E','K','Q','D','T',};
			break;
			//ThinRotor β,γ.
		case 8:	
			wiring =new char[]{'L','E','Y','J','V','C','N','I','X','W','P','B','Q','M',
					'D','R','T','A','K','Z','G','F','U','H','O','S',};
			break;
		case 9:
			wiring =new char[]{'F','S','O','K','A','N','U','E','R','H','M','B','T','I',
					'Y','C','W','L','Q','P','Z','X','V','G','J','D',};
			break;
		default:
			System.out.println("ローター不正な入力");
			wiring = getLetters();
		}
		return wiring;
	}
	/*リフレクターの内部配線、アルファベットの列を得るためのメソッド
	UKW-A,B,C,D,UKW-B(Thin),UKW-C(Thin)を参照。*/
	static char[] getUKWWiring(int n) {
		char[]wiring;
		switch(n) {
		//A,B,C
		case 0:	
			wiring = new char[]{'E','J','M','Z','A','L','Y','X','V','B',
					'W','F','C','R','Q','U','O','N','T','S','P','I','K','H','G','D',};
			break;
		case 1:
			wiring = new char[]{'Y','R','U','H','Q','S','L','D','P','X',
					'N','G','O','K','M','I','E','B','F','Z','C','W','V','J','A','T',};
			break;
		case 2:
			wiring = new char[]{'F','V','P','J','I','A','O','Y','E','D'
					,'R','Z','X','W','G','C','T','K','U','Q','S','B','N','M','H','L',};
			break;
			//D(使用しない。参考用）
		case 3:
			wiring = new char[]{'A','-','Z','X','W','V','U','T','S',
					'R','Q','P','O','N','-','M','L','K','I','H','G','F','E','D','C','B',};
			break;
			//B(thin),C(thin)
		case 4:	
			wiring =new char[]{'E','N','K','Q','A','U','Y','W','J','I','C','O','P','B',
					'L','M','D','X','Z','V','F','T','H','R','G','S',};
			break;
		case 5:
			wiring =new char[]{'R','D','O','B','J','N','T','K','V','E','H','M','L','F',
					'C','W','Z','A','X','G','Y','I','P','S','U','Q',};
			break;
		default:
			return getLetters();
		}
		return wiring;
	}
	public static char[] getLetters() {
		return letters;
	}
	public static boolean checkIsIncompatible(char c) {
		for(int i=0;i<letters.length;i++) {
			if(c == letters[i]) {
				return false;
			}
		}
		return true;
		
	}
	
}