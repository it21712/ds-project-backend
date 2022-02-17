package gr.ds.dsbackendproject.helper;

public class HelperClasses {

    static public class JSONString{

        private String string;



        public JSONString(){

        }

        public JSONString(String string){
            this.string=string;

        }

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }
    }
}
