package cz.spsmb.model;

import cz.spsmb.scanner.CellName;
import cz.spsmb.scanner.CsvEntity;

@CsvEntity
public class CsvRow {

    @CellName(id = "identification")
    private long id;

    @CellName(id = "user_name")
    private String name;

    @CellName(id = "user_country")
    private String country;

    public CsvRow(long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
