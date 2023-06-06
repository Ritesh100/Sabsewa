    package com.example.sabaesewa.adapter;

    import android.app.AlertDialog;
    import android.content.Context;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.ImageView;
    import android.widget.TextView;

    import androidx.annotation.NonNull;
    import androidx.recyclerview.widget.RecyclerView;

    import com.example.sabaesewa.R;
    import com.example.sabaesewa.ServiceProvider;

    import java.util.List;
    public class ServiceProviderAdapter extends RecyclerView.Adapter<ServiceProviderAdapter.ViewHolder> {
        private static Context context;
        private static List<ServiceProvider> providers;

        public ServiceProviderAdapter(Context context, List<ServiceProvider> providers) {
            this.context = context;
            this.providers = providers;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_provider_card, parent, false);
            return new ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            ServiceProvider provider = providers.get(position);
            holder.providerImageView.setImageResource(provider.getImageResId());
            holder.providerNameTextView.setText(provider.getName());
            holder.contactTextView.setText(provider.getContact());
            holder.addressTextView.setText(provider.getAddress());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Show the dialog when the card is clicked
                    holder.showServiceProviderDialog();
                }
            });
        }

        @Override
        public int getItemCount() {
            return providers.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            ImageView providerImageView;
            TextView providerNameTextView;
            TextView contactTextView;
            TextView addressTextView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                providerImageView = itemView.findViewById(R.id.providerImageView);
                providerNameTextView = itemView.findViewById(R.id.providerNameTextView);
                contactTextView = itemView.findViewById(R.id.contactTextView);
                addressTextView = itemView.findViewById(R.id.addressTextView);
            }
            private void showServiceProviderDialog() {
                int position = getAdapterPosition();
                ServiceProvider provider = providers.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View dialogView = LayoutInflater.from(context).inflate(R.layout.dialogue_service_provider, null);
                builder.setView(dialogView);

                // Retrieve the dialog views
                TextView nameTextView = dialogView.findViewById(R.id.nameTextView);
                TextView contactTextView = dialogView.findViewById(R.id.contactTextView);
                TextView addressTextView = dialogView.findViewById(R.id.addressTextView);
                EditText messageEditText = dialogView.findViewById(R.id.messageEditText);
                Button requestButton = dialogView.findViewById(R.id.requestButton);
                Button cancelButton = dialogView.findViewById(R.id.cancelButton);

                // Set the dialog content
                nameTextView.setText(provider.getName());
                contactTextView.setText(provider.getContact());
                addressTextView.setText(provider.getAddress());

                // Create the dialog
                AlertDialog dialog = builder.create();

                // Set the click listener for the request button
                requestButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String message = messageEditText.getText().toString().trim();
                        dialog.dismiss();
                    }
                });
                // Set the click listener for the cancel button
                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Dismiss the dialog
                        dialog.dismiss();
                    }
                });
                // Show the dialog
                dialog.show();
            }
        }

    }