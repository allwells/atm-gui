package main.java.modules;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 *
 * @author Allwell Onen
 * @since Wed 8 Dec 2021, 05:23 PM
 */
public class Animation {

    private AnchorPane anchor = null;
    private AnchorPane anchorPane1 = null;
    private AnchorPane anchorPane2 = null;

    public Animation(AnchorPane anchorPane) {
        this.anchor = anchorPane;
    }

    /**
     *
     * @param anchorPane1
     * @param anchorPane2
     */
    public Animation(AnchorPane anchorPane1, AnchorPane anchorPane2) {
        this.anchorPane1 = anchorPane1;
        this.anchorPane2 = anchorPane2;
    }

    /**
     *
     * This method slides the screen out through the left
     *
     * @param duration duration of animation in seconds
     * @param layoutX layoutX position of pane
     */
    public void slideLeft(int duration, double layoutX) {
        anchorPane1.translateXProperty().set((anchorPane2.getPrefWidth() + layoutX));

        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(anchorPane2.translateXProperty(), 50, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValue);
        timeline.getKeyFrames().add(keyFrame);

        timeline.setOnFinished(event -> {
            slideRight(duration, layoutX);
        });
        timeline.play();
    }

    /**
     *
     * This method slides the screen out through the right
     *
     * @param duration duration of animation in seconds
     * @param layoutX layoutX position of pane
     */
    public void slideRight(int duration, double layoutX) {
        anchorPane2.translateXProperty().set(anchorPane1.getPrefWidth() + layoutX);

        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(anchorPane1.translateXProperty(), 50, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(duration), keyValue);
        timeline.getKeyFrames().add(keyFrame);

        timeline.setOnFinished(event -> {
            slideLeft(duration, layoutX);
        });
        timeline.play();
    }

    /**
     *
     * This method fades in one screen
     *
     * @param fadeInPane Scene to fade into display
     * @param duration duration of animation in seconds
     */
    public void fadeIn(AnchorPane fadeInPane, double duration) {
        FadeTransition fit = new FadeTransition(Duration.seconds(duration), fadeInPane);
        fit.setFromValue(0.0);
        fit.setToValue(1.0);

        fit.setOnFinished(evt -> {
            fadeInPane.setVisible(true);
        });
        fit.play();
    }

    /**
     *
     * This method fades out one screen
     *
     * @param fadeOutPane scene to fade out of display
     * @param duration duration of animation in seconds
     */
    public void fadeOut(AnchorPane fadeOutPane, double duration) {
        FadeTransition fit = new FadeTransition(Duration.seconds(duration), fadeOutPane);

        fit.setFromValue(1.0);
        fit.setToValue(0.0);

        fit.setOnFinished(evt -> {
            fadeOutPane.setVisible(false);
        });

        fit.play();
    }

}
