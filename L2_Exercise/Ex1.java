public class Ex1 {
    public static void main(String [] args){
        String txt = "nyc";
        System.out.println(txt);
        txt = txt.toUpperCase();
        System.out.println(txt);
        txt = txt.replace('Y','e').replace('C','w');
        System.out.println(txt);
        txt = txt + " York";
        System.out.println(txt);
        txt = txt.concat(" City");
        System.out.println(txt);
        txt = txt.toLowerCase();
        System.out.println(txt);
        txt = txt.substring(9);
        System.out.println(txt);

    }
}
