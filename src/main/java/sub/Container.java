package sub;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Container {

    private String source;
    private ArrayList<Reactor> reactors;

    public Container(String source, ArrayList<Reactor> reactors){
        setSource(source);
        setReactors(reactors);
    }

    public Container(String source){
        setSource(source);
        setReactors(source);
    }

    public Container(){}

    // GET

    public String getSource(){
        return source;
    }

    public ArrayList<Reactor> getReactors(){
        return reactors;
    }

    // SET

    public void setSource(String source){
        this.source = source;
    }

    public void setReactors(ArrayList<Reactor> reactors){
        this.reactors = reactors;
    }

    //

    private void setReactors(String source){
        try {
            ObjectMapper objectMapper = null;
            String pathname = "D:\\_Mehi\\6sem\\INF\\web3maven\\src\\main\\java\\files\\ReactorType."+source;
            switch(source){
                case("yaml"):
                    objectMapper = new ObjectMapper(new YAMLFactory());
                    break;
                case("json"):
                    objectMapper = new ObjectMapper();
                    break;
                case("xml"):
                    objectMapper = new XmlMapper();
                    break;
            }
            Reactor[] reactorsMas = objectMapper.readValue(new File(pathname), Reactor[].class);
            setReactors(new ArrayList<>(Arrays.asList(reactorsMas)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print(){
        System.out.println("Source = "+getSource());
        for(Reactor reactor : reactors){
            reactor.print();
        }
    }

}
