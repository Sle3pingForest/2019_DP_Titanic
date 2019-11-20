package modele.gestionBoat;

public class Case {
	private int id;
	private boolean Touched;
	private boolean Water;
	private int x,  y;
	
    /****************Constructor********************/
	public Case(int id) {
		this.id = id;
		this.Water = true;
		this.Touched = false; 
		
	}
	public Case(int id, int x, int y) {
		this.id = id;
		this.Water = true;
		this.Touched = false; 
		this.x = x;
		this.y = y;
		
	}

	public Case(int id, boolean toucher, boolean eau) {
		this.id = id;
		this.Touched = toucher;
		this.Water = eau;
	}
	
	public Case(int id,int x, int y, boolean toucher, boolean eau) {
		this.id = id;
		this.Touched = toucher;
		this.Water = eau;
		this.x = x;
		this.y = y;
	}
	 /****************End_Constructor***************/

	
	public int getid() {
		return this.id;
	}
	public void touched() {
		this.Touched = true;
	} 
	public void setWaterisTouched() {
		this.Water = false;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isTouched() {
		return this.Touched;
	}
	public boolean isWater() {
		return this.Water;
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public void setTouched(boolean touched) {
		Touched = touched;
	}

	public void setWater(boolean water) {
		Water = water;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.id).append(",").append(this.Touched).append(",").append(this.Water);
		return sb.toString();
	}

}