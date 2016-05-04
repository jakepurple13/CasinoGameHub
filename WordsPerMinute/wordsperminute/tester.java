package wordsperminute;



public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String words = "Hello World Good day isn't it";
		
		String word = "";
		int next = 0;
		words = words.replace(" ", "|");
		while(!words.equals("")) {
			next = words.indexOf("|");
			word = words.substring(0, next);
			words = words.substring(next+1);
			System.out.println(word);
		}
		
		
		
	}

}
