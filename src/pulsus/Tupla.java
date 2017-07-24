/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulsus;

/**
 *
 * @author david
 */
public class Tupla {
    private char letra;
    private int quantidade;

 
     public Tupla(char letra) {           
        this.letra = letra;
        this.quantidade = 0;             
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
    public void increment(){
        this.quantidade++;
    }
    

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    @Override
    public String toString(){
        return "Letra: "+this.letra +"\nQuantidade: "+this.quantidade;
    }
}
