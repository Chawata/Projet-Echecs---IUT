package srcPackage;

public enum EnumCouleurs
{
	NOIR("noir"), BLANC("blanc");
	
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
