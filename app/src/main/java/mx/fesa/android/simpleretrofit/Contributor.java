package mx.fesa.android.simpleretrofit;


public class Contributor {
    String login;
    String html_url;

    int contributions;

    @Override
    public String toString(){
        return login + "(" + contributions + ")";
    }
}
