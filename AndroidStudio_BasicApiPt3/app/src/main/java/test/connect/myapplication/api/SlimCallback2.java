package test.connect.myapplication.api;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SlimCallback2<T> implements Callback<T> {

    LambdaInterface2<T> lambdaInterface2;

    String logTag;



    public SlimCallback2(LambdaInterface2<T> lambdaInterface2){
        this.lambdaInterface2 = lambdaInterface2;
    }

    public SlimCallback2(LambdaInterface2<T> lambdaInterface2, String customTag){
        this.lambdaInterface2 = lambdaInterface2;
        this.logTag = customTag;
    }



    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        if (response.isSuccessful()){
            lambdaInterface2.doSomething(response.body());
        }
        else{
            Log.d(logTag, "Code:  "+response.code() + "    Msg:  "+response.message());
        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

        Log.d(logTag, "Thrown:  "+t.getMessage());

    }
}
