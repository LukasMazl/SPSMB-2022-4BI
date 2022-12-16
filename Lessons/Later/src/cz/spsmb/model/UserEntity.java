package cz.spsmb.model;

import cz.spsmb.repository.anotation.Column;

public class UserEntity {

    @Column(name = "identification")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_country")
    private String country;

    @Column(name = "has_dog")
    private Boolean hasDog;

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getHasDog() {
        return hasDog;
    }

    public void setHasDog(Boolean hasDog) {
        this.hasDog = hasDog;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", country='" + country + '\'' +
                ", hasDog=" + hasDog +
                '}';
    }
}
