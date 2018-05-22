package fr.unilim.iut.spaceinvaders;

public class Vaisseau {

    int x;
    int y;
    
    Position origine;
    Dimension dimension;
    
    int longueur;
    int hauteur;

    public Vaisseau(int longueur, int hauteur, int x, int y) {
    	this.dimension = new Dimension(longueur, hauteur);
	   this.origine = new Position (x,y);
    }
    
    public Vaisseau(int longueur, int hauteur) {
		this(longueur, hauteur, 0, 0);
	}
    
    public void seDeplacerVersLaDroite() {
		this.origine.changerAbscisse(this.origine.abscisse()+1);
	}


	public void seDeplacerVersLaGauche() {
		this.origine.changerAbscisse(this.origine.abscisse()-1);
	}


	public void positionner(int x, int y) {
		this.origine.changerAbscisse(x);
		this.origine.changerOrdonnee(y);
	}

    public boolean occupeLaPosition(int x, int y) {
	     if (estAbscisseCouverte(x) && estOrdonneeCouverte(y))
	    	 return true;
		
	     return false;
    }

	private boolean estOrdonneeCouverte(int y) {
		return (ordonneeLaPlusBasse()<=y) && (y<=ordonneeLaPlusHaute());
	}

	private int ordonneeLaPlusHaute() {
		return this.y;
	}

	private int ordonneeLaPlusBasse() {
		return ordonneeLaPlusHaute()-this.hauteur+1;
	}

	private boolean estAbscisseCouverte(int x) {
		return (abscisseLaPlusAGauche()<=x) && (x<=abscisseLaPlusADroite());
	}

	public int abscisseLaPlusADroite() {
		return this.x+this.longueur-1;
	}

	public int abscisseLaPlusAGauche() {
		return this.x;
	}

}