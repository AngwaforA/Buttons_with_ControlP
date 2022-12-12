import controlP5.CColor;
import processing.core.PApplet;

public interface Deactivatable {
    /**
     * Contains the color of the controller
     * Sets the color of the slider or button when active
     * */
    default CColor getActiveColor() {
        CColor c = new CColor();
        c.setForeground(new PApplet().color(0, 170, 204));
        c.setActive(new PApplet().color(0, 190, 234));
        c.setBackground(new PApplet().color(0, 99, 204));
        c.setCaptionLabel(new PApplet().color(255, 255, 255));
        return c;
    }

    default CColor getDisabledColor() {
        CColor c = new CColor();
        c.setForeground(new PApplet().color(200, 200, 180));
        c.setActive(new PApplet().color(204, 204, 204));
        c.setBackground(new PApplet().color(167, 199, 231));
        c.setCaptionLabel(new PApplet().color(255, 255, 255));
        return c;
    }

    boolean isEnabled();

    void setDisabled(boolean state);

}
