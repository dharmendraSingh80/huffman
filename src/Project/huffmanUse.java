package Project;

import java.util.Scanner;

public class huffmanUse {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		Huffman huffman= new Huffman(str);
		String encodedText = huffman.encode();
		System.out.println(encodedText);
		huffman.printCode();
		String originalText = huffman.decode(encodedText);
		System.out.println(originalText);

	}

}
