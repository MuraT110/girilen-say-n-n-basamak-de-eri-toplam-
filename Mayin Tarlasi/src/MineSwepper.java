import com.sun.security.jgss.GSSUtil;
import java.util.Random;
import java.util.Scanner;

public class MineSwepper {
    int rowNumber;
    int colNumber;
    String[][] mayinMap;
    String[][] gameMap;
    int mayinSayisi;
    int a,b;
    int count;
    boolean isTrue=true;

    public MineSwepper(int row,int col){
        this.rowNumber=row;
        this.colNumber=col;
        this.gameMap=new String[row][col];
        this.mayinMap=new String[row][col];
        this.mayinSayisi=(row * col)/4;
    }
    public void mayinMap(){
        for (int i=0;i<rowNumber;i++){
            for (int j=0;j<colNumber;j++){
                mayinMap[i][j]="-";
                gameMap[i][j]="-";


            }
        }
    }
    public void randomNumber(){
        Random r=new Random();
        for (int i=0;i<this.mayinSayisi;i++){
            int rSayi=r.nextInt(this.rowNumber);
            int rSayi2=r.nextInt(this.colNumber);
            if (!this.mayinMap[rSayi][rSayi2].equals("*")){
                this.mayinMap[rSayi][rSayi2]="*";
            }
        }
    }
    public void printMayinMap(){
        System.out.println("Mayınların konumu");
        randomNumber();
        for (int i=0;i<this.rowNumber;i++){
            for (int j=0;j<this.colNumber;j++){
                if (!this.mayinMap[i][j].equals("*")){
                    this.mayinMap[i][j]="-";
                }
                System.out.print(this.mayinMap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=======================");
        System.out.println("Mayın Tarlası Oyununa Hoş Geldiniz");
    }
    public void printGameMap(){
        for (int i=0;i<this.rowNumber;i++){
            for (int j=0;j<this.colNumber;j++){
                this.gameMap[i][j]="-";
                System.out.print(this.gameMap[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void indisSecme(){
        Scanner inp=new Scanner(System.in);
        isTrue=false;
        while (!isTrue){
            System.out.print("Satır Sayına Giriniz : ");
            a=inp.nextInt();
            System.out.print("Sütun Sayısına Giriniz : ");
            b=inp.nextInt();
            if (a > rowNumber || b > colNumber) {
                System.out.println("Map sinirlari disinda secim yaptınız tekrar giriniz !");
                continue;
            }
            if (mayinMap[a][b].equals("*")){
                System.out.println("Game Over ! ");
                break;
            }
            control();
            if (finish()){
                System.out.println("Tebrikler Kazandınız !");
                break;
            }
        }
    }
    public void control(){
        count=0;
        for (int i=(a-1);i<=(a+1);i++){
            for (int j=(b-1);j<=(b+1);j++){
                if (i<0 || j<0 || i>=this.rowNumber || j>=this.colNumber){
                    continue;
                }
                if (this.mayinMap[i][j].equals("*")){
                    count++;
                }
            }
        }
        this.gameMap[a][b]=String.valueOf(count);
        this.mayinMap[a][b]=String.valueOf(count);
        for (int i=0;i<this.rowNumber;i++){
            for (int j=0;j<this.colNumber;j++){
                System.out.print(this.gameMap[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public boolean finish(){
        for (int i=0;i<this.rowNumber;i++){
            for (int j=0;j<this.colNumber;j++){
                if (mayinMap[i][j].equals("-")){
                    return false;
                }
            }
        }
        return true;
    }
    public void run(){
        mayinMap();
        printMayinMap();
        indisSecme();
    }
}
