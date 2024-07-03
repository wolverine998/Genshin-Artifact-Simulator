package com.genshin.artifactsimulator;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.genshin.artifactsimulator.databinding.ActivityMainBinding;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArtifactAdapter artifactAdapter;
    private Domain domain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate and get instance of binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // set content view to binding's root
        setContentView(binding.getRoot());

        domain = new Domain("Faded Theatre", "Fragment of Harmonic Whimsy", "Unfinished Reverie");

        binding.simulateButton.setOnClickListener(
                v -> {
                    printVersion();
                });

        binding.recyclerView.addOnScrollListener(
                new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dX, int dY) {
                        super.onScrolled(recyclerView, dX, dY);

                        if (Math.abs(dY) > 5) {
                            if (dY > 0) binding.simulateButton.shrink();
                            else binding.simulateButton.extend();
                        }
                    }
                });
        
        binding.appBar.setOnMenuItemClickListener(new MaterialToolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                    if (artifactAdapter != null) {
                        int itemId = item.getItemId();
                        if (itemId == R.id.action_wipe) {
                            artifactAdapter.wipeArtifacts();
                            return true;
                        }
                    }
                    return false;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.binding = null;
    }

    private void simulateDrops() {
        artifactAdapter = new ArtifactAdapter(domain.simulateArtifactDrops(50), this);

        binding.recyclerView.setAdapter(artifactAdapter);
    }
    
    private void printVersion() {
        String version = System.getProperty("java.vm.version");
        Toast.makeText(this, "ART version: " + version, Toast.LENGTH_LONG).show();
    }
}