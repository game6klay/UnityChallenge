package csfundamentals;

/**
 * Created by jay on 7/28/17.
 */
public class StringReversal {

    /**
    * Java provides three different classes to work with Strings
    * String , StringBuilder and StringBuffer.
    * Depending upon our requirement we can choose to work with one of them.
    *
    * */

    /**
    * String class in Java is immutable , so whenever we can want to run some kind of operation on it ,
    * a different String object is created in the String access pool. It would be better to convert the String
    * into a Character Array , perform the operations and convert the array into String object when we return it.
    * It would take O(n) of extra space but since it is immutable it is also Thread safe.
    * In real world we are more worried about the time complexity than space and thus we take a note that the
    * performance of the String class is FAST.
    * */

    public static void main(String[] args) {
        System.out.println(reverseString("'/n'"));
        System.out.println(reverseString("\t"));
        System.out.println(reverseString("\\uDC00\\uD800"));

    }

    public static String reverseString (String s) {
        if (s==null) throw new NullPointerException("input can not be null");
        int head =0, tail = s.length()-1;
        char[] arr = new char[s.length()];
        while (head <= tail) {
            arr[head] = s.charAt(tail);
            arr[tail--] = s.charAt(head++);
        }
        return new String(arr);
    }

    /**
    * StringBuilder is mutable class in Java stored in Heap Memory which serves as a second option of creating a
    * StringBuilder object of the input String and return the String. While the performance of StringBuilder is FAST,
    * the drawback is it not thread-safe.
    * */

    public static String reverseStringWithStringBuilder (String s) {
        if (s==null) throw new NullPointerException("input can not be null");
        int head =0, tail = s.length()-1;
        StringBuilder sb = new StringBuilder(s);
        while (head <= tail) {
            char temp = sb.charAt(tail);
            sb.setCharAt(tail--,sb.charAt(head));
            sb.setCharAt(head++,temp);
        }
        return sb.toString();
    }

    /**
    * StringBuffer is also a mutable class in Java stored in Heap memory which serves as an option for String class
    * performing different kind of operations on the String. It is also thread safe but the drawback being it has a
    * SLOW performance.
    * */

    public static String reverseStringWithStringBuffer (String s) {
        if (s==null) throw new NullPointerException("input can not be null");
        int head =0, tail = s.length()-1;
        StringBuffer sb = new StringBuffer(s);
        while (head <= tail) {
            char temp = sb.charAt(tail);
            sb.setCharAt(tail--,sb.charAt(head));
            sb.setCharAt(head++,temp);
        }
        return sb.toString();
    }
}
