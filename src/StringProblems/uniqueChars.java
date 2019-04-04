
public class uniqueChars {
	
	public static boolean isUniqueChars(String s){
		if(s.length()>128) {
			return false;
		}
		else {
			boolean[] word = new boolean[128];
			for(int i=0;i<s.length(); i++) {
				int val = s.charAt(i);
				if(word[val]) {
					return false;
				}
				word[val] = true;
			}
			return true;
		}
	}
	
	public static void main(String[] args) {
		String[] items = {"abcde", "hello", "apple", "kite", "padle"};
		for(String word: items) {
			System.out.println(word+" : "+ isUniqueChars(word));
		}
	}
}
