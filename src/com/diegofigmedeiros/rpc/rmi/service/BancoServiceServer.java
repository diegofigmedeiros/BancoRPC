package com.diegofigmedeiros.rpc.rmi.service;

import com.diegofigmedeiros.rpc.rmi.model.Conta;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private final List<Conta> contas = new ArrayList<>();

    public BancoServiceServer() throws RemoteException {
        contas.add(new Conta("1", 100.0));
        contas.add(new Conta("2", 50.0));
        contas.add(new Conta("3", 150.0));
    }

    @Override
    public double saldo(String numero) throws RemoteException {
        return Objects.requireNonNull(contas.stream()
                        .filter(conta -> conta.getNumero().equals(numero))
                        .findAny()
                        .orElse(null))
                .getSaldo();
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

    @Override
    public String adicionarConta(String numero, Double saldo) throws RemoteException {
        contas.add(new Conta(numero, saldo));
        return String.format("Conta %s adicionada com R$%s de saldo", numero, saldo);
    }

    @Override
    public String removerConta(String numero) throws RemoteException {
        Double saldoConta = saldo(numero);
        contas.remove(pesquisarConta(numero));
        return String.format("Conta %s removida com R$%s de saldo", numero, saldoConta);
    }

    @Override
    public Conta pesquisarConta(String numero) throws RemoteException {
         return Objects.requireNonNull(contas.stream()
                        .filter(conta -> conta.getNumero().equals(numero))
                        .findAny()
                        .orElse(null));
    }
}
