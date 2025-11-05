public class Email extends Document{
    private String sender;
    private String recip;
    private String title;
    Email(String text, String sender, String recip, String title){
        super(text);
        this.sender = sender;
        this.recip = recip;
        this.title = title;
    }
    Email(){this("TBD", "Unknown sender", "Unknown recip", "None" );}
    String getSender(){return sender;}
    String getRecip(){return recip;}
    String getTitle(){return title;}
    void setSender(String sender){this.sender = sender;}
    void setRecip(String recip){this.recip = recip;}
    void setTitle(String title){this.title = title;}
}
