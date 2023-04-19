package enigmasrc;

interface AbstractRotor {

	void rotate();
	
	CirculatingNumber goThrough(CirculatingNumber n);

	void setNextRotor(AbstractRotor abstractRotor);
	
	String getWiring();
}
