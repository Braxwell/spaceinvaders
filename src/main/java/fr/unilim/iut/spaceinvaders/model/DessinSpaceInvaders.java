package fr.unilim.iut.spaceinvaders.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import fr.unilim.iut.spaceinvaders.moteurJeu.DessinJeu;

public class DessinSpaceInvaders implements DessinJeu {

	private SpaceInvaders jeu;

	public DessinSpaceInvaders(SpaceInvaders spaceInvaders) {
		this.jeu = spaceInvaders;
	}

	private void dessinerUnVaisseau(Vaisseau vaisseau, BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();

		crayon.setColor(Color.gray);
		crayon.fillRect(vaisseau.abscisseLaPlusAGauche(), vaisseau.ordonneeLaPlusBasse(), vaisseau.getDimension().longueur(), vaisseau.getDimension().hauteur());

	}
	
	private void dessinerUnMissile(Missile missile, BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		
		crayon.setColor(Color.red);
		crayon.fillRect(missile.abscisseLaPlusAGauche(), missile.ordonneeLaPlusBasse(), missile.getDimension().longueur(), missile.getDimension().hauteur());
	}
	
	private void dessinerUnEnvahisseur(Envahisseur envahisseur, BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		
		crayon.setColor(Color.black);
		crayon.fillRect(envahisseur.abscisseLaPlusAGauche(), envahisseur.ordonneeLaPlusBasse(), envahisseur.getDimension().longueur(), envahisseur.getDimension().hauteur());
	}

	@Override
	public void dessiner(BufferedImage image) {
		if (this.jeu.aUnVaisseau()) {
			Vaisseau vaisseau = this.jeu.recupererVaisseau();
			this.dessinerUnVaisseau(vaisseau, image);
		}
		
		if (this.jeu.aUnMissile()) {
			Missile missile = this.jeu.recupererMissile();
			this.dessinerUnMissile(missile, image);
		}
		
		if (this.jeu.aUnEnvahisseur()) {
			Envahisseur envahisseur = this.jeu.recupererEnvahisseur();
			this.dessinerUnEnvahisseur(envahisseur, image);
		}
	}

}
