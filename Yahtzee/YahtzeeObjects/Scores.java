package YahtzeeObjects;
import java.util.ArrayList;
import java.util.Collections;


public class Scores {
	
	private int ones = 0;
	private int twos = 0;
	private int threes = 0;
	private int fours = 0;
	private int fives = 0;
	private int sixes = 0;
	private int smallTotal = 0;
	
	private int threeOfAKind = 0;
	private int fourOfAKind = 0;
	private int fullHouse = 0;
	private int smallStraight = 0;
	private int largeStraight = 0;
	private int yahtzee = 0;
	private int chance = 0;
	private int largeTotal = 0;
	
	private int total = 0;
	
	private boolean oneBool = false;
	private boolean twoBool = false;
	private boolean threeBool = false;
	private boolean fourBool = false;
	private boolean fiveBool = false;
	private boolean sixBool = false;
	private boolean threeKindBool = false;
	private boolean fourKindBool = false;
	private boolean fullHouseBool = false;
	private boolean smallStraightBool = false;
	private boolean largeStraightBool = false;
	private boolean yahtzeeBool = false;
	private boolean chanceBool = false;
	
	public Scores() {
		
		 ones = 0;
		 twos = 0;
		 threes = 0;
		 fours = 0;
		 fives = 0;
		 sixes = 0;
		 smallTotal = 0;
		
		 threeOfAKind = 0;
		 fourOfAKind = 0;
		 fullHouse = 0;
		 smallStraight = 0;
		 largeStraight = 0;
		 yahtzee = 0;
		 chance = 0;
		 largeTotal = 0;
		
		 total = 0;
		
		 oneBool = false;
		 twoBool = false;
		 threeBool = false;
		 fourBool = false;
		 fiveBool = false;
		 sixBool = false;
		 threeKindBool = false;
		 fourKindBool = false;
		 fullHouseBool = false;
		 smallStraightBool = false;
		 largeStraightBool = false;
		 yahtzeeBool = false;
		 chanceBool = false;
	}
	
	public void reset() {
		 ones = 0;
		 twos = 0;
		 threes = 0;
		 fours = 0;
		 fives = 0;
		 sixes = 0;
		 smallTotal = 0;
		
		 threeOfAKind = 0;
		 fourOfAKind = 0;
		 fullHouse = 0;
		 smallStraight = 0;
		 largeStraight = 0;
		 yahtzee = 0;
		 chance = 0;
		 largeTotal = 0;
		
		 total = 0;
		
		 oneBool = false;
		 twoBool = false;
		 threeBool = false;
		 fourBool = false;
		 fiveBool = false;
		 sixBool = false;
		 threeKindBool = false;
		 fourKindBool = false;
		 fullHouseBool = false;
		 smallStraightBool = false;
		 largeStraightBool = false;
		 yahtzeeBool = false;
		 chanceBool = false;
	}
	
	public int updateScore(ArrayList<Dice> dice, int scored) {
		
		int value = 0;
		
		Collections.sort(dice, new DiceCompare());
		
		switch (scored) {
	        case 1: 
	    		ones = getOnes(dice);
	    		value = ones;
	            break;
	        case 2:  
	        	twos = getTwos(dice);
	        	value = twos;
	        	break;
	        case 3:  
	        	threes = getThrees(dice);
	        	value = threes;
	            break;
	        case 4: 
	        	fours = getFours(dice);
	        	value = fours;
	        	break;
	        case 5:  
	        	fives = getFives(dice);
	        	value = fives;
	        	break;
	        case 6: 
	        	sixes = getSixes(dice);
	        	value = sixes;
	        	break;
	        case 7:  //fix three of a kind
	        	threeOfAKind = getThreeOfAKind(dice);
	        	value = threeOfAKind;
	        	break;
	        case 8:  
	        	fourOfAKind = getFourOfAKind(dice);
	        	value = fourOfAKind;
	        	break;
	        case 9:  
	        	fullHouse = getFullHouse(dice);
	        	value = fullHouse;
	        	break;
	        case 10: 
	        	smallStraight = getSmallStraight(dice);
	        	value = smallStraight;
	        	break;
	        case 11:
	        	largeStraight = getLargeStraight(dice);
	        	value = largeStraight;
	        	break;
	        case 12: 
	        	yahtzee = getYahtzee(dice);
	        	value = yahtzee;
	        	break;
	        case 13: 
	        	chance = getChance(dice);
	        	value = chance;
	        	break;
	        default: 
	        	break;
		}
		
		
		smallTotal = ones + twos + threes + fours + fives + sixes;
		if(smallTotal>=63) {
			smallTotal+=35;
		}
		largeTotal = threeOfAKind + fourOfAKind + fullHouse + smallStraight + largeStraight + yahtzee + chance;
		
		total = smallTotal + largeTotal;
		
		return value;
		
	}
	
	public int getSmallTotal() {
		return smallTotal;
	}
	
	public int getLargeTotal() {
		return largeTotal;
	}
	
	public int getTotal() {
		return total;
	}
	
	
	@Override
	public String toString() {
		return "Ones: " + ones +
				"\nTwos: " + twos + 
				"\nThrees: " + threes +
				"\nFours: " + fours + 
				"\nFives: " + fives + 
				"\nSixes: " + sixes +
				"\nSmall Total: " + smallTotal +
				"\n------------------" +
				"\nThree of a kind: " + threeOfAKind +
				"\nFour of a kind: " + fourOfAKind +
				"\nFull House: " + fullHouse + 
				"\nSmall Straight: " + smallStraight + 
				"\nLarge Straight: " + largeStraight +
				"\nYahtzee: " + yahtzee + 
				"\nChance: " + chance + 
				"\nLarge Total: " + largeTotal + 
				"\nTotal: " + total;
	}
	
	
	private int getOnes(ArrayList<Dice> dice) {
		int one = 0;
		for(int i=0;i<dice.size();i++) {
			if(dice.get(i).getValue()==1) {
				one++;
			}
		}
		if(oneBool==false) {
			oneBool = true;
			return one;
		} else {
			return ones;
		}
	}
	
