import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {
        EUI.execute();
        Scanner scanner = new Scanner(System.in);
        Scanner stuff = scanner; // just because it looks cooler

        while (true)
        {
            Integer choice = canvas.execute(stuff);

            if (choice == 5) // "5.Exit"
            {
                System.out.println("Thank U :D ");
                scanner.close();
                return;
            }

            System.out.println("Would You like to continue? (y/n)");
            String ans = scanner.next();

            if (!ans.equals("y"))
            {
                scanner.close();
                break;
            }
        }
    }
}