package org.openvasp.core.model.vasp;

import org.openvasp.core.lnurl.Lnurl;
import org.openvasp.core.model.ivms101.Person;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class VaspAccount {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String password;

    private String accountNumber;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "lnurl_secret")
    private Lnurl lnurl;

    @ElementCollection
    @JoinTable(name="asset_type", joinColumns=@JoinColumn(name="id"))
    @MapKeyColumn (name="asset_type_id")
    @Column(name="asset_address")
    private Map<String, String> assetsAddresses = new HashMap<>();

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "person_id")
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Lnurl getLnurl() {
        return lnurl;
    }

    public void setLnurl(Lnurl lnurl) {
        this.lnurl = lnurl;
    }

    public String getAssetAddress(String assetType) {
        return assetsAddresses.get(assetType);
    }

    public void setAssetAddress(String type, String address) {
        assetsAddresses.put(type, address);
    }

    public Map<String, String> getAssetsAddresses() {
        return assetsAddresses;
    }

    public void setAssetsAddresses(Map<String, String> assetsAddresses) {
        this.assetsAddresses = assetsAddresses;
    }
}
