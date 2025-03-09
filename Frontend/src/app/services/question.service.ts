import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(private http:HttpClient) { }
  //private baseUrl = 'http://localhost:9002/question'; 

  public getQuestionsOfQuiz(qid:any){
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get(`http://localhost:9002/question/quiz/all/${qid}`,{headers});
  }

  public getQuestionsOfQuizForUser(qid:any){
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get(`http://localhost:9002/question/quiz/${qid}`,{headers});
  }

  public addQuestion(question:any){
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.post(`http://localhost:9002/question/`,question,{headers});
  }

  public deleteQuestion(qid:any){
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.delete(`http://localhost:9002/question/${qid}`,{headers});
  }

  public evalQuiz(questions:any){
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.post(`http://localhost:9002/question/eval-quiz`,questions,{headers});
  }
}
