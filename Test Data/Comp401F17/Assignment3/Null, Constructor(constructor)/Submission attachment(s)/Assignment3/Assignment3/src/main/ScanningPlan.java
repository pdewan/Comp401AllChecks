package main;

public interface ScanningPlan 
{
	public void scanString(String s);
	public String getScannedString();
	public void setScannedString(String s);
	public int indexOf(String s, char ch, int fromIndex);
}
