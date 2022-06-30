package halfbytesoftware.game.irh;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class UiItem extends Group {
    // variables


    // methods
    public UiItem(){
        // table to hold everything
        Table table = new TableWithBackground(Color.YELLOW);
        table.setFillParent(true);
        table.pad(4);
        table.defaults().space(4);

        // name
        Label name = new Label("Sword of Truth", GameAssetManager.getInstance().getLabelStyle(32));
        table.add(name).expand().fill();
    }
}
