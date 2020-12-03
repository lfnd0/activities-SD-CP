package br.edu.ufal.model;

public class Garcon implements Runnable {
	ListaPedidos lista;
	int id;
	String nome;

	public Garcon(ListaPedidos lista, String nome) {
		this.lista = lista;
		this.nome = nome;
	}

	public void pegandoLista() throws InterruptedException {
		lista.pegarLista();
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
					System.out.println("Lista de pedidos cheia. Aguardando: " + lista);
				} else {
					Pedido pedido = new Pedido();

					lista.adicionarPedidoNaLista(pedido);
					System.out.println(">[GARCON] " + this.nome + " anotando pedido: " + pedido.getId() + ", prato: "
							+ pedido.getPrato());

					Thread.sleep((long) ((Math.random() * 2) + 1) * 1000);

					soltandoLista();

					System.out.println(">[GARCON] " + this.nome + " anotou pedido: " + pedido.getId() + ", prato: "
							+ pedido.getPrato());
					System.out.println(">[GARCON] Lista de pedidos: " + lista);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			soltandoLista();
		}
	}
}
