import { TheoryService } from './../../services/theory.service';
import { Component, HostListener, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  @HostListener('click')
  clicked() {
    console.log('clicked');
  }

  constructor(public userService: UserService, public theoryService: TheoryService) { }

  getTheory(userId: number): any {
    console.log('file: user.component.ts ~ UserComponent ~ getTheory() ~ UserId is' + userId)
    return this.theoryService.getTheory(userId)
  }

}
