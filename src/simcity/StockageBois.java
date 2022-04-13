package simcity;

public class StockageBois extends Stockage {
    StockageBois() {
        this.level=1;
        this.coutArgent = 0;
        this.coutFer = 100;

    }

    @Override
	//cette fonction upgrade permet d'ameliorer le stockage de bois de la ville, le capacité de stockage va augmenter en fonction du niveau (attribut level)
    public void upgrade() {
        if (this.level< 4) {
            switch (this.level) {
                case 1:
                	Ville.stockageBois=1000;
                	this.MajRessources();
                    this.coutFer = 500;
                    
                    break;
                case 2:
                    Ville.stockageBois=10000;
                    this.coutFer = 9000;
                    this.MajRessources();
                    break;

                case 3:
                    Ville.stockageBois=50000;
                    this.coutFer = 40000;
                    this.MajRessources();
                    break;

                default:

                    break;
            }
            this.level=this.level+1;
        }
    }
}