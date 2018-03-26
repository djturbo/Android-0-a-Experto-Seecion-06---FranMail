package franmail.fjarquellada.es.franmail.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import franmail.fjarquellada.es.franmail.R;
import franmail.fjarquellada.es.franmail.fragment.MailDetailFragment;
import franmail.fjarquellada.es.franmail.model.Mail;

public class DetailActivity extends AppCompatActivity {
    private String subject;
    private String body;
    private String mailTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (getIntent().getExtras() != null) {
            subject = getIntent().getStringExtra("subject");
            body = getIntent().getStringExtra("body");
            mailTo = getIntent().getStringExtra("mailTo");
        }

        Mail mail = new Mail(subject, body, mailTo);

        MailDetailFragment detailsFragment = (MailDetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentDetailMail);
        detailsFragment.renderMail(mail);
    }
}
