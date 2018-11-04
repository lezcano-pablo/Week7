package ExecutorJarroba;


public class CajeraRunnable implements Runnable {

	private Cliente cliente;
	private long initialTime;

	public CajeraRunnable(Cliente cliente, long initialTime) {
		this.cliente = cliente;
		this.initialTime = initialTime;
	}

	@Override
	public void run() {
		System.out.println("\"The checkout girl " + Thread.currentThread().getName() 
				+ "\" starts to process the customer purchase  " + this.cliente.getNombre() 
				+ " on the time: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");

		for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
			// The order is processed in X seconds
			this.esperarXsegundos(cliente.getCarroCompra()[i]);
			System.out.println("Processing the product  " + (i + 1) + " of " + this.cliente.getNombre() 
				+ "->Time: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
		}

		System.out.println("\"The checkout girl " + Thread.currentThread().getName() + "\" has finished to process " 
				+ this.cliente.getNombre() + " on the time: "
				+ (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");

	}

	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	public long getInitialTime() {
		return initialTime;
	}

	public void setInitialTime(long initialTime) {
		this.initialTime = initialTime;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
