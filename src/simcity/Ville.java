package simcity;

public class Ville {
	//les attributs de la ville déclarés en public static
	public static int argent=20000;
	public static int Bois=100;
	public static int fer=100;
	public static int population=0;
	public static int populationPolluted=0;		//population vivant dans la pollution
	public static float electriciteP=0;			//electricite produite
	public static float electriciteC=0;			//electricite consommée
	public static float eauP=0;					//eau produite
	public static float eauC=0;					//eau consommée
	public static float Satisfaction=100;	
	public static int stockageBois=100;
	public static int stockageFer=100;
	public static int CoefficientRevenu=0;
	
	
	/**
	 * cette fonction permet de mettre à jour la satisfaction de la ville
	 * elle est basée sur 3 élements; 
	 * la satisfaction en eau  	(est ce que la production d'eau est suffisante?)
	 * la satisfaction en electricite  (est ce que la production d'electricité est suffisante?)
	 * le taux de pollution de la ville en fonction du nombre d'habitant
	 */

	public static void updateSatisfaction(){
        float satisfactionEau, satisfactionElec,satisfactionPolluer=0;
        float pop = population;
        float popP = populationPolluted;
        if(population !=0)
        {
            if (eauP > eauC) {
                satisfactionEau = 1;

            } else {
                satisfactionEau = eauP / eauC;
            }

            if (electriciteP > electriciteC) {
                satisfactionElec = 1;

            } else {
                satisfactionElec = electriciteP / electriciteC;
            }

            if(populationPolluted == 0 ){
                satisfactionPolluer = 1;
            }else{
                satisfactionPolluer =1 - (popP / pop);

            }
            Satisfaction = ((satisfactionEau + satisfactionElec + satisfactionPolluer) / 3)*100;
        }
    }
}
