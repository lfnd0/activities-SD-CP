package br.edu.ufal.model;

public class Chefe implements Runnable {
	ListaPedidos lista;
	String nome;

	public Chefe(ListaPedidos lista, String nome) {
		this.lista = lista;
		this.nome = nome;
	}

	public void pegandoLista() throws InterruptedException {
		lista.pegaLista();
		Thread.sleep(1000);
	}

	public void soltandoLista() throws InterruptedException {
		lista.soltarLista();
	}

	@Override
	public void run() {
		try {
			while (true) {
				pegandoLista();
				if (!lista.listaVazia()) {
					int idPedido = lista.getPedido().getId();
					String nomePedido = lista.getPedido().getNome();

					lista.removerPedidoDaLista();
					soltandoLista();

					System.out.println(
							">[CHEFE] " + this.nome + " preparando o pedido: " + idPedido + ", nome: " + nomePedido);

					Thread.sleep(3000);

					System.out.println(
							">[CHEFE] " + this.nome + " preparou o pedido: " + idPedido + ", nome: " + nomePedido);
				} else {
					soltandoLista();
					System.out.println("Lista de pedidos vazia.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
