
public class permutation {
	public static void main(String[] args) {
		String inString = "Tact Coa";
		String[] strArray = inString.split(" ");
		StringBuilder finalStr = new StringBuilder();
		int count = 0;
		for(int i=0;i<strArray.length;i++) {
			finalStr = finalStr.append(strArray[i]);
		}
		System.out.println(finalStr.toString().toLowerCase());
		inString = finalStr.toString().toLowerCase();
		int[] hashArr = new int[58];
		for(int i=0; i<inString.length();i++) {
			int val = inString.charAt(i) - 'A';
			hashArr[val]++;
		}
		for(int i=0; i<hashArr.length;i++) {
			hashArr[i] %= 2;
			if(hashArr[i] > 0) {
				count++;
			}
		}
		if(count>1) {
			System.out.println("The result is false");
		}else {
			System.out.println("The result is true");
		}
	}
}
