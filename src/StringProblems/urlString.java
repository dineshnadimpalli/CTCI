
public class urlString {
	
	public static void main(String[] args) {
		String url = "Mr John Smith is a faggot ";
		System.out.println(url.trim());
		String[] urlArr = url.trim().split(" ");
		System.out.println(urlArr.length);
		StringBuilder result = new StringBuilder();
		for(int i=0;i<urlArr.length-1;i++) {
			result = result.append(urlArr[i]+"%20");
		}
		result = result.append(urlArr[urlArr.length-1]);
		System.out.println(result);
	}
}
