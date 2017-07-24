/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulsus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author david
 */
public class Pulsus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        exercicio1(getArray(-100, 100, 10));
        exercicio2("Pressaaao");
    }
    
   
    /*
    Exercício 1 - Recebe uma lista de inteiros. Esta será varrido por um for
    duplo que criará todas subsequencias possíveis da lista. Para cada uma delas,
    será calculado a soma de seus valores. Caso a soma dessa subsequencia seja 
    maior do que a maior soma já encontrada, está será substituida pela nova soma.
    Por fim, é printado a maior subsequencia e a soma de seus valores
    */
    
    public static void exercicio1(ArrayList<Integer> array){
        List<Integer> sequencia;
        List<Integer> maior = new ArrayList();
        int maior_soma = 0;
        for (int i = 0; i < array.size(); i++) {
                for (int j = i+1; j <= array.size(); j++) {
                    sequencia = array.subList(i, j);
                    int soma_list = calculaValor(sequencia);
                    if(soma_list > maior_soma){
                        maior_soma = soma_list;
                        maior = sequencia;
                    }         
                }
        }
         System.out.println("Soma:"+maior_soma+" \nSequencia: "+maior.toString());
    } 
    
    // Método usado para calcular os inteiros de uma lista
    public static int calculaValor(List<Integer> array){
        int soma = 0;    
        soma = array.stream().map((obj) -> obj).reduce(soma, Integer::sum);
        return soma;
    }
    
    
    /* Método para obter um arraylist de inteiros. Este método recebe por parametro
    o intervalo de valores do vetor e o tamanho do vetor
    */
    
    public static ArrayList getArray(int menor, int maior, int tamanho){
        Random r = new Random();                
        int num;
         ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < tamanho;i++){           
             num = r.nextInt(maior-menor) + menor;
             list.add(num);             
        }
        System.out.println(list.toString());
        return list;
    }
    
    
    /*
    Exercício 2 - É criado uma classe Tupla para armazenar um caractere e a
    quantidade de vezes que este aparece. São criados 2 objetos dessa classe, um
    temporário e um que conterá a maior sequencia. É incrementado um espaço no final
    da palavra para verificar a última sequencia desta.
    
    Cada caractere da palavra é verificado se ele pertence a sequencia atual ou 
    e iniciou outra sequencia. 
    Caso seja a sequencia atual, esta é incrementada em 1 o seu
    tamanho. Caso o caractere pertenca a uma nova sequencia, é verificado se a
    sequencia antiga é maior do que a maior sequencia global. Caso sim, a maior
    sequencia global é substituida. Caso negativo, a sequencia antiga é descartada.
    Por fim, é retornado a Tupla com a maior sequencia.
    */
    
    public static Tupla exercicio2(String palavra){
        Tupla temp = new Tupla(palavra.charAt(0));
        Tupla maior = temp;
        palavra = palavra+" ";
        for(int i = 0; i < palavra.length();i++){            
            if(temp.getLetra() == palavra.charAt(i)){ 
                temp.increment();                
            }else{
                if(temp.getQuantidade() > maior.getQuantidade()){
                    maior = temp;                
                }                
                temp = new Tupla(palavra.charAt(i));
                temp.increment();                                
            }
        }
        System.out.println(maior.toString());
        return maior;
    }
}
