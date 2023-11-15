package activities;

import control.*;
import org.openqa.selenium.By;

public class AlarmScreen {

    public ImageButton addAlarmButton = new ImageButton(By.id("com.google.android.deskclock:id/fab"));
    public TextBox alarmName = new TextBox(By.xpath("//android.widget.EditText"));
    public Button okButton = new Button(By.id("android:id/button1"));

    public TextView getAlarmLabelOption(String hour, String minute, String amPm) {
        TextView alarmLabelOption = new TextView(By.xpath("//android.view.ViewGroup[contains(@content-desc, \"" + hour + ":" + minute + "\") and contains(@content-desc, \"" + amPm + " Alarm\")]//android.widget.TextView[@text=\"Label\"]"));
        return alarmLabelOption;
    }

    public ViewGroup getAlarm(String hour, String minute, String amPm) {
        ViewGroup alarm = new ViewGroup(By.xpath("//android.view.ViewGroup[contains(@content-desc, \"" + hour + ":" + minute + "\") and contains(@content-desc, \"" + amPm + " Alarm\")]"));
        return alarm;
    }

    public String getAlarmLabel(String label) {
        TextView alarmLabel = new TextView(By.xpath("//android.widget.TextView[@content-desc=\"Label " + label + "\"]"));
        return alarmLabel.getText();
    }
}
