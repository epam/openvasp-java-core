package org.openvasp.core.model.vasp;

import org.openvasp.core.model.ivms101.Person;

import javax.persistence.*;

@Entity
public class VaspAccount {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String password;

    private String accountNumber;

    private String lnurl;

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

    public String getLnurl() {
        return lnurl;
    }

    public void setLnurl(String lnurl) {
        this.lnurl = lnurl;
    }
}
