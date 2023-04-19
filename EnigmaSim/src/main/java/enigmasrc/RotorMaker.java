package enigmasrc;

class RotorMaker {
	public static void main(String[] args) {
		String str="A-ZXWVUTSRQPON-MLKIHGFEDCB";
		char[]array =str.toCharArray();
		System.out.print("wiring =new char[]{");
		for (int i = 0; i < array.length; i++) {
			System.out.print("'"+array[i]+"',");
		}
		System.out.print("};");
	}

}