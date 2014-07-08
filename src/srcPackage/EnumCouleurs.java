package srcPackage;

public enum EnumCouleurs
{
	NOIR("N"), BLANC("B");
	
	private String name = "";
	
	private EnumCouleurs(String name)
	{
		this.name = name;
	}
	
	public String toString()
	{
		return this.name;
	}
}
