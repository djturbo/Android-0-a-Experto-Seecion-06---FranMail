package franmail.fjarquellada.es.franmail.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import franmail.fjarquellada.es.franmail.R;
import franmail.fjarquellada.es.franmail.model.Mail;


public class MailDetailFragment extends Fragment {
    private TextView textViewSubject;
    private TextView textViewSender;
    private TextView textViewMessage;
    private LinearLayout wrapper;

    public MailDetailFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mail_detail, container, false);

        textViewSubject = (TextView) view.findViewById(R.id.textViewFragmentSubject);
        textViewSender = (TextView) view.findViewById(R.id.textViewFragmentSenderName);
        textViewMessage = (TextView) view.findViewById(R.id.textViewFragmentMessage);
        wrapper = (LinearLayout) view.findViewById(R.id.fragmentDetailsMailWrapper);
        return view;
    }


    public void renderMail(Mail mail) {
        wrapper.setVisibility(View.VISIBLE);
        textViewSubject.setText(mail.getSubject());
        textViewSender.setText(mail.getMailTo());
        textViewMessage.setText(mail.getBody());
    }
}
