package br.edu.ufal.model;

public class Garcon implements Runnable {
	ListaPedidos listaPedidos;
	String nomeGarcon;
	int id;

	public Garcon(ListaPedidos lista, String nome) {
		this.listaPedidos = lista;
		this.nomeGarcon = nome;
	}

	public void lockListaGarcon() throws InterruptedException {
		listaPedidos.lockLista();
	}

	public void unlockListaGarcon() {
		listaPedidos.unlockLista();
	}

	@Override
	public void run() {
		try {
			while (true) {
				lockListaGarcon();

				if (listaPedidos.listaCheia()) {
					unlockListaGarcon();
					System.out.println("Lista de pedidos cheia. Aguardando: " + listaPedidos);
				} else {
					Pedido pedido = new Pedido();

					listaPedidos.adicionarPedidoLista(pedido);
					System.out.println(">[GARCON] " + this.nomeGarcon + " anotando pedido: " + pedido.getId()
							+ ", prato: " + pedido.getPrato());

					Thread.sleep((long) ((Math.random() * 2) + 2) * 1000);
					unlockListaGarcon();

					System.out.println(">[GARCON] " + this.nomeGarcon + " anotou pedido: " + pedido.getId()
							+ ", prato: " + pedido.getPrato() + ". Lista de pedidos: " + listaPedidos);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			unlockListaGarcon();
		}
	}
}
