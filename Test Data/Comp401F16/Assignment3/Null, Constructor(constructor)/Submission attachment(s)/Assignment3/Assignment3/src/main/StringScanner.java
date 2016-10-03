package main;

public class StringScanner implements ScanningPlan
{
	String typed;
	public void scanString(String s)
	{
		int location1=0;
		int location2;
		while(location1<s.length())
		{
			if(s.charAt(location1)!='"')
			{
				location2=indexOf(s,' ',location1);
				if(Character.isLetter(s.charAt(location1)))
				{
					WordInput aWordInput=new WordInput();
					aWordInput.setInput(s.substring(location1,location2));
					System.out.println(aWordInput);
					System.out.println(aWordInput.getInput());
					System.out.println(aWordInput.getLowercaseProperty());
				}
				else if(s.charAt(location1)=='{')
				{
					Input aStartInput=new StartInput();
					aStartInput.setInput(s.substring(location1,location2));
					System.out.println(aStartInput);
					System.out.println(aStartInput.getInput());
				}
				else if(s.charAt(location1)=='}')
				{
					Input anEndInput=new EndInput();
					anEndInput.setInput(s.substring(location1,location2));
					System.out.println(anEndInput);
					System.out.println(anEndInput.getInput());
				}
				else
				{
					NumberInput aNumberInput=new NumberInput();
					aNumberInput.setInput(s.substring(location1,location2));
					System.out.println(aNumberInput);
					System.out.println(aNumberInput.getInput());
					System.out.println(aNumberInput.getIntProperty());
				}
				location1=location1+(location2-location1)+1;
			}
			
			else
			{
				location2=indexOf(s,'"',location1+1);
				Input aQuoteInput=new QuoteInput();
				aQuoteInput.setInput(s.substring(location1+1,location2));
				System.out.println(aQuoteInput);
				System.out.println(aQuoteInput.getInput());
				location1=location1+(location2-location1)+2;
			}
		}
	}
	
	public String getScannedString()
	{
		return typed;
	}
	
	public void setScannedString(String s)
	{
		typed=s;
		scanString(typed);
	}
	
	public int indexOf(String s, char ch, int fromIndex)
	{
		for(int i=fromIndex; i<s.length(); i++)
			if(s.charAt(i)==ch)
				return i;		
		return -1;
	}
}
