package br.edu.ufal.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ListaPedidos extends Thread {
	List<Pedido> lista = new ArrayList<Pedido>();
	Lock aLock;

	public ListaPedidos() {
		this.lista = Collections.synchronizedList(lista);
		this.aLock = new ReentrantLock();
	}

	public Pedido getPedido() {
		return (this.lista.get(0));
	}

	public List<Pedido> getLista() {
		return lista;
	}

	public void lockLista() throws InterruptedException {
		aLock.lock();
		Thread.sleep(1000);
	}

	public void unlockLista() {
		aLock.unlock();
	}

	public boolean adicionarPedidoLista(Pedido pedido) {
		if (lista.size() < 5) {
			this.lista.add(pedido);
			return true;
		}
		return false;
	}

	public boolean removerPedidoLista() {
		if (!listaVazia()) {
			this.lista.remove(0);
			return true;
		}
		return false;
	}

	public boolean listaVazia() {
		if (lista.isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean listaCheia() {
		if (lista.size() == 5) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "" + this.lista;
	}
}
