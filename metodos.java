import java.util.Stack;

import javax.swing.JOptionPane;

public class metodos 
{
    public Stack<objRopa> LlenarPila() 
    {
        Stack<objRopa> pila = new Stack<>();//Declara variable pila de tipo obj, la pila es una coleccion de objeto
        boolean continuar = true;
        String agregar = "";
        String ingreso;
        while (continuar) 
        {
            objRopa o = new objRopa();
            o.setMarca(JOptionPane.showInputDialog("Ingrese la marca del repuesto"));
            ingreso =  JOptionPane.showInputDialog(null, "Ingrese la referencia del repuesto");
            while (!ingreso.matches("\\d+")) 
            {
                JOptionPane.showMessageDialog(null, "Dato no valido, reintente");
                ingreso =  JOptionPane.showInputDialog(null, "Ingrese la referencia valida");
            }
            o.setReferencia(Integer.parseInt(ingreso));
            ingreso =  JOptionPane.showInputDialog(null, "Ingrese la cantidad de repuestos");
            while (!ingreso.matches("\\d+")) 
            {
                JOptionPane.showMessageDialog(null, "Dato no valido, reintente");
                ingreso =  JOptionPane.showInputDialog(null, "Ingrese cantidad valida");
            }
            o.setCantidad(Integer.parseInt(ingreso));
            ingreso =  JOptionPane.showInputDialog(null, "Ingrese el precio del repuesto");
            while (!ingreso.matches("\\d+(\\.\\d+)?")) 
            {
                JOptionPane.showMessageDialog(null, "Dato no valido, reintente");
                ingreso =  JOptionPane.showInputDialog(null, "Ingrese precio valido");
            }
            o.setPrecio(Double.parseDouble(ingreso));
            pila.push(o);//Aqui llevo los datos a la pila 
            JOptionPane.showMessageDialog(null, "Repuesto agregado con exito");
            agregar = JOptionPane.showInputDialog("Desea agregar mas Registros S/N");
            if (agregar.equalsIgnoreCase("N"))
            {
                continuar = false;
            }
        }
        return pila;
    }
    public void MostrarPila(Stack<objRopa> pila) 
    {
        for (objRopa ropa : pila) //Deshapilando para mostrar(es lo mismo que un for normal)
        {
            JOptionPane.showMessageDialog(null, "LA PILA\n"+
                         "Marca:" + ropa.getMarca()+"\n" + "Referencia: " + ropa.getReferencia() +"\n" +
                         "Cantidad: " + ropa.getCantidad() + "\n" + "Precio: " + ropa.getPrecio() ); 
        }
    }
    public void buscarTienda (Stack<objRopa> pila)
    {
        while (pila.empty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay repuestos ingresados");
            //pila = LlenarPila(); //para me lleve directamente al metodo llenar y no al menu y comento el return
            return;
        }
        int opc = Integer.parseInt(JOptionPane.showInputDialog("Consultar\n" + "1: Por marca\n" + "2: Por referencia\n"));
        String marcaBusc = "";
        int refBusc = 0;
        if(opc == 1)
        {
            marcaBusc = JOptionPane.showInputDialog(null, "Ingrese la marca a buscar");
        }
        else
        {
            refBusc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la referencia a buscar"));
        }
        for(objRopa ropa : pila)
        {
            if(opc == 1)
            {
                if(ropa.getMarca().equalsIgnoreCase(marcaBusc))
                {
                    JOptionPane.showMessageDialog(null, "Datos del repuesto buscado\n"+
                         "Marca:" + ropa.getMarca()+"\n" + "Referencia: " + ropa.getReferencia() +"\n" +
                         "Cantidad: " + ropa.getCantidad() + "\n" + "Precio: " + ropa.getPrecio() ); 
                    return;
                }
            }
            else
            {
                if(ropa.getReferencia() == refBusc) // == porque referencia es una entero too double 
                {
                JOptionPane.showMessageDialog(null, "Datos de la prenda buscada\n"+
                         "Marca:" + ropa.getMarca()+"\n" + "Referencia: " + ropa.getReferencia() +"\n" +
                         "Cantidad: " + ropa.getCantidad() + "\n" + "Precio: " + ropa.getPrecio() ); 
                return;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Prenda no encontrada");
                }
            }
        }
    }
    public void modifPrenda(Stack<objRopa> pila)
    {
        while (pila.empty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay repuestos ingresados");
            //pila = LlenarPila(); //para me lleve directamente al metodo llenar y no al menu y comento el return
            return;
        }
        int refAMod = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese la referencia del repuesto que desea modificar")));
        boolean amodif = false;
        for(objRopa ropa : pila)
        {
            if(ropa.getReferencia() == refAMod)
            {
                    amodif = true;
                    int opc;
                    opc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opción\n" + "1: Marca\n" + "2: Referencia\n" +
                                                                     "3: Cantidad\n" + "4:Precio\n"));
                    switch (opc) 
                    {
                        case 1:
                            String newmarca = JOptionPane.showInputDialog("Ingrese nueva marca");
                            ropa.setMarca(newmarca);
                        break;
                        case 2:
                            int newreferen = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva referencia"));
                            ropa.setReferencia(newreferen);
                        break;
                        case 3:
                            int newcant = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad"));
                            ropa.setCantidad(newcant);
                        break;
                        case 4:
                            double newprecio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio"));
                            ropa.setPrecio(newprecio);
                        break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no disponible");
                        break;
                    }
                        JOptionPane.showMessageDialog(null, "Modificación realizada correctamente");
                        JOptionPane.showMessageDialog(null, "Datos de la prenda modificada\n"+
                        "Marca:" + ropa.getMarca()+"\n" + "Referencia: " + ropa.getReferencia() +"\n" +
                        "Cantidad: " + ropa.getCantidad() + "\n" + "Precio: " + ropa.getPrecio() ); 
                        return;
            }
        }
        if(!amodif)//llega falso porque "como no entra al if de arriba el se comvierte en true" y por eso el !amodif(false)
        {
            JOptionPane.showMessageDialog(null, "Referencia de repuesto no encontrada");
        }
    }
    public void venderPren(Stack<objRopa> pila)
    {
        while (pila.empty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay repuestos ingresados");
            //pila = LlenarPila(); //para me lleve directamente al metodo llenar y no al menu y comento el return
            return;
        }
        int opc = Integer.parseInt(JOptionPane.showInputDialog("Consultar\n" + "1: Por marca\n" + "2: Por referencia\n"));
        String marcaBusc = "";
        int refBusc = 0;
        boolean encontrado = false;
        if(opc == 1)
        {
            marcaBusc = JOptionPane.showInputDialog(null, "Ingrese la marca a vender");
        }
        else
        {
            refBusc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la referencia a vender"));
        }
        for(objRopa ropa : pila)
        {
            if(opc == 1)
            {
                if(ropa.getMarca().equalsIgnoreCase(marcaBusc))
                {
                    if(ropa.getCantidad() > 0)
                    {
                        encontrado = true;
                        int cantAVend = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a vender")));
                        if(cantAVend <= ropa.getCantidad())
                        {
                            ropa.setCantidad(ropa.getCantidad() - cantAVend);
                            JOptionPane.showMessageDialog(null, "Venta realizada");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Stock insuficiente");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, " No hay Stock disponible");
                    }
                    JOptionPane.showMessageDialog(null, "Datos del repuesto vendido\n"+
                        "Marca:" + ropa.getMarca()+"\n" + "Referencia: " + ropa.getReferencia() +"\n" +
                        "Cantidad: " + ropa.getCantidad() + "\n" + "Precio: " + ropa.getPrecio() ); 
                        return;
                }
            }
            else
            {
                if(ropa.getReferencia() == refBusc)
                {
                    if(ropa.getCantidad() > 0)
                    {
                        encontrado = true;
                        int cantAVend = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a vender")));
                        if(cantAVend <= ropa.getCantidad())
                        {
                            ropa.setCantidad(ropa.getCantidad() - cantAVend);
                            JOptionPane.showMessageDialog(null, "Venta realizada");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Stock insuficiente");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, " No hay Stock disponible");
                    }
                    JOptionPane.showMessageDialog(null, "Datos del repuesto vendido\n"+
                        "Marca:" + ropa.getMarca()+"\n" + "Referencia: " + ropa.getReferencia() +"\n" +
                        "Cantidad: " + ropa.getCantidad() + "\n" + "Precio: " + ropa.getPrecio() ); 
                        return;
                }
            }
        }
        if(!encontrado)
        {
            JOptionPane.showMessageDialog(null, "Repuesto no encontrado");
        }
    }
}
