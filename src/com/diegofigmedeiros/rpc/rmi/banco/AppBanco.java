package com.diegofigmedeiros.rpc.rmi.banco;

import com.diegofigmedeiros.rpc.rmi.service.BancoServiceIF;
import com.diegofigmedeiros.rpc.rmi.service.BancoServiceServer;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AppBanco {

    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {

        // Cria uma instância do serviço com.gugawag.rpc.banco.BancoServiceServer...
        BancoServiceIF bancoService = new BancoServiceServer();

        // instanciando o registro
        Registry registry = LocateRegistry.createRegistry(1099);

        // liga (bind) o serviço ao RMI Registry
        registry.rebind("BancoService", bancoService);

        System.out.println("\n=== Diego Figueiredo de Medeiros ===");
        System.out.println("Service de banco registrado ...");
    }
}
