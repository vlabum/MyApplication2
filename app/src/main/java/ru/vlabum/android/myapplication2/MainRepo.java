package ru.vlabum.android.myapplication2;

public class MainRepo {

    MainData mainData = new MainData();

    public String getHello() {
        return mainData.hello;
    }

    public String getSaved() {
        return mainData.savedText;
    }

    public void setSaved(final String text) {
        mainData.savedText = text;
    }

}
