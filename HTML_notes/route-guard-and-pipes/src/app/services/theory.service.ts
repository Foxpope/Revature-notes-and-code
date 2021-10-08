import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TheoryService {

  constructor() { }

  readonly theories = [
    {
      title: 'quantum theory',
      userId: 1
    },
    {
      title: 'relativity',
      userId: 2
    }
  ]

  getTheory(userId: number) {
    return this.theories.find(t => t.userId === userId)
  }
}
