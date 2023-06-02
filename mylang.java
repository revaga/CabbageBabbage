//import java.util.stream.Stream;
import java.io.*;
import java.util.*;


public class mylang {
        // main driver method
        public static void main(String[] args) throws Exception
        {
            File file = new File(
                    "C:\\Users\\reva\\IdeaProjects\\compiler\\src\\sample.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {

                enterline e = new enterline(st);
                if(st.startsWith("loop")){
                    loop obj = new loop(st);
                    enterline.lines.add(obj);
                    obj.run_loop();

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
                    }
                }
                else if(st.startsWith("~")||st.equals(" ")||st.equals("")){
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
                    for (varri temp:enterline.variables) {
                        if(st.substring(15, st.length() - 1).equals(temp.namevar)){
                            System.out.println(temp);
                            is_var = true;
                        }


                    }
                    if(!is_var)
                        System.out.println(st.substring(15, st.length()-1));
                }else{
                    //error
                    System.out.println("oopsie on line " + (enterline.lines.size()+1));
                }


                if(enterline.lines.size() > 1){
                    enterline.lines.get(enterline.lines.size()-2).setNext(e);
                }


            }



        }
    }
