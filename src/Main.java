import controlP5.*;
import processing.core.PApplet;

public class Main extends PApplet {
    public static void main(String[] args) {
        PApplet.main(Main.class);
    }

    ControlP5 cp5;
    private Button button;
    private Toggle deactvationSlider, deactivationSlider;
    private Slider slider;


    @Override
    public void settings() {
        size(400, 400);
    }

    /**
     * The buttons and slider will be declared and given properties
     * in the setup method
     * */
    @Override
    public void setup() {
        cp5 = new ControlP5(this);

        /**
         * The Slider takes as parameter cp5, its position and its color
         * */
        slider = new Slider(cp5, "Deactivatable Slider").setPosition(200, 100).setSize(100, 20);
        /**
         * The slider created above is to be a deactivatable slider
         * */
        DeactivatableSlider deactivatableSlider = new DeactivatableSlider(slider, callbackEvent -> System.out.println("Value" ));
        /**
         * deactvationSlider is the button which activates or deactivates the deactivatable slider
         * */
        deactvationSlider = cp5.addToggle("DeactivationB Slider");
        deactvationSlider.setPosition(10, 100);
        deactvationSlider.setSize(100, 20);
        deactvationSlider.addListenerFor(ControlP5Constants.SWITCH, (e) -> {
            deactivatableSlider.setDisabled(deactivatableSlider.isEnabled());
            if(deactivatableSlider.isEnabled()) {
                System.out.println("slider activated");
            }else {
                System.out.println("slider deactivated");}
        });

        button = cp5.addButton("Deactivatable Button");
        button.setPosition(200, 200);
        button.setSize(100, 20);

        DeactivatableButton deactivatableButton = new DeactivatableButton(button, callbackEvent -> System.out.println("button clicked"));

        deactivationSlider = cp5.addToggle("Deactivation Button");
        deactivationSlider.setPosition(10, 200);
        deactivationSlider.setSize(100, 20);
        deactivationSlider.addListenerFor(ControlP5Constants.SWITCH, (e) -> {
                    deactivatableButton.setDisabled(deactivatableButton.isEnabled());
            if(deactivatableButton.isEnabled()) {
                System.out.println("button activated");
            }else {
                System.out.println("button deactivated");}
        });
    }


    public void draw() {
        background(20);
        fill(color(100));
        noStroke();
        rect(0, 0, 200, height);

        fill(255, 255, 255);
        textSize(18);
        text("Deactivation CP5", 10, slider.getPosition()[1] - 50);
    }

}