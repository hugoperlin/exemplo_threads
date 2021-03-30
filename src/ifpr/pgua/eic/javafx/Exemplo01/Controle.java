package ifpr.pgua.eic.javafx.Exemplo01;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Controle {

    // Create the TextArea
    @FXML
    private TextArea taContent;

    // Create the Label
    @FXML
    private Label lbStatus;

    // Create the Buttons
    @FXML
    private Button btStart;

    @FXML
    private Button btExit;


    @FXML
    public void runTask()
    {
        for(int i = 1; i <= 10; i++)
        {
            try
            {
                String status = "Processing " + i + " of " + 10;
                lbStatus.setText(status);
                taContent.appendText(status+"\n");
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void exit(){
        Platform.exit();
    }

}
