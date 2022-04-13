package simcity;


import java.io.*;
import java.nio.charset.StandardCharsets;

public class Plateau {
	//on déclare notre tableau avec colonne et ligne comme attribut statique
	static private int colonne=12;
	static private int ligne=12;
	private Case tableau[][];

	/****
	 * sauvegarde :
	 *
	 * méthode que nous appelons afin de sauvegarder la partie actuel dans un fichier "sauvegarde.txt"
	 *
	 */


	public void sauvegarde(){
		File sauv = new File("C:\\Users\\Public\\Documents\\sauvegarde.txt");
		if(!sauv.exists()){			//on verifie si le fichier existe ou pas
			try{
				sauv.createNewFile();	//si il n'existe pas on tente de le créer
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		try{									//on essaye de lire le fichier
			FileWriter writer = new FileWriter(sauv);
			BufferedWriter bw = new BufferedWriter(writer);	//on céer un buffer pour écrire dans le fichier


			bw.write(Ville.argent +" " + Ville.Bois + " "+Ville.fer + " ");		// on commence par écrire toutes les infos des recources de l'utilisateur


			bw.newLine();	// on reviens à la ligne
			
			int natureConstruction = 0;
			
			for(int i=0 ; i<colonne ; i++){				// nous allons parcourir l'entiereté du plateau
				for(int y=0 ; y<ligne ; y++){
					if(tableau[i][y].getMaConstruction()!=null){
						

						switch (tableau[i][y].getMaConstruction().getClass().getTypeName()) {		// suivant la construction nous allons mettre un code pour la reconnaitre

						case "simcity.Route":
							natureConstruction = 1;
							break;
							
						case "simcity.PetiteMaison":
							natureConstruction = 10;
							break;
							
						case "simcity.GrandeMaison":
							natureConstruction = 11;

							break;
						case "simcity.Appartement":
							natureConstruction = 12;
							break;
							
						case "simcity.Immeuble":
							natureConstruction = 13;
							break;
							
						case "simcity.ChateauEau":
							natureConstruction = 20;
							break;
							
						case "simcity.PompeEau":
							natureConstruction = 21;
							break;
							
						case "simcity.Eolienne":
							natureConstruction = 30;
							break;
							
						case "simcity.PanneauSolaire":
							natureConstruction = 31;
							break;
							
						case "simcity.Nucleaire":
							natureConstruction = 32;
							break;

						case "simcity.UsineBois":
							natureConstruction = 40;
							break;
							
						case "simcity.ExtracteurFer":
							natureConstruction = 41;
							break;
							
						case "simcity.Mairie":
							natureConstruction = 50;
							break;

						case "simcity.Transport":
							natureConstruction = 51;
							break;

						case "simcity.Ecole":
							natureConstruction = 52;
							break;
							
						case "simcity.Bibliotheque":
							natureConstruction = 53;
							break;
							
						case "simcity.TerrainBasket":
							natureConstruction = 54;
							break;

						case "simcity.TerrainFoot":
							natureConstruction = 56;
							break;
							
						case "simcity.StockageFer" :												//pour le stockage il a un code qui prend en compte le niveau actuel du stockage
							switch (((Stockage)tableau[i][y].getMaConstruction()).getLevel()){

								case 1 :
									natureConstruction = 601;

									break;

								case 2:
									natureConstruction = 602;

									break;

								case 3 :
									natureConstruction = 603;

									break;
								case 4 :
									natureConstruction = 604;

									break;
								default:

									break;


							}
							break;
							
						case "simcity.StockageBois":

							switch (((Stockage)tableau[i][y].getMaConstruction()).getLevel()){

								case 1 :
									natureConstruction = 611;

									break;

								case 2:
									natureConstruction = 612;

									break;

								case 3 :
									natureConstruction = 613;

									break;
								case 4 :
									natureConstruction = 614;

									break;

								default:

									break;


							}
							break;
						default:
							natureConstruction = 1;

							break;
					}
									//on écrit toutes les infos sur la case ( l'id de la construction + eau + les mines + la pollution + l'ensoleillement + le vent )
						bw.write(
										natureConstruction + " " +
										tableau[i][y].getEau() + " " + tableau[i][y].getMine() + " " +
										tableau[i][y].getPollution() + " " + tableau[i][y].getSoleil() +
										" " + tableau[i][y].getVent() + " ");

						bw.newLine();
					}else{
						// si il n'y a pas de batiment le code 0 est par défault
						bw.write(
											"0"+ " " +
								tableau[i][y].getEau() + " " + tableau[i][y].getMine() + " " +
								tableau[i][y].getPollution() + " " + tableau[i][y].getSoleil() +
								" " + tableau[i][y].getVent() + " ");
						bw.newLine();
					}

				}
			}


			System.out.println("ecriture dans le fichier réussi");
			bw.newLine();
			bw.close();
			writer.close();		// on ferme tous
		}catch(IOException e){
			e.printStackTrace();
		}
	}


	/****
	 * Constructeur de plateau
	 *
	 * @param isAlreadySaved ( permetant de savoir si il charge une partit déja existante ou non )
	 */
	public Plateau(boolean isAlreadySaved){
		this.tableau=new Case[colonne][ligne];	// on remplit le tableau avec des cases
		for (int i = 0;i < colonne; i++) {
			for (int j = 0;j < ligne; j++) {
				tableau[j][i]= new Case();
			}
		}
		if(!isAlreadySaved) {				// si il en céer une nouvelle on lui donne certain batiment d'office
			
			 this.tableau[5][0].SetMaConstruction(new Route());
			 this.tableau[5][1].SetMaConstruction(new Route());
			 this.tableau[5][2].SetMaConstruction(new Route());
			 this.tableau[5][3].SetMaConstruction(new Route());
			 this.tableau[4][1].SetMaConstruction(new Mairie());
			 this.tableau[6][0].SetMaConstruction(new StockageBois());
			 this.tableau[6][1].SetMaConstruction(new StockageFer());
			 
		}else {
			
		File sauv = new File("C:\\Users\\Public\\Documents\\sauvegarde.txt");			//sinon on charge le fichier de sauvegarde présent dans le répertoire src/simcity/
		if(sauv.exists()){
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sauv), StandardCharsets.UTF_8));	//on céer un buffer pour lire dans le fichier
				int c=0;
				String a = new String();
				int i=0;
				int x=0,y=0;
				int argent=0;
				int bois=0;
				int fer=0;
				while((c = reader.read()) != '\n'){				// dans ce premier while on va récupérer les infos à propos des ressources de l'utilisateur
					char ch = (char) c;
					if (ch != ' ') {
						if(ch!='\r') {
							a = a + ch;	//on recupere caractère par caractère
						}


					}else{
						System.out.println(Integer.parseInt(a));
						switch (i) {
							case 0 :
								argent = Integer.parseInt(a);

								break;
							case 1 :
								bois = Integer.parseInt(a);
								break;
							case 2 :
								fer = Integer.parseInt(a);
								break;

						}
						a="";
						i++;
					}

				}

				x=0;
				i=0;
				while((c = reader.read()) != -1)	// puis tant que nous sommes pas à la fin du fichier
				{
					char ch = (char) c;
					if(ch!='\n') {					//tant que nous arrivons pas à la fin de la ligne
						if (ch != ' ') {			//si on a un espace on continu le mot
							if(ch!='\r') {
								a = a + ch;
							}
							//System.out.println("lettre" + a);

						} else {					//sinon on applique l'info lu
							switch (i) {			// le i permet de se repérer dans le fichier et de savoir quelle info on est en train de lire
								case 0:
									switch (a) {

										case "1":
											this.tableau[x][y].SetMaConstruction(new Route());

											break;
										case "10":
											this.tableau[x][y].SetMaConstruction(new PetiteMaison());

											break;
										case "11":
										this.tableau[x][y].SetMaConstruction(new GrandeMaison());

										break;
										case "12":
											this.tableau[x][y].SetMaConstruction(new Appartement());

											break;
										case "13":
											this.tableau[x][y].SetMaConstruction(new Immeuble());

											break;
										case "20":
											this.tableau[x][y].SetMaConstruction(new ChateauEau());

											break;
										case "21":
											this.tableau[x][y].SetMaConstruction(new PompeEau());

											break;
										case "30":
											this.tableau[x][y].SetMaConstruction(new Eolienne());

											break;
										case "31":
											this.tableau[x][y].SetMaConstruction(new PanneauSolaire());

											break;
										case "32":
											this.tableau[x][y].SetMaConstruction(new Nucleaire());

											break;

										case "40":
											this.tableau[x][y].SetMaConstruction(new UsineBois());

											break;
										case "41":
											this.tableau[x][y].SetMaConstruction(new ExtracteurFer());

											break;
										case "50":
											this.tableau[x][y].SetMaConstruction(new Mairie());

											break;
										case "51":
											this.tableau[x][y].SetMaConstruction(new Transport());

											break;
										case "52":
											this.tableau[x][y].SetMaConstruction(new Ecole());

											break;
										case "53":
											this.tableau[x][y].SetMaConstruction(new Bibliotheque());

											break;
										case "54":
											this.tableau[x][y].SetMaConstruction(new TerrainBasket());

											break;
										case "55":
										//	this.tableau[x][y].SetMaConstruction(new Par());

											break;
										case "56":
											this.tableau[x][y].SetMaConstruction(new TerrainFoot());

											break;
										case "601":
											this.tableau[x][y].SetMaConstruction(new StockageFer());

											break;
										case "602":
											this.tableau[x][y].SetMaConstruction(new StockageFer());

												((StockageFer)this.tableau[x][y].getMaConstruction()).upgrade();


											break;
										case "603":
											this.tableau[x][y].SetMaConstruction(new StockageFer());
											for(int nb =0;nb<2;nb++){
												((StockageFer)this.tableau[x][y].getMaConstruction()).upgrade();

											}
											break;
										case "604":
											this.tableau[x][y].SetMaConstruction(new StockageFer());
											for(int nb =0;nb<3;nb++){
												((StockageFer)this.tableau[x][y].getMaConstruction()).upgrade();

											}
											break;
										case "611":
											this.tableau[x][y].SetMaConstruction(new StockageBois());

											break;
										case "612":
											this.tableau[x][y].SetMaConstruction(new StockageBois());
											((StockageBois)this.tableau[x][y].getMaConstruction()).upgrade();

											break;
										case "613":
											this.tableau[x][y].SetMaConstruction(new StockageBois());
											for(int nb =0;nb<2;nb++){
												((StockageBois)this.tableau[x][y].getMaConstruction()).upgrade();

											}
											break;
										case "614":
											this.tableau[x][y].SetMaConstruction(new StockageBois());
											for(int nb =0;nb<3;nb++){
												((StockageBois)this.tableau[x][y].getMaConstruction()).upgrade();

											}
											break;
										default:

											break;
									}
									break;
								case 1:
									if (a.contains("true")){
										this.tableau[x][y].setEau(true);
									} else {
										this.tableau[x][y].setEau(false);
									}

									break;
								case 2:
									if (a.contains("true")){
										this.tableau[x][y].setMine(true);
									} else {
										this.tableau[x][y].setMine(false);
									}

									break;
								case 3:
									if (a.contains("true")){
										this.tableau[x][y].setPollution(true);
									} else {
										this.tableau[x][y].setPollution(false);
									}

									break;
								case 4:
									if (a.contains("true")){
										this.tableau[x][y].setSoleil(true);
									} else {
										this.tableau[x][y].setSoleil(false);
									}

									break;
								case 5:
									if (a.contains("true")){
										this.tableau[x][y].setVent(true);
									} else {
										this.tableau[x][y].setVent(false);
									}

									break;
								default:

									break;


							}
							i++;

							a = "";
							if (i == 6) {	// si on a lu toute la ligne alors on incrémente y pour passer à la case suivante et on remplace i à 0 car nous commencons une nouvelle ligne du fichier
								y++;
								if(y==colonne){
									y=0;
									x=x+1;

								}
								i=0;
							}
						}
					}

				}

				reader.close();
				Ville.Bois=bois;
				Ville.fer=fer;
				Ville.argent=argent;
			}catch (IOException e){
				e.printStackTrace();
			}
		}else {
			//crer une pop up
			System.out.println("il n'y a aucun fichier de ce nom");
		}

	}
	}

	//getter pour le tableau, prend un couple de coordonnées en paramètre et nous retourne le contenue du tableau
	public Case getCaseTableau(int x, int y) {
	return this.tableau[x][y];
	}

	/***
	 * cette fonction permet de construire un batiment dans le tableau. 
	 * @param <T> 	on utilise les generics afin de simplifier cette méthode de construction T prend le type de batiment à construire par exp Appartement,PetiteMaison....
	 * @param x		coordonnée x
	 * @param y 	coordonnée y
	 * @param construction  le type de construction
	 * 
	 */
    public <T> int setConstruction(int x, int y,T construction){
        if(this.tableau[x][y].isVide()) {
        	
        if(((Construction)construction).RessourcesEnoughToBuild()&&(isNextToRoad(x,y))) {	//on vérifie tout d'abord que les ressources de l'utilisateur sont suffisante et que la construction se trouve à coté d'une route
        
        if((construction.getClass().getSuperclass().getTypeName())=="simcity.Eau"){         //on vérifie que l'installation s'agit d'un type eau
            if(this.tableau[x][y].getEau()) {												//on doit vérifier si il est possible d'implementer une construction d'eau sur la case en question
                this.tableau[x][y].SetMaConstruction(construction);							//si les conditions sont vérifier on construit
                return 1;																	//les return d'entiers nous permettent de gérer sur l'interface graphiques les messages d'erreurs, si on éffectue un return 1 c'est que le batiment à été construit avec succès
            }else {
               
                return 2;
            }
        }else {
         
        if(construction.getClass().getTypeName()=="simcity.Eolienne") {						//on vérifie de même pour l'eolienne 	
            if(this.tableau[x][y].getVent()) {
                this.tableau[x][y].SetMaConstruction(construction);
                return 1;
            }else {
               
                return 3;
            }
        }else {
         
        if(construction.getClass().getTypeName()=="simcity.PanneauSolaire") {				//de la même manière on ne peut pas implémenter des panneaux solaires n'importe ou
            if(this.tableau[x][y].getSoleil()) {
                this.tableau[x][y].SetMaConstruction(construction);
                return 1;
            }else {
                
                return 4;
            }
        }else {
         
        if(construction.getClass().getTypeName()=="simcity.ExtracteurFer") {				//idem pour le fer, il faut que la case possède un attribut fer= vrai
            if(this.tableau[x][y].getMine()) {
            	Polluer(x,y);																//l'extracteur de fer pollue donc on appel la fonction polluer en lui précisant les coordonnées
                this.tableau[x][y].SetMaConstruction(construction);
                return 1;
               
            }else {
                
                return 5;
            }
        }else {
            this.tableau[x][y].SetMaConstruction(construction);								//pour les autres constructions nous n'avons pas besoin de vérifier les attributs vent,eau,soleil et mine
            return 1;
        }
        }
        }
        }
        }else {
            return 6;
        }
        }else{
            return 7;
    }
    }
	
	
	
	
	/**
	 * la fonction destruct permet de détruire une construction qui se trouve sur les coordonnées précisées
	 * @param x
	 * @param y
	 */
	 public void destruct(int x, int y){
	        if(this.tableau[x][y].isVide()){
	            System.out.println("la case est déjà vide !");
	        }else {
	        	
	            if((tableau[x][y].getMaConstruction().getClass().getSuperclass().getTypeName()=="simcity.Habitation")) {		//si une habitation est détruite on doit diminuer la population
	                Ville.population=Ville.population-((Habitation)tableau[x][y].getMaConstruction()).getPopulation();
	                
	                Ville.eauC=Ville.eauC-((Habitation)tableau[x][y].getMaConstruction()).getPopulation();						//on met aussi à jour la consommation d'energie en fonction de l'habitation construite
	                Ville.electriciteC=Ville.electriciteC-((Habitation)tableau[x][y].getMaConstruction()).getPopulation();
	                if(tableau[x][y].getPollution()){
	                    Ville.populationPolluted=Ville.populationPolluted-((Habitation)tableau[x][y].getMaConstruction()).getPopulation();
	                }
	                Ville.updateSatisfaction();
	            }
	            
	            if(tableau[x][y].getMaConstruction().getClass().getSuperclass().getTypeName()=="simcity.Eau") {				//si un batiment d'énergie est détruit, nous devons également mettre à jour la production d'energie en fonction du type
	            	Ville.eauP=Ville.eauP-((Eau)tableau[x][y].getMaConstruction()).getProduction();
	            }
	            
	            if(tableau[x][y].getMaConstruction().getClass().getSuperclass().getTypeName()=="simcity.Electricite") {
	            	Ville.electriciteP=Ville.electriciteP-((Electricite)tableau[x][y].getMaConstruction()).getProduction();
	            }
	            
	            
	            
	            this.tableau[x][y].setVide();													//enfin on vide la construction 
	            Ville.updateSatisfaction();														
	        }
	    }
	
	
	
	
	
	// fonction boolean qui permet de vérifier si une route se trouve au nord de la case
	public boolean isNordRoad(int x,int y){
		if(y==0) {
			return false;
		}else{
			return this.tableau[x][y-1].isRoad();
		}
	}
	// fonction boolean qui permet de vérifier si une route se trouve au sud de la case
	public boolean isSudRoad(int x, int y) {
		if(y==(colonne-1)){
			return false;
		}else{
			return this.tableau[x][y+1].isRoad();
		}
	}
	// fonction boolean qui permet de vérifier si une route se trouve à l'ouest de la case
	public boolean isOuestRoad(int x, int y){
		if(x==0) {
			return false;
		}else{
			return this.tableau[x-1][y].isRoad();
		}
	}
	// fonction boolean qui permet de vérifier si une route se trouve à l'est de la case
	public boolean isEstRoad(int x, int y){
		if(x==(ligne-1)) {
			return false;
		}else{
			return this.tableau[x+1][y].isRoad();
		}
	}
	/**
	 * Fonction boolean qui prend en parametre un couple de coordonnée 
	 * return vrai si on trouve au moins une route au nord, au sud, à l'ouest ou a l'est
	 * return faux sinon
	 */
	public boolean isNextToRoad(int x, int y){
		return (isNordRoad(x,y)||isSudRoad(x,y)||isOuestRoad(x,y)||isEstRoad(x,y));
	}
	//fonction qui permet de polluer la case en question
	public void setPollutionCentre(int x, int y) {
		if(y!=0) {
			this.tableau[x][y].Pollute();
			SatisfactionPollution(x,y);
		}
	}
	//fonction qui permet de polluer la case nord de la construction
	public void setPollutionNord(int x, int y) {
		if(y!=0) {
			this.tableau[x][y-1].Pollute();
			SatisfactionPollution(x,y-1);
		}
	}
	//fonction qui permet de polluer la case nord est de la construction
	public void setPollutionNordEst(int x, int y) {
		if((y!=0)&&(x!=ligne-1)) {
			this.tableau[x+1][y-1].Pollute();
			SatisfactionPollution(x+1,y-1);
		}
	}
	//fonction qui permet de polluer la case nord ouest de la construction
	public void setPollutionNordOuest(int x, int y) {
		if((x!=0)&&(y!=0)) {
			this.tableau[x-1][y-1].Pollute();
			SatisfactionPollution(x-1,y-1);
		}
	}
	//fonction qui permet de polluer la case est de la construction
	public void setPollutionEst(int x,int y) {
	if(x!=ligne-1) {
		this.tableau[x+1][y].Pollute();
		SatisfactionPollution(x+1,y);
		}
	}
	//fonction qui permet de polluer la case ouest de la construction
	public void setPollutionOuest(int x, int y) {
		if(x!=0) {
			this.tableau[x-1][y].Pollute();
			SatisfactionPollution(x-1,y);
		}	
	}
	//fonction qui permet de polluer la case sud de la construction
	public void setPollutionSud(int x, int y) {
		if(y!=colonne-1) {
			this.tableau[x][y+1].Pollute();
			SatisfactionPollution(x,y+1);
		}
	}
	//fonction qui permet de polluer la case sud ouest de la construction
	public void setPollutionSudOuest(int x, int y) {
		if((x!=0)&&(y!=colonne-1)) {
			this.tableau[x-1][y+1].Pollute();
			SatisfactionPollution(x-1,y+1);
		}
	}
	//fonction qui permet de polluer la case sud ouest de la construction
	public void setPollutionSudEst(int x, int y) {
		if((x!=ligne-1)&&(y!=colonne-1)) {
			this.tableau[x+1][y+1].Pollute();
			SatisfactionPollution(x+1,y+1);
		}
	}
	/**
	 * cette fonction prend en paramètre un couple de coordonnée et pollue toutes les cases qui se trouvent à proximité de ces coordonnées
	 * @param x
	 * @param y
	 */
	public void Polluer(int x, int y) {
		setPollutionCentre(x,y);
		setPollutionNord(x,y);
		setPollutionSud(x,y);
		setPollutionOuest(x,y);
		setPollutionEst(x,y);
		setPollutionNordEst(x,y);
		setPollutionNordOuest(x,y);
		setPollutionSudOuest(x,y);
		setPollutionSudEst(x,y);
	}
		
	/**
	*cette fonction de satisfaction prend en parametre un couple coordonnées et met à jour la satisfaction en fonction de la pollution
	*@param x
	*@param y
	*/
	public void SatisfactionPollution(int x,int y) {
		if((tableau[x][y].isVide()==false)&&(tableau[x][y].getMaConstruction().getClass().getSuperclass().getTypeName()=="simcity.Habitation")) {
			Ville.populationPolluted=Ville.populationPolluted+((Habitation)tableau[x][y].getMaConstruction()).getPopulation();
		}
	}
	
}
