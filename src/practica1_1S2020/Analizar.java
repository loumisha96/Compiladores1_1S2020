/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_1S2020;

import java.util.ArrayList;
import jdk.nashorn.internal.runtime.ListAdapter;

/**
 *
 * @author josej
 */
public class Analizar {
    ArrayList<token> lista = new ArrayList<token>();
    ArrayList<Conjunto> listConj;
    String texto;
    public Analizar(String texto) {
        this.texto = texto;
    }
    
    public void Ejecutar(){
        System.out.println("Entro");
        //String texto = texto.getText();
        String[] reservadas = {"CONJ"};
        char[] caracter = texto.toCharArray();
        String lexema= "";
        int ascii;
        for(int i= 0; i<caracter.length; i++){
            
            ascii = (int)caracter[i];
            //switch(estado)
            if(ascii == 123){
                token tk= new token();
                tk.setLexema(String.valueOf(caracter[i]));
                tk.setTipo("Llave Abierta");
                lista.add(tk);
            }
            else if(ascii == 125){
                token tk = new token();
                tk.setLexema(String.valueOf(caracter[i]));
                tk.setTipo("Llave Cerrada");
                lista.add(tk);
            }
            else if(ascii == 40){
                token tk = new token();
                tk.setLexema(String.valueOf(caracter[i]));
                tk.setTipo("Corchete abierto");
            }
            else if(ascii == 41){
                token tk = new token();
                tk.setLexema(String.valueOf(caracter[i]));
                tk.setTipo("Corchete cerrado");
                lista.add(tk);
            }
            else if(ascii == 46){
                token tk = new token();
                tk.setLexema(String.valueOf(caracter[i]));
                tk.setTipo("Concatenación");
                lista.add(tk);
            }
            else if(ascii == 44){
                token tk = new token();
                tk.setLexema(String.valueOf(caracter[i]));
                tk.setTipo("Coma");
                lista.add(tk);
            }
            else if(ascii == 126){
                token tk = new token();
                tk.setLexema(String.valueOf(caracter[i]));
                tk.setTipo("Virgulilla");
                lista.add(tk);
            }
            else if(ascii == 42){
                token tk = new token();
                tk.setLexema(String.valueOf(caracter[i]));
                tk.setTipo("Cerradura Kleene");
                lista.add(tk);
            }
            else if((ascii >=65 && ascii <=90)||(ascii >=97 && ascii <=122)){
                while((i!=caracter.length&&(caracter[i]!= ' ')) &&((ascii >=65 && ascii <=90)||(ascii >=97 && ascii <=122)||(ascii >=48 && ascii <=57))){
                    lexema = lexema + caracter[i];
                    i++;
                    if(i<caracter.length){
                        ascii = caracter[i];
                    }
                    
                }
                i--;
                for(int j =0; j<reservadas.length; j++){
                    if(reservadas[j].equals(lexema)){
                        token tk = new token();
                        tk.setLexema(lexema);
                        tk.setTipo("Reservada");
                        lista.add(tk);
                        lexema = "";
                    
                    }else{
                        token tk = new token();
                        tk.setLexema(lexema);
                        tk.setTipo("ID");
                        lista.add(tk);
                        lexema = "";
                    }
                }
                
            }
            else if(ascii == 34){
                lexema = lexema + caracter[i];
                i++;
                ascii = caracter[i];
                while(i!=caracter.length && ascii != 34){
                    lexema = lexema + caracter[i];
                    i++;
                    ascii = caracter[i];
                }
                lexema = lexema + caracter[i];
                i--;
                token tk = new token();
                tk.setLexema(String.valueOf(lexema));
                tk.setTipo("Cadena");
                lexema = "";
                lista.add(tk);
                i++;
                lexema = "";
            }
            else if(ascii == 124){
                token tk = new token();
                tk.setLexema(String.valueOf(caracter[i]));
                tk.setTipo("Disyuncion");
                lista.add(tk);
            }
            else if(ascii == 63){
                token tk = new token();
                tk.setLexema(String.valueOf(caracter[i]));
                tk.setTipo("0 o más veces");
                lista.add(tk);
            }
            else if(ascii == 43){
                token tk = new token();
                tk.setLexema(String.valueOf(caracter[i]));
                tk.setTipo("1 o más veces");
                lista.add(tk);
            }else if(ascii == 35){
                token tk = new token();
                tk.setLexema(String.valueOf(caracter[i]));
                tk.setTipo("Numeral");
                lista.add(tk);
            }else if(ascii >=48 && ascii <=57){
                while(i!=caracter.length && ascii!=32&&((ascii >=48 && ascii <=57))){
                    lexema = lexema + caracter[i];
                    i++;
                    ascii = caracter[i];
                }
                i--;
                token tk = new token();
                tk.setLexema(String.valueOf(lexema));
                tk.setTipo("Digito");
                lista.add(tk);
                lexema = "";
            }
            else if(ascii == 59){
                token tk = new token();
                tk.setLexema(String.valueOf(caracter[i]));
                tk.setTipo("Punto y coma");
                lista.add(tk);
            }else if(ascii == 47){
                lexema = lexema + caracter[i];
                i++;
                ascii= (int)caracter[i];
                if(ascii== 47){
                    lexema = lexema + caracter[i];
                    i++;
                    ascii= (int)caracter[i];
                    while(i!=caracter.length&&ascii !=10){
                        lexema = lexema + caracter[i];
                        i++;
                        ascii = caracter[i];
                    }
                    i--;
                    token tk = new token();
                    tk.setLexema(String.valueOf(lexema));
                    tk.setTipo("Comentario");
                    lista.add(tk);
                    lexema = "";
                }
                else{
                    token tk = new token();
                    tk.setLexema(String.valueOf(lexema));
                    tk.setTipo("signo");
                    lista.add(tk);
                    lexema = "";
                }
                
                
            }else if(ascii == 60){
                ascii= (int)caracter[i+1];
                lexema = lexema + caracter[i];
                if(ascii ==33){
                    i++;
                    ascii= (int)caracter[i+1];
                    
                    while(i!=caracter.length && ascii != 33){
                        lexema = lexema + caracter[i];
                        i++;
                        ascii= (int)caracter[i];
                    }
                    lexema = lexema + caracter[i];
                    ascii= (int)caracter[i+1];
                    if(ascii ==62){
                        i++;
                        lexema = lexema + caracter[i];
                        token tk = new token();
                        tk.setLexema(String.valueOf(lexema));
                        tk.setTipo("Comentario");
                        lista.add(tk);
                        lexema = "";
                    }
                }
                else{
                    token tk = new token();
                    tk.setLexema(String.valueOf(caracter[i]));
                    tk.setTipo("Signo");
                    lista.add(tk);
                }
                
            }else if(ascii == 37){
                token tk = new token();
                tk.setLexema(String.valueOf(caracter[i]));
                tk.setTipo("Porcentaje");
                lista.add(tk);
            }
            else if(ascii == 58){
                token tk = new token();
                tk.setLexema(String.valueOf(caracter[i]));
                tk.setTipo("Dos puntos");
                lista.add(tk);
            }
            else if(ascii ==45){
                ascii = caracter[i+1];
                if(ascii == 62){
                    lexema = lexema + caracter[i];
                    lexema = lexema + caracter[i+1];
                    i++;
                }
                else{
                    token tk = new token();
                    tk.setLexema(String.valueOf(caracter[i]));
                    tk.setTipo("Signo");
                    lista.add(tk);
                    lexema = "";
                }
                token tk = new token();
                tk.setLexema(String.valueOf(lexema));
                tk.setTipo("Flecha");
                lista.add(tk);
                lexema= "";
            }
            else if(ascii!= 10 && ascii !=32 && ascii !=13){
                token tk = new token();
                tk.setLexema(String.valueOf(caracter[i]));
                tk.setTipo("Error");
                lista.add(tk);
            }
            
        }
       // print();
       
       
       for(int i = 0; i<lista.size(); i++){
            System.out.print(lista.get(i).getLexema()+" ");
            System.out.println(lista.get(i).getTipo());
        }
       
       
       
    }
    
    public void definirConjuntos(){
        int ascii;
        char caracter;
        int i=0;
        while(lista.get(i).tipo.equals("Reservada")){
            
            i++;
            if(lista.get(i).tipo.equals("Dos puntos")){
                i++;
               if(lista.get(i).tipo.equals("ID")){
                   i++;
                   Conjunto conj= new Conjunto();
                   if(lista.get(i+1).lexema.equals("~")){
                       conj.setNombre(lista.get(i).lexema);
                       caracter = lista.get(i).lexema.charAt(i);
                       ascii=(int)caracter;
                       conj.setRangoMenor(ascii);
                       caracter = lista.get(i+2).lexema.charAt(i+2);
                       ascii=(int)caracter;
                       conj.setRangoMayor(ascii);
                   }
               }
            }
                
        }
    }
    public void definirExpresiones(){
        
    }
    
}
