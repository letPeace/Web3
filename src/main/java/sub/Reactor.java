package sub;

public class Reactor{

    private String type;
    private Double burnup;
    private Double kpd;
    private Double enrichment;
    private Double termalCapacity;
    private Double electricalCapacity;
    private Double lifeTime;
    private Double firstLoad;

    public Reactor(String type,
                   Double burnup,
                   Double kpd,
                   Double enrichment,
                   Double termalCapacity,
                   Double electricalCapacity,
                   Double lifeTime,
                   Double firstLoad){
        setType(type);
        setBurnup(burnup);
        setKpd(kpd);
        setEnrichment(enrichment);
        setTermalCapacity(termalCapacity);
        setElectricalCapacity(electricalCapacity);
        setLifeTime(lifeTime);
        setFirstLoad(firstLoad);
    }

    public Reactor(){}

    // SET

    public void setType(String type){
        this.type = type;
    }

    public void setBurnup(Double burnup){
        this.burnup = burnup;
    }

    public void setKpd(Double kpd){
        this.kpd = kpd;
    }

    public void setEnrichment(Double enrichment){
        this.enrichment = enrichment;
    }

    public void setTermalCapacity(Double termalCapacity){
        this.termalCapacity = termalCapacity;
    }

    public void setElectricalCapacity(Double electricalCapacity){
        this.electricalCapacity = electricalCapacity;
    }

    public void setLifeTime(Double lifeTime){
        this.lifeTime = lifeTime;
    }

    public void setFirstLoad(Double firstLoad){
        this.firstLoad = firstLoad;
    }

    // GET

    public String getType(){
        return type;
    }

    public Double getBurnup(){
        return burnup;
    }

    public Double getKpd(){
        return kpd;
    }

    public Double getEnrichment(){
        return enrichment;
    }

    public Double getTermalCapacity(){
        return termalCapacity;
    }

    public Double getElectricalCapacity(){
        return electricalCapacity;
    }

    public Double getLifeTime(){
        return lifeTime;
    }

    public Double getFirstLoad(){
        return firstLoad;
    }

    //

    public void print(){
        System.out.println(objectToString());
    }

    private String objectToString(){
        return "type = "+getType()
                +"; burnup = "+getBurnup()
                +"; kpd = "+getKpd()
                +"; enrichment = "+getEnrichment()
                +"; termalCapacity = "+getTermalCapacity()
                +"; electricalCapacity = "+getElectricalCapacity()
                +"; lifeTime = "+getLifeTime()
                +"; firstLoad = "+getFirstLoad();
    }

}
