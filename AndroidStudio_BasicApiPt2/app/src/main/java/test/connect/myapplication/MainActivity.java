package test.connect.myapplication;

import static test.connect.myapplication.api.ApiClientFactory.GetPostApi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.connect.myapplication.api.SlimCallback;
import test.connect.myapplication.model.Post;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView apiText1 = findViewById(R.id.activity_main_textView1);

        GetPostApi().getFirstPost().enqueue(new SlimCallback<Post>(response -> {
         String result = "ID:  "+ response.getId()
         +"\n  Title:  "+ response.getTitle()
         +"\n  Body:    "+ response.getBigText();
         apiText1.setText(result);
        }, "CustomTagForFirstApi"));
    }
}

