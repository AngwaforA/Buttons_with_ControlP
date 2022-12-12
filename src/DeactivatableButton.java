import controlP5.Button;
import controlP5.CallbackListener;
import controlP5.Controller;

/**
 *
 */
public class DeactivatableButton implements Deactivatable {

    public Button button;
    CallbackListener listener;

    boolean disabled;

    /**
     * Constructor for Button
     * */
    DeactivatableButton(Button button, CallbackListener listener) {
        this.button = button;
        this.listener = listener;
        this.button.addListenerFor(Controller.ACTION_CLICK, listener);
        this.button.setColor(getActiveColor());
    }

    public boolean isEnabled() {
        return !disabled;
    }

    public void setDisabled(boolean state) {
        this.disabled = state;

        if (this.disabled) { //if button is disabled then the listener is removed when button is clicked again
            this.button.setColor(getDisabledColor());
            this.button.removeListenersFor(Controller.ACTION_CLICK);
        } else {  //listener listens for a click and changes color if clicked on button
            this.button.addListenerFor(Controller.ACTION_CLICK, listener);
            this.button.setColor(getActiveColor());
        }
    }

}
