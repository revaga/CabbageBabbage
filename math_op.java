public class math_op extends varri {
    String entered;
    String[] arr_math;

    String op1 = null;
    String op2 = null;
    String op3 = null;

    double one;
    double two;
    double three;

    //double value;
    public math_op(String entered){
        this.entered = entered;

        clean();
        value = String.valueOf(run_cal());
    }

    public void clean(){
        int i = 0;
        int b = 0;
        arr_math = new String[entered.length()-7];
        for(int c = 7; c < entered.length(); c++){
            arr_math[c-7] = entered.substring(c,c+1);
        }


        for (int c = 0; c<arr_math.length; c++) {
            String temp = arr_math[c];
            boolean numeric = true;
            try {
                Double num = Double.parseDouble(temp);
            } catch (NumberFormatException e) {
                numeric = false;
            }
            if(temp.equals("+") || temp.equals("-") || temp.equals("/") || temp.equals("*")) {
                i += 1;
                if (i == 1)
                    op1 = temp;
                else if (i == 2)
                    op2 = temp;
                else if (i == 3)
                    op3 = temp;
            } else if (numeric) {
                b +=1;
                if(b==1){
                    one = Double.parseDouble(temp);
                }
                else if(b==2){
                    two = Double.parseDouble(temp);
                }
                else if(b==3){
                    three = Double.parseDouble(temp);
                }
            }
        }
    }

    public double option1(double one, double two, String op1){
        if(op1.equals("+")){
            return one + two;
        } else if (op1.equals("-")) {
            return one-two;
        } else if (op1.equals("/")) {
                return one / two;
        } else if (op1.equals("*")) {
            return one*two;
        }
        return 1.0;
    }

    public double option2(double one, double two, String op1, double three, String op2){
        if(op2.equals("/")||op2.equals("*")){
            double newnum = option1(two, three, op2);
            return option1(one, newnum, op1);
        }
        else{
            double newnum = option1(one, two, op1);
            return option1(newnum, three, op2);
        }
    }

    public double run_cal(){
        if(op1 == null){
            return one;
        }
        else if(Double.isNaN(three)||op2 == null){
            return option1(one, two, op1);
        }else{
            return option2(one, two, op1, three, op2);
        }
    }

    public String toString(){
        return value + "";
    }

}
