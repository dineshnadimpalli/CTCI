import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class OneWayString{

    public static boolean isDiffString(String first, String second){
        if(Math.abs(first.length()-second.length())>1){
            return false;
        }
        String largerString = first.length()>second.length()?first: second;
        String shorterString = first.length()>second.length()?second: first;
        int index1 =0;
        int index2 =0;
        boolean foundDiff = false;
        while(index1<largerString.length() && index2<shorterString.length()){
            if(largerString.charAt(index1) != shorterString.charAt(index2)){
                if(foundDiff){
                    return false;
                }
                foundDiff = true;
                if(largerString.length()==shorterString.length()){
                    index2++;
                }
            }else{
                index2++;
            }
            index1++;
        }
        return true;
    }
    public static void main(String[] args){
        String firstString = "pale";
        String secondString = "par";
        boolean finalResult = isDiffString(firstString, secondString);
        System.out.println(finalResult);
    }
}