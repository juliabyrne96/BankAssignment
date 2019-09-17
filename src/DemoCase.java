public class DemoCase {
    public static void main(String[] args){
        System.out.println("Text Processing Demo");

        String str="HELLO";
        int len=str.length();
        System.out.println("The length of the string is " + len);
        for(int i=0; i<len; i++){
            char c=Character.toLowerCase(str.charAt(i));
            System.out.print(c);
        }

    }
}
