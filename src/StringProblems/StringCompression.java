public class StringCompression{

    public static String compressedStr(String str){
        StringBuilder resultStr = new StringBuilder();
        int consecutiveCount =0;
        for (int i=0;i<str.length();i++){
            consecutiveCount++;
            if(i+1 >=str.length()  || str.charAt(i) != str.charAt(i+1)){
                resultStr.append(str.charAt(i));
                resultStr.append(consecutiveCount);
                consecutiveCount=0;
            }
        }
        System.out.println(resultStr.length() + " " + str.length());
        return resultStr.length()<str.length()?resultStr.toString():str;
    }
    
    public static void main(String[] args){
        String str = "aaaabbbcccdddee";
        System.out.println("The original string is "+str);
        System.out.println("The compressed string is "+compressedStr(str));
    }
}