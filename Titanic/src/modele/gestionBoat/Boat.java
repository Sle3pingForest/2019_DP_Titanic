package modele.gestionBoat;

public abstract class Boat {
	
	protected int posX, posY, size, hp;
	protected boolean horizontal, dead;
	
	
	// horizontal = true, else vertical
	public Boat(int x, int y, int size, boolean horizontal) {
		this.posX = x;
		this.posY = y;
		this.size = size;
		this.horizontal = horizontal;
		dead = false;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public boolean isHorizontal() {
		return horizontal;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}


}
