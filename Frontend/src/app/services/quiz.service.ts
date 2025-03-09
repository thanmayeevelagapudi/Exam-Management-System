import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  constructor(private http: HttpClient) { }
 // private baseUrl = 'http://localhost:9004/quiz';
  public display() {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get(`http://localhost:9004/quiz/`,{headers});
  }

  public addQuiz(quiz: any) {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.post(`http://localhost:9004/quiz/`, quiz,{headers});
  }

  public deleteQuiz(qid: any) {
  
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.delete(`http://localhost:9004/quiz/${qid}`, { headers });
  }

  public getQuiz(qid: any){
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get(`http://localhost:9004/quiz/${qid}`, {headers});
  }

  public updateQuiz(qid:any,quiz:any){
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.put(`http://localhost:9004/quiz/${qid}`,quiz,{headers});
  }

  public getQuizzesOfCategory(categoryId:any){
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get(`http://localhost:9004/quiz/category/${categoryId}`,{headers});
  }

  public getActiveQuizzes(){
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get(`http://localhost:9004/quiz/active`,{headers});
  }

  public getActiveQuizzesOfCategory(cid:any){
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get(`http://localhost:9004/quiz/category/active/${cid}`,{headers});
  }
}
