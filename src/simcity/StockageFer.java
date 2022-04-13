package simcity;

public class StockageFer extends Stockage {

    StockageFer() {
        this.coutArgent = 0;
        this.coutBois = 100;
        this.level=1;

    }

    @Override
	//cette fonction upgrade permet d'ameliorer le stockage de fer de la ville, le capacité de stockage va augmenter en fonction du niveau (attribut level)
    public void upgrade() {
        if (this.level< 4) {
            switch (this.level) {
                case 1:
                    Ville.stockageFer=1000;
                    this.MajRessources();
                    this.coutBois = 500;
                    break;
                    
                case 2:
                    Ville.stockageFer=10000;
                    this.MajRessources();
                    this.coutBois = 9000;

                    break;

                case 3:
                    Ville.stockageFer=50000;
                    this.MajRessources();
                    this.coutBois = 40000;

                    break;

                default:

                    break;
            }
            this.level=this.level+1;
        }
    }
}