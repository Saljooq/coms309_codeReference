package test.connect.myapplication;

import static test.connect.myapplication.api.ApiClientFactory.GetPhotoApi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import test.connect.myapplication.api.SlimCallback;
import test.connect.myapplication.model.Photo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView apiText1 = findViewById(R.id.activity_main_textView1);
        apiText1.setMovementMethod(new ScrollingMovementMethod());

        Button photoButton = findViewById(R.id.activity_main_button_for_photo);
        EditText photoNumInput = findViewById(R.id.activity_main_photoNum_input);

//        GetPhotoApi().getFirstPhoto().enqueue(new SlimCallback<Photo>(responsePhoto -> {
//            apiText1.setText(responsePhoto.printable());
//        }));

//        GetPhotoApi().getAllPhoto().enqueue(new SlimCallback<List<Photo>>(photos->{
//            apiText1.setText("");
//            for (int i = 0; i < photos.size(); i++){
//                apiText1.append(photos.get(i).printable());
//            }
//
//        }, "multiplePhotosApi"));


        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetPhotoApi().getPhotoByNum(photoNumInput.getText().toString()).enqueue(new SlimCallback<Photo>(photo ->{
                    apiText1.setText(photo.printable());
                }));
            }
        });

    }
}

