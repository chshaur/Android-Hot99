package tw.com.hot99.hot99;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {

    private WebView hot99_webview ;
    private String myUrl = new String("http://www.09ya63ke0202ny180wr75.com.tw/rsadmin/andform.php?id=");
    private EditText mPhone;
    private Button btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        mPhone = (EditText) findViewById(R.id.editText);
        btnEnter = (Button) findViewById(R.id.button);
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPhone.getText().toString().trim().length() != 0){
                    new AlertDialog.Builder(WebActivity.this)
                            .setTitle("前往我的火紅超市")
                            .setMessage("即將另外開啟瀏覽器進入會員專屬的火紅超市 !!")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    hot99_webview = new WebView(WebActivity.this);
                                    myUrl = myUrl + mPhone.getText()  ;
                                    Intent tarIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(myUrl));
                                    startActivity(tarIntent);
                                    finish();
                                }
                            })
                            .show();
                }else{
                    Toast.makeText(WebActivity.this, "請先輸入會員編號(手機號碼)", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
