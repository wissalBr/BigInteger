

import java.lang.String;
import java.math.BigInteger;

import java.util.Scanner;


public class Main {

	
	public static void main(String[] args) {
		
	
		
		System.out.println("Bienvenue !");
		System.out.println("1- Addition grand Nombre");
		System.out.println("2- Soustraction grand Nombre");
		System.out.println("3- Multiplication grand Nombre");
		System.out.println("4- Addition modulaire grand Nombre");
		System.out.println("5- Soustraction modulaire grand Nombre");
		System.out.print("Votre choix: ");
		
		try (Scanner in = new Scanner ( System.in )) {
			String GN1 = "";
			String GN2 = "";
			String GN3 = "";
			@SuppressWarnings("resource")
			Scanner inN1 = new Scanner ( System.in );
			@SuppressWarnings("resource")
			Scanner inN2 = new Scanner ( System.in );
			//@SuppressWarnings("unused")
			Scanner inN3 = new Scanner ( System.in );
			
			switch ( in.nextInt() ) {
			  case 1 :
				  System.out.println();
				  System.out.println("1- Addition grand Nombre!");
				  System.out.println();
				  System.out.println("Entrez votre premier grand nombre N1");
				  GN1 = inN1. nextLine();
				  System.out.println("Entrez votre premier grand nombre N2");
				  GN2 = inN2. nextLine();
				  
				  BigInteger A1 =  new BigInteger(GN1);
				  BigInteger A2 =  new BigInteger(GN2);
				  
				  Nombre1024 N11 = new Nombre1024(A1);
				  System.out.print("N1 = ");
				  System.out.print(N11.affichage());
				  System.out.print(" / "+N11.affichage().length());
				  System.out.println();
				  
				  Nombre1024 N12 = new Nombre1024(A2);
				  System.out.print("N2 = ");
				  System.out.print(N12.affichage());
				  System.out.print(" / "+N12.affichage().length());
				  System.out.println();
				  
				  System.out.print("N1 + N2 = ");
				 // long lStartTime = System.nanoTime();
				  System.out.print(N11.addition(N12).affichage());
				 // long lEndTime = System.nanoTime();
				  //System.out.println("Elapsed time in milliseconds: " + ( lEndTime - lStartTime )/1000000);
				  System.out.print(" / "+N11.addition(N12).affichage().length());
				  System.out.println();
				
				  break;
				  
			  case 2 :
				  System.out.println();
				  System.out.println("2- Soustraction grand Nombre!");
				  System.out.println();
				  System.out.println("Entrez votre premier grand nombre N1");
				  GN1 = inN1. nextLine();
				  System.out.println("Entrez votre premier grand nombre N2");
				  GN2 = inN2. nextLine();
				  
				  BigInteger S1 =  new BigInteger(GN1);
				  BigInteger S2 =  new BigInteger(GN2);
				  
				  Nombre1024 N21 = new Nombre1024(S1);
				  System.out.print("N1 = ");
				  System.out.print(N21.affichage());
				  System.out.print(" / "+N21.affichage().length() + " / "+N21.getTaille());
				  System.out.println();
				  
				  Nombre1024 N22 = new Nombre1024(S2);
				  System.out.print("N2 = ");
				  System.out.print(N22.affichage());
				  System.out.print(" / "+N22.affichage().length() + " / "+N22.getTaille());
				  System.out.println();
				  
				  System.out.print("N1 - N2 = ");
				  System.out.print(N21.soustractionPositif(N22).affichage());
				  System.out.print(" / "+N21.soustraction(N22).affichage().length());
				  System.out.println();
				
				  break;
				  
			  case 3 :
				  System.out.println();
				  System.out.println("3- Multiplication grand Nombre!");
				  System.out.println();
				  System.out.println("Entrez votre premier grand nombre N1");
				  GN1 = inN1. nextLine();
				  System.out.println("Entrez votre premier grand nombre N2");
				  GN2 = inN2. nextLine();
				  
				  BigInteger M1 =  new BigInteger(GN1);
				  BigInteger M2 =  new BigInteger(GN2);
				  
				  Nombre1024 N31 = new Nombre1024(M1);
				  System.out.print("N1 = ");
				  System.out.print(N31.affichage());
				  System.out.print(" / "+N31.affichage().length());
				  System.out.println();
				  
				  Nombre1024 N32 = new Nombre1024(M2);
				  System.out.print("N2 = ");
				  System.out.print(N32.affichage());
				  System.out.print(" / "+N32.affichage().length());
				  System.out.println();
				  
				  System.out.print("N1 * N2 = ");
				  long lStartTime = System.nanoTime();
				  System.out.print(N31.multiplication(N32).affichage());
				  long lEndTime = System.nanoTime();
				  System.out.println();
				  System.out.println("Elapsed time in milliseconds: " + ( lEndTime - lStartTime )/1000000);
				 
				
				  System.out.println();
				 // System.out.print(" / "+N31.multiplication(N32).affichage().length());
				  System.out.println();
				
				  break;
			  case 4 :
				  System.out.println();
				  System.out.println("4- Addition modulaire grand Nombre!");
				  System.out.println();
				  System.out.println("Entrez votre premier grand nombre N1");
				  GN1 = inN1. nextLine();
				  System.out.println("Entrez votre premier grand nombre N2");
				  GN2 = inN2. nextLine();
				  System.out.println("Entrez le modulo");
				  GN3 = inN3. nextLine();
				  
				  BigInteger AM1 =  new BigInteger(GN1);
				  BigInteger AM2 =  new BigInteger(GN2);
				  BigInteger AM3 =  new BigInteger(GN3);
				  
				  Nombre1024 N41 = new Nombre1024(AM1);
				  System.out.print("N1 = ");
				  System.out.print(N41.affichage());
				  System.out.print(" / "+N41.affichage().length());
				  System.out.println();
				  
				  Nombre1024 N42 = new Nombre1024(AM2);
				  System.out.print("N2 = ");
				  System.out.print(N42.affichage());
				  System.out.print(" / "+N42.affichage().length());
				  System.out.println();
				  
				  Nombre1024 N43 = new Nombre1024(AM3);
				  System.out.print("n   = ");
				  System.out.print(N43.affichage());
				  System.out.print(" / "+N43.affichage().length());
				  System.out.println();
				  
				  System.out.print("N1+N2 mod(n) = ");
				  System.out.print(N41.additionModulaire(N42,N43).affichage());
				  System.out.print(" / "+N41.additionModulaire(N42,N43).affichage().length());
				  
				  
				  break;
				  
			  case 5 :
				  System.out.println();
				  System.out.println("5- Soustraction modulaire grand Nombre!");
				  System.out.println();
				  System.out.println("Entrez votre premier grand nombre N1");
				  GN1 = inN1. nextLine();
				  System.out.println("Entrez votre premier grand nombre N2");
				  GN2 = inN2. nextLine();
				  System.out.println("Entrez le modulo");
				  GN3 = inN3. nextLine();
				  
				  BigInteger SM1 =  new BigInteger(GN1);
				  BigInteger SM2 =  new BigInteger(GN2);
				  BigInteger SM3 =  new BigInteger(GN3);
				  
				  Nombre1024 N51 = new Nombre1024(SM1);
				  System.out.print("N1 = ");
				  System.out.print(N51.affichage());
				  System.out.print(" / "+N51.affichage().length());
				  System.out.println();
				  
				  Nombre1024 N52 = new Nombre1024(SM2);
				  System.out.print("N2 = ");
				  System.out.print(N52.affichage());
				  System.out.print(" / "+N52.affichage().length());
				  System.out.println();
				  
				  Nombre1024 N53 = new Nombre1024(SM3);
				  System.out.print("n   = ");
				  System.out.print(N53.affichage());
				  System.out.print(" / "+N53.affichage().length());
				  System.out.println();
				  
				  System.out.print("N1-N2 mod(n) = ");
				  System.out.print(N51.SoustractionModulaire(N52,N53).affichage());
				  System.out.print(" / "+N51.additionModulaire(N52,N53).affichage().length());
				  
				  
				  break;
				  
				  
			}
		}

		
	}

}
