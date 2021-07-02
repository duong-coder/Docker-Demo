import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'angular-app';
  helloText: string;
  obj: any[];

  constructor(
    private http: HttpClient
  ){
  }

  ngOnInit(): void{
    this.http.get<any>('http://localhost:8081/hello').subscribe((data) => {
      this.helloText = data;
    });

    this.http.get<any[]>('http://localhost:8081/people').subscribe((data) => {
      this.obj = data;
    });
  }
}
