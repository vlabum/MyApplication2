package ru.vlabum.android.myapplication2;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MainViewModel viewModel = new MainViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewToast(viewModel.viewHelloWorld().getValue());
        viewModel.viewHelloWorld().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String value) {
                viewToast(value);
            }
        });
        viewModel.viewSavedText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                viewToast(s);
                updateTextView(s);
            }
        });
    }

    private void viewToast(String value) {
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
    }


    private void updateTextView(String value) {
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(value);
    }

    protected void clickListener(final View v) {
        EditText edit = (EditText)findViewById(R.id.editText2);
        viewModel.setSave(edit.getText().toString());
    }

}
