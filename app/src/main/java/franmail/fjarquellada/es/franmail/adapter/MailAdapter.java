package franmail.fjarquellada.es.franmail.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import franmail.fjarquellada.es.franmail.R;
import franmail.fjarquellada.es.franmail.model.Mail;
import franmail.fjarquellada.es.franmail.util.Util;

/**
 * Created by francisco on 25/3/18.
 */

public class MailAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    protected List<Mail> list;
    private int SUBJECT_MAX_LENGHT = 40;
    private int MESSAGE_MAX_LENGHT = 80;

    public MailAdapter(Context context, int layout, List<Mail> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Mail getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, null);
            holder = new ViewHolder();
            holder.subject = (TextView) convertView.findViewById(R.id.textViewListSubject);
            holder.message = (TextView) convertView.findViewById(R.id.textViewListMessage);
            holder.sender = (TextView) convertView.findViewById(R.id.textViewListSenderName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        Mail currentMail = getItem(position);

        // Si el título del correo es más corto de 40 letras, lo dejamos igual, si es más largo,
        // lo cortamos y le añadimos puntos suspensivos al final
        String shortSubject;
        if (currentMail.getSubject().length() > SUBJECT_MAX_LENGHT) {
            shortSubject = currentMail.getSubject().substring(0, SUBJECT_MAX_LENGHT) + "...";
        } else {
            shortSubject = currentMail.getSubject();
        }
        holder.subject.setText(shortSubject);


        // Si el mensaje de correo es más corto de 80 letras, lo dejamos igual, si es más largo,
        // lo cortamos y le añadimos puntos suspensivos al final
        String shortMessage;
        if (currentMail.getBody().length() > MESSAGE_MAX_LENGHT) {
            shortMessage = currentMail.getBody().substring(0, MESSAGE_MAX_LENGHT) + "...";
        } else {
            shortMessage = currentMail.getBody();
        }
        holder.message.setText(shortMessage);

        // Cogemos sólo la primera letra del correo
        holder.sender.setText(currentMail.getMailTo().substring(0, 1));
        // Obtenemos el backround que es un drawable, y le cambiamos el color con el random color
        holder.sender.getBackground().setColorFilter(Color.parseColor("#" + Util.getRandomColor()), PorterDuff.Mode.SRC);

        return convertView;
    }

    static class ViewHolder {
        private TextView subject;
        private TextView message;
        private TextView sender;
    }
}
