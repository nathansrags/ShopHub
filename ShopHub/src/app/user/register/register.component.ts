import { Component } from '@angular/core';
import { DirectiveModule } from '../../directive.module';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [DirectiveModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

}
