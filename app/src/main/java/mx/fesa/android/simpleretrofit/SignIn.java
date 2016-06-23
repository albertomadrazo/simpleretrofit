package mx.fesa.android.simpleretrofit;


import com.google.gson.annotations.SerializedName;

public class SignIn {

    private static String usuario;
    private static String password;

    int status;

/*    public static String getStatus() {
        return status;
    }*/

//    public static void setStatus(String status) {
//        SignIn.status = status;
//    }

    @Override
    public String toString(){
        return "status: " + status;
    }
}
