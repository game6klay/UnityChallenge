package csfundamentals;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jay on 7/28/17.
 */
public class StringReversalTestOne {
    @Test
    public void reverseString() throws NullPointerException {
        assertEquals("zab raboof",StringReversal.reverseString("foobar baz"));
        assertEquals("raboof",StringReversal.reverseString("foobar"));
        assertEquals("aaabbbaaa",StringReversal.reverseString("aaabbbaaa"));
        assertEquals("",StringReversal.reverseString(""));
        assertEquals("!doog si sihT",StringReversal.reverseString("This is good!"));
        assertEquals(" ",StringReversal.reverseString(" "));
        assertEquals("/ ",StringReversal.reverseString(" /"));
        assertEquals("'n/'",StringReversal.reverseString("'/n'"));
        assertEquals(".margelet swen tiawa I \".tnew\" s'tel\n" +
                "egraM",StringReversal.reverseString("Marge\n" +
                "let's \"went.\" I await news telegram."));

        assertEquals("\t",StringReversal.reverseString("\t"));
        assertEquals("\n",StringReversal.reverseString("\n"));
        assertEquals("008Du\\00CDu\\",StringReversal.reverseString("\\uDC00\\uD800"));
        assertEquals("\uD800\uDC00",StringReversal.reverseString("\uDC00\uD800"));
    }

    @Test
    public void reverseStringWithStringBuilder() throws NullPointerException {
        assertEquals("zab raboof",StringReversal.reverseString("foobar baz"));
        assertEquals("raboof",StringReversal.reverseString("foobar"));
        assertEquals("aaabbbaaa",StringReversal.reverseString("aaabbbaaa"));
        assertEquals("",StringReversal.reverseString(""));
        assertEquals("!doog si sihT",StringReversal.reverseString("This is good!"));
        assertEquals(" ",StringReversal.reverseString(" "));
        assertEquals("/ ",StringReversal.reverseString(" /"));
        assertEquals("'n/'",StringReversal.reverseString("'/n'"));
        assertEquals(".margelet swen tiawa I \".tnew\" s'tel\n" +
                "egraM",StringReversal.reverseString("Marge\n" +
                "let's \"went.\" I await news telegram."));

        assertEquals("\t",StringReversal.reverseString("\t"));
        assertEquals("\n",StringReversal.reverseString("\n"));
        assertEquals("008Du\\00CDu\\",StringReversal.reverseString("\\uDC00\\uD800"));
        assertEquals("\uD800\uDC00",StringReversal.reverseString("\uDC00\uD800"));

    }

    @Test
    public void reverseStringWithStringBuffer() throws NullPointerException {
        assertEquals("zab raboof",StringReversal.reverseString("foobar baz"));
        assertEquals("raboof",StringReversal.reverseString("foobar"));
        assertEquals("aaabbbaaa",StringReversal.reverseString("aaabbbaaa"));
        assertEquals("",StringReversal.reverseString(""));
        assertEquals("!doog si sihT",StringReversal.reverseString("This is good!"));
        assertEquals(" ",StringReversal.reverseString(" "));
        assertEquals("/ ",StringReversal.reverseString(" /"));
        assertEquals("'n/'",StringReversal.reverseString("'/n'"));
        assertEquals(".margelet swen tiawa I \".tnew\" s'tel\n" +
                "egraM",StringReversal.reverseString("Marge\n" +
                "let's \"went.\" I await news telegram."));

        assertEquals("\t",StringReversal.reverseString("\t"));
        assertEquals("\n",StringReversal.reverseString("\n"));
        assertEquals("\uD800\uDC00",StringReversal.reverseString("\uDC00\uD800"));
    }

}