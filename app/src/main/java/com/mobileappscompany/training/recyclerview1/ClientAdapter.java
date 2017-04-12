package com.mobileappscompany.training.recyclerview1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by ferna on 2/9/2017.
 */

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientViewHolder> {

    private List<Client> mClients;
    public Context ctx;


    public class ClientViewHolder extends  RecyclerView.ViewHolder{
        public LinearLayout cLL;
        public TextView cName;
        public TextView cPhone;

        public ClientViewHolder(View itemView) {
            super(itemView);
            cName = (TextView) itemView.findViewById(R.id.item_name);
            cPhone = (TextView) itemView.findViewById(R.id.item_phone);
            cLL = (LinearLayout) itemView.findViewById(R.id.ll);
        }
    }

    public ClientAdapter(List<Client> mClients, Context cx) {

        this.mClients = mClients;
        ctx = cx;
    }

    @Override
    public ClientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_data, parent, false);

        return new ClientViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ClientViewHolder holder, int position) {
        Client thisClient = mClients.get(position);

        holder.cName.setText(thisClient.getName());
        holder.cPhone.setText(thisClient.getPhone());
  s      holder.cLL.setTag("Hello");

        holder.cLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout ll = (LinearLayout)v;
                String s = ((TextView)ll.getChildAt(0)).getText().toString() + " " +
                        ((TextView)ll.getChildAt(1)).getText().toString() + " " +
                        ll.getTag()
                        ;

                Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mClients.size();
    }
}
