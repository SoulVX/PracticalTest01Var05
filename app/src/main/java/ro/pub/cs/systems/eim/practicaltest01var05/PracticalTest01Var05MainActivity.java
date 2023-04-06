package ro.pub.cs.systems.eim.practicaltest01var05;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var05MainActivity extends AppCompatActivity {

    Button secondActivityButton;
    Button topLeftButton;
    Button topRightButton;
    Button centerButton;
    Button bottomLeftButton;
    Button bottomRightButton;

    TextView currentStringTextView;

    int totalPush;

    StringBuilder currentString;

    int threshold;

    private IntentFilter intentFilter = new IntentFilter();

    private MessageBroadcastReceiver messageBroadcastReceiver = new MessageBroadcastReceiver();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_main);

        secondActivityButton = findViewById(R.id.secondActivityButton);
        topLeftButton = findViewById(R.id.button_top_left);
        topRightButton = findViewById(R.id.button_top_right);
        centerButton = findViewById(R.id.button_center);
        bottomLeftButton = findViewById(R.id.button_bottom_left);
        bottomRightButton = findViewById(R.id.button_bottom_right);
        currentStringTextView = findViewById(R.id.result_text);
        currentString = new StringBuilder();
        totalPush = 0;
        threshold = 5;
        intentFilter.addAction(Intent.ACTION_BATTERY_LOW);

        topLeftButton.setOnClickListener(view -> {
            currentString.append("Top Left,");
            currentStringTextView.setText(currentString.toString());
            totalPush++;
            if(totalPush > threshold) {
                Intent intent = new Intent(this, PracticalTest01Var05Service.class);
                intent.putExtra("sablon", currentString.toString());
                getApplicationContext().startService(intent);
            }
        });

        topRightButton.setOnClickListener(view -> {
            currentString.append("Top Right,");
            currentStringTextView.setText(currentString.toString());
            totalPush++;
            if(totalPush > threshold) {
                Intent intent = new Intent(this, PracticalTest01Var05Service.class);
                intent.putExtra("sablon", currentString.toString());
                getApplicationContext().startService(intent);
            }
        });

        centerButton.setOnClickListener(view -> {
            currentString.append("Center,");
            currentStringTextView.setText(currentString.toString());
            totalPush++;
            if(totalPush > threshold) {
                Intent intent = new Intent(this, PracticalTest01Var05Service.class);
                intent.putExtra("sablon", currentString.toString());
                getApplicationContext().startService(intent);
            }
        });

        bottomLeftButton.setOnClickListener(view -> {
            currentString.append("Bottom Left,");
            currentStringTextView.setText(currentString.toString());
            totalPush++;
            if(totalPush > threshold) {
                Intent intent = new Intent(this, PracticalTest01Var05Service.class);
                intent.putExtra("sablon", currentString.toString());
                getApplicationContext().startService(intent);
            }
        });

        bottomRightButton.setOnClickListener(view -> {
            currentString.append("Bottom Right,");
            currentStringTextView.setText(currentString.toString());
            totalPush++;
            if(totalPush > threshold) {
                Intent intent = new Intent(this, PracticalTest01Var05Service.class);
                intent.putExtra("sablon", currentString.toString());
                getApplicationContext().startService(intent);
            }
        });

        secondActivityButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, PracticalTest01Var05SecondActivity.class);
            intent.putExtra("sablon", currentString.toString());
            startActivityForResult(intent, 1);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(messageBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(messageBroadcastReceiver);
    }

    @Override
    protected void onDestroy() {
        Intent intent = new Intent(this, PracticalTest01Var05Service.class);
        stopService(intent);
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("textViewValue", currentString.toString());
        outState.putInt("totalPush", totalPush);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState.containsKey("textViewValue")) {
            currentStringTextView.setText(savedInstanceState.getString("textViewValue"));
        }
        if(savedInstanceState.containsKey("totalPush"))
            Toast.makeText(this, savedInstanceState.getInt("totalPush") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1) {
            if(resultCode == RESULT_OK) {
                Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show();
            } else if(resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
            }
            totalPush = 0;
            currentString = new StringBuilder();
            currentStringTextView.setText("");
        }
    }
}