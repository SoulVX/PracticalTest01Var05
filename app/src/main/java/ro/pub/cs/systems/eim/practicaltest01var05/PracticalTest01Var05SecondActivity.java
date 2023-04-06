package ro.pub.cs.systems.eim.practicaltest01var05;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var05SecondActivity extends AppCompatActivity {
    Button verifyButton;
    Button cancelButton;
    TextView secondTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_secondary);
        verifyButton = findViewById(R.id.verify_button);
        cancelButton = findViewById(R.id.cancel_button);
        secondTextView = findViewById(R.id.second_text_view);

        verifyButton.setOnClickListener(view -> {
            setResult(RESULT_OK);
            finish();
        });

        cancelButton.setOnClickListener(view -> {
            setResult(RESULT_CANCELED);
            finish();
        });

        secondTextView.setText(getIntent().getStringExtra("sablon"));
    }
}
