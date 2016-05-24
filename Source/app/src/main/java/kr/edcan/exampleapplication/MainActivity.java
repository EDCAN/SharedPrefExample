package kr.edcan.exampleapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText key, value;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button save, search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDefault();
    }

    private void setDefault() {
        sharedPreferences = getSharedPreferences("WOW", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        save = (Button) findViewById(R.id.save);
        search = (Button) findViewById(R.id.search_start);
        key = (EditText) findViewById(R.id.name);
        value = (EditText) findViewById(R.id.number);
        search.setOnClickListener(this);
        save.setOnClickListener(this);
    }

    private void saveToDB() {
        String keyString = key.getText().toString().trim();
        String valueString = value.getText().toString().trim();

        if (keyString.equals("") || valueString.equals("")) {
            Toast.makeText(this, "공백 없이 입력해주세요!", Toast.LENGTH_SHORT).show();
        } else {
            editor.putString(keyString, valueString);
            editor.commit();
            Toast.makeText(this, keyString + " " + valueString + " 저장되었습니다", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                saveToDB();
                break;
            case R.id.search_start:
                startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                break;
        }
    }


}
