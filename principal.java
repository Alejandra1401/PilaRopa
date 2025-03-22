import java.util.Stack;

import javax.swing.JOptionPane;

public class principal
{
    
    public int Menu()
    {
        String input;
        int vrUsu = 0; 
        boolean validInput = false;
        do 
        {
            input = JOptionPane.showInputDialog("        MENU\n" +
                                                "1: Registrar Prenda\n" +
                                                "2: Buscar Prenda\n" +
                                                "3: Modificar Prenda\n" +
                                                "4: Vender Prenda\n" + 
                                                "5: Consultar Stock\n" + 
                                                "6: Salir\n");
            if (input != null && input.matches("\\d+")) 
            {
                vrUsu = Integer.parseInt(input);
                if (vrUsu >= 1 && vrUsu <= 6) 
                {
                    validInput = true;
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "Opción no válida, reintente por favor");
                }
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido.");
            }

        } while (!validInput);

        return vrUsu;
    }
    public static void main(String[] args) 
    {
        Stack<objRopa> pila = new Stack<>();
        int opc;
        do 
        {
            metodos m = new metodos();
            principal p = new principal();
            opc = p.Menu();
            switch (opc) 
            {
                case 1:
                    pila = m.LlenarPila();
                    m.MostrarPila(pila);
                    break;
                case 2:
                    m.buscarTienda(pila);
                    break;
                case 3:
                    m.modifPrenda(pila);
                    break;
                case 4:
                    m.venderPren(pila);
                    break;
                case 5:
                    m.consultarStock(pila);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "BYE");
                    break;
            }
            
        } while (opc != 6);
    }

    /*
     * metodos m = new metodos();
        Stack<objRopa> pila = new Stack<>();
        int opc;
        boolean validomenu = false;
        do
        {
            String menu = "           MENÚ \n" + 
                        "1: Ingresar prenda\n" + 
                        "2: Buscar prenda\n"+
                        "3: Modificar prenda\n" +
                        "4: vender prenda\n" +
                        "5: Consultar Stock\n" +
                        "6: SALIR\n";
            if(menu != null && menu.matches("\\d+"))
            {
                opc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opción " + menu));
                if(opc >= 1 && opc <= 6)
                {
                    validomenu = true;
                    switch (opc) 
                    {
                        case 1:
                            pila = m.LlenarPila();
                            m.MostrarPila(pila);
                            break;
                        case 2:
                            m.buscarTienda(pila);
                            break;
                        case 3:
                            m.modifPrenda(pila);
                            break;
                        case 4:
                            break;
                        case 5:
                            m.consultarStock(pila);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "BYE");
                            break;
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog( null, "Opcion no valida, reintente");
                }
            }
            else
            {
                JOptionPane.showMessageDialog( null, "ERROR, ingrese un número valido");
            }
        }while(validomenu);   
     */
    
}
