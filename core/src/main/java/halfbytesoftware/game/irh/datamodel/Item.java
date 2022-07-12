package halfbytesoftware.game.irh.datamodel;

import java.util.ArrayList;
import java.util.List;

public class Item {
    // variables
    private long m_id;
    private String m_name;
    private boolean m_identified;
    private int m_iLvl;
    private List<Affix> m_affixes;

    // methods
    public Item(long id, String name, boolean identified, int iLvl){
        this.m_id = id;
        this.m_name = name;
        this.m_identified = identified;
        this.m_iLvl = iLvl;
        this.m_affixes = new ArrayList<>();
    }
}
