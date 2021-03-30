package ifpr.pgua.eic.javafx.Exemplo05;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Controle {

    // Create the Label
    @FXML
    private Label lbRelogio;

    // Create the Buttons
    @FXML
    private Button btControle1;

    @FXML
    private ProgressBar pbProgresso1;

    @FXML
    private Button btControle2;

    @FXML
    private ProgressBar pbProgresso2;

    @FXML
    private Button btControle3;

    @FXML
    private ProgressBar pbProgresso3;

    private DateTimeFormatter df=DateTimeFormatter.ofPattern("HH:mm:ss");


    private boolean tarefa1=false;

    private boolean tarefa2=false;

    private boolean tarefa3=false;


    public void initialize(){
        Task<Void> relogio = controleRelogio();
        lbRelogio.textProperty().bind(relogio.messageProperty());
        // Run the task in a background thread
        Thread backgroundThread = new Thread(relogio);
        // Terminate the running thread if the application exits
        backgroundThread.setDaemon(true);
        // Start the thread
        backgroundThread.start();


        Task<Void> tarefa1 = controleTarefa1();

        pbProgresso1.progressProperty().bind(tarefa1.progressProperty());

        Thread threadTarefa1 = new Thread(tarefa1);
        // Terminate the running thread if the application exits
        threadTarefa1.setDaemon(true);
        // Start the thread
        threadTarefa1.start();

        Task<Void> tarefa2 = controleTarefa2();

        pbProgresso2.progressProperty().bind(tarefa2.progressProperty());

        Thread threadTarefa2 = new Thread(tarefa2);
        // Terminate the running thread if the application exits
        threadTarefa2.setDaemon(true);
        // Start the thread
        threadTarefa2.start();

        Task<Void> tarefa3 = controleTarefa3();

        pbProgresso3.progressProperty().bind(tarefa3.progressProperty());

        Thread threadTarefa3 = new Thread(tarefa3);
        // Terminate the running thread if the application exits
        threadTarefa3.setDaemon(true);
        // Start the thread
        threadTarefa3.start();

    }





    @FXML
    private void controle1(){
        tarefa1 = !tarefa1;
        btControle1.setText(tarefa1?"Pausar":"Inicia");
    }

    @FXML
    private void controle2(){
        tarefa2 = !tarefa2;
        btControle2.setText(tarefa2?"Pausar":"Inicia");

    }

    @FXML
    private void controle3(){
        tarefa3 = !tarefa3;
        btControle3.setText(tarefa3?"Pausar":"Inicia");

    }


    public Task<Void> controleRelogio(){
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                while(true){
                    String str = df.format(LocalDateTime.now());
                    this.updateMessage(str);
                    Thread.sleep(1000);

                }
            }
        };
    }

    public Task<Void> controleTarefa1(){
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                int contProgresso=0;
                while(true){
                    if(tarefa1){
                        contProgresso+=10;
                        if(contProgresso>100){
                            contProgresso=0;
                        }
                        this.updateProgress(contProgresso,100);
                        Thread.sleep(1000);
                    }else{
                        Thread.sleep(100);
                    }
                }
            }
        };
    }

    public Task<Void> controleTarefa2(){
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                int contProgresso=0;
                while(true){
                    if(tarefa2){
                        contProgresso+=10;
                        if(contProgresso>100){
                            contProgresso=0;
                        }
                        this.updateProgress(contProgresso,100);
                        Thread.sleep(1000);
                    }else{
                        Thread.sleep(100);
                    }
                }
            }
        };
    }

    public Task<Void> controleTarefa3(){
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                int contProgresso=0;
                while(true){
                    if(tarefa3){
                        contProgresso+=10;
                        if(contProgresso>100){
                            contProgresso=0;
                        }
                        this.updateProgress(contProgresso,100);
                        Thread.sleep(1000);
                    }else{
                        Thread.sleep(100);
                    }
                }
            }
        };
    }


    @FXML
    public void exit(){
        Platform.exit();
    }

}
