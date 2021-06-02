package sg.edu.rp.c346.id20042755.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvTranslatedText, tvTranslatedText2, tvTranslatedText3;
    String Option1 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTranslatedText = findViewById(R.id.TextDBS);
        tvTranslatedText2 = findViewById(R.id.TextOCBC);
        tvTranslatedText3 = findViewById(R.id.TextUOB);
        registerForContextMenu(tvTranslatedText);
        registerForContextMenu(tvTranslatedText2);
        registerForContextMenu(tvTranslatedText3);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.EnglishSelection){
            tvTranslatedText.setText("DBS");
            tvTranslatedText2.setText("OCBC");
            tvTranslatedText3.setText("UOB");
        }
        else if(item.getItemId() == R.id.ChineseSelection){
            tvTranslatedText.setText("星展银行");
            tvTranslatedText2.setText("华侨银行");
            tvTranslatedText3.setText("大华银行");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        if(v == tvTranslatedText){
            Option1 = "DBS";
            menu.add(0,0,0,"Website");
            menu.add(0,1,1,"Call The Bank");
            menu.add(0,2,2,"Favourite");

        } else if(v == tvTranslatedText2){
            Option1 = "OCBC";
            menu.add(0,0,0,"Website");
            menu.add(0,1,1,"Call The Bank");
            menu.add(0,2,2,"Favourite");

        }
        else if(v == tvTranslatedText3){
            Option1 = "UOB";
            menu.add(0,0,0,"Website");
            menu.add(0,1,1,"Call The Bank");
            menu.add(0,2,2,"Favourite");

        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (Option1 == "DBS"){
            if (item.getItemId() == 0){
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(i);

            }
            else if  (item.getItemId() == 1){
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "1800111111"));
                startActivity(i);
        }
            else if (item.getItemId() == 2){
                if(tvTranslatedText.getCurrentTextColor() ==  Color.BLACK){
                tvTranslatedText.setTextColor(Color.RED);
                    }
                else if(tvTranslatedText.getCurrentTextColor() == Color.RED){
                    tvTranslatedText.setTextColor(Color.BLACK);
                }
            }
        }
        else if (Option1 == "OCBC"){
            if (item.getItemId() == 0){
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(i);

            }
            else if  (item.getItemId() == 1){
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                startActivity(i);
            }
            else if (item.getItemId() == 2){
                if(tvTranslatedText2.getCurrentTextColor() ==  Color.BLACK){
                    tvTranslatedText2.setTextColor(Color.RED);
                }
                else if(tvTranslatedText2.getCurrentTextColor() == Color.RED){
                    tvTranslatedText2.setTextColor(Color.BLACK);
                }
            }

        }
        else if (Option1 == "UOB"){
            if (item.getItemId() == 0){
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(i);

            }
            else if  (item.getItemId() == 1){
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
                startActivity(i);
            }
            else if (item.getItemId() == 2){
                if(tvTranslatedText3.getCurrentTextColor() ==  Color.BLACK){
                    tvTranslatedText3.setTextColor(Color.RED);
                }
                else if(tvTranslatedText3.getCurrentTextColor() == Color.RED){
                    tvTranslatedText3.setTextColor(Color.BLACK);
                }
            }

        }
        return super.onContextItemSelected(item);
    }

}