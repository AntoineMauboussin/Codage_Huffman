package Algorithme;

import java.io.IOException;

public class Reader {
	
	public static Tree handleLine(String l)
	{
		Couple c = new Couple();
		
		switch(l.charAt(0))
		{
		case('"'):
			c.ch = l.charAt(1);
			c.freq = Integer.parseInt(l.substring(4));
		break;
		case(','):
			c.ch = ' ';
			c.freq = Integer.parseInt(l.substring(1));
		break;
		default:
			c.ch = l.charAt(0);
			c.freq = Integer.parseInt(l.substring(2));
		}
		
		return new Tree(c);
	}

	//convertit le fichier texte en premier argument décrivant les fréquence de caractères en liste d'arbres réduits à leur racine
	public static Liste readTab(String[] arg) throws IOException
	{
		
	java.util.Scanner reader ;
	
	java.io.File fichier = new java.io.File(arg[0]);
	reader = new java.util.Scanner(fichier);
	
	Liste l = new Liste();
	
	while(reader.hasNextLine())
	{
		l = l.addSortInc(handleLine(reader.nextLine()));
	}
	
	reader.close();
	
	return l;
    }
	
	//convertit le fichier texte indiqué en second argument contenant le texte à coder en String
	public static String readText(String[] arg) throws IOException
	{
		
	java.util.Scanner reader ;
	
	java.io.File fichier = new java.io.File(arg[1]);
	reader = new java.util.Scanner(fichier);
	
	String ret = "";;
	
	while(reader.hasNextLine())
	{
		ret = ret + reader.nextLine();
	}
	
	reader.close();
	
	return ret;
    }
}
