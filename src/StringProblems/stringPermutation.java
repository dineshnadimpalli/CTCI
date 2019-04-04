
public class stringPermutation {
	public static void main(String[] args) {
		String firstString = "abcd";
		String secondString = "acba";
		if(firstString.length() != secondString.length()) {
			System.out.println("Not a permutation");
		}
		else {
			int[] firstStringHash = new int[128];
			for(int i=0;i<firstString.length(); i++) {
				int val = firstString.charAt(i);
				firstStringHash[val]++;
			}
			for(int i=0;i<secondString.length(); i++) {
				int val = secondString.charAt(i);
				firstStringHash[val]--;
				if(firstStringHash[val]<0) {
					System.out.println("Not a permutation");
				}
			}
			System.out.println("Is a permutation");

		}
	}
}
