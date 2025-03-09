import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class QuizResultService {

 
  constructor(private http: HttpClient) {

    
   }

  public getAllQuizResults() {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get(`http://localhost:9004/quiz/quizResult/all`, { headers });
  }

  public getQuizResultsOfQuiz(qid: any){
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get(`http://localhost:9004/quiz/quizResult/quiz/${qid}`, { headers });
  }

  public saveQuizResult(quizResult: any){
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.post(`http://localhost:9004/quiz/quizResult/`, quizResult, { headers });
  }

  public deleteQuizResult(id: any){
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.delete(`http://localhost:9004/quiz/quizResult/${id}`, { headers });
  }

  public checkUserAttemptedQuiz(username: string, qid: any) {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get(`http://localhost:9004/quiz/quizResult/quiz/${username}/${qid}`, { headers });
  }
}