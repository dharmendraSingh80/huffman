package Project;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Huffman {
    
	private  HuffmanNode root = null;
	private  String str;
	private HashMap<Character, Integer> freqMap;
	private HashMap<Character, String> huffmanCodes;
	public Huffman(String str) {
		huffmanCodes = new HashMap<>();
		this.str = str;
	}
	
	public String encode() {
		freqMap = new HashMap<>();
		for(int i =0; i < str.length(); i++) {
			if(freqMap.containsKey(str.charAt(i))) {
				freqMap.put(str.charAt(i), freqMap.get(str.charAt(i)) + 1);
			}else {
				freqMap.put(str.charAt(i), 1);
			}
		}
		int n = freqMap.size();

		PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(n, new MyComparator());
		Set<Character> keys = freqMap.keySet();
		for(char key : keys) {
			HuffmanNode hn = new HuffmanNode(key, freqMap.get(key));
			hn.leftNode = null;
			hn.rightNode = null; 
			pq.add(hn);
		}	 
		
		while(pq.size() > 1) {
			HuffmanNode x = pq.poll();
			HuffmanNode y = pq.poll();
			Integer data = x.getFrequency() + y.getFrequency();
			HuffmanNode f = new HuffmanNode('-', data );
			f.leftNode = x;
			f.rightNode = y;
			root = f;
			pq.add(f);
		}
		generateHuffmanCodes(root, "");
		return getEncodedText();	
	}
	private void generateHuffmanCodes(HuffmanNode node, String code) {
		if (node.leftNode
				== null
				&& node.rightNode
				== null
				&& Character.isLetter(node.getCharacter())) {
			huffmanCodes.put(node.getCharacter(), code);
			return;
		}
		generateHuffmanCodes(node.leftNode, code.concat("0"));
		generateHuffmanCodes(node.rightNode, code.concat("1"));
	}

	private String getEncodedText() {
		StringBuilder sb = new StringBuilder();
		for(char character : str.toCharArray()) {
			sb.append(huffmanCodes.get(character));
		}
		return sb.toString();
	}
	
	public String decode(String encodedText) {
		StringBuilder sb = new StringBuilder();
		HuffmanNode current = root;
		for(char character : encodedText.toCharArray()) {
			current = character == '0'? current.leftNode : current.rightNode;
			if (current.leftNode
					== null
					&& current.rightNode
					== null
					&& Character.isLetter(current.getCharacter())) {
				sb.append(current.getCharacter());
				current = root;
			}
		}
		return sb.toString();
	}

	public void printCode(){
		huffmanCodes.forEach((character, code) ->
		    System.out.println(character + ": "+ code));
	}
}
