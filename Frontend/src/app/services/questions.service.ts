import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Questions } from '../model/questions.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuestionsService {
  //private baseUrl = 'http://localhost:9003/exam/parentQuestion'; 

  constructor(private http: HttpClient) { }

  addQuestion(question: any): Observable<Questions> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.post<Questions>(`http://localhost:9003/exam/parentQuestion/add`, question,{headers});
  }

  updateQuestion(id: number, question: any): Observable<Questions> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.put<Questions>(`http://localhost:9003/exam/parentQuestion/update/${id}`, question,{headers});
  }

  getAllQuestions(): Observable<Questions[]> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get<Questions[]>(`http://localhost:9003/exam/parentQuestion/getAll`,{headers});
  }

  getQuestionById(qId: number): Observable<Questions> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get<Questions>(`http://localhost:9003/exam/parentQuestion/${qId}`,{headers});
  }

  deleteQuestion(qId: number): Observable<void> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.delete<void>(`http://localhost:9003/exam/parentQuestion/delete/${qId}`,{headers});
  }

  getQuestionsOfQuestionPaper(questionPaperId: number): Observable<Questions[]> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get<Questions[]>(`http://localhost:9003/exam/parentQuestion/getByQuestionPaper/${questionPaperId}`,{headers});
  }
}