package de.gedoplan.ek.swagger.model;

/**
 * @author Dominik Mathmann, GEDOPLAN
 */
public class ContactPerson {

  private Integer id;

  private String firstname;

  private String lastname;

  private String mail;

  public ContactPerson(Integer id, String firstname, String lastname, String mail) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.mail = mail;
  }

  public ContactPerson() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

}
