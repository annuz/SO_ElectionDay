package affluenze;

public class Affluenza {
	
		private String tipologia;
		private int affluenze ;
		
		public Affluenza(String tipologia, int affluenze) {
			// TODO Auto-generated constructor stub
			this.affluenze = affluenze;
			this.tipologia = tipologia;
		}
		
		public String getTipologia(){
			return tipologia;
		}
		public int getAffluenze(){
			return affluenze;
		}
		public int setSomma( int val ){
			return affluenze = val;
		}
	}

