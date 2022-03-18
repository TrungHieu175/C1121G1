public class Hourglass {
        public static void main(String[] args)
        {
            createHourGlass(12);

        }
        public static void createHourGlass(int n){
            for(int i=1; i<=n/2; i++)
            {
                for(int k=1; k<=i-1; k++)
                {
                    System.out.print("  ");
                }
                for(int j=1; j<=n - 2*(i-1); j++)
                {
                    System.out.print("* ");
                }
                System.out.println();
            }
            for(int i=n; i>=1; i=i-2)
            {
                for(int k=1; k<=i-2; k++)
                {
                    System.out.print(" ");
                }
                for(int j=i; j<=n+1; j++)
                {
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
    }
