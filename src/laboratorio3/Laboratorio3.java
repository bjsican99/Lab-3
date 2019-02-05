package laboratorio3;
import java.util.*;
/**
 *Software tipo planilla, para calculo de sueldo liquido, con uso de vectores y matrices.
 * @author BillyS
 * 0901-17-16250
 */
public class Laboratorio3 {  
    public static void main(String[] args) {        
        //Vectores y Matrices
        int [][] intPlanilla = new int[10][6];
        int [] intDepartamento = new int[5];
        String [] snombres = new String[10];
        System.out.println("Bienvenido");
        LlenadoDePlanilla(intPlanilla, snombres);
        SumaSueldo(intPlanilla, intDepartamento);
        MostrarPlanillaYVector(intPlanilla, intDepartamento, snombres);
    }
    
    public static void LlenadoDePlanilla(int[][] intPlani, String[] sNombresVec){
        Scanner scngua = new Scanner(System.in);
        int iConteo=1;
        String sNombre;
        Random rSueldoBase = new Random();
        Random rDeducciones = new Random();
        Random rPersepciones = new Random();
        Random rDepartamento = new Random();
        for(int ifila = 0; ifila <10; ifila++){
            System.out.println("Ingrese el Nombre del Empleado #"+iConteo);
            sNombre = scngua.next();//Guardar el nombre en una variable            
            sNombresVec[ifila] = sNombre;//nombre
            intPlani[ifila][0] = ifila;
            intPlani[ifila][1] = rSueldoBase.nextInt(2000)+1500;
            intPlani[ifila][2] = rDeducciones.nextInt(500)+100;
            intPlani[ifila][3] = rPersepciones.nextInt(500)+250;
            intPlani[ifila][4] = intPlani[ifila][1]-intPlani[ifila][2]+intPlani[ifila][3];
            intPlani[ifila][5] = rDepartamento.nextInt(5)+1;            
            iConteo++;
        }   
    }
    
    public static void SumaSueldo(int[][] intPlani, int[] intDepar){
        for(int iPosicion = 0; iPosicion < 10; iPosicion++){
            switch(intPlani[iPosicion][5]){
                case 1:
                    intDepar[0] += intPlani[iPosicion][4];
                break; 
                case 2:
                    intDepar[1] += intPlani[iPosicion][4];
                break;
                case 3:
                    intDepar[2] += intPlani[iPosicion][4];
                break;
                case 4:
                    intDepar[3] += intPlani[iPosicion][4];
                break;
                case 5:
                    intDepar[4] += intPlani[iPosicion][4];
                break;
            }
        }
    }
    
    public static void MostrarPlanillaYVector(int[][] intPlani, int[] intDepar, String[] sNombresVec){
        int iconteoaux=1;
        System.out.println("-------------------------------------------------");
        
        for(int iFila=0; iFila <10; iFila++){            
                System.out.println("Nombre: "+sNombresVec[iFila]+"--Sueldo Base: "+intPlani[iFila][1]+"--Deducciones: "+intPlani[iFila][2]+"--Prestaciones: "+intPlani[iFila][3]+"--Sueldo Liquido: "+intPlani[iFila][4]+"--Departamento: "+intPlani[iFila][5]);            
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Total Por Departamento");
        for(int iPosicion = 0; iPosicion <5;iPosicion++){
            System.out.println("Numero De Departamento "+iconteoaux+": "+intDepar[iPosicion]);
            iconteoaux++;
        }
        
    }
}