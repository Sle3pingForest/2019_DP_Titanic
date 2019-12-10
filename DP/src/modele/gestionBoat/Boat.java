package modele.gestionBoat;

public abstract class Boat {
	
	protected boolean dead;
	protected int id,direction;
	protected String name;
	protected int posX, posY, size, hp;
	
	// horizontal = true, else vertical
	public Boat(String name, int id ,int x, int y, int size, int horizontal) {
		this.posX = x;
		this.posY = y;
		this.size = size;
		this.direction = horizontal;
		this.name = name;
		dead = false;
		this.id = id;
	}

	public int getHp() {
		return hp;
	}

	public String getName() {
		return name;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public int getSize() {
		return this.size;
	}

	public boolean isDead() {
		return dead;
	}

	public int getDirection() {
		return direction;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

}
