import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("\"\"   =  " + add(""));
            System.out.println("\"1,2\"   =  " + add("1,2"));
            System.out.println("\"1,2\\n3\"   =  " + add("1,2\n3"));
            System.out.println("//;\\\\n1;2   =  " + add("//;\n1;2"));
            System.out.println("//;\\\\n1;2;9   =  " + add("//;\n1;2;9"));
            System.out.println("//;\\\\n1;2\\n7   =  " + add("//;\n1;2\n7"));
            //System.out.println("//;\\\\n1;2\\n7;-3   =  " + add("//;\n1;2\n7;-3"));
            System.out.println("//;\\\\n100;23\\n6   =  " + add("//;\n100;23\n6"));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    static int add(String numbers) throws  Exception{

        if (numbers.isEmpty()) return 0;    // if empty string return 0

        char symbol = ',';
        if ( numbers.startsWith("//") ) {     // check for changing delimeter
            symbol = numbers.charAt(2);
            //numbers = numbers.substring(4);
            numbers = numbers.split("\\n",2)[1];
        }
        //System.out.println(numbers);


        String expr = symbol + "|\\n";
        //System.out.println("expr = " + expr);

        String[] arr_str;
        ArrayList<Integer> arr_negatives = new ArrayList<Integer>();
        int sum = 0;
        int n;
        boolean failed = false;
        arr_str = numbers.split(expr);
        //System.out.println(Arrays.toString(arr_str));
        for ( String s : arr_str){
            n = Integer.parseInt(s);
            if (n > 0 && n <= 1000){
                sum += n;
            }
            if (n < 0){
                arr_negatives.add(n);
                failed = true;
            }

        }
        if(failed){
            throw new Exception("negatives not allowed" + arr_negatives);
        }
        return sum;
    }



}