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

	public void pegarLista() {
		aLock.lock();
	}

	public void soltarLista() {
		aLock.unlock();
	}

	public boolean adicionarPedidoNaLista(Pedido pedido) {
		if (lista.size() < 5) {
			this.lista.add(pedido);
			return true;
		}
		return false;
	}

	public boolean removerPedidoDaLista() {
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
