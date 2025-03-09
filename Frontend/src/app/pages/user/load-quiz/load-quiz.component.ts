import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { QuizService } from '../../../services/quiz.service';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-load-quiz',
  standalone: true,
  imports: [CommonModule, MatCardModule, MatListModule, MatIconModule, MatButtonModule, RouterLink],
  templateUrl: './load-quiz.component.html',
  styleUrl: './load-quiz.component.css',
})
export class LoadQuizComponent implements OnInit {
  cId: any;
  quizzes = [
    {
      qid: '',
      title: '',
      description: '',
      maxMarks: '',
      numberOfQuestions: '',
      active: '',

      category: {
        title: '', cid:''
      },
    },
  ];

  constructor(private route: ActivatedRoute, private quiz: QuizService) {}

  ngOnInit(): void {
    // Log the initial value of route params
    console.log('Initializing LoadQuizComponent...');

    this.route.params.subscribe((params) => {
      this.cId = this.route.snapshot.params['cId'];
      console.log('Category ID (cId):', this.cId);

      if (this.cId == 0) {
        // Fetch all active quizzes
        this.quiz.getActiveQuizzes().subscribe(
          (data: any) => {
            console.log('Fetched Active Quizzes:', data);
            this.quizzes = data;
          },
          (error) => {
            console.error('Error fetching active quizzes:', error);
          }
        );
      } else {
        // Fetch active quizzes of a specific category
        this.quiz.getActiveQuizzesOfCategory(this.cId).subscribe(
          (data: any) => {
            console.log(`Fetched Active Quizzes for Category ID ${this.cId}:`, data);
            this.quizzes = data;
          },
          (error) => {
            console.error(`Error fetching quizzes for Category ID ${this.cId}:`, error);
          }
        );
      }
    });
  }
}
