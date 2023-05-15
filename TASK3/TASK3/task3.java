import java.util.*;
class Bank {
    String name,username,password,acct_no;
    float balance = 100000f;
    int transaction = 0;
    String transHistory = " ";

    public void register()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        this.name = sc.nextLine();
        System.out.println("Enter your username:");
        this.username = sc.nextLine();
        System.out.println("Enter your password:");
        this.password = sc.nextLine();
        System.out.println("Enter your account number:");
        this.acct_no = sc.nextLine();
        System.out.println("Registration completed.....You can login now!!!");
    }

    public boolean login()
    {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while( !isLogin)
        {
            System.out.println("Enter username:");
            String user_name = sc.nextLine();
            if(user_name.equals(username))
            {
                while(!isLogin)
                {
                    System.out.println("Enter password:");
                    String pass_word = sc.nextLine();
                    if(pass_word.equals(password))
                    {
                        System.out.println("Login Successful!!!");
                        isLogin = true;
                    }
                    else
                    {
                        System.out.println("Incorrect Password!!");
                    }
                }
            }
            else
            {
                System.out.println("Username not found!!");
            }
        }
        return isLogin;
    }
    public void withdraw()
    {
        System.out.println("Enter the amount you want to withdraw:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try
        {
            if(balance >= amount)
            {
                transaction++;
                balance = balance-amount;
                System.out.println("Withdraw successfull!!!");
                String cash = amount + "Rs Withdrawed!!";
                transHistory = transHistory.concat(cash);
            }
            else
            {
                System.out.println("Insufficient Balance!!");
            }
        }
        catch(Exception e)
        {

        }
    }
    public void deposit()
    {
        System.out.println("Enter amount to deposit:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        try
        {
            if(amount <= 100000f)
            {
                transaction++;
                balance = balance + amount;
                System.out.println("Deposit successfull!!!");
                String cash = amount + "Rs deposited!!";
                transHistory = transHistory.concat(cash);
            }
            else
            {
                System.out.println("Sorry.....Deposit limit is 100000.00");
            }
        }
        catch(Exception e)
        {

        }
    }

    public void transfer()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter recipent name:");
        String recipent = sc.nextLine();
        System.out.println("Enter amount to be transfer:");
        float amount = sc.nextFloat();

        try
        {
            if(balance >= amount)
            {
                if(amount <= 50000f)
                {
                    transaction++;
                    balance = balance-amount;
                    System.out.println("Succesfully transferred to "+recipent);
                    String cash = amount+" Rs is transferred to "+recipent;
                    transHistory = transHistory.concat(cash);
                }
                else
                {
                    System.out.println("Sorry...Transfer limit is 50000.00");
                }
            }
            else
            {
                System.out.println("Insufficient Balance!!!");
            }
        }
        catch(Exception e)
        {

        }
    }

    public void check_balance()
    {
        System.out.println("Balance is"+balance+" Rs");
    }

    public void transaction_History()
    {
        if(transaction == 0)
        {
            System.out.println("Empty!!");
        }
        else
        {
            System.out.println("Transaction history is "+transHistory);
        }
    }
}

public class task3
{
    public static int Take_int_Input(int limit)
    {
        int ip = 0;
        boolean flag = false;
        
        while(!flag)
        {
            try
            {
                Scanner sc = new Scanner(System.in);
                ip = sc.nextInt();
                flag = true;
                if(flag && ip>limit || ip<1)
                {
                    System.out.println("Choose a number between 1 to "+limit);
                    flag = false;
                }
            }
            catch(Exception e)
            {
                System.out.println("Enter only integer value");
                flag = false;
            }
        };
        return ip;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to SBI ATM System!!!!!!");
        System.out.println("1.Register \n2.Exit");
        System.out.println("Enter your Choice:");
        int choice = Take_int_Input(2);

        if(choice == 1)
        {
            Bank b = new Bank();
            b.register();

            while(true)
            {
                System.out.println("1.Login \n2.Exit");
                System.out.println("Enter your choice:");
                int choose = Take_int_Input(2);
                if(choose == 1)
                {
                    if(b.login())
                    {
                        System.out.println("......Welcome back "+b.name+" ......");
                        boolean is_Finished = false;
                        while(!is_Finished)
                        {
                            System.out.println("1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
                            System.out.println("Enter your choice:");
                            int c = Take_int_Input(6);
                            switch(c)
                            {
                                case 1:
                                b.withdraw();
                                break;
                                case 2:
                                b.deposit();
                                break;
                                case 3:
                                b.transfer();
                                break;
                                case 4:
                                b.check_balance();
                                break;
                                case 5:
                                b.transaction_History();
                                break;
                                case 6:
                                is_Finished = true;
                                break;
                            }
                        }
                    }
                }
                else 
                {
                    System.exit(0);
                }
            }
        }
        else
        {
            System.exit(0);
        }
    }
}