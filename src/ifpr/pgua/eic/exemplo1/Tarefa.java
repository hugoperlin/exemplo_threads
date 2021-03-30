package ifpr.pgua.eic.exemplo1;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Tarefa implements Runnable{

    private SecureRandom rnd;
    private int tempoSono;
    private String mensagem;
    private String nomeTarefa;
    private int vezesImprimir;

    public Tarefa(String nomeTarefa, String mensagem, int vezesImprimir){
        this.nomeTarefa = nomeTarefa;
        this.mensagem = mensagem;
        this.vezesImprimir = vezesImprimir;
        rnd = new SecureRandom();
        tempoSono = rnd.nextInt(2000);
    }

    @Override
    public void run() {
        for(int i=0;i<this.vezesImprimir;i++){
            try{
                System.out.println(nomeTarefa+" -> Dormindo por "+(tempoSono/1000)+" (s)");
                //colocando a thread em espera cronometrada
                Thread.sleep(tempoSono);
            }catch (InterruptedException e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            //processamento...
            System.out.println(nomeTarefa+"-> Acordando ->"+mensagem);
        }
        System.out.println(nomeTarefa+"-> Finalizando...");
    }
}
