package com.genshin.artifactsimulator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.dialog.MaterialDialogs;
import com.google.android.material.transition.MaterialArcMotion;
import java.util.List;

import com.genshin.artifactsimulator.databinding.ArtifactBinding;
import com.genshin.artifactsimulator.databinding.InfoArtifactBinding;

public class ArtifactAdapter extends RecyclerView.Adapter<ArtifactAdapter.ArtifactViewHolder> {
    private List<Artifact> artifacts;
    private Context context;

    public ArtifactAdapter(List<Artifact> artifacts, Context context) {
        this.artifacts = artifacts;
        this.context = context;
    }

    @NonNull
    @Override
    public ArtifactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ArtifactBinding binding = ArtifactBinding.inflate(inflater, parent, false);
        return new ArtifactViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtifactViewHolder holder, int position) {
        Artifact artifact = artifacts.get(position);
        holder.binding.artifactName.setText(artifact.getSetName());
        holder.binding.artifactImage.setImageResource(artifact.getResourceID());
        
        holder.binding.artifactLayout.setOnClickListener(v -> {
            showArtifactDetails(artifact);
        });
    }

    @Override
    public int getItemCount() {
        return artifacts.size();
    }

    private void showArtifactDetails(Artifact artifact) {
        InfoArtifactBinding infoBinding = InfoArtifactBinding.inflate(LayoutInflater.from(context));

        infoBinding.artifactIcon.setImageResource(artifact.getResourceID());
        infoBinding.artifactName.setText(artifact.getArtifactTypeString());
        infoBinding.artifactSetname.setText(artifact.getSetName());

        String mainStatType = artifact.getMainStatType();
        MainStat<?> mainStatValue = artifact.getMainStatValue();

        String mainStatString;

        if (mainStatValue.getValue() instanceof Float) {
            mainStatString =
                    String.format("%s: %.1f%%", mainStatType, (Float) mainStatValue.getValue());
        } else {
            mainStatString =
                    String.format("%s: %d", mainStatType, (Integer) mainStatValue.getValue());
        }

        infoBinding.artifactMainstat.setText(mainStatString);

        new MaterialAlertDialogBuilder(context).setView(infoBinding.getRoot()).show();
    }

    private void removeArtifact(int position) {
        artifacts.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, artifacts.size());
    }
    
    public void wipeArtifacts() {
        if (!artifacts.isEmpty()) {
           new MaterialAlertDialogBuilder(context).setTitle(R.string.wipe_title)
        .setMessage(R.string.wipe_msg)
        .setPositiveButton("Yes", (dialog, which) -> {
            artifacts.clear();
            notifyDataSetChanged();
        })
        .setNegativeButton("No", (dialog, which) -> {
            dialog.dismiss();
        }).show();
        }
    }

    static class ArtifactViewHolder extends RecyclerView.ViewHolder {
        final ArtifactBinding binding;

        ArtifactViewHolder(ArtifactBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}