package enigmasrc;

class Rotor implements AbstractRotor{
	private int rotorType;
	private CirculatingNumber rotation;
	private CirculatingNumber ringSetting;
	private CirculatingNumber notch;
	private AbstractRotor nextRotor;
	private Scrambler scrambler;


	Rotor(){
	this(0,0,0);	
	}
	Rotor(int rotorType,int startPosition,int ringSetting) {
		this.rotorType=rotorType;
		scrambler = new Scrambler(rotorType);
		this.rotation=CirculatingNumber.setNumber(startPosition);
		this.ringSetting=CirculatingNumber.setNumber(ringSetting);
		rotation =rotation.subtractValue(this.ringSetting);
		this.notch=CirculatingNumber.setNumber(CodeTables.getNotch(rotorType));
	}
	
	@Override
	public CirculatingNumber goThrough(CirculatingNumber n){
			n =this.scrambler.scramble(n.addValue(rotation));
			n =this.nextRotor.goThrough(n.subtractValue(rotation));
			n= this.scrambler.reverseScramble(n.addValue(rotation));
			return (n.subtractValue(rotation));
	}
	
	@Override
	public void rotate() {
		this.rotation=rotation.plus1();
		CirculatingNumber n= (notch.subtractValue(ringSetting));
		if(rotation.isEqual(n)) {
			this.nextRotor.rotate();
		}
		if(4<this.rotorType&&rotation.isZero()) {
			this.nextRotor.rotate();
		}
	}	
	public void setNextRotor(AbstractRotor r) {
		this.nextRotor=r;
	}
	@Override
	public String getWiring() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	

}