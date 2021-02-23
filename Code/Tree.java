package Algorithme;

import java.util.ArrayList;

public class Tree {

	private boolean empty;
	private Couple root;
	private Tree ls;
	private Tree rs;
	
	public Tree()
	{
		this.empty = true;
	}
	
	public Tree(Couple root)
	{
		this.root = root;
		this.ls = new Tree();
		this.rs = new Tree();
	}
	
	public Tree(Couple root, Tree ls, Tree rs)
	{
		this.root = root;
		this.ls = ls;
		this.rs = rs;
	}
	
	public boolean empty()
	{
		return empty;
	}
	
	public Couple root()
	{
		if(!empty)
		{
			return root;
		}
		else
		{
			throw new IndexOutOfBoundsException("Empty tree");
		}
	}
	
	public Tree ls()
	{
		if(!empty)
		{
			return ls;
		}
		else
		{
			return new Tree();
		}
	}
	
	public Tree rs()
	{
		if(!empty)
		{
			return rs;
		}
		else
		{
			return new Tree();
		}
	}
	
	public void replaceL(Tree t)
	{
		if(!empty)
		{
			ls = t;
		}
		else
		{
			throw new IndexOutOfBoundsException("Empty tree");
		}
	}
	
	public void replaceR(Tree t)
	{
		if(!empty)
		{
			rs = t;
		}
		else
		{
			throw new IndexOutOfBoundsException("Empty tree");
		}
	}
	
	@Override
	public String toString()
	{
		if(!empty)
		{
			return ls.toString() + " -- " + root.toString() + " -- " + rs.toString();
		}
		return "O";
	}
	

	//transforme une liste d'arbres triés en arbre de huffman
	public static Tree Huffman(Liste l)
	{
		if(!l.remain().empty())
		{
			Tree t = new Tree(new Couple(), l.head(), l.remain().head());
			t.root().freq = t.ls().root().freq + t.rs().root().freq;
			Liste ret = l.remain().remain().addSortInc(t);
			
			return Huffman(ret);
		}
		
		return(l.head());
	}
	
	//place les différents caractères et leurs codages respectifs dans les ArrayList chars et codes a partir d'un arbre de huffman
	public static void code(Tree t, ArrayList<String> codes, ArrayList<Character> chars, String code)
	{
		if(t.ls().empty() && t.rs().empty())
		{
			codes.add(code);
			chars.add(t.root().ch);
		}
		else
		{
			code(t.ls(), codes, chars, code + "0"); 
			code(t.rs(), codes, chars, code + "1");
		}
	}
	
	//décode la chaine codée en utlisant l'arbre de Huffman
	public static String decode(Tree t, Tree temp, String s, int index)
	{
		
		if(temp.ls().empty() && temp.rs().empty())
		{
			if(index == s.length())
			{
				return temp.root().ch + "";
			}
			return temp.root().ch + decode(t, t, s, index);
		}
		else if(s.charAt(index) == '0')
		{
			return decode(t, temp.ls(), s, index+1);
		}
		else
		{
			return decode(t, temp.rs(), s, index+1);
		}
	}
}
