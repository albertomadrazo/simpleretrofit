package mx.fesa.android.simpleretrofit;


import com.google.gson.annotations.Expose;

public class SignIn {

    private static String usuario;
    private static String password;
    @Expose
    private static String status;

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        SignIn.status = status;
    }

    @Override
    public String toString(){
        return usuario;
    }
}
