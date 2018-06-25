package de.gedoplan.ek.swagger.service;

import de.gedoplan.ek.swagger.model.ContactPerson;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Dominik Mathmann, GEDOPLAN
 */
@ApplicationScoped
public class ContactPersonService {

  private List<ContactPerson> localStore;

  public List<ContactPerson> getContactPersons() {
    return this.localStore;
  }

  public ContactPerson getContactPerson(Integer id) {
    if (id >= 0 && id < 4) {
      return this.localStore.get(id);
    } else {
      return null;
    }
  }

  public ContactPerson addContactPerson(ContactPerson contactPerson) {
    contactPerson.setId(this.localStore.size());
    this.localStore.add(contactPerson);
    return contactPerson;
  }

  @PostConstruct
  private void createExampleData() {
    this.localStore = new ArrayList<>();

    this.localStore.add(new ContactPerson(0, "Dominik", "Mathmann", "dominik.mathmann@gedoplan.de"));
    this.localStore.add(new ContactPerson(1, "Max", "Mustermann", "max.mustermann@gedoplan.de"));
    this.localStore.add(new ContactPerson(2, "Lieschen", "Müller", "lieschen.mueller@gedoplan.de"));
    this.localStore.add(new ContactPerson(3, "Erika", "Mustermann", "erika.mustermann@gedoplan.de"));
  }
}
