package enigmasrc;

class CirculatingNumber {

	private final int VALUE;
	static int maxValue = CodeTables.getLetters().length;


	private CirculatingNumber(int value) {
		value = checkValue(value);
		this.VALUE=(value);
	}
	private static int checkValue(int value){
		if(value<0) {
			value =(maxValue+(value%maxValue));
		}
		if(value ==maxValue) {
			value=0;
		}
		return (value%maxValue);
	}
	static  CirculatingNumber setNumber(int value) {
		return new CirculatingNumber(value);
	}
	int getValue() {
		return VALUE;
	}
	boolean isZero() {
		if(this.VALUE==0) {
			return true;
		}else {
			return false;
		}
	}
	CirculatingNumber plus1() {
		int value=(this.VALUE+1);
		return new CirculatingNumber(value);
	}
	CirculatingNumber addValue(CirculatingNumber n) {
		int value = (this.VALUE+n.VALUE);
		return new CirculatingNumber(value);
	}
	CirculatingNumber subtractValue(CirculatingNumber n) {
		int value = (this.VALUE-n.VALUE);
		return new CirculatingNumber(value);
	}
	boolean isEqual(CirculatingNumber n) {
		if(this.VALUE==n.VALUE) {
			return true;
		}
		return false;
	}
}