package mx.fesa.android.simpleretrofit;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LogUser {
    @FormUrlEncoded
    @POST("/login.php")
    Call<SignIn> logUser(@Field("user") String user, @Field("password") String password);

    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://granfonda.com").addConverterFactory(GsonConverterFactory.create()).build();
}
