package VideoPoker;

import Cards.Hand;

public class Scores {
	
	
	
	public boolean pair(Hand h) {
		
		Hand g = h;
		g.sortHandByValue();
		boolean acceptable = false;
		int count = 0;
		for(int i=1;i<g.getHand().size();i++) {
			
			if(g.getCard(i).compareTo(g.getCard(i-1))==0) {
				count++;
			}
			
		}
		
		if(count==1) {
			acceptable=true;
		}
		
		return acceptable;
	}
	
	public boolean twoPair(Hand h) {
		
		Hand g = h;
		g.sortHandByValue();
		int count = 1;
		boolean found = false;
		boolean found1 = false;
		for(int i=1;i<g.getHand().size();i++) {
			if(g.getCard(i).compareTo(g.getCard(i-1))==0) {
				count++;
				i++;
			}
				if(count==2 && found1==true) {
					found = true;
					count = 1;
				} else if(count==2) {
					found1 = true;
					count = 1;
				} 
				 
			
			
		}
		
		if(count==2) {
			found1 = true;
		} else if(count==2 && found1==true) {
			found = true;
		}
		
		if(found && found1) {
			return true;
		}
		
		return false;
	}
	
	public boolean threeOfAKind(Hand h) {
		
		Hand g = h;
		g.sortHandByValue();
		boolean acceptable = false;
		int count = 1;
		boolean hold = false;
		for(int i=1;i<g.getHand().size();i++) {
			
			if(g.getCard(i).compareTo(g.getCard(i-1))==0) {
				count++;
				hold = true;
			} else if(hold) {
				break;
			}
			
		}
		
		if(count==3) {
			acceptable=true;
		}
		
		return acceptable;
	}
	
	public boolean fourOfAKind(Hand h) {
		
		Hand g = h;
		g.sortHandByValue();
		boolean acceptable = false;
		int count = 0;
		int numberCount = 0;
		numberCount = g.getCard(3).getValue();
		for(int i=0;i<g.getHand().size();i++) {
			
			if(g.getCard(i).getValue()==numberCount) {
				count++;
			}
			
		}
		
		if(count==4) {
			acceptable=true;
		}
		
		return acceptable;
	}
	