	private int getTwos(ArrayList<Dice> dice) {
		int two = 0;
		for(int i=0;i<dice.size();i++) {
			if(dice.get(i).getValue()==2) {
				two+=2;
			}
		}
		
		if(twoBool==false) {
			twoBool = true;
			return two;
		} else {
			return twos;
		}
	}
	
	private int getThrees(ArrayList<Dice> dice) {
		int three = 0;
		for(int i=0;i<dice.size();i++) {
			if(dice.get(i).getValue()==3) {
				three+=3;
			}
		}
		
		if(threeBool==false) {
			threeBool = true;
			return three;
		} else {
			return threes;
		}
	}
	
	private int getFours(ArrayList<Dice> dice) {
		int four = 0;
		for(int i=0;i<dice.size();i++) {
			if(dice.get(i).getValue()==4) {
				four+=4;
			}
		}
		
		if(fourBool==false) {
			fourBool = true;
			return four;
		} else {
			return fours;
		}
	}
	
	private int getFives(ArrayList<Dice> dice) {
		int five = 0;
		for(int i=0;i<dice.size();i++) {
			if(dice.get(i).getValue()==5) {
				five+=5;
			}
		}
		
		if(fiveBool==false) {
			fiveBool = true;
			return five;
		} else {
			return fives;
		}
	}
	
	private int getSixes(ArrayList<Dice> dice) {
		int six = 0;
		for(int i=0;i<dice.size();i++) {
			if(dice.get(i).getValue()==6) {
				six+=6;
			}
		}
		
		if(sixBool==false) {
			sixBool = true;
			return six;
		} else {
			return sixes;
		}
	}
	
	private int getThreeOfAKind(ArrayList<Dice> dice) {
		
		int value = 0;
		int count = 0;
		
		for(int i=0;i<dice.size()-1;i++) {
			if(dice.get(i).getValue()==dice.get(i+1).getValue()) {
				count++;
			}
		}
		
		if(count>=2) {
			for(int i=0;i<dice.size();i++) {
				value+=dice.get(i).getValue();
			}
		}
		
		if(threeKindBool==false) {
			threeKindBool = true;
			return value;
		} else {
			return threeOfAKind;
		}
	}
	
	private int getFourOfAKind(ArrayList<Dice> dice) {
		
		int value = 0;
		int count = 0;
		for(int i=0;i<dice.size()-1;i++) {
			if(dice.get(i).getValue()==dice.get(i+1).getValue()) {
				count++;
			}
		}
		
		if(count>=3) {
			for(int i=0;i<dice.size();i++) {
				value+=dice.get(i).getValue();
			}
		}
		
		if(fourKindBool==false) {
			fourKindBool = true;
			return value;
		} else {
			return fourOfAKind;
		}
	}
	
	private int getFullHouse(ArrayList<Dice> dice) {
		
		int count = 1;
		int value = 0;
		boolean found = false;
		boolean found1 = false;
		for(int i=1;i<dice.size();i++) {
			if(dice.get(i).getValue()==dice.get(i-1).getValue()) {
				count++;
			} else {
				if(count==3) {
					found1 = true;
				} else if(count==2) {
					found = true;
				}
				 count = 1;
			}
			
		}
		
		if(count==3) {
			found1 = true;
		} else if(count==2) {
			found = true;
		}
		
		if(found && found1) {
			value = 25;
		}
		
		if(fullHouseBool==false) {
			fullHouseBool = true;
			return value;
		} else {
			return fullHouse;
		}
	}
	
	private int getSmallStraight(ArrayList<Dice> dice) {
		
		int value = 0;
		int count = 0;
		for(int i=0;i<dice.size()-1;i++) {
			if(dice.get(i).getValue()+1==dice.get(i+1).getValue()) {
				count++;
			}
		}
		
		if(count>=3) {
			value = 30;
		}
		
		if(smallStraightBool==false) {
			smallStraightBool = true;
			return value;
		} else {
			return smallStraight;
		}
	}
	
	private int getLargeStraight(ArrayList<Dice> dice) {
		
		int value = 0;
		int count = 0;
		for(int i=0;i<dice.size()-1;i++) {
			if(dice.get(i).getValue()+1==dice.get(i+1).getValue()) {
				count++;
			}
		}
		
		if(count==4) {
			value = 40;
		}
		
		if(largeStraightBool==false) {
			largeStraightBool = true;
			return value;
		} else {
			return largeStraight;
		}
	}
	
	private int getYahtzee(ArrayList<Dice> dice) {
		
		int value = 0;
		int count = 0;
		for(int i=0;i<dice.size()-1;i++) {
			if(dice.get(i).getValue()==dice.get(i+1).getValue()) {
				count++;
			}
		}
		
		if(count==4) {
			value = 50;
		}
		
		if(yahtzeeBool==false) {
			yahtzeeBool = true;
			return value;
		} else if(yahtzeeBool==true) {
			value = 100;
			return value;
		} else {
			return yahtzee;
		}
	}
	
	private int getChance(ArrayList<Dice> dice) {
		
		int value = 0;
		for(int i=0;i<dice.size()-1;i++) {
			value+=dice.get(i).getValue();
		}
		
		if(chanceBool==false) {
			chanceBool = true;
			return value;
		} else {
			return chance;
		}
	}
	
}
