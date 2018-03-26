package franmail.fjarquellada.es.franmail.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import franmail.fjarquellada.es.franmail.R;
import franmail.fjarquellada.es.franmail.fragment.ListFragment;
import franmail.fjarquellada.es.franmail.fragment.MailDetailFragment;
import franmail.fjarquellada.es.franmail.model.Mail;

public class MainActivity extends AppCompatActivity implements ListFragment.OnFragmentInteractionListener {

    private boolean isMultipanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMultipanel();
    }



    private void setMultipanel(){
        this.isMultipanel = getSupportFragmentManager().findFragmentById(R.id.fragmentDetailMail) != null;
    }


    @Override
    public void onListClick(Mail mail) {
        if(isMultipanel){
            MailDetailFragment fragment = (MailDetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentDetailMail);
            fragment.renderMail(mail);
        }else{
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("body", mail.getBody());
            intent.putExtra("subject", mail.getSubject());
            intent.putExtra("mailTo", mail.getMailTo());
            startActivity(intent);
        }
    }
}
