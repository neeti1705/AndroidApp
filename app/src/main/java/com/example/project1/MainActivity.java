package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView responseText;
    APIinterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responseText = (TextView) findViewById(R.id.textview);
        //apiInterface = APIClient.getClient().create(APIinterface.class);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dummyapi.io").addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(APIinterface.class);
        Call<List<Post>> call = apiInterface.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

              if (!response.isSuccessful())  {
                  responseText.setText("Code: "+ response.code());
                  return;
              }
              List<Post> posts = response.body();

              for(Post post: posts)
              {
                  String content="";
                  content += post.getText() + "\n" ;
                  content += post.getLikes() + " Likes" + "\n";
                  content +=  "Posted on: " + post.getPublishDate() + "\n";

                  responseText.append(content);

              }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                responseText.setText(t.getMessage());

            }
        });
    }
}