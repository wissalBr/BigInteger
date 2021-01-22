import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Nombre1024 {
	
	
	int[] Nombre = new int[70];
	
	private int taille;
	public final NumberFormat formatter = new DecimalFormat("000000000"); 
	
	Nombre1024 (BigInteger B) {
		boolean bool = (B.toString().length()%9)== 0;
		int val = (bool) ? 0 : 1;
		this.taille = B.toString().length()/9 + val;
		BigInteger d =  new BigInteger("1000000000");
		
		for(int i=this.taille-1;i>=0; i--)
		{
			this.Nombre[i]= B.remainder(d).intValue();
			B = B.divide(d);
		}
	}
	
	
	public String affichage() {
		
		String ch ="";
		
		ch = ch + this.Nombre[0];
		for ( int j=1 ; j <= this.taille-1 ; j++ ) {
			ch = ch + formatter.format(this.Nombre[j]);
		}
		
		return ch;
			
	}
	
	public boolean sup(Nombre1024 N1 ) {
		boolean res = false;
		if (this.affichage().toString().length() < N1.affichage().toString().length()) res = false ; 
		else if ((this.taille == N1.taille) && (this.Nombre[0]<N1.Nombre[0])) res = false; 
			else res = true;
		return res;
	}
	

	public void setTaille(int n) {
		this.taille = n;
	}
	
	public int getTaille() {
		return this.taille;
	}
	

	public void setNombre(int i, int n) {
		this.Nombre[i]=n;
	}
	
	
	public Nombre1024 addition(Nombre1024 N1) {
		
		Nombre1024 Result = new Nombre1024(new BigInteger("0"));
		int retenu = 0;
		int c = 0;
		boolean THIS_IS_MAX = true;
		int diffTaille=0;
		
		
		//Choix de la taille du resultat:
		if (this.taille> N1.taille) {
			Result.taille=this.taille;
			diffTaille = this.taille - N1.taille;
		}
		else if (this.taille<= N1.taille) {
			Result.taille = N1.taille;
			THIS_IS_MAX = false;
			diffTaille = N1.taille - this.taille;
		}
		
		
		if (THIS_IS_MAX == true) {
			
		
		for(int i=N1.taille-1; i>=0; i--)
		{
			
			c = retenu + this.Nombre[i+diffTaille]+N1.Nombre[i];
			Result.setNombre(i+diffTaille, c%1000000000);
			retenu = c/1000000000;	
			
			
		}
		
		for (int j = diffTaille-1 ; j>=0; j--) {
			
			Result.Nombre[j]= retenu + this.Nombre[j];
		}
		}
		
		if (THIS_IS_MAX == false){
			
			for(int i=this.taille-1; i>=0; i--)
			{
				c = retenu + N1.Nombre[i+diffTaille]+this.Nombre[i];
				Result.setNombre(diffTaille+i, c%1000000000);
				retenu = c/1000000000;			
				
			}
			for (int j = diffTaille-1 ; j>=0; j--) {
			
				Result.Nombre[j]=retenu + N1.Nombre[j];
				}
			}
		
		
		
		return Result;		
	}
	
	public Nombre1024 Decal(int x) {
		Nombre1024 decal = new Nombre1024(new BigInteger("0"));
		decal.setTaille(this.taille+x);
		
		decal.Nombre[decal.taille-1]=0;
		for(int i=0; i<=decal.taille-1; i++) {
			if (i<=decal.taille - x +1)
			decal.Nombre[i]= this.Nombre[i];
			else decal.Nombre[i]=0;
		}
		return decal;
	}
	public int toStringTaille() {
		String ch ="";
		for (int i=0 ; i<this.taille ; i++) {
			ch= ch + this.Nombre[i];
		}
		
		return ch.length();
	}
	
	public Nombre1024 additionModulaire(Nombre1024 N1, Nombre1024 n) {
		Nombre1024 res = this.addition(N1);
		Nombre1024 a = null;
		if (res.sup(n) == false ) return this.addition(N1);
		else {
			
			while (res.sup(n) == true) {
					a = res.soustractionPositif(n);
					res = a;
					}
		
		return a;
		}
	}
	
	public Nombre1024 SoustractionModulaire(Nombre1024 N1, Nombre1024 n) {
		Nombre1024 res = this.soustractionPositif(N1);
		Nombre1024 a = null;
		if (res.sup(n) == false ) return this.soustractionPositif(N1);
		else {
			
			while (res.sup(n) == true) {
					a = res.soustractionPositif(n);
					res = a;
					}
		
		return a;
		}
	}
	

	
	public Nombre1024 multiplication(Nombre1024 N1) {
		
		Nombre1024 Result = new Nombre1024(new BigInteger("0"));
		long ResultUnit = 0;
		long RetenuUnit = 0;
		
		Result.taille=N1.taille + this.taille -2;
	
		for(int j=this.taille-1; j>=0; j--) {
				
				ResultUnit = 0;
				RetenuUnit = 0;
				Nombre1024 ResultX = new Nombre1024(new BigInteger("0"));
				ResultX.taille = N1.taille +1;
				
				for(int k=N1.taille; k>=1; k--) {
				
					ResultUnit = RetenuUnit + Long.valueOf(this.Nombre[j])*Long.valueOf(N1.Nombre[k-1]);
					ResultX.Nombre[k]=(int)((ResultUnit)%10000000);
					RetenuUnit = ResultUnit/10000000;
			
				}
			
				ResultX.Nombre[0]=(int)RetenuUnit;
				Result = Result.addition(ResultX.Decal(this.taille - 1 -j));
		
			}
	
		return Result;
	}
	

	
	public Nombre1024 soustractionPositif(Nombre1024 N1) {
		
		
		Nombre1024 Result = new Nombre1024(new BigInteger("0"));
		Result.taille=this.taille;
		int diff = this.taille - N1.taille;
		
		
		for(int i=this.taille-1; i>diff  ; i--) {
			if (this.Nombre[i]>=N1.Nombre[i-diff]) Result.Nombre[i]= this.Nombre[i]-N1.Nombre[i-diff];
			else {
				Result.Nombre[i] = this.Nombre[i] + 1000000000 -N1.Nombre[i-diff] ;
				N1.Nombre[i-diff-1] = N1.Nombre[i-diff-1] - 1;
		
			}
			//System.out.println( Result.Nombre[i]);
		}
		
		Result.Nombre[diff]= this.Nombre[diff] - N1.Nombre[0];
		
		for(int i=diff -1; i>=0  ; i--) {
			Result.Nombre[i]= this.Nombre[i];
		}
		
		
		
		
		
		return Result;
	}
	
	public Nombre1024 soustraction(Nombre1024 N1) {
		Nombre1024 Result = new Nombre1024(new BigInteger("0"));
		Result = this.soustractionPositif(N1); 
		if (this.sup(N1)==true) return Result;
		else {
			Result.setNombre(0, N1.soustractionPositif(this).Nombre[0]*(-1));
			return Result;
		}
		
	}

	

	

}
