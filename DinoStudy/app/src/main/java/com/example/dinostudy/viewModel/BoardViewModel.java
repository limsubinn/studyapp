package com.example.dinostudy.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.dinostudy.model.board.CreatePostData;
import com.example.dinostudy.model.board.CreatePostResponse;
import com.example.dinostudy.model.board.ReadPostResponse;
import com.example.dinostudy.model.todo.CreateTodoData;
import com.example.dinostudy.model.todo.CreateTodoResponse;
import com.example.dinostudy.repository.RetrofitClient;
import com.example.dinostudy.repository.ServiceApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BoardViewModel extends AndroidViewModel {
    public MutableLiveData<CreatePostResponse> createPostResult = new MutableLiveData<>();
    public MutableLiveData<ReadPostResponse> readPostResult = new MutableLiveData<>();

    ServiceApi service;


    public BoardViewModel(@NonNull Application application) {
        super(application);
        service = RetrofitClient.getClient().create(ServiceApi.class);

    }

    public void createPost (CreatePostData data) {
        System.out.println("********* createPostData *********");

        service.createPost(data).enqueue(new Callback<CreatePostResponse>() {
            @Override
            public void onResponse(Call<CreatePostResponse> call, Response<CreatePostResponse> response) {
                CreatePostResponse result = response.body();
                createPostResult.postValue(result);
                System.out.println("createPost resultCode: " + result.getCode());
            }

            @Override
            public void onFailure(Call<CreatePostResponse> call, Throwable t) {
                System.out.println("fail");
                t.printStackTrace();
            }
        });
    }

    public void readPost() {
        System.out.println("********* readPostData *********");

        service.readPost().enqueue(new Callback<ReadPostResponse>() {
            @Override
            public void onResponse(Call<ReadPostResponse> call, Response<ReadPostResponse> response) {
                ReadPostResponse result = response.body();
                readPostResult.postValue(result);
                System.out.println("read post resultCode: " + result.getCode());
            }

            @Override
            public void onFailure(Call<ReadPostResponse> call, Throwable t) {
                System.out.println("ReadPostResponse fail");
                t.printStackTrace();
            }
        });
    }

}