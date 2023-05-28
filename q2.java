import java.util.Scanner;
class LowBalanceException extends RuntimeException{
    public LowBalanceException(){
        super("EXCEPTION:THE BALANCE BELOW 500:"); //assuming that the balance limit is RS 500
    }
    public LowBalanceException(String msg){
        super(msg);
    }
}
class PinGeneratorException extends RuntimeException{
    public PinGeneratorException(){
        super("INCORRECT PIN FORMAT:");
    }
    public PinGeneratorException(String msg){
        super(msg);
    }
}
interface A{
    void show1();
    void deposit();
    int withdrawal();
}
class bank implements A{
    Scanner sc=new Scanner(System.in);
    int pin;
    public int startmoney=1000; //ASSUMING INITIALLY THE CUSTOMER HAS 1000 RPS IN BANK ACCOUNT
    public bank(int a){
        pin=a;
    }
    public void show1(){
        System.out.println("welcome to ICICI BANK");
    }
}
class transaction extends bank{
    Scanner sc=new Scanner(System.in);
    int withdraw_money;
    int deposit_money;
    public transaction(int a){
        super(a);
    }
    public int withdrawal(int a1){
        withdraw_money=a1;
        startmoney=startmoney - withdraw_money;
        return startmoney;
    }
    public void deposit(){
        System.out.println("enter the deposited money:");
        deposit_money=sc.nextInt();
        startmoney=startmoney + deposit_money;
        System.out.println("THE AVAILABLE BALANCE="+startmoney);
    }
}
class q2{
    public static void main(String args[]){
        while(true){
            Scanner sc=new Scanner(System.in);
            int num,a2;
            System.out.println("enter the PIN:");
            num=sc.nextInt();
            transaction t1=new transaction(num);
            if(num > 1000 && num < 10000){
                t1.show1();
            }
            else{
                System.out.println("INCORRECT PIN FORMAT:");
                break;
            }
            System.out.println("ENTER 1 FOR WITHDRAWAL:");
            System.out.println("ENTER 2 FOR DEPOSIT:");
            System.out.println("ENTER 3 FOR EXIT:");
            int ch;
            System.out.println("ENTER YOUR CHOICE:");
            ch=sc.nextInt();
            if(ch==1){
                System.out.println("ENTER THE WITHDRAWAL AMOUNT:");
                a2=sc.nextInt();
                int exe=t1.withdrawal(a2);
                if(exe >= 500){
                    System.out.println("THE AVAILABLE BALANCE="+exe);
                }
                else{
                    try{
                        throw new LowBalanceException();
                    }
                    catch(LowBalanceException e){
                        System.out.println(e);
                    }
                    break;
                }    
            }
            else if(ch==2){
                t1.deposit();
            }
            else{
                System.out.println("NO SERVICE OPTED:");
            }
            int choice;
            System.out.println("DO YOU WANT TO CONTINUE:");
            System.out.println("PRESS 10 TO CONTINUE:");
            System.out.println("PRESS 0 TO STOP:");
            System.out.println("ENTER YOUR CHOICE:");
            choice=sc.nextInt();
            if(choice==0){
                System.out.println("***************************TRANSACTION COMPLETE***********");
                break;
            }  
            else{
                continue;
            }
        }
    }
}