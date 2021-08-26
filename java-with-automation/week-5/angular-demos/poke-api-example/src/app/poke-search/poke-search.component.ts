import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-poke-search',
  templateUrl: './poke-search.component.html',
  styleUrls: ['./poke-search.component.css']
})
export class PokeSearchComponent implements OnInit {

  @Output()
  search: EventEmitter<number> = new EventEmitter();

  id: number = 0;

  constructor() { }

  ngOnInit(): void {
  }

  emitSearch() {
    this.search.emit(this.id);
  }

}
