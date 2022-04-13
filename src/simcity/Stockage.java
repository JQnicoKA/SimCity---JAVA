package simcity;

public abstract class Stockage extends Construction{


    protected int level;



    public abstract void upgrade();




/******************************getter and setter *************************************/
    public int getLevel() {
        return level;
    }

    public void setLevel(int level){
        this.level=level;
    }
    
    
    /******************************fonctions *************************************/
    
    public boolean amelioration() {
    	if(this.RessourcesEnoughToBuild()) {
    		this.upgrade();
    		return true;
    	}else {
    		return false;
    	}
    }

}