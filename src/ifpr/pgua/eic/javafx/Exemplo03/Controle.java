package ifpr.pgua.eic.javafx.Exemplo03;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    private Label lbRelogio;


    @FXML
    public void initialize(){

        new Thread(()->atualizaRelogio()).start();


    }

    private void atualizaRelogio(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");

        while(true){

            LocalDateTime agora = LocalDateTime.now();
            String hora = formatter.format(agora);

            Platform.runLater(()-> lbRelogio.setText(hora));
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }


    }


    @FXML
    public void startTask()
    {
        // Create a Runnable
        Runnable task = new Runnable()
        {
            public void run()
            {
                runTask();
            }
        };

        // Run the task in a background thread
        Thread backgroundThread = new Thread(task);
        // Terminate the running thread if the application exits
        backgroundThread.setDaemon(true);
        // Start the thread
        backgroundThread.start();
    }

    public void runTask()
    {
        for(int i = 1; i <= 10; i++)
        {
            try
            {
                // Get the Status
                final String status = "Processing " + i + " of " + 10;

                // Aqui serão atualizados os componentes da interface gráfica
                Platform.runLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        lbStatus.setText(status);

                        taContent.appendText(status+"\n");

                    }
                });

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
