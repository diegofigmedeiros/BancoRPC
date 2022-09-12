package com.diegofigmedeiros.rpc.rmi.service;

import com.diegofigmedeiros.rpc.rmi.model.Conta;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BancoServiceIF extends Remote {

    double saldo(String conta) throws RemoteException;
    int quantidadeContas() throws RemoteException;
    String adicionarConta(String nomeConta, Double saldoConta) throws RemoteException;
    String removerConta(String nomeConta) throws RemoteException;

    Conta pesquisarConta(String numero) throws RemoteException;
}
