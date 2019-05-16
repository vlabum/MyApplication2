package ru.vlabum.android.myapplication2;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    MainRepo repo = new MainRepo();

    private MutableLiveData<String> viewHelloWorld = new MutableLiveData<>();

    private MutableLiveData<String> viewSaved = new MutableLiveData<>();

    public MainViewModel() {
        viewHelloWorld.setValue(repo.getHello());
    }

    public LiveData<String> viewHelloWorld() {
       return viewHelloWorld;
    }

    public LiveData<String> viewSavedText() {
        return viewSaved;
    }

    public void setSave(final String text) {
        repo.setSaved(text);
        viewSaved.setValue(repo.getSaved());
    }

}
