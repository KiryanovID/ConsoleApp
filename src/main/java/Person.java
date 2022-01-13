import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    @JsonProperty("data")
    private DataPerson dataPerson;
    @JsonProperty("support")
    private SupportPerson supportPerson;

    public Person() {
    }

    public DataPerson getDataPerson() {
        return dataPerson;
    }

    public void setDataPerson(DataPerson dataPerson) {
        this.dataPerson = dataPerson;
    }

    public SupportPerson getSupportPerson() {
        return supportPerson;
    }

    public void setSupportPerson(SupportPerson supportPerson) {
        this.supportPerson = supportPerson;
    }


}
