import controlP5.*;

public class DeactivatableSlider implements Deactivatable {

    public Slider slider;
    ControlListener listener;

    boolean disabled = false;
    /**
     * Slider gives the button a sliding property
     * Listener is used to listen for an acton. In this case a click
     * */
    DeactivatableSlider(Slider slider, ControlListener listener) {
        this.slider = slider;
        this.listener = listener;
        this.slider.addListener(listener);  //adds Listener for the Slider
        this.slider.setColor(getActiveColor());  //gets the color from the method getActiveColor() int the interface and  gives it to slider
    }

    public boolean isEnabled() {
        return !disabled;
    }

    /**
     * deactivates button when it's enabled and activates it when it's enabled
     * */
    public void setDisabled(boolean state) {
        this.disabled = state;

        /**
         * When the program is started the value of disabled is false so it enters the if
         * Lister which was added in the slider constructor listens for click
         * once the button is clicked the listener is removed
         * hence the slider can no longer be used
         * */
        if (this.disabled) {  //the button here is deactivated
            this.slider.setColor(getDisabledColor());
            this.slider.setLock(true);
            this.slider.removeListenersFor(Controller.ACTION_CLICK);
        } else {
            this.slider.setColor(getActiveColor());
            this.slider.setLock(false);
        }
    }
}
