package uoft.csc207.gameproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import uoft.csc207.gameproject.R;

public class GameMenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamemenu);
        String viewName = getIntent().getStringExtra("View");
        setOnClickListeners(viewName);
    }

    private void setOnClickListeners(String viewName){
        Button start = findViewById(R.id.btnNewGame);
        Button load = findViewById(R.id.btnContinue);
        Button start2 = findViewById(R.id.btnNewLevelTwo);
        Button start3 = findViewById(R.id.btnNewLevelThree);
        final String gameName = viewName;
        start.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameMenuActivity.this, GameActivity.class);
                intent.putExtra("Operation","NewGame");
                intent.putExtra("View",gameName);
                startActivity(intent);
            }
        });
        start2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameMenuActivity.this, GameActivity.class);
                intent.putExtra("Operation","2");
                intent.putExtra("View",gameName);
                startActivity(intent);
            }
        });
        start3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameMenuActivity.this, GameActivity.class);
                intent.putExtra("Operation","3");
                intent.putExtra("View",gameName);
                startActivity(intent);
            }
        });
        load.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameMenuActivity.this, GameActivity.class);
                intent.putExtra("Operation","LoadGame");
                intent.putExtra("View",gameName);
                startActivity(intent);
            }
        });
    }
}
