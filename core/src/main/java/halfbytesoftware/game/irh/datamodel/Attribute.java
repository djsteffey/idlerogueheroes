package halfbytesoftware.game.irh.datamodel;

public class Attribute {
    // variables
    private enums.EAttributeType m_attributeType;
    private int m_base;
    private int m_added;
    private float m_multiplier;
    private int m_effective;

    // methods
    public Attribute(enums.EAttributeType attributeType, int base){
        this.m_attributeType = attributeType;
        this.m_base = base;
        this.m_added = 0;
        this.m_multiplier = 0.0f;
        this.m_effective = 0;
    }
}
