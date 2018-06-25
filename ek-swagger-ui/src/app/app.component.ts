import { Component } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { ContactPerson, ContactPersonService } from '../generated';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ContactPersonService]
})
export class AppComponent {
  public persons: Observable<ContactPerson[]>;

  constructor(service: ContactPersonService) {
    this.persons = service.getContactPersons();
  }
}
