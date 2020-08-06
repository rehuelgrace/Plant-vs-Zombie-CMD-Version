import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Play {
	private String status;
	private boolean stop = false;
	private String command;
	//private int countcommand = 0;
	private boolean loopMenu = true;
	private int jumlahZombieMAX = 5;
	private int sunflowerPoint = 200;
	public Array arraydisp;
	
	public Play(Array arraydisp)
	{
		this.arraydisp = arraydisp;
	}
	Scanner input = new Scanner(System.in);
	
	public String getStatusPlay(){
		return status;
	}
	
	public void printSunflowerPoint(){
		System.out.println("Sunflower Point yang dimiliki sebanyak "+ getSunflowerPoint());
	}

	public int getSunflowerPoint(){
		return sunflowerPoint;
	}
	public void setSunflowerPoint(int sunflowerPoint){
		this.sunflowerPoint = sunflowerPoint;
	}
		
	public void printMenu(){
		System.out.println("SKIP untuk lewati giliran");
		System.out.println("BELI untuk membeli tanaman");
		System.out.println("LIHAT untuk melihat jenis tanaman dan harganya");
		}	
	
	public void buyPlant(ArrayAll<PeaShooter> ar1, ArrayAll<FreezePeaShooter> ar2){
		int angka;
		printTanaman();
		printSunflowerPoint();
		System.out.println("Kamu mau beli tanaman nomor berapa?");
		angka = input.nextInt();
		
		if (angka==1){
			if (this.getSunflowerPoint()>=100){
				System.out.println("Pilih lokasi tanaman");
				arraydisp.printGame();
				//Asumsi input selalu valid
				PeaShooter peashooter = new PeaShooter(input.nextInt(), input.nextInt(), arraydisp, ar1);
				//ArrayAll<Plant> ps = new ArrayAll<Plant>('P');
				setSunflowerPoint(this.getSunflowerPoint() - 100);
			}else{
				System.out.println("Sunflower Point tidak mencukupi");
			}
		}else if (angka==2){
			if (this.getSunflowerPoint()>=150){
				System.out.println("Pilih lokasi tanaman <row> <column>");
				arraydisp.printGame();
				//Asumsi input selalu valid
				FreezePeaShooter freezepeashooter = new FreezePeaShooter(input.nextInt(), input.nextInt(),arraydisp,ar2);
				//ArrayAll<Plant> fps = new ArrayAll<Plant>('F');
				setSunflowerPoint(this.getSunflowerPoint() - 150);
			}else{
				System.out.println("Sunflower Point tidak mencukupi");
			}
			
		}else{
				System.out.println("Input tidak dikenali");
		}
		arraydisp.printGame();
		
		}
	public int getGiliran(String command){
		int count = 0;
		while(!arraydisp.isGameOver()){
			if (command.equals("SKIP")){
				count+=1;
			} else {
				count = count;
			}
		}
		return count;
	}	
		
	public void skip(ArrayAll<ZombieBoss> arrZB, ArrayAll<ZombieIndie> arrZI,  ArrayAll<FreezePeaShooter> arrFPS, ArrayAll<PeaShooter> arrPS ,ArrayAll<Pea> arrP){
		//int j = 0;
		//if (j<=jumlahZombieMAX){
			//random panggil zombie di kanan barisan
			//while (!stop){
				for (int i=0; i<240; i++)
				{
					// if zombie ,panggil method maju
					
					int row = 2 * (i / 60) + 1;
					int col = i % 60;
					if (arraydisp.getArrayGame()[row][col] == 'B'){
						//arrZB[i].getArray().move(arrZB, arrZI, arrdisplay, arrP, arrFPS, arrPS);
						//arrZB[i]
						arrZB.getContentIdx(i).move(arrZB, arrZI, arraydisp, arrP, arrFPS, arrPS);
			 		}else if(arraydisp.getArrayGame()[row][col] == 'I'){
						//arrZI[i].move(arrZB, arrZI, arraydisp, arrP, arrFPS, arrPS);
						//System.out.println(arraydisp.getArrayGame()[row][col]);
						arrZI.getContentIdx(i).move(arrZB, arrZI, arraydisp, arrP, arrFPS, arrPS);
						//System.out.println("TesIndie di "+ i);
					// if pea, majuin(?)	
					}else if (arraydisp.getArrayGame()[row][col] == '-'){
						//arrP[i].move() ;//ini apa methodnya
						arrP.getContentIdx(i).move(arrZB, arrZI, arraydisp, arrP, arrFPS, arrPS);
					}
					// tanaman
					else if (arraydisp.getArrayGame()[row][col] == 'P')
					{
						arrPS.getContentIdx(i).serangZombie(arraydisp, arrZB, arrZI, arrP);
					}
					else if (arraydisp.getArrayGame()[row][col] == 'F')
					{
						arrFPS.getContentIdx(i).serangZombie(arraydisp, arrZB, arrZI, arrP);
					}
					// if zombie sampe kiri then status = kalah, stop = true
					// if zombie kalah semua then status = menang, stop = true
				}//nnutup for
				
				/*if (arraydisp.isGameOver())
				{
					stop = true;
				}*/
			//}nutup while, stop udah true
				arraydisp.printGame();
		//}nutup if
		
	}
		
	public void printTanaman(){
		System.out.println("1. Peashooter");
		System.out.println("   Harga : 100 Sunflower Point");
		System.out.println("2. Freeze Peashooter");
		System.out.println("   Harga : 150 Sunflower Point");
		System.out.println("   Dapat membuat zombie berhenti bergerak sementara");
		}		
		
	public void playGames(ArrayAll<ZombieBoss> arrZB, ArrayAll<ZombieIndie> arrZI,  ArrayAll<FreezePeaShooter> arrFPS, ArrayAll<PeaShooter> arrPS ,ArrayAll<Pea> arrP){
		arraydisp.startGame(); //array dibuat
		//arraydisp.printGame(); //array diprint pertama kali
		int countcommand = 0;
		//looping sampai menang/kalah
		while (!arraydisp.isGameOver()){
			if (countcommand % 5 == 0)
			{
				int randomloc = ThreadLocalRandom.current().nextInt(1,5);
				ZombieIndie zi = new ZombieIndie(arraydisp, randomloc, arrZI);
			}
			if ((countcommand % 7 == 0) && (countcommand != 0))
			{
				int randomloc = ThreadLocalRandom.current().nextInt(1,5);
				ZombieBoss zb = new ZombieBoss(arraydisp, randomloc, arrZB);
			}
			if (countcommand == 0)
			{
				arraydisp.printGame();
			}
			 //awal
			//while (loopMenu){
			printMenu();
			command = input.next();

			if (command.equals("SKIP"))
			{
				skip(arrZB, arrZI, arrFPS, arrPS, arrP);
				setSunflowerPoint(this.getSunflowerPoint() + 100);
				countcommand ++;
				//loopMenu = false;
			}
			else if(command.equals("BELI"))
			{
				buyPlant(arrPS, arrFPS);
				countcommand ++;
			}
			else if(command.equals("LIHAT"))
			{
				printTanaman();
			}
			else
			{	
				System.out.println ("Input tidak dikenali");
			}
		} 	//Cuman keluar loop kalau udah skip, berarti zombie udah maju, pea maju
			//Diolah di skip
		
		//arraydisp.printGame();
		printSunflowerPoint();		
	}
	
	
	
}
