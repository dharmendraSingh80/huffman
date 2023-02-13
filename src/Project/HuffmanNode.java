package Project;


public class HuffmanNode {
	private int frequency;
	private char character;	
	HuffmanNode leftNode;
	HuffmanNode rightNode;
	
	
	public HuffmanNode(char character, Integer frequency) {
		this.character = character;
		this.frequency = frequency;			
	}
	public Integer getFrequency() {
		return frequency;
	}


	public Character getCharacter() {
		return character;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}


	public void setCharacter(char character) {
		this.character = character;
	}


	
}
