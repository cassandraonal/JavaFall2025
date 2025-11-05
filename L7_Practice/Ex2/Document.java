public class Document {
    private String text;

    Document(String text){
        this.text = text;
    }
    Document(){this("TBD");}
    void setText(String text){
        this.text = text;
    }
    String getText(){return text;}

}
