/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zara
 */
public class NodoHijo {
    NodoGeneral direccionHijo;
    NodoHijo ant, sig;
    
    public NodoHijo(NodoGeneral hijoApuntar){
        direccionHijo = hijoApuntar;
        ant = sig = null;
    }
}
