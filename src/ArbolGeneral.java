
import static javax.swing.JOptionPane.showMessageDialog;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zara
 */
public class ArbolGeneral {
    NodoGeneral raiz;
    
    public ArbolGeneral(){
        raiz = null;
    }
    public boolean insertar(char dato, String path){
        if(raiz==null){
            raiz = new NodoGeneral(dato);
            if(raiz==null)return false;
            return true;
        }
        if(path.isEmpty())return false;
        
        NodoGeneral padre = buscarNodoR(path,0);
        if(padre == null) return false;
        
        NodoGeneral hijoYaExiste = buscarNodoR(path+"/"+dato,0);
        if(hijoYaExiste!=null)return false;
        
        NodoGeneral nuevo = new NodoGeneral (dato);
        return padre.enlazar(nuevo);
    }
    
    private NodoGeneral buscarNodo(String path){
        path = path.substring(1);
        String vector[] = path.split("/");
        
        if(vector[0].charAt(0) == raiz.dato){
            if(vector.length==1) return raiz;
            
            NodoGeneral padre = raiz;
            for(int i=1; i<vector.length;i++){
                padre = padre.obtenerHijo(vector[i].charAt(0));
                if(padre==null) return null;
            }
            return padre;
        } 
        return null;
    }
    private NodoGeneral buscarNodoR(String path, int z){
       path = path.substring(1);
        String vector[] = path.split("/");
        
        if(vector[0].charAt(0) == raiz.dato){
            if(vector.length==1) return raiz;
            
            NodoGeneral padre = raiz;
            /*for(int i=1; i<vector.length;i++){
                padre = padre.obtenerHijo(vector[i].charAt(0));
                if(padre==null) return null;
            }*/
            int i=0;
            if(padre.obtenerHijo(vector[i].charAt(i)) != null)return buscarNodoR(path, i+1);
            return padre;
        } 
        return null;
    }
}