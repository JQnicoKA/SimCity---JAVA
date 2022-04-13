package simcity;

public abstract class Energie extends Construction {
protected int  production;
protected boolean isPollute;
	
	public int getProduction(){
	return production;
	}
	
	public void setProduction(int prod) {
	this.production=prod;	
	}
	
	public boolean getIsPollute() {
		return this.isPollute;
	}
}
