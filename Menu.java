import java.util.Scanner;
public class Menu {
	private String nama;
	private int command;
	private boolean exit=false;
	
	public Menu()
	{
	}
	
	public static void main (String[] args)
	{
		Menu menu = new Menu();
		menu.go();
	}

	public void go ()
	{
	Scanner input = new Scanner(System.in);
	System.out.println("Mulai permainan, masukkan nama anda!");
	this.nama = input.next();
	
	System.out.println("Input angka untuk menjalankan perintah");
	System.out.println("1. Main");
	System.out.println("2. Help");
	System.out.println("3. Ganti nama");
	
	
	while(!exit){
		command = input.nextInt();
		if (command==1){
			System.out.println("Selamat bermain!");	
			Array arraydisp = new Array();
			Play play = new Play(arraydisp);
			ArrayAll<ZombieBoss> arrZB = new ArrayAll<ZombieBoss>('B');
			ArrayAll<ZombieIndie> arrZI = new ArrayAll<ZombieIndie>('I');
			ArrayAll<PeaShooter> arrPS = new ArrayAll<PeaShooter>('P');
			ArrayAll<FreezePeaShooter> arrFPS = new ArrayAll<FreezePeaShooter>('F');
			ArrayAll<Pea> arrP = new ArrayAll<Pea>('-');
			
			play.playGames(arrZB, arrZI, arrFPS, arrPS, arrP);
			exit = true;
			System.out.println("Permainan telah selesai");
			//System.out.println(nama + " kamu telah " +play.getStatusPlay());
		}else if(command==2){
			System.out.println("Ini adalah permainan Plant vs Zombie Sederhana");	
			System.out.println("Zombie akan menyerang dari sisi kanan dan berjalan menuju ke kiri");	
			System.out.println("Pemain harus menghentikan zombie dengan cara menyerang menggunakan tanaman");	
			System.out.println("Tanaman dapat dibeli menggunakan Sunflower Point yang didapatkan dari setiap giliran");	
			System.out.println("Perintah SKIP digunakan untuk melewati giliran membeli");	
			System.out.println("Perintah untuk membeli akan diberitahu pada saat permainan");	
			System.out.println("Pemain akan menang saat semua zombie kalah dan permainan dinyatakan selesai");	
			System.out.println("Jika zombie menyentuk sisi kiri maka pemain kalah dan permainan dinyatakan selesai");	
			
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			
			//System.out.println("Selamat bermain!");	
			//playGames();
			//exit = true;
		}else if(command==3){
			System.out.println("Silakan masukkan nama baru");			
			nama = input.next();
			System.out.println("Input angka untuk menjalankan perintah");
			System.out.println("1. Main");
			System.out.println("2. Help");
			System.out.println("3. Ganti nama");
		}else{
			System.out.println("Input tidak dikenali");
			System.out.println("Input angka untuk menjalankan perintah");
			System.out.println("1. Main");
			System.out.println("2. Help");
			System.out.println("3. Ganti nama");			
		}	
	}
	//System.out.println("Permainan telah selesai");
	//System.out.println(nama, " kamu telah ", play.getStatusPlay());	
	}
}
