package Proyecto1;

import java.util.Scanner;

public class Adivinador 
{
	Scanner inputScanner = new Scanner (System.in);
        String resp;

//------------------------------------------------------------------------------
    public static void main(String[] args) 
    {
        //Explicación de lo que hace el programa
	System.out.println("Este programa intenatrá adivinar un número pensado por el usuario entre el 1-100 de tal forma que cada vez");
        System.out.println("el programa mostrará un numero y el usuario tendrá 3 opciones para contestar: 'exacto', 'mayor' o 'menor'.");
        System.out.println("Dependiendo de esta respuesta el programa irá acotando los posibles valores hasta que finalmente lo acierte.");
        System.out.println("Al final mostrará los intentos que ha necesitado para acertarlo.");
        
        Adivinador test = new Adivinador();
	test.Adivinador(); //Llamada al juego
        
        test.JugarOtra(); //Llamar a otro método donde el jugador indicará si quiere seguir jugando.
        
    }
    
//------------------------------------------------------------------------------
    void Adivinador()
    {
        //DECLARACIÓN DE VARIABLES
        boolean condicion = false;
        int cont = 0;
        int prop = 50;
        int min = 1;
	int max = 100;
        
        System.out.println("Piensa un número entre el " + min + " y el " + max + " y yo lo adivinaré");
        
        while(condicion == false) //Realiza el programa hasta que el jugador diga que adivinó el número
        {
            cont++;  //Actualizo el contador para imprimir posteriormente el número de intentos utilizados.

            if (prop <= min || prop >= max) //Detector de tramposos :/
            {
		System.out.println("Eres un poquito tramposete tu no???? Pierdes el progreso de esta partida por listo");
		return; //Si detecto que ha hecho trampas, para la ejecución del programa y le volveré a dejar jugar en la siguiente partida
            }

            System.out.println("¿El número que has pensado es exacto " + prop + "? En caso de que no, solo dime si es menor o mayor");
            
            switch(inputScanner.nextLine())
            {
                //Agrupo todos los posibles casos en los que el usuario puede introducir por teclado la instrucción para no generar un fallo en el programa. Podemos llamarlo una especie de cortafuegos. 
                
                case "Exacto":
                case "exacto":
                case "EXACTO":
                case "=":
                case "Sí":
                case "si":
                case "sí":
                case "Si":
                case "SI":
                case "SÍ":
                case "sI":
                case "sÍ":
                    condicion = true; //Si lo que detecto por consola equivale a un =, hago que pare de realizar el bucle y muestre que ha ganado.
                    break;
                    
                case "menor":
                case "Menor":
                case "MENOR":
                case "mENOR":
                case "<":
                    max = prop; //En el caso de que me diga que es menor actualizo la variable máximo a ese número y además con la línea de abajo actualizo la siguiente opción que le mostraré.
                    prop = (max+min)/2;
                    break;
                    
                case "mayor":
                case "Mayor":
                case "MAYOR":
                case "mAYOR":
                case ">":
                    min = prop; //Aquí realizo lo contrario, si me dice que es mayor, actualizo el mínimo y la variable que le mostraré a continuación.
                    prop = (max+min)/2;
                    break;
                
                default:
                    System.out.println("***ERROR***");  //En el caso de que ponga algún parametro incorrecto le diré que vuelva a escribir bien la instrucción.
                    System.out.println("No se contempla esa opción, vuelve a escribirlo pero esta vez bien jeje");
                    break;
            }
        }
        //En esta parte del código le muestro los resultados.
        System.out.println("El número que habías pensado es el " + prop);
        if(cont == 1)
        {
            System.out.println("Ja sabía que te lo adivinaría a la primera ;)");
        }
        else if(cont == 2)
        {
            System.out.println("Bueno, no está mal adivinarlo a la segunda eh...");
        }
        else if(cont > 2 && cont < 5)
        {
            System.out.println("No está mal, tan solo he necesitado " + cont + " intentos jeje");
        }
        else
        {
            System.out.println("Buah, tu número ha sido muy dificil, he necesitado muchos intentos, en concreto: " + cont);
        }
    }
    
//------------------------------------------------------------------------------    
    void JugarOtra()
    {
        /*En este método simplemente le pregunto que si quiere volver a jugar
        y en el caso de que su respuesta sea sí, llamo al método Adivinador,
        si la respuesta es no, finalizo el programa.
        */
        System.out.println("¿Quieres que te vuelva a ganar (si/no)?");
        
        switch(inputScanner.nextLine())
        {
            case "Sí":
            case "si":
            case "sí":
            case "Si":
            case "SI":
            case "SÍ":
            case "sI":
            case "sÍ":
                Adivinador();  
                break;
            
            case "no":
            case "No":
            case "NO":
            case "nO":
                break;
                
            default:
                System.out.println("***ERROR***");
                System.out.println("No entendí la instrucción, lo tomaré como un NO");
                break;
        }
    } 
}

//Aarón Blanco Medrano
