package halfbytesoftware.game.irh.datamodel;

import java.util.EnumMap;
import java.util.Map;

public class Character {
    // variables
    private long m_id;
    private String m_name;
    private int m_graphic;
    private int m_level;
    private Map<enums.EAttributeType, Attribute> m_attributes;
    private Inventory m_inventory;
    private Map<enums.EItemSlot, Item> m_equipment;

    // methods
    public Character(long id, String name, int graphic, int level){
        this.m_id = id;
        this.m_name = name;
        this.m_graphic = graphic;
        this.m_level = level;
        this.m_attributes = new EnumMap<enums.EAttributeType, Attribute>(enums.EAttributeType.class);
        this.m_inventory = new Inventory();
        this.m_equipment = new EnumMap<enums.EItemSlot, Item>(enums.EItemSlot.class);
    }
}
