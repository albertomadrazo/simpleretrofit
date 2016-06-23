package mx.fesa.android.simpleretrofit;


public class Usuario {
    String usuario;
    String id;

    @Override
    public String toString(){
        return usuario + ": " + id;
    }
}
