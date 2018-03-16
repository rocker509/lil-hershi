import java.util.*;
public class LilHri$hi
{
    Scanner scanner = new Scanner(System.in);
    private String message;
    int key;
    int[] m;
    String outroM = "";
    public LilHri$hi()
    {
        int choice;
        do{
            System.out.println("(1) Encode");
            System.out.println("(2) Decode");
            System.out.println("(3) Quit");
            System.out.print("Choice --> ");
            choice = scanner.nextInt();
        }while(choice < 1 || choice > 3);
        if(choice == 3){
            return;
        }
        System.out.println("Input your desired text...");
        message = scanner.next().toLowerCase();
        if(choice == 1){
            do{
                key = (int)(Math.random() * 1499) + 1000;
            }while(key % 25 == 0);
            System.out.println("Encryption: " + enCode()); 
            System.out.println("Key: " + key);
        }
        else{
            System.out.println("Input Key...");
            key = scanner.nextInt();
            System.out.println("Your message is: " +  deCode());
        }
    }

    public String enCode(){
        intoArray();
        for(int i = 0; i < m.length; i++){
            if(m[i] != -65){
                m[i] = (m[i] + key) % 25;
            }
        }
        int add = key / 25;
        outArray();
        key = key * 100 + add;
        return outroM;
    }

    public String deCode(){
        intoArray();
        int add = key % 100;
        key = key / 100;
        for(int i = 0; i < m.length; i++){
            if(m[i] != -65){
                m[i] = (25 * add + m[i]) - key;
                if(m[i] < 0){
                    m[i] += 25;
                }
            }
        }
        outArray();
        return outroM;
    }

    public void intoArray(){
        m = new int[message.length()];
        for(int i = 0; i < m.length; i++){
            m[i] = ((int)message.charAt(0)) - 97;
            message = message.substring(1 , message.length());
        }
    }

    public void outArray(){
        for(int i = 0; i < m.length; i++){
            outroM = outroM + String.valueOf((char)(m[i] + 97));
        }
    }
}
