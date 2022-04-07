import sub.*;

import java.io.IOException;

public class Web {

    public static void main(String[] args){

        //----------
//        Files files = new Files("source");
//
//        DBBuilder builder = new DBBuilder("MyDB");
//        DBProvider provider = new DBProvider(builder);
//        provider.create();

        // --------

        Container json = new Container("json");
        Container xml = new Container("xml");
        Container yaml = new Container("yaml");

        json.print();
        xml.print();
        yaml.print();

    }

}