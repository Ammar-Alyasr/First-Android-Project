package com.dedikodu.thesecondandrdap;

import android.content.Intent;
import android.service.voice.VoiceInteractionService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String KullaniciAdi;
    EditText KullaniciAdiText;
    String[] Kullanicilar;
    List<String> kullanicilar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        KullaniciAdiText= (EditText) findViewById(R.id.editText);
        kullanicilar = new ArrayList<String>();
        kullanicilar.add("ammar");
        kullanicilar.add("sagbas");
        Kullanicilar = new String[7];
        Kullanicilar[0] = "ensar";
        Kullanicilar[1] = "ammar";
        Kullanicilar[2] = "caglar";
        Kullanicilar[3] = "yavuz";
        Kullanicilar[4] = "emre";
        Kullanicilar[5] = "faisal";
        Kullanicilar[6] = "arif";


         //KullaniciAdi = KullaniciAdiText.getText().toString();
    }





    public void KayitOlBasildi(View view){
        Intent i = new Intent(this, KayitOlActivity.class);  //Kayitol Basilnda kayitOla gider ...
        startActivity(i);
    }

    public void SifreHatirlaBasildi(View view){
        Intent r= new Intent(this, SifreHatirlama.class);//SifreHAtirla Basilnda Sifre hatirlaya gider ...
        startActivity(r);
    }

    public void GirisYapBasildi(View view){

        KullaniciAdi = KullaniciAdiText.getText().toString();
        Intent y= new Intent(this, Paylasim.class);
        int m,sayac=0;
        for (m=0;m<kullanicilar.size();m++){
            if (KullaniciAdi.equals(kullanicilar.get(m).toString())){
                y.putExtra("KullaniciAdi",kullanicilar.get(m).toString());
                startActivity(y);
                sayac++;
            }
        }
        if(sayac==0)
        Toast.makeText(this,KullaniciAdi+" isim yok",Toast.LENGTH_LONG).show();
    }

    public void KayitIcinBasildi(View view){
        Intent k = new Intent(this, MainActivity.class);
        Toast.makeText(this , "Kayitin Tamamlanmistir,",Toast.LENGTH_SHORT).show();
        Toast.makeText(this , "Giris Yap",Toast.LENGTH_SHORT).show();

        startActivity(k);
    }

    public void GonderBasildi(View view){
        Intent s= new Intent(this, MainActivity.class);
        Toast.makeText(this , "Tekrar giris yap",Toast.LENGTH_SHORT).show();

        startActivity(s);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
