import java.util.*;
class game {
    int sysip;
    int userip;
    int no_of_guesses = 0;

    game()
    {
        Random random = new Random();
        this.sysip = random.nextInt(100)+1;
    }

    public boolean take_User_input()
    {
        if(no_of_guesses < 10)
        {
            System.out.println("Guess the number: ");
            this.userip = task2.take_integer_input(100);
            no_of_guesses++;
            return false;
        }
        else
        {
            System.out.println("Attempt limit reached....Better luck next time\n");
            return true;
        }
    }

    public boolean is_correct_guess()
    {
        if(sysip == userip)
        {
            System.out.println("Congratulation your guess the number "+sysip+"in"+no_of_guesses+"guesses");
            switch(no_of_guesses)
            {
                case 1:
                System.out.println("Your score is 100");
                break;
                case 2:
                System.out.println("Your score is 90");
                break;
                case 3:
                System.out.println("Your score is 80");
                break;
                case 4:
                System.out.println("Your score is 70");
                break;
                case 5:
                System.out.println("Your score is 60");
                break;
                case 6:
                System.out.println("Your score is 50");
                break;
                case 7:
                System.out.println("Your score is 40");
                break;
                case 8:
                System.out.println("Your score is 30");
                break;
                case 9:
                System.out.println("Your score is 20");
                break;
                case 10:
                System.out.println("Your score is 10");
                break;
            }
            System.out.println();
            return true;
        }
        else if(no_of_guesses<10 && userip>sysip)
        {
            if(userip-sysip>10)
            {
                System.out.println("Too High");
            }
            else
            {
                System.out.println("Little High");
            }
        }
        else if(no_of_guesses<10 && userip<sysip)
        {
            if(sysip-userip>10)
            {
                System.out.println("Too Low");
            }
            else
            {
                System.out.println("Little Low");
            }
        }
        return false;
    }
}
public class task2 {
    public static int take_integer_input(int limit)
    {
        int input = 0;
        boolean flag = false;

        while(!flag)
        {
            try
            {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if(flag && input>limit || input<1)
                {
                    System.out.println("choose the number between 1 to "+limit);
                    flag = false;
                }
            }
            catch(Exception e)
            {
                System.out.println("Enter only integer value");
                flag = false;
            }
        };
        return input;
    }
    public static void main(String[] args) {
        System.out.println("1.start the game\n2.exit");
        System.out.println("enter your choice :");
        int choice = take_integer_input(2);
        int nextRound = 1;
        int noOfRound = 0;

        if(choice==1)
        {
            while(nextRound == 1)
            {
                game Game = new game();
                boolean isMatched = false;
                boolean isLimitCross = false;
                System.out.println("\nRound "+ ++noOfRound+"starts...");

                while(!isMatched && !isLimitCross)
                {
                    isLimitCross = Game.take_User_input();
                    isMatched = Game.is_correct_guess();
                }

                System.out.println("1.Next round \n2.exit");
                System.out.println("enter your choice :");
                nextRound = take_integer_input(2);
                if(nextRound != 1)
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
