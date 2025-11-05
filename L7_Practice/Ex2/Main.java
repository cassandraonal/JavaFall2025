public class Main{
   public static boolean ContainsKeyword(Document messageObject, String
keyword)
{
    if(messageObject.toString().indexOf(keyword,0) >= 0)
        return true;
    return false;
}
public static void main(String args[]){
    Document a = new Document("Hello world");
    System.out.println(a.getText());
    System.out.println(a);
    System.out.println(ContainsKeyword(a,"hello"));
    a = new Email("Hi how are you?","Greeting","Tom","Sam");
    System.out.println(a.getText());
    System.out.println(a);
    System.out.println(ContainsKeyword(a,"Hi"));
    a = new File("Timesheet","Home/work/time");
    System.out.println(a.getText());
    System.out.println(a);
    System.out.println(ContainsKeyword(a,"time"));
}
}
