package OOPVIRTUALPET;

import java.util.Random;
import java.util.Scanner;

public class VirtualPetApp {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        
        //String petState;
        VirtualPet vPet = new VirtualPet();
        
        //Initialize pet's attributes
        vPet.food = randInt(1,10);
        vPet.water = randInt(1,10);
        vPet.boredom = randInt(1,10);
        vPet.clean = true;
 
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Farzana's Virtual Pet World.");
		System.out.println("Please name your Pet.");
		System.out.println("Type Quit to exit.");
	
		vPet.name = input.next();
		checkForQuit(vPet.name);
	 
		System.out.println("You are the proud owner of " + vPet.name + " and it is a koala.");
		
		petEmotions(vPet.petState());
		
		//Display pet's initial state
		System.out.println("\n" + vPet.name + " is " + vPet.state);
			
		System.out.println("");
		System.out.println("Pick a number from 1 to 6 from the options below.");
		System.out.println("");
	
		boolean play = true;
	    
		while (play == true) {
			
			showMenu();
			System.out.println("");
// Putting user input into vOption		
			String vOption = input.next();
			
// method to check if the user wants to quit			
			checkForQuit(vOption);
			int iOption = Integer.parseInt(vOption);
	    
// options the user chose  	        
	    switch(iOption) {    	
	    	case 1:{	     	               
	   	       System.out.println("Yayyy, I love food.");
	   	       System.out.println("Level before adding food: " + vPet.food);
	   	       vPet.giveFood();
	   	   	   petEmotions(vPet.petState());
	   	       System.out.println("");
	   	       System.out.println("Level after giving food " + vPet.food + " and emotional state is " + vPet.state);
	   	       System.out.println("Water level " + vPet.water);
	   	       System.out.println("Boredom level " + vPet.boredom);
	   	       System.out.println("Are you clean? " + vPet.clean);
	   	       System.out.println("");
	   	       break; 
	    	}   
	    	   
	    	case 2:{ 
	    	   System.out.println("I need water.");
	    	   System.out.println("");
	    	   System.out.println("Before adding water: " + vPet.water);
	   	       vPet.giveWater();
	   	       petEmotions(vPet.petState());
	   	       System.out.println("After giving water: " + vPet.water + " and emotional state is " + vPet.state);
	   	       System.out.println("Food level " + vPet.food);
	   	       System.out.println("Boredom level " + vPet.boredom);
	   	       System.out.println("Are you clean? " + vPet.clean);
	   	       System.out.println("");
	   	       break; 
	    	}   
	    	
	    	case 3:{
	    		System.out.println("Pause Play and cleanup yourself.");
		    	System.out.println("");
		    	System.out.println("" + vPet.clean);
		   	    vPet.getClean();
		   	    petEmotions(vPet.petState());
		   	    System.out.println("Food level " + vPet.food);
		   	    System.out.println("Water level " + vPet.water);
		   	    System.out.println("Boredom level " + vPet.boredom);
		   	    System.out.println("Are you clean? " + vPet.clean);
		   	    System.out.println("");
		   	    break; 	
	    		
	    	}
	    	
	    	case 4:{	    		
	    		System.out.println("Great! You can rename your pet from " + vPet.name + " to any new name." );
	    		String rName  = input.next();
	    		checkForQuit(rName);
	    		vPet.reNamePet(rName);
	    		System.out.println("Now your pet's name is " + vPet.name + ".");
	    		System.out.println("Water level " + vPet.water);
	    		System.out.println("Food level " + vPet.food);
		   	    System.out.println("Boredom level " + vPet.boredom);
		   	    System.out.println("Are you clean? " + vPet.clean);
		   	    System.out.println("");
		   	    break; 
	    	}
	    	
	    	case 5:{	    		
	    		System.out.println("Dance with your pet. ");
	    		System.out.println("Before dance boredom level is: " + vPet.boredom);
		   	    vPet.reduceBore();
		   	    petEmotions(vPet.petState());
		   	    System.out.println("After dance boredom level is: " + vPet.boredom + " and emotional state is " + vPet.state);
		   	    System.out.println("Water level " + vPet.water);
	    		System.out.println("Food level " + vPet.food);
		   	    System.out.println("Is it clean " + vPet.clean);
		   	    System.out.println("");
		   	    break; 
	    	}
	    	
	    	case 6:{	    		
	    		System.out.println("You asked " + vPet.name + " to fall asleep. Start your game again to play with your pet again later." );
	    		play = false;
	    		vPet.state = "Sleepy";
	    		System.out.println("Water level " + vPet.water);
	    		System.out.println("Food level " + vPet.food);
		   	    System.out.println("Boredom level " + vPet.boredom);
		   	    System.out.println("Are you clean " + vPet.clean);
	    		petEmotions(vPet.state);
	    		System.out.println("");
	    		System.exit(0);
	    		break; 
	    	}
	    	
	    	default:{
	    		vPet.tick();
	    		showMenu();
	    		break; 
	    	}
			
		    
			
		}
		
		}
		input.close();
	}
	
	
// method to quit the program	
	public static void checkForQuit(String userInput){
		
		userInput = userInput.toLowerCase();
		
		if (userInput.equals("quit")) {		
		System.out.println("Nobody likes a quitter...");
		System.exit(0);
		}
	}
	
	public static int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
// show menu for available options	
    public static void showMenu(){
    	System.out.println("1. Give food");
    	System.out.println("2. Give water");
    	System.out.println("3. Cleanup");
    	System.out.println("4. Rename your pet");
    	System.out.println("5. Dance with your pet");
    	System.out.println("6. Let your pet sleep and end playing");
    	
   }
   
 // ascii pictures according to the emotional state of your pet   
    
    public static void petEmotions(String state){
    
    switch (state){
      case "Party":{
    	System.out.println("   *   ");
		System.out.println("  / " + "\\");
		System.out.println("   _  ");
		System.out.println("{~._.~}");
		System.out.println(" ( Y )");
		System.out.println("()~*~()");
		System.out.println("(_)-(_)");
		break;
      }
      case "Sleepy":{
    	System.out.println("  ___  ");
  		System.out.println("{~___~}");
  		System.out.println(" ( Y )");
  		System.out.println("()~*~()");
  		System.out.println("(_)-(_)");
  		break;
        }
      case "Angry":{
      	System.out.println("  ___  ");
    		System.out.println("{~x_x~}");
    		System.out.println(" ( Y )");
    		System.out.println("()~*~()");
    		System.out.println("(_)-(_)");
    		break;
          }
      case "Happy":{
        	System.out.println("   _ _  ");
      		System.out.println(" {~._.~}");
      		System.out.println(" _( Y )_");
      		System.out.println("(:_~*~_:)");
      		System.out.println(" (_)-(_)");
      		break;
            }
      case "Hungry":{
        	System.out.println("  ___  ");
      		System.out.println("{~p_q~}");
      		System.out.println(" ( Y )");
      		System.out.println("()~*~()");
      		System.out.println("(_)-(_)");
      		break;
            }
    }
    }
	
}
    	
    	
    	
   
    
	

	

