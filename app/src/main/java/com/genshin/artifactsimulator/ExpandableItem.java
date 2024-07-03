package com.genshin.artifactsimulator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

public class ExpandableItem extends FrameLayout {
    private LayoutInflater inflater;
    private View collapsedView;
    private View expandedView;
    private boolean isExpanded = false;
    
    public ExpandableItem(Context context) {
        super(context);
    }
    
    public ExpandableItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    public ExpandableItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}