package halfbytesoftware.game.irh;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;

public class TableWithBackground extends Table {
    // variables


    // methods
    public TableWithBackground(Color color){
        NinePatchDrawable background = new NinePatchDrawable(GameAssetManager.getInstance().getNinePatch("panel_thin.png")).tint(color);
        this.setBackground(background);
        this.pad(4);
        this.defaults().space(4);
    }
}
