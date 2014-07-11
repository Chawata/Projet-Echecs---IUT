/**
 * Enumération servant à représenter les couleurs des pièces et des joueurs.
 * @author Ben Vittupier
 * @version 1.0
 */

package srcPackage;

public enum EnumCouleurs
{
	NOIR("N"), BLANC("B");
	
	private String name = "";
	
	private EnumCouleurs(String name)
	{
		this.name = name;
	}
	
	@Override
	public String toString()
	{
		return this.name;
	}
	
	public static EnumCouleurs getOpposite(EnumCouleurs couleur)
	{
		if (couleur == EnumCouleurs.BLANC)
		{
			return EnumCouleurs.NOIR;
		}
		else
		{
			return EnumCouleurs.BLANC;
		}
	}
}
