package OOPVIRTUALPET;

public class VirtualPet {

	String name;
	String state;
	int food;
	int water;
	int dance;
	int boredom;
	boolean clean;
	
	String petName(){
		return name;
	}
	
    String reNamePet(String pName) {
		name = pName;
		return name;
	}
	
    int giveFood() {
        this.food = food + 4;
        if (this.food >= 10){
        	this.food = 10;
        	clean = false;
        } 
        this.water = water - 1;   
        return food;
    }
   
    int giveWater() {
        this.water = water + 2;
        if (this.water >= 10){
       	  	this.water = 10;
       	  	clean = false;
        }
        
        return water;
    }
    
    int reduceBore() {
    	this.boredom = boredom - 3;  
    	
    	if (this.boredom <= 0){
    		this.boredom = 0;
       	 
     }
    	return this.boredom;
     }
    
    boolean getClean() {
     
    	this.clean = true;
    	this.food = food - 1;
    	this.water = water - 1;
           
    	return clean;
    }
    
    void tick() {
    	
    	this.food = food + 5;
    	this.water = water - 2;
    	this.clean = false;
    
    	return;
    }
        
    String petState(){
    	if ((this.food == 10 || this.water == 10) && this.clean == false){
        	this.state = "Angry";
    	}
    	
    	else if (this.food <= 5 || this.water <= 5 && this.boredom >= 5){
        	this.state = "Angry";
        }
    	
        else if (this.food <= 5 && this.water <= 5 && this.boredom >= 5){
        	this.state = "Angry";
        	
        }
    
        else if (this.food >= 5 && this.water >= 5 && this.boredom >= 5){
        	this.state = "Sleepy";
        	
	    }
    	
        else if (this.food >= 5 && this.water >= 5 && this.boredom <= 5){
            this.state = "Party";
        
        }
        
        else if (this.food <= 5 && this.water <= 5 && this.boredom >= 5){
        	this.state = "Hungry";
        	
	    }
        
        else {
        
        	this.state = "Happy";
        	
        }
    	return this.state;
    }
    
    
    
    
}

       	
	
	
	

	 
	

