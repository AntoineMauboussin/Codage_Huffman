package Algorithme;

import java.io.IOException;
import java.util.ArrayList;

public class Main 
{
	
	public static void main(String[] args) throws IOException 
	{
		Liste l = Reader.readTab(args);
		
		//affiche les différents caractères et leurs fréquences triés selon leurs fréquences
		System.out.println(l);
		
		Tree th = Tree.Huffman(l);
		
		ArrayList<Character> chars = new ArrayList<Character>();
		ArrayList<String> codes = new ArrayList<String>();
		
		Tree.code(th, codes, chars, "");
		
		//affiche chaque caractère associé à son codage
		for(int i=0; i<chars.size(); i++)
		{
			System.out.println(chars.get(i));
			System.out.println(codes.get(i) + "\n");
		}
		
		String text = Reader.readText(args);
		String codedText = "";
		
		for(int i=0; i<text.length(); i++)
		{
			int index = 0;
			
			for(int j=0; text.charAt(i) != chars.get(j); j++)
			{
				index++;
			}
			
			codedText = codedText + codes.get(index);
		}
		
		System.out.println("Texte codé:");
		System.out.println(codedText + "\n");
		
		String decodedText = Tree.decode(th, th, codedText, 0);
		
		System.out.println("Texte décodé:");
		System.out.println(decodedText);
	}

}
