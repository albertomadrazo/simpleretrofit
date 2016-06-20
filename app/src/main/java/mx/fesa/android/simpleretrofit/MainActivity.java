package mx.fesa.android.simpleretrofit;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
                // haces una instancia de la interface GitHubService y le creas un retrofit
                GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);

                // Call, de dónde viene?
                final Call<List<Contributor>> call =
                        gitHubService.repoContributors("square", "retrofit");

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
                });
            }
        });
    }
}