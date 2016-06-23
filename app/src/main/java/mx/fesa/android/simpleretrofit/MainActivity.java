package mx.fesa.android.simpleretrofit;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    // libreria butterknife, sirve para
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // no entiendo esto!
        ButterKnife.bind(this);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
/*                // haces una instancia de la interface GitHubService y le creas un retrofit
                GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);

                // Call, de dónde viene?
                final Call<List<Contributor>> call = gitHubService.repoContributors("square", "retrofit");
                //final Call<List<SignIn>> call = gitHubService.getUserLogin("beto", "html", Response<SignIn>);
                // enqueue, de dónde viene?
                call.enqueue(new Callback<List<Contributor>>() {
                    // on success!
                    @Override
                    public void onResponse(Call<List<Contributor>> call, Response<List<Contributor>> response) {
                        final TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText(response.body().toString());
                    }
                    // not successful
                    @Override
                    public void onFailure(Call<List<Contributor>> call, Throwable t) {
                        final TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Something went wrong: " + t.getMessage());
                    }
                });*/

                LogUser logUser = LogUser.retrofit.create(LogUser.class);
                final Call<SignIn> call = logUser.authenticate("beto", "lolo");


                call.enqueue(new Callback<SignIn>() {
                    @Override
                    public void onResponse(Call<SignIn> call, Response<SignIn> response) {
                        Log.i("jfdkljsdf", "Entrale");

                        final TextView textView = (TextView) findViewById(R.id.textView);
                        // Log.i(">>>>>>>>>>>>>>>>> ", response.toString());
                        if(response.headers().toString() == null){
                            Log.i(">>>>>>>>>>>>>> ", "The body is empty");
                        }
                        Log.i(">>>>>>>>>>>>>>>>> ", response.headers().toString());

                        textView.setText(response.headers().toString()); //response.body().toString());

                    }

                    @Override
                    public void onFailure(Call<SignIn> call, Throwable t) {
                        final TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText(call.toString());
                    }
                });
            }
        });
    }
}
