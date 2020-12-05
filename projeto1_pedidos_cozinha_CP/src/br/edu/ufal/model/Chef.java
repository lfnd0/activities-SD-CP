package br.edu.ufal.model;

public class Chef implements Runnable {
	ListaPedidos lista;
	String nome;

	public Chef(ListaPedidos lista, String nome) {
		this.lista = lista;
		this.nome = nome;
	}

	public void pegandoLista() {
		lista.pegarLista();
	}

	public void soltandoLista() {
		lista.soltarLista();
	}

	@Override
	public void run() {
		try {
			while (true) {
				pegandoLista();
//				Thread.sleep(1000);

				if (!lista.listaVazia()) {
					System.out.println(">[CHEF] Lista de pedidos: " + lista);

					int idPedido = lista.getPedido().getId();

					String prato = lista.getPedido().getPrato();

					lista.removerPedidoDaLista();
					soltandoLista();

					System.out.println(
							">[CHEF] " + this.nome + " preparando o pedido: " + idPedido + ", prato: " + prato);

					Thread.sleep((long) ((Math.random() * 2) + 4) * 1000);

					System.out
							.println(">[CHEF] " + this.nome + " preparou o pedido: " + idPedido + ", prato: " + prato);
				} else {
					soltandoLista();
					System.out.println("Lista de pedidos vazia.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			soltandoLista();
		}
	}
}
