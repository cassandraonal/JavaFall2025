public class test {
    public static void main(String [] args){
        char d = 'A'; // A-Z, a-z, 0-9, , . ?
        d = '?';
        d = '1';
        d = 'a';
        d = ' ';
        d = '\t';
        d = '\n';
        d = '\u4E54'; //乔
        System.out.println(d);
        d = '\u0041'; //A
        System.out.println(d);
        d = '\uAC00'; //가
        System.out.println(d);
        d = '\u3051'; //け
        System.out.println(d);
    }
}