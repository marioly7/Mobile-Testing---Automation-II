package activities;

import control.Label;
import org.openqa.selenium.By;

public class MainScreen {

    public Label getTaskName(String name){
        Label taskName = new Label(By.xpath("//android.widget.TextView[@text='"+name+"']"));
        return taskName;
    }

}
