package adapter.recyclerview;

import android.graphics.drawable.Drawable;

/**
 * Created by Adik Widiasmono on 9/10/2015.
 */
public class Store {
    private String name;
    private Drawable icon;
    private Drawable background;
    private String description;
    private boolean isFavorite;

    public Store(String name, Drawable icon, Drawable background, String description, boolean isFavorite) {
        this.name = name;
        this.icon = icon;
        this.background = background;
        this.description = description;
        this.isFavorite = isFavorite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public Drawable getBackground() {
        return background;
    }

    public void setBackground(Drawable background) {
        this.background = background;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
}
