package pr.ivanov.task.util;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class MarathonTimer {

    private final Label marathonLabel;
    private final LocalDateTime marathonTime;
    private Timeline timeline;

    public MarathonTimer(Label marathonLabel, LocalDateTime marathonTime) {
        this.marathonLabel = marathonLabel;
        this.marathonTime = marathonTime;
        startTimer();
    }

    private void startTimer() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), _ -> updateMarathonLabel()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void updateMarathonLabel() {

        LocalDateTime now = LocalDateTime.now();
        long secondsUntilMarathon = ChronoUnit.SECONDS.between(now, marathonTime);

        if (secondsUntilMarathon > 0) {
            long days = secondsUntilMarathon / (24 * 3600);
            long hours = (secondsUntilMarathon % (24 * 3600)) / 3600;
            long minutes = (secondsUntilMarathon % 3600) / 60;
            long seconds = secondsUntilMarathon % 60;
            marathonLabel.setText(String.format("До марафона: %d дн. %d ч. %d мин. %d сек.", days, hours, minutes, seconds));
        } else {
            marathonLabel.setText("Марафон начался!");
            timeline.stop();
        }
    }
}

