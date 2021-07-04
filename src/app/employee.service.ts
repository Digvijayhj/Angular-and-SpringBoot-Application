import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private getURL = "http://localhost:8080/api/v1/employee/all";
  private postURL = "http://localhost:8080/api/v1/employee/add";
  private getPutDeleteURL = "http://localhost:8080/api/v1/employee"

  constructor(private httpClient: HttpClient) { }

  getEmployeeList(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.getURL}`);
  }

  createEmployee(employee: Employee): Observable<Object>{
    return this.httpClient.post(`${this.postURL}`,employee);
  }

  getEmployeeById(id: number ): Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.getPutDeleteURL}/${id}`);
  }

  updateEmployee(id: number, employee: Employee): Observable<Object>{
    return this.httpClient.put(`${this.getPutDeleteURL}/${id}`,employee);
  }

  deleteEmployee(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.getPutDeleteURL}/${id}`);
  }
}
