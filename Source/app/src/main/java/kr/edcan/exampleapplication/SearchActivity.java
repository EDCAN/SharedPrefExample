package kr.edcan.exampleapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    EditText searchQuery;
    Button search;
    TextView searchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setDefault();
    }

    private void setDefault() {
        sharedPreferences = getSharedPreferences("WOW", MODE_PRIVATE);
        search = (Button) findViewById(R.id.searchButton);
        searchQuery = (EditText) findViewById(R.id.searchQuery);
        searchResult = (TextView) findViewById(R.id.result);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = searchQuery.getText().toString().trim();
                if (s.equals("")) {
                    searchQuery.setError("공백 없이 입력해주세요");
                } else {
                    if (sharedPreferences.getAll().containsKey(s)) {
                        searchResult.setText(s + "의 전화번호는 " + sharedPreferences.getString(s, "") + "입니다");
                    } else{
                        searchResult.setText("검색된 결과가 없습니다.");
                    }
                }

            }
        });
    }
}
