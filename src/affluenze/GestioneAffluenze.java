package affluenze;
import java.util.ArrayList;

public class GestioneAffluenze {
	//public ArrayList <Affluenza> aff = new ArrayList <Affluenza> ();	  

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Affluenza> aff = new ArrayList <Affluenza> ();
		
		ArrayList <Affluenza> affluenza = new ArrayList <Affluenza> ();
		affluenza.add(new Affluenza("Camera", 1 ));
		affluenza.add(new Affluenza("Senato", 1 ));
		affluenza.add(new Affluenza("Quesito1", 0));
		affluenza.add(new Affluenza("Quesito2", 1 ));
		affluenza.add(new Affluenza("Quesito3", 1 ));
		affluenza.add(new Affluenza("Quesito4", 0 ));
		
		aff = Riempi( aff, affluenza);
		
		
		
		int timer = 0;
		while (timer <= 100){
			//System.out.println(timer);
			if (timer == 100){
				for(Affluenza uno: aff){
					System.out.println(uno.getTipologia() +" " + uno.getAffluenze());	
				}
				System.out.println("rimuovo");
				affluenza.removeAll(affluenza);
			}
			timer++;
		}
	}
	/*private static int ContaVoti(ArrayList <Affluenza> array, String tipo){
		int contaVotiTipo = 0;
		for(int i = 0 ; i < array.size() ; i++ ){
			//conto i voti appartenenti alla stessa coalizione
			String k = array.get(i).getTipologia();
			if (k.equals(tipo)){
				contaVotiTipo = contaVotiTipo + array.get(i).getAffluenze();
			}
		}
		return contaVotiTipo;
	}*/
	
	public static ArrayList<Affluenza> Riempi(ArrayList <Affluenza> aff, ArrayList <Affluenza> array){
		aff = new ArrayList <Affluenza> ();
		aff.add(new Affluenza("Camera", 5));
		aff.add(new Affluenza("Senato", 1 ));
		aff.add(new Affluenza("Quesito1", 2));
		aff.add(new Affluenza("Quesito2", 6 ));
		aff.add(new Affluenza("Quesito3", 1 ));
		aff.add(new Affluenza("Quesito4", 3 ));
		
		for(int i = 0; i< aff.size() ; i++ ){
			if(array.get(i).getTipologia().equals(aff.get(i).getTipologia())){
				System.out.println("somma " + aff.get(i).getAffluenze() + " + " + array.get(i).getAffluenze());
				int conta = aff.get(i).getAffluenze() + array.get(i).getAffluenze();
				aff.get(i).setSomma(conta);
				System.out.println("VALORE ARRAY: " + aff.get(i).getAffluenze());
			}
		}
		return aff;
		
	}
}
