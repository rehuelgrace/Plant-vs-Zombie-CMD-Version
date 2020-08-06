public abstract class Plant{
	private int health;
	private int x;
	private int y;
	private char type;
	private boolean deteksiZombie;
    protected Zombie zombie;
    protected Array arr;
    private int power;

	public Plant (int x, int y, char type){
		this.x = x;
		this.y = y;
		this.type = type;
		this.health = 200;
	}
	public int getHealth(){
    	return health;
    }
    public void setHealth(int health){
    	this.health = health;
    }
    public void reduceHealth(int health){ //health berkurang kalo kena demage zombie
        this.health = this.health-zombie.getPower();
    }
    public int getRow(){
        return x;
    }
    public void setRow(int x){
        this.x = x;
    }
    public int getColumn(){
        return y;
    }
    public void setColumn(){
        this.y = y;
    }
    public char getType(){
        return type;
    }
    /*public char getType(){ //bener gasih? kayak ngecek typenya  apakah F atau P gitu
    	if (input.equals("P")){ //ato ini gaperlu?
    		type = 'P';
    		return type;
    	} else if (input.equals("F")){
    		type = 'F';
    		return type;
    	} else {
            type = 'N';
            return type;   
        }
    }*/
    public int getPower(){
        return power;
    }
    public void setPower(int power){
        this.power = power;
    }
    public void serangZombie(ArrayAll<ZombieBoss> zombieBoss, ArrayAll<ZombieIndie> zombieIndie){
    	
    }
    public boolean getDeteksi(){
    	return deteksiZombie;
    }
}
