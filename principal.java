import java.util.Stack;

import javax.swing.JOptionPane;

public class principal
{
    public static void main(String[] args) 
    {
        metodos m = new metodos();
        Stack<objRopa> pila = new Stack<>();
        int opc;
        String menu = "           MENÚ \n" + 
                        "1: Ingresar prenda\n" + 
                        "2: Buscar prenda\n"+
                        "3: Modificar prenda\n" +
                        "4: vender prenda\n" +
                        "5: Consultar Stock\n" +
                        "6: SALIR\n";
        do
        {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opción " + menu));
            if(opc > 6 || opc < 1)
            {
                JOptionPane.showMessageDialog( null, "Opcion no valida, reintente");//Recursividad para que no se salga
            }
            switch (opc) 
            {
                case 1:
                   pila = m.LlenarPila();
                    m.MostrarPila(pila);
                    break;
                case 2:
                    break;
                case 3:
                    
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "BYE");
                    break;
            }

        }while(opc !=6);   
    }
    
}
