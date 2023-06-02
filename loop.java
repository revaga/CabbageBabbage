import java.util.ArrayList;
import java.util.Objects;

public class loop extends enterline{
    public String entered;
    public int repeat;

    public loop(String entered) {
        this.entered = entered;
        try {
            repeat = Integer.parseInt(entered.substring(entered.indexOf("(")+1, entered.indexOf("):")));
        }
        catch (Exception NumberFormatException){
            repeat = 0;
        }
    }

    public void run_loop() {
        String modified = entered.substring(entered.indexOf(": "));
        enterline obj = new enterline(modified);
        for (int i = 0; i < repeat; i++) {
            obj.setEntered_as(modified);
        }
    }


    /*public void setEntered_as(String st) {
        if(st.startsWith("loop")){
            loop obj = new loop(st);
            enterline.lines.add(obj);
        }
        else if(st.startsWith("{string_bean}")){
            string obj = new string(st);
            enterline.lines.add(obj);
        }
        else if(st.contains("{math}")){
            if(st.contains("var")) {
                math_op obj = new math_op(st.substring(st.indexOf("= ") + 2));
                obj.setNamevar(st.substring(st.indexOf("var") + 4, st.indexOf(" =")));
                enterline.variables.add(obj);
                enterline.lines.add(obj);
            }
            else{
                math_op obj = new math_op(st);
                System.out.println(obj.value);
        }}
        else if(st.startsWith("~")){
            comments obj =  new comments(st);
            enterline.lines.add(obj);
        } else if (st.startsWith("var")) {
            boolean is_def_variable = false;
            for (varri temp:
                    enterline.variables) {
                if(Objects.equals(temp.namevar, st.substring(4, st.indexOf(" =")))){
                    is_def_variable = true;
                }
            }
            //already a variable
            if(is_def_variable){

            }else //create a new variable
            {
                try {
                    Double.parseDouble(st.substring(st.length() - 1));
                    math_op obj = new math_op(st.substring(6));
                    enterline.variables.add(obj);
                    System.out.println(obj);

                } catch (Exception NumberFormatException) {
                    string obj = new string(st.substring(4));
                    enterline.variables.add(obj);
                    System.out.println(obj);
                }
            }

        } else if (st.contains("scribblebibble(")) {
            boolean is_var = false;
            String substring = st.substring(15 + 2, st.length() - 1);
            for (varri temp:enterline.variables) {
                if(substring.equals(temp.namevar)){
                    System.out.println(temp);
                    is_var = true;
                }
            }
            if(!is_var) {
                //System.out.println(st.substring(15, st.length() - 1));
                enterline obj = new enterline(substring);
                obj.setEntered_as(substring);
                System.out.println(obj);
            }
        } else if (st.equals(" ")||st.equals("")) {
            //handles empty lines
        } else{
            //error
            System.out.println("oopsie");
        }
    } */
}
