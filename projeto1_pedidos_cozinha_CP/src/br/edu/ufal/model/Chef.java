package br.edu.ufal.model;

public class Chef implements Runnable {
	ListaPedidos listaPedidos;
	String nomeChef;

	public Chef(ListaPedidos lista, String nome) {
		this.listaPedidos = lista;
		this.nomeChef = nome;
	}

	public void lockListaChef() throws InterruptedException {
		listaPedidos.lockLista();
	}

	public void unlockListaChef() {
		listaPedidos.unlockLista();
	}

	@Override
	public void run() {
		try {
			while (true) {
				lockListaChef();

				if (!listaPedidos.listaVazia()) {
					System.out.println(">[CHEF] Lista de pedidos recebida: " + listaPedidos);

					int idPedido = listaPedidos.getPedido().getId();

					String prato = listaPedidos.getPedido().getPrato();

					listaPedidos.removerPedidoLista();

					System.out.println(
							">[CHEF] " + this.nomeChef + " preparando o pedido: " + idPedido + ", prato: " + prato);

					unlockListaChef();
					Thread.sleep((long) ((Math.random() * 2) + 4) * 1000);

					System.out.println(
							">[CHEF] " + this.nomeChef + " preparou o pedido: " + idPedido + ", prato: " + prato);
				} else {
					unlockListaChef();
					System.out.println("Lista de pedidos vazia.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			unlockListaChef();
		}
	}
}
