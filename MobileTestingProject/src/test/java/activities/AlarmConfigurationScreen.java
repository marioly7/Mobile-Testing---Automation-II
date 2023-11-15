package activities;

import control.Button;
import control.Label;
import control.RadialPickerTouchHelper;
import org.openqa.selenium.By;

public class AlarmConfigurationScreen {

    public Label hours = new Label(By.id("android:id/hours"));
    public Label minutes = new Label(By.id("android:id/minutes"));
    public Button okButton = new Button(By.id("android:id/button1"));
    public Button pmButton = new Button(By.id("android:id/pm_label"));
    public Button amButton = new Button(By.id("android:id/am_label"));

    public RadialPickerTouchHelper getRadialPickerTouchHelper(String time) {
        RadialPickerTouchHelper radialPickerTouchHelper = new RadialPickerTouchHelper(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='"+time+"']"));
        return radialPickerTouchHelper;
    }
}
