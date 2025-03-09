import { Component, OnInit } from '@angular/core';
import { NavbarComponent } from "../../../components/navbar/navbar.component";
import { LocationStrategy } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { QuestionService } from '../../../services/question.service';
import { MatCardModule } from '@angular/material/card';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import Swal from 'sweetalert2';
import { RouterLink } from '@angular/router';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { LoginService } from '../../../services/login.service';
import { QuizResultService } from '../../../services/quiz-result.service';

@Component({
    selector: 'app-start-quiz',
    standalone: true,
    templateUrl: './start-quiz.component.html',
    styleUrl: './start-quiz.component.css',
    imports: [
        NavbarComponent, MatCardModule, MatListModule, MatIconModule, MatButtonModule,
        CommonModule, MatFormFieldModule, FormsModule, MatInputModule, MatRadioModule,
        RouterLink, MatProgressSpinnerModule
    ]
})
export class StartQuizComponent implements OnInit {
    qid: any;
    questions = [
        {
            qid: '',
            content: '',
            option1: '',
            option2: '',
            option3: '',
            option4: '',
            answer: '',
            givenAnswer: '',
            quiz: {
                qid: '',
                title: '',
                maxMarks: ''
            }
        }
    ];

    marksGot = 0;
    correctAnswers = 0;
    attempted = 0;
    isSubmit = false;
    timer: any;

    constructor(
        private locationStrategy: LocationStrategy,
        private route: ActivatedRoute,
        private questionService: QuestionService,
        private loginService: LoginService,
        private quizResultService: QuizResultService,
        private router: Router
    ) {}

    ngOnInit(): void {
        this.preventBackButton();

        // Log route parameters
        this.route.params.subscribe((params) => {
            console.log('Route parameters:', params);
        });

        // Log query parameters (if any)
        this.route.queryParams.subscribe((queryParams) => {
            console.log('Query parameters:', queryParams);
        });

        // Fetch 'qid' from route and log it
        this.qid = this.route.snapshot.params['qid'];
        console.log('Quiz ID (qid) from URL:', this.qid);

        // Load questions for the quiz
        this.loadQuestions();
    }

    loadQuestions() {
        this.questionService.getQuestionsOfQuizForUser(this.qid).subscribe(
            (data: any) => {
                console.log('Fetched Questions:', data); // Log questions data
                this.questions = data;
                this.timer = this.questions.length * 2 * 60;
                this.startTimer();
            },
            (error) => {
                console.error('Error fetching questions:', error);
            }
        );
    }

    preventBackButton() {
        history.pushState(null, 'null', location.href);
        this.locationStrategy.onPopState(() => {
            history.pushState(null, 'null', location.href);
        });
    }

    submitQuiz() {
        Swal.fire({
            title: 'Do You Want To Submit The Quiz',
            showCancelButton: true,
            denyButtonText: 'Cancel',
            confirmButtonText: 'Submit',
            icon: 'info'
        }).then((result) => {
            if (result.isConfirmed) {
                this.evalQuiz();
            }
        });
    }

    public startTimer() {
        let t = window.setInterval(() => {
            if (this.timer <= 0) {
                this.evalQuiz();
                clearInterval(t);
            } else {
                this.timer--;
            }
        }, 1000);
    }

    public getFormattedTime() {
        let mm = Math.floor(this.timer / 60);
        let ss = this.timer - mm * 60;
        return `${mm} min : ${ss} sec`;
    }

    public evalQuiz() {
        this.questionService.evalQuiz(this.questions).subscribe(
            (data: any) => {
                console.log('Quiz evaluation result:', data); // Log evaluation data
                this.marksGot = data.marksGot;
                this.correctAnswers = data.correctAnswers;
                this.attempted = data.attempts;

                const username = this.loginService.getUser().username;

                const quizResult = {
                    username: username,
                    marksGot: this.marksGot,
                    attempted: this.attempted,
                    correctAnswers: this.correctAnswers,
                    quiz: {
                        qid: this.qid
                    }
                };

                this.quizResultService.saveQuizResult(quizResult).subscribe(
                    (result: any) => {
                        console.log('Quiz result saved successfully:', result); // Log saved result
                    },
                    (error: any) => {
                        console.error('Failed to save quiz result:', error);
                    }
                );
            },
            (error: any) => {
                console.error('Error evaluating quiz:', error);
            }
        );
        this.isSubmit = true;
    }
}
