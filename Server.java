package exp66;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements Calculator {

	private static final long serialVersionUID = 1L;

	// Constructor
    protected Server() throws RemoteException {
        super();
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) throws RemoteException {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) throws RemoteException {
        return a * b;
    }

    @Override
    public double divide(int a, int b) throws RemoteException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return (double) a / b;
    }

    public static void main(String[] args) {
        try {
            // Create an instance of CalculatorServer
            Server server = new Server();

            // Create and bind the RMI registry
            Registry registry = LocateRegistry.createRegistry(200);
            registry.bind("CalculatorService", server);

            System.out.println("Server is ready on port 2000...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
