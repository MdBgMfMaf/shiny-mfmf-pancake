package enigmasrc;

class ThinRotor implements AbstractRotor{
	private CirculatingNumber rotation;
	private CirculatingNumber ringSetting;;
	private Scrambler scrambler;
	private AbstractRotor nextRotor;

	ThinRotor(int rotorType,int startPosition,int ringSetting) {
		this.scrambler = new Scrambler(rotorType+8);
		this.rotation=CirculatingNumber.setNumber(startPosition);
		this.ringSetting=CirculatingNumber.setNumber(ringSetting);
		rotation =rotation.subtractValue(this.ringSetting);
	}
	@Override
	public void rotate() {
	}
	@Override
	public CirculatingNumber goThrough(CirculatingNumber n) {
		n =this.scrambler.scramble(n.addValue(rotation));
		n =this.nextRotor.goThrough(n.subtractValue(rotation));
		n= this.scrambler.reverseScramble(n.addValue(rotation));
		return (n.subtractValue(rotation));
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
