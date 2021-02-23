package Algorithme;

public class Liste {
	
	private boolean empty;
	private Tree head;
	private Liste remain;
	
	public Liste()
	{
		empty = true;
	}
	
	public Liste(Tree head, Liste remain)
	{
		this.head = head;
		this.remain = remain;
		empty = false;
	}
	
	public boolean empty() 
	{
		return empty;
	}
	
	public Tree head()
	{
		if(!empty)
		{
			return head;
		}
		else
		{
			throw new IndexOutOfBoundsException("Empty list");
		}
	}
	
	public Liste remain()
	{
		if(!empty)
		{
			return remain;
		}
		else
		{
			return new Liste();
		}
	}
	
	public Liste add(Tree e)
	{
		return new Liste(e, this);
	}
	
	//ajoute un arbe dans la liste de manière a ce que la liste soit triée par ordre croissant de frequences
	public Liste addSortInc(Tree e)
	{
		if(empty)
		{
			return this.add(e);
		}
		
		if(e.root().freq > head.root().freq)
		{
			remain = remain.addSortInc(e);
			return this;
		}
		
		return this.add(e);
	}
	
	@Override
	public String toString()
	{
		if(empty)
		{
			return "";
		}
		return this.head.root() + "\n" + this.remain.toString();
	}
}
