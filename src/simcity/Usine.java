package simcity;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Usine extends Construction {
	protected boolean  production;
	protected boolean isPollute;
	
		public Usine() {
			
		}
		//getter pour l'attribut production
		public boolean getProduction(){
		return production;
		}
		
		public boolean getIsPollute() {
			return this.isPollute;
		}
		/**
		*cette fonction MajProductionUsine prend en paramètre un id qui permet de savoir si c'est une usine de fer ou de bois, le id=0 correspond à  usine de fer et le id =1 correspond à une usine de bois
		*cette fonction va incrémenter le fer ou le bois de la ville en fonction de l'id
		*/
		public void MajProductionUsine(int id) {
			if(id==0) {
				Ville.fer++;
			}else {
				Ville.Bois++;
			}
		}
		
		/**
		*cette fonction de chrono prend en paramètre un id, et permet de produire du fer et du bois
		*la production s'arrete lorsque la capacité maximale de stockage est atteint
		*/
		public void Chrono(final int id) {
			
			Timer chrono = new Timer();
            chrono.schedule(new TimerTask() {

                @Override
                public void run() {
                	if(id==0) {
                        if(Ville.fer>Ville.stockageFer-1){
                            cancel();
                            production = false;
                        }else {
                            production = true;
                            MajProductionUsine(id);
                            
                        }
                        
                }else {
                    if(Ville.Bois>Ville.stockageBois-1){
                        cancel();
                        production = false;
                    }else {
                        production = true;
                        MajProductionUsine(id);
                    }
                }
                }
            }, 1000 , 1000);
            
		}
		
		
	}