	public boolean fullHouse(Hand h) {
		
		Hand g = h;
		g.sortHandByValue();
		int count = 1;
		boolean found = false;
		boolean found1 = false;
		for(int i=1;i<g.getHand().size();i++) {
			if(g.getCard(i).compareTo(g.getCard(i-1))==0) {
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
			return true;
		}
		
		return false;
	}
	
	public boolean straight(Hand h) {
		
		Hand g = h;
		g.sortHandByValue();
		int count = 0;
		int value = 0;
		for(int i=0;i<g.getHand().size()-1;i++) {
			value = g.getCard(i).getValue();
			if(value == 1) {
				if(g.getCard(i+1).getValue()==2) {
					value = 1;
				} else if(g.getCard(i+1).getValue() == 10) {
					value = 9;
				}
			}
			if(value+1 == g.getCard(i+1).getValue()) {
				count++;
			}
		}
		
		if(count==4) {
			return true;
		}
		return false;
	}

	public boolean flush(Hand h) {
		
		Hand g = h;
		g.sortHandByValue();
		for(int i=1;i<g.getHand().size();i++) {
			
			if(!g.getCard(i).compareSuit(g.getCard(i-1))) {
				return false;
			}
			
		}
		
		return true;
	}
	
	public boolean straightFlush(Hand h) {
		
		if(straight(h) && flush(h)) {
			return true;
		}
		
		return false;
	}
	
	public boolean royalFlush(Hand h) {
		
		Hand g = h;
		g.sortHandByValue();
		if(g.getCard(1).getValue() == 10) {
			if(g.getCard(2).getValue() == 11) {
				if(g.getCard(3).getValue() == 12) {
					if(g.getCard(4).getValue() == 13) {
						if(g.getCard(0).getValue() == 1) {
							if(straight(h) && flush(h)) {
								return true;
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	
	public int winCheck(Hand h, int bet) {
		int value = 0;
		
		if(royalFlush(h)) {
			value = getWinning(9, bet);
			System.out.println("Royal Flush + " + h);
		} else if(straightFlush(h)) {
			value = getWinning(8, bet);
			System.out.println("Straight Flush + " + h);
		} else if(fourOfAKind(h)) {
			value = getWinning(7, bet);
			System.out.println("Four of a Kind + " + h);
		} else if(fullHouse(h)) {
			value = getWinning(6, bet);
			System.out.println("Full House + " + h);
		} else if(flush(h)) {
			value = getWinning(5, bet);
			System.out.println("Flush + " + h);
		} else if(straight(h)) {
			value = getWinning(4, bet);
			System.out.println("Straight + " + h);
		} else if(threeOfAKind(h)) {
			value = getWinning(3, bet);
			System.out.println("Three of a Kind + " + h);
		} else if(twoPair(h)) {
			value = getWinning(2, bet);
			System.out.println("Two Pair + " + h);
		} else if(pair(h)) {
			value = getWinning(1, bet);
			System.out.println("Pair + " + h);
		}
		
		return value;
	}
	
	public int getWinning(int rank, int bet) {
		String values = "";
		
		double value = 1;
		
		switch (rank) {
		case 9:
			values+="Royal Flush:    |";
			value = 250;
			break;
		case 8:
			values+="Straight Flush: |";
			value = 50;
			break;
		case 7:
			values+="4 of a Kind:    |";
			value = 25;
			break;
		case 6:
			values+="Full House:     |";
			value = 9;
			break;
		case 5:
			values+="Flush:          |";
			value = 6;
			break;
		case 4:
			values+="Straight:       |";
			value = 4;
			break;
		case 3:
			values+="3 of a Kind:    |";
			value = 3;
			break;
		case 2:
			values+="Two Pair:       |";
			value = 2;
			break;
		case 1:
			values+="Pair:           |";
			value = 1;
			break;
		default:
			System.out.println(values);
			break;
		}
		return (int) (value * bet);
	}
	
	
	public String getValues() {
		String values = "";
		
		double value = 1;
		int next;
		
		for(int i=9;i>0;i--) {
			switch (i) {
			case 9:
				values+="Royal Flush:    |";
				value = 250/9.0;
				break;
			case 8:
				values+="Straight Flush: |";
				value = 6.25;
				break;
			case 7:
				values+="4 of a Kind:    |";
				value = 25/7.0;
				break;
			case 6:
				values+="Full House:     |";
				value = 9/6.0;
				break;
			case 5:
				values+="Flush:          |";
				value = 6/5.0;
				break;
			case 4:
				values+="Straight:       |";
				value = 4/4.0;
				break;
			case 3:
				values+="3 of a Kind:    |";
				value = 3/3.0;
				break;
			case 2:
				values+="Two Pair:       |";
				value = 2/2.0;
				break;
			case 1:
				values+="Pair:           |";
				value = 1/1.0;
				break;
			default:
				break;
			}
			for(int j = 1;j<6;j++) {
				next = (int) (i*j*value);
				values += next + "|";
			}
			values+="\n";
		}
		
		return values;
	}
	
	
	public String getHTMLValues() {
		String values = "<html><pre>";
		
		double value = 1;
		int next;
		
		for(int i=9;i>0;i--) {
			switch (i) {
			case 9:
				values+="Royal Flush:    |";
				value = 250/9.0;
				break;
			case 8:
				values+="Straight Flush: |";
				value = 50/8.0;
				break;
			case 7:
				values+="4 of a Kind:    |";
				value = 25/7.0;
				break;
			case 6:
				values+="Full House:     |";
				value = 9/6.0;
				break;
			case 5:
				values+="Flush:          |";
				value = 6/5.0;
				break;
			case 4:
				values+="Straight:       |";
				value = 4/4.0;
				break;
			case 3:
				values+="3 of a Kind:    |";
				value = 3/3.0;
				break;
			case 2:
				values+="Two Pair:       |";
				value = 2/2.0;
				break;
			case 1:
				values+="Pair:           |";
				value = 1/1.0;
				break;
			default:
				break;
			}
			for(int j = 1;j<6;j++) {
				next = (int) (i*j*value);
				values += next + "|";
			}
			values+="<br />";
		}
		
		values+="</pre></html>";
		
		return values;
	}
	
}
