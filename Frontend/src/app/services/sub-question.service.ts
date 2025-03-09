import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SubQuestionService {
  //private baseUrl = 'http://localhost:9003/exam/subQuestion';

  constructor(private http: HttpClient) { }

  addSubQuestion(subQuestion: any): Observable<any> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.post<any>(`http://localhost:9003/exam/subQuestion/add`, subQuestion,{headers});
  }

  updateSubQuestion(id: number, subQuestion: any): Observable<any> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.put<any>(`http://localhost:9003/exam/subQuestion/update/${id}`, subQuestion,{headers});
  }

  getAllSubQuestions(): Observable<any[]> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get<any[]>(`http://localhost:9003/exam/subQuestion/all`,{headers});
  }

  getSubQuestionById(id: number): Observable<any> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get<any>(`http://localhost:9003/exam/subQuestion/${id}`,{headers});
  }

  deleteSubQuestion(id: number): Observable<any> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.delete<any>(`http://localhost:9003/exam/subQuestion/delete/${id}`,{headers});
  }

  getSubQuestionsOfParentQuestion(parentId: number): Observable<any[]> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get<any[]>(`http://localhost:9003/exam/subQuestion/parentQuestion/${parentId}`,{headers});
  }
}