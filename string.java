public class string extends varri {
    final String entered;
    String value;

    public string(String entered) {
        super(entered.substring(0, entered.indexOf(" ")));
        this.entered = entered;
        value = entered.substring(entered.indexOf(" ") +3);
    }

    public String toString(){
        return namevar + " = " + value;
    }
}
