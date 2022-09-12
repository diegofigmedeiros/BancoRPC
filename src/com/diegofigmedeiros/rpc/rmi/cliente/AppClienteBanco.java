package com.diegofigmedeiros.rpc.rmi.cliente;

import com.diegofigmedeiros.rpc.rmi.service.BancoServiceIF;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AppClienteBanco {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        // procura o serviço no RMI Registry local. Perceba que o cliente não connhece a implementação do servidor,
        // apenas a interface
        Registry registry = LocateRegistry.getRegistry();
        BancoServiceIF banco = (BancoServiceIF) registry.lookup("BancoService");

        menu();
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();

        while(opcao != 9) {

            switch (opcao) {
                case 1: {
                    System.out.println("Digite o número da conta a ser consultada:");
                    String conta = entrada.next();
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println("Banco>");
                    System.out.println(banco.saldo(conta));
                    break;
                }
                case 2: {
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println("Banco>");
                    System.out.println(banco.quantidadeContas());
                    break;
                }
                case 3: {
                    System.out.println("Digite o número da conta a ser adicionada:");
                    String contaNome = entrada.next();
                    System.out.println("Digite o saldo da conta:");
                    double contaSaldo = Double.parseDouble(entrada.next());
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println("Banco>");
                    System.out.println(banco.adicionarConta(contaNome, contaSaldo));
                    break;
                }
                case 4: {
                    System.out.println("Digite o número da conta a ser removida:");
                    String conta = entrada.next();
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println("Banco>");
                    System.out.println(banco.removerConta(conta));
                    break;
                }
            }
            menu();
            opcao = entrada.nextInt();
        }
    }

    public static void menu() {
        System.out.println("\n=== Diego Figueiredo de Medeiros ===");
        System.out.println("\n=== BANCO RMI (ou FMI?!) ===");
        System.out.println("1 - Saldo da conta");
        System.out.println("2 - Quantidade de contas");
        System.out.println("3 - Adicionar conta");
        System.out.println("4 - Remover conta");

        System.out.println("9 - Sair");
    }

}
