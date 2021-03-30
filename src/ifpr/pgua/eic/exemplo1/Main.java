package ifpr.pgua.eic.exemplo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        System.out.println("Principal-> Criando Threads...");
        Tarefa tarefa1 = new Tarefa("T1","Uma mensagem da T1",20);
        Tarefa tarefa2 = new Tarefa("T2","Uma mensagem da T2",20);
        Tarefa tarefa3 = new Tarefa("T3","Uma mensagem da T3",20);

        System.out.println("Principal-> Iniciando Threads...");

        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(tarefa1);
        executor.execute(tarefa2);
        executor.execute(tarefa3);

        executor.shutdown();

        System.out.println("Principal-> Executando Threads");

        try{
            executor.awaitTermination(10, TimeUnit.SECONDS);

        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Principal-> Terminei...");
    }
}
