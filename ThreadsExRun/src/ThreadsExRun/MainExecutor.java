package ExecutorJarroba;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainExecutor {
    
    private static final int numCajeras = 2;

    public static void main(String[] args) {
        
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(new Cliente("Client 1", new int[] { 2, 2, 1, 5, 2 })); 
        clientes.add(new Cliente("Client 2", new int[] { 1, 1, 5, 1, 1 })); 
        clientes.add(new Cliente("Client 3", new int[] { 5, 3, 1, 5, 2 })); 
        clientes.add(new Cliente("Client 4", new int[] { 2, 4, 3, 2, 5 })); 
        clientes.add(new Cliente("Client 5", new int[] { 1, 3, 2, 2, 3 })); 
        clientes.add(new Cliente("Client 6", new int[] { 4, 2, 1, 3, 1 })); 
        clientes.add(new Cliente("Client 7", new int[] { 3, 3, 2, 4, 7 })); 
        clientes.add(new Cliente("Client 8", new int[] { 6, 1, 3, 1, 3 })); 
        
        
        long init = System.currentTimeMillis();  // Initial processing moment
        
        ExecutorService executor = Executors.newFixedThreadPool(numCajeras);
        for (Cliente cliente: clientes) {
            Runnable cajera = new CajeraRunnable(cliente, init);
            executor.execute(cajera);
        }
        executor.shutdown();	// Close the executor
        while (!executor.isTerminated()) {
        	// Await to finish the execution of all the process 
        	// to continue with the next instructions 
        }
        
        long fin = System.currentTimeMillis();	// Final processing moment
        System.out.println("Total time of processing: "+(fin-init)/1000+" Seconds");
    }
}
