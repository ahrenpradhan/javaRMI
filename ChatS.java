import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;



//HERE RATHER THAN CREATING IMPLEMENTATION CLASS SEPERATELY WE ARE CREATING IT IN SERVER
public class Server extends UnicastRemoteObject implements adder{
    public Server() throws RemoteException{
        //super()  
    }
        @Override
        public int add(int n1,int n2)throws RemoteException{
            return n1+n2;
        }
        public static void main(String[] args)throws RemoteException{
            try{
                Registry reg=LocateRegistry.createRegistry(9989);
                //9989 is port no
                reg.rebind("hi Server", new Server());
                //HERE REBIND METHOD IS USED TO BIND THE REGISTRY
                //THE NAME SHOULD BE UNIQUE i.e "hi Server"
                System.out.println("SERVER IS READY");
            }
            catch(RemoteException e){
                System.out.println("exception"+e);
            }
        }

   
    public int adder(int n1, int n2) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
