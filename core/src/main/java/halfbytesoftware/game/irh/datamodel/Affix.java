package halfbytesoftware.game.irh.datamodel;

public class Affix {
    // variables
    private enums.EAttributeType m_attributeType;
    private int m_minRange;
    private int m_maxRange;
    private int m_actual;
    private boolean m_isFloat;

    // methods
    public Affix(enums.EAttributeType attributeType, int minRange, int maxRange, int actual, boolean isFloat){
        this.m_attributeType = attributeType;
        this.m_minRange = minRange;
        this.m_maxRange = maxRange;
        this.m_actual = actual;
        this.m_isFloat = isFloat;
    }
}
