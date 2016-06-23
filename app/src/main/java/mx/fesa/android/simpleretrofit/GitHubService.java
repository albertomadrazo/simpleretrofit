package mx.fesa.android.simpleretrofit;


import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GitHubService {
    @GET("repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> repoContributors(@Path("owner") String owner, @Path("repo") String repo );

    //@POST("loginao.php")
    //Call<SignIn> getUserLogin(@Field("usuario") String user, @Field("password") String password, Response<SignIn>);

    public static final Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.github.com/").addConverterFactory(GsonConverterFactory.create()).build();
}
