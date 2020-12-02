package br.edu.ufal.model;

public class Garcom implements Runnable {
	ListaPedidos lista;
	int id;
	boolean livre = true;
	String nome;

	public Garcom(ListaPedidos lista, String nome) {
		this.lista = lista;
		this.nome = nome;
	}

	public void pegandoLista() throws InterruptedException {
		lista.pegaLista();
		Thread.sleep(1000);
	}

	public void soltandoLista() {
		lista.soltarLista();
	}

	@Override
	public void run() {
		try {
			while (true) {
				pegandoLista();

				if (lista.listaCheia()) {
					soltandoLista();
					System.out.println("Lista de pedidos cheia. " + lista);
				} else {
					Pedido pedido = new Pedido();

					System.out.println(">[GARCOM] " + this.nome + " anotando pedido: " + pedido.getId() + ", nome: "
							+ pedido.getNome());

					lista.adicionarPedidoNaLista(pedido);

					Thread.sleep(1000);

					System.out.println(">[GARCOM] " + this.nome + " anotou pedido: " + pedido.getId() + ", nome: "
							+ pedido.getNome());

					soltandoLista();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
