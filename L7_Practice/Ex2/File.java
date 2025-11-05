public class File extends Document{
    private String pathname;
    File(String text,String pathname){super(text); this.pathname= pathname;}
    File(){this("TBD","Unknown pathname");}
    void setPathname(String pathname){this.pathname = pathname;}
    String getPathname(){return pathname;}

}
